package controllers.commands;

import beans.User;
import controllers.JspDispatcher;
import controllers.UrlDispatcher;
import services.ClientService;
import services.ServiceException;
import services.ServiceFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command{
    private static final User incorrectUser = new User();
    private static final ServiceFactory serviceFactory = ServiceFactory.getInstance();
    @Override
    public String executePost(HttpServletRequest request, HttpServletResponse response) throws CommandException{
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String page = UrlDispatcher.ERROR_URL;

        try {
            ClientService service = serviceFactory.getClientService();
            User user = service.registration(login, password);
            if(user.equals(incorrectUser)) {
                page = UrlDispatcher.LOGIN_URL;
            }
            else {
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("token",
                        serviceFactory.getTokenService().create(user));

                page = UrlDispatcher.INDEX_URL;
            }
        } catch (ServiceException e) {
            CommandProvider.logger.error("LoginCommand POST: {}", e.getMessage());
        }

        return page;
    }

    @Override
    public String executeGet(HttpServletRequest request, HttpServletResponse response) throws CommandException{
        return JspDispatcher.LOGIN_PAGE;
    }

}
