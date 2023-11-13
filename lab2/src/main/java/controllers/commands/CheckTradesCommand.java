package controllers.commands;

import beans.Trade;
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

public class CheckTradesCommand implements Command{
    @Override
    public String executePost(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        if(request.getSession().getAttribute("token") == null)
            return UrlDispatcher.SIGNIN_URL;

        int tradeId = 0;
        if(request.getParameter("tradeId") != null)
            tradeId = Integer.parseInt(request.getParameter("tradeId"));

        double bidUp = 0;
        if(request.getParameter("bidUp") != null)
            bidUp = Double.parseDouble(request.getParameter("bidUp"));


        User user = (User)request.getSession().getAttribute("user");
        try {
            var service = ServiceFactory.getInstance().getTradeService();
            service.updateBid(tradeId, bidUp, user.getLogin());
        } catch (ServiceException e) {
            CommandProvider.logger.error(e.getMessage());
        }
        return UrlDispatcher.CHECKTRADES_URL;
    }

    @Override
    public String executeGet(HttpServletRequest request, HttpServletResponse response) throws CommandException {
            response.setCharacterEncoding("utf-8");
            CommandProvider.logger.info("trades are start to load");

            try {
                var service = ServiceFactory.getInstance().getTradeService();
                List<Trade> list = service.getTrades();
                System.out.println(list.get(0).getMaxBid());
                var tm = new TradeManager().setTrades(list);

                request.setAttribute("tradeManager", tm);
                CommandProvider.logger.info("trades are loaded {}", tm.getTrades().get(0).getMaxBid());

            } catch (ServiceException e) {
                CommandProvider.logger.error("CheckTradeCommand POST: {}", e.getMessage());
            }

            return JspDispatcher.CHECKTRADES_PAGE;
    }
}

