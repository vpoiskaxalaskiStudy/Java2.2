<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 21.05.18
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    out.println("<h1> Error: " + (String)request.getAttribute("error") + "</h1>");
    out.println("<h1> Code: " + (String)request.getAttribute("code") + "</h1>");
%>
</body>
</html>
