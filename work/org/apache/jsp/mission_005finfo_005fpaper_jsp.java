/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.76
 * Generated at: 2018-03-13 02:14:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.DMS.ghb.entity.Papers;
import java.util.List;

public final class mission_005finfo_005fpaper_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	List<Papers> papers = (List<Papers>)request.getAttribute("papers");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("<title>- 数据表格</title>\r\n");
      out.write("<meta name=\"keywords\" content=\"\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"favicon.ico\">\r\n");
      out.write("<link href=\"css/bootstrap.min.css?v=3.3.6\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"css/font-awesome.css?v=4.4.0\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Data Tables -->\r\n");
      out.write("<link href=\"css/plugins/dataTables/dataTables.bootstrap.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<link href=\"css/animate.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"css/style.css?v=4.1.0\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"gray-bg\">\r\n");
      out.write("\t<input id=\"usertype\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${suser.type }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" hidden=\"\">\r\n");
      out.write("\t<div class=\"wrapper wrapper-content animated fadeInRight\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-sm-12\">\r\n");
      out.write("\t\t\t\t<div class=\"ibox float-e-margins\">\r\n");
      out.write("\t\t\t\t\t<div class=\"ibox-title\">\r\n");
      out.write("\t\t\t\t\t\t<h5>任务</h5>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary btn-xs\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"float: right; margin-right: 10px;\" onclick=\"ex('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mId }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')\">导出</button>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"ibox-content\">\r\n");
      out.write("\t\t\t\t\t\t<table\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"table table-striped table-bordered table-hover dataTables-example\">\r\n");
      out.write("\t\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>学号</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>学生姓名</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>论文题目</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>审批</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      boolean _jspx_th_c_005fforEach_005f0_reused = false;
      try {
        _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
        _jspx_th_c_005fforEach_005f0.setParent(null);
        // /mission_info_paper.jsp(59,8) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
        _jspx_th_c_005fforEach_005f0.setItems(papers);
        // /mission_info_paper.jsp(59,8) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fforEach_005f0.setVar("p");
        int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
        try {
          int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
          if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n");
              out.write("\t\t\t\t\t\t\t\t\t<tr class=\"gradeX\">\r\n");
              out.write("\t\t\t\t\t\t\t\t\t\t<td>");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${p.students.stuNum }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
              out.write("</td>\r\n");
              out.write("\t\t\t\t\t\t\t\t\t\t<td>");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${p.students.name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
              out.write("</td>\r\n");
              out.write("\t\t\t\t\t\t\t\t\t\t<td>");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${p.name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
              out.write("</td>\r\n");
              out.write("\t\t\t\t\t\t\t\t\t\t<td><button type=\"button\" class=\"btn btn-primary btn-sm\" onclick=\"hege('");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${p.papersId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
              out.write("')\">合格</button>\r\n");
              out.write("\t\t\t\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary btn-sm\" onclick=\"buhege('");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${p.papersId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
              out.write("')\">不合格</button>\r\n");
              out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
              out.write("\t\t\t\t\t\t\t\t");
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
      out.write("\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 全局js -->\r\n");
      out.write("\t<script src=\"js/jquery.min.js?v=2.1.4\"></script>\r\n");
      out.write("\t<script src=\"js/bootstrap.min.js?v=3.3.6\"></script>\r\n");
      out.write("\t<script src=\"js/layer/layer.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"js/plugins/jeditable/jquery.jeditable.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Data Tables -->\r\n");
      out.write("\t<script src=\"js/plugins/dataTables/jquery.dataTables.js\"></script>\r\n");
      out.write("\t<script src=\"js/plugins/dataTables/dataTables.bootstrap.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 自定义js -->\r\n");
      out.write("\t<script src=\"js/content.js?v=1.0.0\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Page-Level Scripts -->\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$(document).ready(function() {\r\n");
      out.write("\t\t\tinit();\r\n");
      out.write("\t\t\t$('.dataTables-example').dataTable();\r\n");
      out.write("\r\n");
      out.write("\t\t\t/* Init DataTables */\r\n");
      out.write("\t\t\tvar oTable = $('#editable').dataTable();\r\n");
      out.write("\r\n");
      out.write("\t\t\t/* Apply the jEditable handlers to the table */\r\n");
      out.write("\t\t\toTable.$('td').editable('../example_ajax.php', {\r\n");
      out.write("\t\t\t\t\"callback\" : function(sValue, y) {\r\n");
      out.write("\t\t\t\t\tvar aPos = oTable.fnGetPosition(this);\r\n");
      out.write("\t\t\t\t\toTable.fnUpdate(sValue, aPos[0], aPos[1]);\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t\"submitdata\" : function(value, settings) {\r\n");
      out.write("\t\t\t\t\treturn {\r\n");
      out.write("\t\t\t\t\t\t\"row_id\" : this.parentNode.getAttribute('id'),\r\n");
      out.write("\t\t\t\t\t\t\"column\" : oTable.fnGetPosition(this)[2]\r\n");
      out.write("\t\t\t\t\t};\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\"width\" : \"90%\",\r\n");
      out.write("\t\t\t\t\"height\" : \"100%\"\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\tfunction fnClickAddRow() {\r\n");
      out.write("\t\t\t$('#editable').dataTable()\r\n");
      out.write("\t\t\t\t\t.fnAddData(\r\n");
      out.write("\t\t\t\t\t\t\t[ \"Custom row\", \"New row\", \"New row\", \"New row\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\"New row\" ]);\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction init() {\r\n");
      out.write("\t\t\tvar type = $(\"#usertype\").val();\r\n");
      out.write("\t\t\tif (type == \"3\") {\r\n");
      out.write("\t\t\t\t$('table tr').find('th:eq(3)').remove();\r\n");
      out.write("\t\t\t\t$('table tr').find('td:eq(3)').remove();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction ex(mId) {\r\n");
      out.write("\t\t\tlayer.load();\r\n");
      out.write("\t\t\tvar url = \"/dms/exportPaper?mId=\"+mId;\r\n");
      out.write("\t\t\tvar xhr = new XMLHttpRequest();\r\n");
      out.write("\t\t\txhr.open('GET', url, true); // 也可以使用POST方式，根据接口\r\n");
      out.write("\t\t\txhr.responseType = \"blob\"; // 返回类型blob\r\n");
      out.write("\t\t\t// 定义请求完成的处理函数，请求前也可以增加加载框/禁用下载按钮逻辑\r\n");
      out.write("\t\t\txhr.onload = function() {\r\n");
      out.write("\t\t\t\t// 请求完成\r\n");
      out.write("\t\t\t\t$(\"#bg,.loading\").hide();\r\n");
      out.write("\t\t\t\tif (this.status === 200) {\r\n");
      out.write("\t\t\t\t\t// 返回200\r\n");
      out.write("\t\t\t\t\tvar blob = this.response;\r\n");
      out.write("\t\t\t\t\tvar reader = new FileReader();\r\n");
      out.write("\t\t\t\t\t// alert(reader);\r\n");
      out.write("\t\t\t\t\treader.readAsDataURL(blob); // 转换为base64，可以直接放入a表情href\r\n");
      out.write("\t\t\t\t\treader.onload = function(e) {\r\n");
      out.write("\t\t\t\t\t\t// 转换完成，创建一个a标签用于下载\r\n");
      out.write("\t\t\t\t\t\tvar a = document.createElement('a');\r\n");
      out.write("\t\t\t\t\t\ta.download =getData()+'-学生论文.xls';\r\n");
      out.write("\t\t\t\t\t\ta.href = e.target.result;\r\n");
      out.write("\t\t\t\t\t\t$(\"body\").append(a); // 修复firefox中无法触发click\r\n");
      out.write("\t\t\t\t\t\ta.click();\r\n");
      out.write("\t\t\t\t\t\t$(a).remove();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t layer.closeAll('loading');\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t\t// 发送ajax请求\r\n");
      out.write("\t\t\txhr.send()\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction hege(id) {\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\t\turl : \"/dms/changePMessage\",\r\n");
      out.write("\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\tcId : id,\r\n");
      out.write("\t\t\t\t\tmessage : \"合格\" \r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tsuccess : function(data, textStatus) {\r\n");
      out.write("\t\t\t\t\tif (data == \"success\") {\r\n");
      out.write("\t\t\t\t\t\tlayer.msg('已审核', {\r\n");
      out.write("\t\t\t\t\t\t\ttime : 1000,\r\n");
      out.write("\t\t\t\t\t\t\ticon : 1,\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\tlayer.msg('服务器错误', {\r\n");
      out.write("\t\t\t\t\t\t\ttime : 1000,\r\n");
      out.write("\t\t\t\t\t\t\ticon : 7,\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction buhege(id) {\r\n");
      out.write("\t\t\tlayer.prompt({\r\n");
      out.write("\t\t\t\ttitle : '请输入不合格原因',\r\n");
      out.write("\t\t\t\tformType : 2\r\n");
      out.write("\t\t\t}, function(text, index) {\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\t\t\turl : \"/dms/changePMessage\",\r\n");
      out.write("\t\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\tcId : id,\r\n");
      out.write("\t\t\t\t\t\tmessage : \"不合格，原因：\"+text  \r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tsuccess : function(data, textStatus) {\r\n");
      out.write("\t\t\t\t\t\tif (data == \"success\") {\r\n");
      out.write("\t\t\t\t\t\t\tlayer.msg('已审核', {\r\n");
      out.write("\t\t\t\t\t\t\t\ttime : 1000,\r\n");
      out.write("\t\t\t\t\t\t\t\ticon : 1,\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\tlayer.close(index);\r\n");
      out.write("\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\tlayer.msg('服务器错误', {\r\n");
      out.write("\t\t\t\t\t\t\t\ttime : 1000,\r\n");
      out.write("\t\t\t\t\t\t\t\ticon : 7,\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction p(s) {\r\n");
      out.write("\t\t    return s < 10 ? '0' + s: s;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction getData(){\r\n");
      out.write("\t\t\tvar myDate = new Date();\r\n");
      out.write("\t\t\t//获取当前年\r\n");
      out.write("\t\t\tvar year=myDate.getFullYear();\r\n");
      out.write("\t\t\t//获取当前月\r\n");
      out.write("\t\t\tvar month=myDate.getMonth()+1;\r\n");
      out.write("\t\t\t//获取当前日\r\n");
      out.write("\t\t\tvar date=myDate.getDate(); \r\n");
      out.write("\t\t\tvar h=myDate.getHours();       //获取当前小时数(0-23)\r\n");
      out.write("\t\t\tvar m=myDate.getMinutes();     //获取当前分钟数(0-59)\r\n");
      out.write("\t\t\tvar s=myDate.getSeconds();  \r\n");
      out.write("\t\t\tvar now=year+p(month)+p(date)+p(h)+p(m)+p(s);\r\n");
      out.write("\t\t\treturn now;\r\n");
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
