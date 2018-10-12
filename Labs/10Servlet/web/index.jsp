<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<form method="get" action="/lab10java_war_exploded/Servlet2">
  <table>
    <tr>
      <td><label for="loginField">Логин</label></td>
      <td><input id="loginField" type="text" name="login"></td>
    </tr>
    <tr>
      <td><label for="passwordField">Пароль</label></td>
      <td><input id="passwordField" type="text" name="password"></td>
    </tr>
  </table>
<input type="submit" value="Login">
</form>
<form action="/lab10java_war_exploded/Servlet1" method="get" >
  <input type="submit" value="Get time">
</form>
</body>
</html>
