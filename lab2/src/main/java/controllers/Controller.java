package controllers;

import controllers.commands.Command;
import controllers.commands.CommandException;
import controllers.commands.CommandProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/"}
)
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class Controller extends HttpServlet {
    private static final CommandProvider commandProvider = new CommandProvider();
    private static final Logger logger = LoggerFactory.getLogger("Controller");
    public Controller() {}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String path = request.getRequestURI().substring(1);
        String page = JspDispatcher.getPage(path);


        try {
            Command command = commandProvider.getCommand(path);
            logger.info("Start command of {} {}", path, command);
            page = command.executeGet(request, response);
            logger.info("Finish command of {}", path);

        }
        catch (CommandException e) {
            logger.error("doGet: {} {}", e.getMessage(), page);
        }

        logger.info("Loaded page: {}", page);

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        if(dispatcher != null)
            dispatcher.forward(request, response);
        else {
            response.setContentType("text/html");
            response.getWriter().println("dispatcher error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getRequestURI().substring(1);
        String urlPath = UrlDispatcher.ERROR_URL;
        try {
            Command command = commandProvider.getCommand(name);
            urlPath = command.executePost(request, response);
            logger.info("urlPath: {}", urlPath);
        }
        catch (CommandException e) {
            logger.error("doPost: {}", e.getMessage());
        }

        response.sendRedirect(urlPath);
    }

}
