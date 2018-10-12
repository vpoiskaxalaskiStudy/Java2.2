
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<h1>Hello</h1>
<%
    String name = (String)request.getAttribute("name");
    String date = (String)request.getAttribute("date");
    String role = (String)request.getAttribute("role");
    out.println("<h1>" + request.getAttribute("hello") + " " + name + "</h1>");
    out.println(date);
    out.println("role: " + role);
%>
<br>
<a href="InputName.jsp">Add card</a>
<jsp:include page="footer.jsp"/>
</body>
</html>
