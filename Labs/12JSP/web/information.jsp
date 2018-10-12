<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 08.05.18
  Time: 1:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information</title>
</head>
<body>
<h1>Information</h1>
<%
    String title = "Servlet Example: Showing Request Headers";
    String date = (String)request.getAttribute("date");
out.println("<HTTP><HEADER>Request Headers</HEADER>\n" +
    "<BODY BGCOLOR=\"#FDF5E6\">\n" +
    "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
    "<B>Request Method: </B>" +
    request.getMethod() + "<BR>\n" +
    "<B>Request URI: </B>" +
    request.getRequestURI() + "<BR>\n" +
    "<B>Request Protocol: </B>" +
    request.getProtocol() + "<BR>\n" +
        "<B>Date, time: : </B>" +
        date + "<BR><BR>\n" +
    "<TABLE BORDER=1 ALIGN=CENTER>\n" + "<TR BGCOLOR=\"#FFAD00\">\n" + "<TH>Header Name<TH>Header Value");
                Enumeration headerNames = request.getHeaderNames();
                while(headerNames.hasMoreElements()) {
                String headerName = (String)headerNames.nextElement();
                out.println("<TR><TD>" + headerName);
            out.println("    <TD>" + request.getHeader(headerName));
            };
%>
</body>
</html>
