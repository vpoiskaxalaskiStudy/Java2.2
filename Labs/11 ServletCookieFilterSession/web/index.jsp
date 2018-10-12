<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<form method="get" action="/web_war_exploded/Servlet1">
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
  <br>
<input type="submit" value="Login">
</form>
</body>
</html>
