<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 26.06.2018
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%--%>
    <%--Cookie[] cookies = request.getCookies();--%>
    <%--if ( cookies != null ) {--%>
        <%--for ( Cookie cookie : cookies ) {--%>
            <%--if ( cookie != null ) {--%>
<%--%>--%>
<%--<div>--%>
    <%--<b><%=cookie.getName()%></b>&nbsp;<%=cookie.getPath()%>&nbsp;<%=cookie.getDomain()%>&nbsp;<%=cookie.getValue()%>--%>
<%--</div>--%>
<%--<%--%>
            <%--}--%>
        <%--}--%>
    <%--}--%>
<%--%>--%>
    <%
  Cookie[] cookies = request.getCookies();
  if ( cookies != null ) {
	  for ( Cookie cookie : cookies ) {
		 if ( cookie != null ) {
			 %>
Ваше имя: <input type="text" required placeholder="login" name="login"  value="<%= request.getParameter("name")%>">
<%--Ваше имя: <input type="text" required placeholder="login" name="login"  value="<%= (String)cookie.getValue()%>">--%>
<%
            }
        }
    }
%>

</body>
</html>
