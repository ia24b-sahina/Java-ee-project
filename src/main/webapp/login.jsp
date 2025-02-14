<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Notitz Manager - Login</title>
    <link rel="stylesheet" href="login.css">
</head>
<body>

<h1>Notitz Manager</h1>

<div class="login-container">
    <c:if test="${param.error != null}">
        <p class="error-message">Falscher Benutzername oder Passwort!</p>
    </c:if>

    <form action="login" method="post">
        <input type="text" name="benutzername" placeholder="Benutzername" required>
        <input type="password" name="passwort" placeholder="Passwort" required>
        <button type="submit">Log in</button>
    </form>
</div>



<div class="footer">
    &copy; 2025 Notitz Manager. Alle Rechte vorbehalten.
</div>

</body>
</html>
