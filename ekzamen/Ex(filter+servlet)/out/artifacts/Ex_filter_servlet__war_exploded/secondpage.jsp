<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 27.06.2018
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="form">
    <h1>Вход в систему</h1><br>
    <form action="SecondServlet" method="get">

        <input type="text" required placeholder="login" name="login"><br>
        <input type="password" required placeholder="password" name="password"><br><br>
        <input class="button" type="submit" value="Войти">

    </form>
</body>
</html>
