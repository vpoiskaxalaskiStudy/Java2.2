import javax.servlet.*;
import  javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

public class Servlet1 extends  HttpServlet{

    //вывод времени
      protected  void doGet(HttpServletRequest request,HttpServletResponse response)
            throws  ServletException, IOException    {
        response.setContentType("text/html");
        Date d = new Date();
        response.getWriter().println("Current time: " + d.toString());
          response.getWriter().println("<br>");
        String mes = request.getProtocol();
          response.getWriter().println("Protocol:   " + mes);
          response.getWriter().println("<br>");
          mes = request.getLocalAddr();
          response.getWriter().println("Client address: " + mes);
          response.getWriter().println("<br>");
          mes = request.getLocalName();
          response.getWriter().println("Client name:    " + mes);
          response.getWriter().println("<br>");
          mes = request.getMethod();
          response.getWriter().println(mes);
          response.getWriter().println("<br>");
          mes = request.getRequestURI();
          response.getWriter().println("URL:    " + mes);
          response.getWriter().println("<br> Headers: <br>");

          Enumeration headers = request.getHeaderNames();
          while(headers.hasMoreElements()) {
              String headerName = (String)headers.nextElement();
              response.getWriter().println(request.getHeader(headerName));
              response.getWriter().println("<br>");
          }
    }
}

