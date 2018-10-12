import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/buttonup")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie newCookie = new Cookie("name",req.getParameter("login"));
//        newCookie.setMaxAge(0); удаление файла куки
        resp.addCookie(newCookie);
        this.getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
    }
}
