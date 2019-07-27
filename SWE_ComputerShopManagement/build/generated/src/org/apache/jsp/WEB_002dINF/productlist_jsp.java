package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class productlist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Product List</title>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                padding-left: 15%;\n");
      out.write("                padding-right: 15%;\n");
      out.write("                font-family: Lucida Sans, Verdana;\n");
      out.write("                background-color: #fff8c6;\n");
      out.write("            }\n");
      out.write("            h1 {\n");
      out.write("                /*mix-blend-mode: color-dodge;*/\n");
      out.write("                font-family: Candara;\n");
      out.write("                font-size: 5rem;\n");
      out.write("                text-align: center;\n");
      out.write("                color: #ffad33;\n");
      out.write("            }\n");
      out.write("            th {\n");
      out.write("                font-size:20px;\n");
      out.write("                border: 1.5px solid black;\n");
      out.write("            }\n");
      out.write("            table,tr,td{\n");
      out.write("                font-size:18px;\n");
      out.write("                border: 1.5px solid black;\n");
      out.write("            }\n");
      out.write("            table{\n");
      out.write("                border-spacing: 0;\n");
      out.write("            }\n");
      out.write("            th,td{\n");
      out.write("                width: 500px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            tr {\n");
      out.write("                height:50px;\n");
      out.write("                width: 900px;\n");
      out.write("            }\n");
      out.write("            #add,#title,#edit,#deleteForm {\n");
      out.write("                display:inline-block;\n");
      out.write("            }\n");
      out.write("            button, #add, #delete{\n");
      out.write("                border-radius: 20px;\n");
      out.write("                color: white;\n");
      out.write("                padding: 10px 20px;\n");
      out.write("                font-size: 15px;\n");
      out.write("                border: 0;\n");
      out.write("            }\n");
      out.write("            #add {\n");
      out.write("                background-color: #00ff00;\n");
      out.write("                float:right;\n");
      out.write("                margin: 20px;\n");
      out.write("            }\n");
      out.write("            #show {\n");
      out.write("                background-color: #00ffff;\n");
      out.write("            }\n");
      out.write("            #edit {\n");
      out.write("                background-color: royalblue;\n");
      out.write("            }\n");
      out.write("            #delete {\n");
      out.write("                background-color: red;\n");
      out.write("            }\n");
      out.write("            .id{\n");
      out.write("                width: 200px;\n");
      out.write("            }\n");
      out.write("            .name {\n");
      out.write("                width: 650px;\n");
      out.write("            }\n");
      out.write("            .action {\n");
      out.write("                width: 25%;\n");
      out.write("            }\n");
      out.write("            button:hover, input:hover {\n");
      out.write("                text-decoration: none;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("            a:visited, a:link, a:active {\n");
      out.write("                color:white;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("            function confirmDelete(){\n");
      out.write("                return confirm('Are you sure to delete this record?');\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 id =\"title\">Product List</h1>\n");
      out.write("        <div>\n");
      out.write("            <form action=\"productadd\" method=\"get\">\n");
      out.write("                <input type=\"submit\" id=\"add\" value=\"Add New Product\"/>\n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        <br><br>\n");
      out.write("        <p style=\"margin: 50px\"></p>\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <th class=\"id\">ID</th>\n");
      out.write("                <th class=\"name\">Product Name</th>\n");
      out.write("                <th class=\"categoryID\">Category ID</th>\n");
      out.write("                <th class=\"price\">Price</th>\n");
      out.write("                <th class=\"quantity\">Quantity</th>\n");
      out.write("                <th class=\"describe\">Describe</th>\n");
      out.write("                <th class=\"addDate\">Add Date</th>\n");
      out.write("                <th class=\"action\">Action</th>\n");
      out.write("            </tr>\n");
      out.write("            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listProduct}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("product");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                <tr>\n");
          out.write("                    <td class=\"id\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                    <td class=\"name\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                    <td class=\"categoryID\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.categoryID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                    <td class=\"price\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                    <td class=\"quantity\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.quantity}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                    <td class=\"describe\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.describe}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                    <td class=\"addDate\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.addDate}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                    <td class=\"action\">\n");
          out.write("                        <a href=\"productdetail?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"><button id=\"show\">Show</button></a>\n");
          out.write("                        <a href=\"productedit?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"><button id =\"edit\">Edit</button></a>\n");
          out.write("                        <form id=\"deleteForm\" action=\"productdelete?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" \n");
          out.write("                              method=\"post\" onsubmit=\"return confirmDelete()\">\n");
          out.write("                            <input type=\"submit\" id =\"delete\" value=\"Delete\"/>\n");
          out.write("                        </form>\n");
          out.write("                    </td>\n");
          out.write("                </tr>\n");
          out.write("                \n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
