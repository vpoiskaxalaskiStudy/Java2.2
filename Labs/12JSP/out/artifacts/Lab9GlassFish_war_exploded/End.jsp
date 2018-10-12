<%@ page import="javax.xml.soap.Name" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
    String cardNumber = null;
    String csv = null;
    String name = null;
    String surname = null;
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie: cookies) {
        if (cookie.getName().equals("cardNumber"))
            cardNumber = cookie.getValue();
        if (cookie.getName().equals("csv"))
            csv = cookie.getValue();
        if (cookie.getName().equals("name"))
            name = cookie.getValue();
        if (cookie.getName().equals("surname"))
            surname = cookie.getValue();
    }
    out.println("<h1>Name: " + name + "</h1>");
    out.println("<h1>Surname: " + surname + "</h1>");
    out.println("<h1>Card Number: " + cardNumber + "</h1>");
    out.println("<h1>CSV Number: " + csv + "</h1>");

%>
<a href="/Lab9GlassFish_war_exploded/ForwardCard">Back</a>
<a href="/Lab9GlassFish_war_exploded/index.html">Main</a>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
