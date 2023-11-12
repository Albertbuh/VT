package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JspDispatcher {
    public static final String LOGIN_PAGE = "login.jsp";
    public static final String  SIGNIN_PAGE = "signin.jsp";
    public static final String INDEX_PAGE = "index.jsp";
    public static final String NEW_REQUEST_PAGE = "new_request.jsp";
    public static final String ERROR_PAGE = "error.jsp";
    public static final String CHECKREQUEST_PAGE = "check_request.jsp";
    public static final String CHECKTRADES_PAGE = "check_trades.jsp";


    private static Map<String, String> pages = new HashMap<>() {{
        put(UrlDispatcher.LOGIN_URL, LOGIN_PAGE);
        put(UrlDispatcher.SIGNIN_URL, SIGNIN_PAGE);
        put(UrlDispatcher.INDEX_URL, INDEX_PAGE);
        put(UrlDispatcher.NEW_REQUEST_URL, NEW_REQUEST_PAGE);
        put(UrlDispatcher.ERROR_URL, ERROR_PAGE);
        put(UrlDispatcher.CHECKREQUEST_URL, CHECKREQUEST_PAGE);
        put(UrlDispatcher.CHECKTRADES_URL, CHECKTRADES_PAGE);
    }};

    public static String getPage(String name) {
        return pages.getOrDefault(name, ERROR_PAGE);
    }
    public static boolean dispatch(HttpServletRequest request, HttpServletResponse response, String page)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);

        if(dispatcher != null)
            dispatcher.forward(request, response);
        else
            return false;
        return true;
    }
}
