/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-03-28 06:56:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"utf-8\">\r\n");
      out.write("\t\t<!-- 声明文档兼容模式，表示使用IE浏览器的最新模式 -->\r\n");
      out.write("\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\t\t<!-- 设置视口的宽度，页面初始缩放值 -->\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\t\t<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->\r\n");
      out.write("\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("\t\t<!-- content的取值为webkit,ie-comp,ie-stand之一，区分大小写，分别代表用webkit内核，IE兼容内核，IE标准内核。 -->\r\n");
      out.write("\t\t<meta name=\"renderer\" content=\"webkit|ie-comp|ie-stand\">\r\n");
      out.write("\t\t<meta name=\"keywords\" content=\"关键词：网盘\">\r\n");
      out.write("\t\t<meta name=\"description\" content=\"网站描述：蚂蚁云盘存储系统\">\r\n");
      out.write("\r\n");
      out.write("\t\t<title></title>\r\n");
      out.write("\t\t<!-- Bootstrap -->\r\n");
      out.write("\t\t<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\t\t<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\r\n");
      out.write("\t\t<script src=\"js/jquery-1.11.3.min.js\"></script>\r\n");
      out.write("\t\t<!-- Include all compiled plugins (below), or include individual files as needed -->\r\n");
      out.write("\t\t<script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t\t<style>\r\n");
      out.write("\t\t\tbody {}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<!-- 导航栏 -->\r\n");
      out.write("\t\t<nav class=\"navbar navbar-default\">\r\n");
      out.write("\t\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t\t<!-- Brand and toggle get grouped for better mobile display -->\r\n");
      out.write("\t\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\">\r\n");
      out.write("\t\t\t\t\t    <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("\t\t\t\t\t    <span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t\t    <span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t\t    <span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t<a class=\"navbar-brand\" href=\"#\">蚂蚁网盘</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Collect the nav links, forms, and other content for toggling -->\r\n");
      out.write("\t\t\t\t<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t\t\t<li class=\"active\"><a href=\"#\">网盘文件</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">分享大厅</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t<form class=\"navbar-form navbar-right\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" placeholder=\"输入想要查找的文件名称\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-default\">搜索</button>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\r\n");
      out.write("\t</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
