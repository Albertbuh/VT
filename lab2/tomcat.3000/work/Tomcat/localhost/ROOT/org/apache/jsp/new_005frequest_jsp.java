/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.23
 * Generated at: 2023-11-10 14:35:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class new_005frequest_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/D:/Univer/vt/labs/lab2/src/main/webapp/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153374282000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1699261072399L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-16BE");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      beans.User user = null;
      synchronized (session) {
        user = (beans.User) _jspx_page_context.getAttribute("user", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (user == null){
          user = new beans.User();
          _jspx_page_context.setAttribute("user", user, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>morcepan</title>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write("    <style>\r\n");
      out.write("        h2 {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("        nav {\r\n");
      out.write("            display: flex;\r\n");
      out.write("            justify-content: space-between;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            position: relative;\r\n");
      out.write("            background-color: #012866;\r\n");
      out.write("            color: white;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            margin: 5px 20px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        nav .button-section button {\r\n");
      out.write("            padding: 6px;\r\n");
      out.write("            margin: 0 4px;\r\n");
      out.write("            border: none;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            transition: background-color .3s, color .3s, outline .3s;\r\n");
      out.write("        }\r\n");
      out.write("        nav .button-section .btn-signin {\r\n");
      out.write("            color: white;\r\n");
      out.write("            background-color: transparent;\r\n");
      out.write("            outline: 1px solid white;\r\n");
      out.write("        }\r\n");
      out.write("        nav .button-section .btn-signin:hover {\r\n");
      out.write("            background-color: white;\r\n");
      out.write("            color: #012866;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        nav .button-section .btn-login {\r\n");
      out.write("            color: #012866;\r\n");
      out.write("            background-color: white;\r\n");
      out.write("            outline: 1px solid black;\r\n");
      out.write("        }\r\n");
      out.write("        nav .button-section .btn-login:hover {\r\n");
      out.write("            background-color: transparent;\r\n");
      out.write("            color: white;\r\n");
      out.write("            outline: 1px solid white;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        nav .links-section {\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            left: 50%;\r\n");
      out.write("            transform: translateX(-50%);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        nav .links-section a {\r\n");
      out.write("            padding: 5px 20px;\r\n");
      out.write("            color: white;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            font-size: 2vw;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            transition: background-color .3s, opacity .15s;\r\n");
      out.write("        }\r\n");
      out.write("        nav .links-section a:hover {\r\n");
      out.write("            background-color: rgba(255, 255, 255, 0.5);\r\n");
      out.write("        }\r\n");
      out.write("        nav .links-section a:active {\r\n");
      out.write("            opacity: 0.5;\r\n");
      out.write("            text-decoration: underline;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      if (_jspx_meth_c_005fimport_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<form method=\"post\" id=\"new_request\" enctype='multipart/form-data' >\r\n");
      out.write("    <div class=\"field\"><label>Lot name</label><input name=\"lot_name\" autofocus/></div>\r\n");
      out.write("    <div class=\"field\"><label>Lot image</label><input name=\"lot_image\" type=\"file\"/></div>\r\n");
      out.write("    <div class=\"field\"><label>Lot price</label><input name=\"lot_price\" type=\"number\" step=\"0.01\"/></div>\r\n");
      out.write("    <div class=\"field\"><label>Trade period</label><input name=\"trade_period\"/></div>\r\n");
      out.write("    <label>Lot description</label><textarea rows=\"4\" cols=\"50\" name=\"lot_description\" form=\"new_request\">Some desc</textarea>\r\n");
      out.write("    <input type=\"submit\" value=\"send\" form=\"new_request\"/>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fimport_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_005fimport_005f0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    boolean _jspx_th_c_005fimport_005f0_reused = false;
    try {
      _jspx_th_c_005fimport_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fimport_005f0.setParent(null);
      // /new_request.jsp(78,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fimport_005f0.setUrl("header.jsp");
      int[] _jspx_push_body_count_c_005fimport_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fimport_005f0 = _jspx_th_c_005fimport_005f0.doStartTag();
        if (_jspx_th_c_005fimport_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fimport_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fimport_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fimport_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.reuse(_jspx_th_c_005fimport_005f0);
      _jspx_th_c_005fimport_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fimport_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fimport_005f0_reused);
    }
    return false;
  }
}
