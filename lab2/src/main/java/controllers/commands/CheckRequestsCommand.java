package controllers.commands;

import beans.TradeManager;
import beans.TradeRequest;
import beans.User;
import controllers.JspDispatcher;
import controllers.UrlDispatcher;
import services.ServiceException;
import services.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

public class CheckRequestsCommand implements Command{
    @Override
    public String executePost(HttpServletRequest request, HttpServletResponse response) throws CommandException{
        boolean isAccepted = false;
         var checkbox = request.getParameter("accepted");
         if(checkbox != null) {
             isAccepted = checkbox.equals("on");
         }

        int id = Integer.parseInt(request.getParameter("requestId"));
        var user = (User)request.getSession().getAttribute("user");

        var service = ServiceFactory.getInstance().getTradeService();
        if(user.getRole().equals("ADMIN")) {
            try {
                System.out.println("start accept");
                service.processTradeRequest(id, user, isAccepted);
            } catch (ServiceException e) {
                CommandProvider.logger.error("CheckRequestCommand POST: {}", e.getMessage());
            }
        }
        else
            return UrlDispatcher.SIGNIN_URL;

        return UrlDispatcher.CHECKREQUEST_URL;
    }

    @Override
    public String executeGet(HttpServletRequest request, HttpServletResponse response) throws CommandException{
        response.setCharacterEncoding("utf-8");
        if(request.getSession().getAttribute("user") instanceof User u) {
            if(!u.getRole().equals("ADMIN"))
                return JspDispatcher.SIGNIN_PAGE;
        } else
            return JspDispatcher.SIGNIN_PAGE;

        try {
            var service = ServiceFactory.getInstance().getTradeService();
            List<TradeRequest> list = service.getRequests();
            var tm = new TradeManager(list);

            request.setAttribute("tradeManager", tm);
        } catch (ServiceException e) {
            CommandProvider.logger.error("CheckRequestCommand POST: {}", e.getMessage());
        }

        return JspDispatcher.CHECKREQUEST_PAGE;
    }
}
