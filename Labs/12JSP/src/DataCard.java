import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DataCard extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addCookie(new Cookie("cardNumber",request.getParameter("cardNumber")));
        response.addCookie(new Cookie("csv", request.getParameter("csv")));
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("cardNumber")){
                cookie.setValue(request.getParameter("cardNumber"));
                response.addCookie(cookie);
            }

            if (cookie.getName().equals("csv")) {
                cookie.setValue( request.getParameter("csv"));
                response.addCookie(cookie);
            }
        }
        request.setAttribute("cardNumber", request.getParameter("cardNumber"));
        request.setAttribute("csv", request.getParameter("csv"));
        request.getRequestDispatcher("End.jsp").forward(request, response);
    }
}
