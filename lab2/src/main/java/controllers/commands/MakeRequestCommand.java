package controllers.commands;

import beans.Lot;
import beans.User;
import controllers.JspDispatcher;
import controllers.UrlDispatcher;
import services.FileManager;
import services.ServiceException;
import services.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

public class MakeRequestCommand implements Command{
    @Override
    public String executePost(HttpServletRequest request, HttpServletResponse response) throws CommandException{
        User user = (User)request.getSession().getAttribute("user");
        if(request.getSession().getAttribute("token") == null)
            return UrlDispatcher.SIGNIN_URL;

        try {
            String name = request.getParameter("lot_name");
            String desc = request.getParameter("lot_description");
            int period = Integer.parseInt(request.getParameter("trade_period"));
            double price = Double.parseDouble(request.getParameter("lot_price"));

            var imageFileName = FileManager.uploadLotImageFromRequest(request, "lot_image");
            var descFileName =  FileManager.writeLotDescriptionToFile(name, desc);

            var tradeService = ServiceFactory.getInstance().getTradeService();
            var lot = new Lot(name, descFileName, imageFileName, price);
            var tradeRequest = tradeService.makeRequest(user, lot, period);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }

        return UrlDispatcher.INDEX_URL;
    }

    @Override
    public String executeGet(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        return JspDispatcher.NEW_REQUEST_PAGE;
    }


}
