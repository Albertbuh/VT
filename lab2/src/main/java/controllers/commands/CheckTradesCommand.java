package controllers.commands;

import beans.Trade;
import beans.TradeManager;
import beans.TradeRequest;
import beans.User;
import controllers.JspDispatcher;
import services.ServiceException;
import services.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CheckTradesCommand implements Command{
    @Override
    public String executePost(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        return null;
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

