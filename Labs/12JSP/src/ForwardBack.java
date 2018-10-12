import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ForwardBack extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String name = "";
        String surname = "";
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("name")){
                name = cookie.getValue();
            }
            if (cookie.getName().equals("surname")){
                surname = cookie.getValue();
            }
        }
        request.setAttribute("name", name);
        request.setAttribute("surname", surname);
        request.getRequestDispatcher("/InputName.jsp").forward(request, response);
    }
}
