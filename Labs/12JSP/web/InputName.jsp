
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div>
    <form method="post" action="/Lab9GlassFish_war_exploded/InputName">
        <label>Name:
            <%
                String name = (String)request.getAttribute("name");
                if (name != null)
                    out.println("<input type=\"text\" value=\"" + name + "\" name=\"name\"><br />");
                else
                    out.println("<input type=\"text\" value=\" name=\"name\"><br />");
            %>
        </label>
        <label>Surname:
            <%
                String surname = (String)request.getAttribute("surname");
                if (surname !=null)
                    out.println("<input type=\"text\" value=\"" + surname + "\" name=\"surname\"><br />");
                else
                    out.println("<input type=\"text\" name=\"surname\"><br />");
            %>
        </label>
        <br>       <button type="submit">Next</button>
        <a href="/Lab9GlassFish_war_exploded/index.html">Main</a>
    </form></div>
<jsp:include page="footer.jsp"/>
</body>
</html>
