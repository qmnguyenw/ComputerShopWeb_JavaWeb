package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>LogIn</title>\n");
      out.write("<!--        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" href=\"images/icons/favicon.ico\"/>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/bootstrap/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/font-awesome-4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animate/animate.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/css-hamburgers/hamburgers.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animsition/css/animsition.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/select2/select2.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/daterangepicker/daterangepicker.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/util.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">-->\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("<!--        <div class=\"limiter\">\n");
      out.write("            <div class=\"container-login100\">\n");
      out.write("                <div class=\"wrap-login100\">\n");
      out.write("                    <form class=\"login100-form validate-form p-l-55 p-r-55 p-t-178\" action=\"signin\" method=\"post\">\n");
      out.write("                        \n");
      out.write("                        <span class=\"login100-form-title\">\n");
      out.write("                            Sign In\n");
      out.write("                        </span>\n");
      out.write("\n");
      out.write("                        <div class=\"wrap-input100 validate-input m-b-16\" data-validate=\"Please enter username\">\n");
      out.write("                            <input class=\"input100\" type=\"text\" name=\"username\" placeholder=\"Username\">\n");
      out.write("                            <span class=\"focus-input100\"></span>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"wrap-input100 validate-input\" data-validate = \"Please enter password\">\n");
      out.write("                            <input class=\"input100\" type=\"password\" name=\"pass\" placeholder=\"Password\">\n");
      out.write("                            <span class=\"focus-input100\"></span>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"text-right p-t-13 p-b-23\">\n");
      out.write("                            <span class=\"txt1\">\n");
      out.write("                                Forgot\n");
      out.write("                            </span>\n");
      out.write("\n");
      out.write("                            <a href=\"#\" class=\"txt2\">\n");
      out.write("                                Username / Password?\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"container-login100-form-btn\">\n");
      out.write("                            <button class=\"login100-form-btn\">\n");
      out.write("                                Sign in\n");
      out.write("                            </button>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"flex-col-c p-t-170 p-b-40\">\n");
      out.write("                            <span class=\"txt1 p-b-9\">\n");
      out.write("                                Don’t have an account?\n");
      out.write("                            </span>\n");
      out.write("\n");
      out.write("                            <a href=\"#\" class=\"txt3\">\n");
      out.write("                                Sign up now\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>-->\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--        <script src=\"vendor/jquery/jquery-3.2.1.min.js\"></script>\n");
      out.write("        <script src=\"vendor/animsition/js/animsition.min.js\"></script>\n");
      out.write("        <script src=\"vendor/bootstrap/js/popper.js\"></script>\n");
      out.write("        <script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"vendor/select2/select2.min.js\"></script>\n");
      out.write("        <script src=\"vendor/daterangepicker/moment.min.js\"></script>\n");
      out.write("        <script src=\"vendor/daterangepicker/daterangepicker.js\"></script>\n");
      out.write("        <script src=\"vendor/countdowntime/countdowntime.js\"></script>\n");
      out.write("        <script src=\"js/main.js\"></script>-->\n");
      out.write("\n");
      out.write("        <h1>Sign In to Computer Shop Management</h1>\n");
      out.write("        <form action=\"signin\" method=\"post\">\n");
      out.write("\n");
      out.write("            ");

                String username = request.getParameter("username");
                if (username == null) {
                    username = "";
                }
            
      out.write("\n");
      out.write("\n");
      out.write("            Username: <input type=\"text\" name=\"username\" value=\"");
      out.print(username);
      out.write("\">\n");
      out.write("            <br>\n");
      out.write("            Password: <input type=\"password\" name=\"password\" value=\"\">\n");
      out.write("            <br><br>\n");
      out.write("            <input type=\"submit\" value=\"Sign In\">\n");
      out.write("        </form> \n");
      out.write("        ");

            if (request.getAttribute("errorMessage") != null) {
        
      out.write("\n");
      out.write("        <h2>");
      out.print( request.getAttribute("errorMessage"));
      out.write("</h2>\n");
      out.write("        ");

            }
        
      out.write("\n");
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
}
