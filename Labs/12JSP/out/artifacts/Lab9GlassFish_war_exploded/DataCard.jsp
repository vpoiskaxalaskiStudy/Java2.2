
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
    <%
        String name = null;
        String surname = null;
        String csv = null;
        String cardNumber = null;
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
        out.println("<h1>Name " + name + "</h1>");
        out.println("<h1>Surname " + surname + "</h1>");
        request.setAttribute("name", request.getAttribute("name"));
        request.setAttribute("surname", request.getAttribute("surname"));
    %>
    <div>
        <form method="post" action="/Lab9GlassFish_war_exploded/DataCard">
            <label>Card Number:
                <%
                    if (cardNumber != null)
                        out.println("<input type=\"text\" value=\"" + cardNumber + "\" name=\"cardNumber\"><br />");
                    else
                        out.println("<input type=\"text\" name=\"cardNumber\"><br />");
                %>
            </label>
            <label>SCV code:
                <%
                    if (csv !=null)
                        out.println("<input type=\"text\" value=\"" + csv + "\" name=\"csv\"><br />");
                    else
                        out.println("<input type=\"text\" name=\"csv\"><br />");
                %>
            </label>
            <button type="submit">Next</button>
        </form></div>
        <a href="/Lab9GlassFish_war_exploded/ForwardBack">Back</a>
        <a href="/Lab9GlassFish_war_exploded/index.html">Main</a>
<jsp:include page="footer.jsp"/>
</body>
</html>
