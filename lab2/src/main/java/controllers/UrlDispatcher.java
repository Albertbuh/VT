package controllers;

public class UrlDispatcher {
    public static final String LOGIN_URL = "login";
    public static final String  SIGNIN_URL = "sign_in";
    public static final String INDEX_URL = "index";
    public static final String NEW_REQUEST_URL = "make_request";
    public static final String ERROR_URL = "error";
    public static final String NEWITEM_URL = "create_item";
    public static final String CHECKREQUEST_URL = "check_requests";
    public static final String CHECKTRADES_URL = "check_trades";

    private static String previousUrl = INDEX_URL;
    public static void setPreviousUrl(String url) {
        previousUrl = url;
    }
    public static String getPreviousUrl() {
        return previousUrl;
    }

}
