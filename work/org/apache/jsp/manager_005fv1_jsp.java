/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.76
 * Generated at: 2018-03-15 05:59:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.DMS.ghb.entity.Announcement;
import com.DMS.ghb.entity.Mission;
import java.util.List;

public final class manager_005fv1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	List<Mission> missions=(List<Mission>)request.getAttribute("missions");
List<Announcement> announcements= (List<Announcement>)request.getAttribute("annList");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("<title>- 任务清单</title>\r\n");
      out.write("<meta name=\"keywords\" content=\"\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"favicon.ico\">\r\n");
      out.write("<link href=\"css/bootstrap.min.css?v=3.3.6\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"css/font-awesome.css?v=4.4.0\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<link href=\"css/animate.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"css/style.css?v=4.1.0\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"gray-bg\">\r\n");
      out.write("\t<div class=\"wrapper wrapper-content  animated fadeInRight\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-sm-6\">\r\n");
      out.write("\t\t\t\t<div class=\"ibox\">\r\n");
      out.write("\t\t\t\t\t<div class=\"ibox-content\">\r\n");
      out.write("\t\t\t\t\t\t<h3>任务列表</h3>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"input-group\"></div>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"sortable-list connectList agile-list ui-sortable\">\r\n");
      out.write("\t\t\t\t\t\t\t");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      boolean _jspx_th_c_005fforEach_005f0_reused = false;
      try {
        _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
        _jspx_th_c_005fforEach_005f0.setParent(null);
        // /manager_v1.jsp(41,7) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
        _jspx_th_c_005fforEach_005f0.setItems(missions);
        // /manager_v1.jsp(41,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fforEach_005f0.setVar("m");
        int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
        try {
          int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
          if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n");
              out.write("\t\t\t\t\t\t\t\t<li class=\"danger-element\" style=\"\">\r\n");
              out.write("\t\t\t\t\t\t\t\t<b>");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.missionName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
              out.write("</b>\r\n");
              out.write("\t\t\t\t\t\t\t\t<p>");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.missionContent }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
              out.write("</p>\r\n");
              out.write("\t\t\t\t\t\t\t\t\t<div class=\"agile-detail\">\r\n");
              out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-clock-o\"></i> ");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.missionTime }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
              out.write("\r\n");
              out.write("\t\t\t\t\t\t\t\t\t</div></li>\r\n");
              out.write("\t\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            return;
          }
        } catch (java.lang.Throwable _jspx_exception) {
          while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
            out = _jspx_page_context.popBody();
          _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
        } finally {
          _jspx_th_c_005fforEach_005f0.doFinally();
        }
        _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
        _jspx_th_c_005fforEach_005f0_reused = true;
      } finally {
        org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
      }
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"col-sm-6\">\r\n");
      out.write("\t\t\t\t<div class=\"ibox\">\r\n");
      out.write("\t\t\t\t\t<div class=\"ibox-content\">\r\n");
      out.write("\t\t\t\t\t\t<h3>公告</h3>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"sortable-list connectList agile-list ui-sortable\">\r\n");
      out.write("\t\t\t\t\t\t\t");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      boolean _jspx_th_c_005fforEach_005f1_reused = false;
      try {
        _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
        _jspx_th_c_005fforEach_005f1.setParent(null);
        // /manager_v1.jsp(60,7) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
        _jspx_th_c_005fforEach_005f1.setItems(announcements);
        // /manager_v1.jsp(60,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fforEach_005f1.setVar("a");
        int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
        try {
          int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
          if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n");
              out.write("\t\t\t\t\t\t\t\t<li class=\"danger-element\" style=\"\" onclick=\"showAnn('");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${a.annId }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
              out.write("')\"><b>");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${a.head }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
              out.write("</b>\r\n");
              out.write("\t\t\t\t\t\t\t\t\t<div class=\"agile-detail\">\r\n");
              out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-clock-o\"></i> ");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${a.time }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
              out.write('/');
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${a.teaId.name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
              out.write("\r\n");
              out.write("\t\t\t\t\t\t\t\t\t</div></li>\r\n");
              out.write("\t\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            return;
          }
        } catch (java.lang.Throwable _jspx_exception) {
          while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
            out = _jspx_page_context.popBody();
          _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
        } finally {
          _jspx_th_c_005fforEach_005f1.doFinally();
        }
        _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
        _jspx_th_c_005fforEach_005f1_reused = true;
      } finally {
        org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f1_reused);
      }
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 全局js -->\r\n");
      out.write("\t<script src=\"js/jquery.min.js?v=2.1.4\"></script>\r\n");
      out.write("\t<script src=\"js/bootstrap.min.js?v=3.3.6\"></script>\r\n");
      out.write("\t<script src=\"js/jquery-ui-1.10.4.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/plugins/layer/layer.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 自定义js -->\r\n");
      out.write("\t<script src=\"js/content.js?v=1.0.0\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$(document).ready(function() {\r\n");
      out.write("\t\t\t$(\".sortable-list\").sortable({\r\n");
      out.write("\t\t\t\tconnectWith : \".connectList\"\r\n");
      out.write("\t\t\t}).disableSelection();\r\n");
      out.write("\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction showAnn(id){\r\n");
      out.write("\t\t\twindow.location.href=\"showAnn?annId=\"+id;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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
}
