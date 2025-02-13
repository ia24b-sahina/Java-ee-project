<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Login</title></head>
<body>
<h1>Login</h1>
<c:if test="${param.error != null}">
    <p style="color: red;">Falscher Benutzername oder Passwort!</p>
</c:if>
<form action="login" method="post">
    Benutzername: <input type="text" name="username" required><br>
    Passwort: <input type="password" name="password" required><br>
    <input type="submit" value="Login">
</form>
</body>
</html>
