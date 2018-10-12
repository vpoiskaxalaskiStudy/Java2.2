import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

public class login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            String passwd = req.getParameter("pass");

            String[] user1 = {"admin", "admin", "Alena", "Admin"};
            String[] user2 = {"user", "user", "Alaska", "User"};

            if (name.equals("") || passwd.equals(""))
                throw new Exception("Invalid name or password");
            if ((user1[0].equals(name) && user1[1].equals(passwd)) ||
                    (user2[0].equals(name) && user2[1].equals(passwd))) {
                String tempName, tempRole;
                if (user1[0].equals(name) && user1[1].equals(passwd)){
                    tempName = user1[2];
                    tempRole = user1[3];
                }
                else{
                    tempName = user2[2];
                    tempRole = user2[3];
                }

                HttpSession session = req.getSession();
                Enumeration<java.lang.String> sessionAtributes = session.getAttributeNames();
                while(sessionAtributes.hasMoreElements()){
                    String s = sessionAtributes.nextElement();
                    System.out.println("key - " + s + "value - " + session.getAttribute(s));
                }
                session.setAttribute("timeIn ", new Date().toString());

                Date date = new Date();
                String hello = "";
                if (date.getHours() >= 6 && date.getHours() < 12){
                    hello = "Доброе утро";
                }
                else if (date.getHours() >= 12 && date.getHours() < 18){
                    hello = "Добрый день";
                }
                else if (date.getHours() >= 18 && date.getHours() < 24){
                    hello = "Добрый вечер";
                }
                req.setAttribute("hello", hello);
                req.setAttribute("name", tempName);
                req.setAttribute("date", new Date().toString());
                req.setAttribute("role",tempRole);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user.jsp");
                requestDispatcher.forward(req, res);
            }
            else {
                res.sendRedirect("/Lab9GlassFish_war_exploded/index.html");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            req.setAttribute("error", e.getMessage());
            req.setAttribute("code", "404");
            req.getRequestDispatcher("error.jsp").forward(req, res);
        }
    }
}