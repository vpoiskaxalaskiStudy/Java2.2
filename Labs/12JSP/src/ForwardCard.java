import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForwardCard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("cardNumber"))
                cookie.setValue(cookie.getValue());
            if (cookie.getName().equals("csv"))
                cookie.setValue(cookie.getValue());
            if (cookie.getName().equals("name"))
                cookie.setValue(cookie.getValue());
            if (cookie.getName().equals("surname"))
                cookie.setValue(cookie.getValue());
        }
        request.getRequestDispatcher("/DataCard.jsp").forward(request, response);
    }
}
