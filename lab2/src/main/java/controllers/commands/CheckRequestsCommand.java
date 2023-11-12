package controllers.commands;

import beans.TradeManager;
import beans.TradeRequest;
import beans.User;
import controllers.JspDispatcher;
import controllers.UrlDispatcher;
import services.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

public class CheckRequestsCommand implements Command{
    @Override
    public String executePost(HttpServletRequest request, HttpServletResponse response) {
//        response.setCharacterEncoding("utf-8");
//        if(request.getSession().getAttribute("user") instanceof User u) {
//            if(!u.getRole().equals("ADMIN"))
//                return JspDispatcher.SIGNIN_PAGE;
//        }
//
//        var service = ServiceFactory.getInstance().getTradeService();
//        List<TradeRequest> list = service.getRequests();
//        var tm = new TradeManager(list);
//
//        for(var tr: tm.getRequests()) {
//            System.out.println(tr.getLot().getName());
//        }
//        request.setAttribute("tradeManager", tm);

        return UrlDispatcher.CHECKREQUEST_URL;
    }

    @Override
    public String executeGet(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        if(request.getSession().getAttribute("user") instanceof User u) {
            if(!u.getRole().equals("ADMIN"))
                return JspDispatcher.SIGNIN_PAGE;
        }

        var service = ServiceFactory.getInstance().getTradeService();
        List<TradeRequest> list = service.getRequests();
        var tm = new TradeManager(list);

        for(var tr: tm.getRequests()) {
            System.out.println(tr.getLot().getName());
        }
        request.setAttribute("tradeManager", tm);

        return JspDispatcher.CHECKREQUEST_PAGE;
    }
}
