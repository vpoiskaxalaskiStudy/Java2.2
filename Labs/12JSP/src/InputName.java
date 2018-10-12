
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InputName extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        Cookie[] cookies = request.getCookies();
        response.addCookie(new Cookie("name", request.getParameter("name")));
        response.addCookie(new Cookie("surname",request.getParameter("surname")));
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("name")){
                cookie.setValue(request.getParameter("name"));
                response.addCookie(cookie);
            }

            if (cookie.getName().equals("surname")) {
                cookie.setValue(request.getParameter("surname"));
                response.addCookie(cookie);
            }
        }
        request.setAttribute("name", request.getParameter("name"));
        request.setAttribute("surname", request.getParameter("surname"));
        request.getRequestDispatcher("DataCard.jsp").forward(request, response);
    }
}
