package controllers.commands;

import controllers.JspDispatcher;
import controllers.UrlDispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    String executePost(HttpServletRequest request, HttpServletResponse response);
    String executeGet(HttpServletRequest request, HttpServletResponse response);
}
