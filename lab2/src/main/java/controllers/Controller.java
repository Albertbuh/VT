package controllers;

import controllers.commands.Command;
import controllers.commands.CommandProvider;
import services.ServiceFactory;

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
    public Controller() {}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRequestURI().substring(1);

        RequestDispatcher dispatcher = request.getRequestDispatcher(JspDispatcher.getPage(path));
        if(dispatcher != null)
            dispatcher.forward(request, response);
        else
            sendErrorMessage(response, "dispatcher error in authentication");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getRequestURI().substring(1);
        String urlPath = "/error";
        try {
            Command command = commandProvider.getCommand(name);
            urlPath = command.execute(request, response);
            System.out.println("urlPath:" + urlPath);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        response.sendRedirect(urlPath);
    }

    private void sendErrorMessage(HttpServletResponse response, String message)
            throws IOException {
        response.setContentType("text/html");
        response.getWriter().println(message);
    }

}