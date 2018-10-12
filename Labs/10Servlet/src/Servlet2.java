import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class Servlet2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        if(request.getParameter("login") != null && request.getParameter("password") != null) {
            if (request.getParameter("login").equals("alena") && request.getParameter("password").equals("1111")) {
                Date date = new Date();
                response.getWriter().println("hi,alena" + "<br>" + date.toString());
            }
            else  {
                response.getWriter().println("Access problems!");
            }
        }
    }

}