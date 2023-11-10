package controllers.commands;

import beans.TradeManager;
import beans.TradeRequest;
import controllers.UrlDispatcher;
import services.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CheckRequestsCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        var service = ServiceFactory.getInstance().getTradeService();
////        List<TradeRequest> list = service.getRequests(5);
////        var tradeManager = new TradeManager(list);
//
//        request.setAttribute("fkingListOfRequests", list);
//
//        return UrlDispatcher.CHECKREQUEST_URL;
        return UrlDispatcher.INDEX_URL;
    }
}
