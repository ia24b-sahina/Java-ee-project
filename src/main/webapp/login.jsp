<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Notiz Manager - Login</title>
    <link rel="stylesheet" href="login.css">
</head>
<body>

<div class="titel-container">
    <h1>Notiz Manager</h1>
</div>

<div class="login-container">
    <c:if test="${param.error != null}">
        <p class="error-message">Falscher Benutzername oder Passwort!</p>
    </c:if>

    <form action="login" method="post">
        <label for="benutzername">Benutzername:</label>
        <input type="text" id="benutzername" name="benutzername" placeholder="Benutzername" required>

        <label for="passwort">Passwort:</label>
        <input type="password" id="passwort" name="passwort" placeholder="Passwort" required>

        <button type="submit">Log in</button>
    </form>
</div>

<img src="${pageContext.request.contextPath}/img/pinker_zettel.png" alt="Notiz" class="note note1">
<img src="${pageContext.request.contextPath}/img/gelber_zettel.png" alt="Notiz" class="note note2">
<img src="${pageContext.request.contextPath}/img/gelber_zettel.png" alt="Notiz" class="note note3">
<img src="${pageContext.request.contextPath}/img/pinker_zettel.png" alt="Notiz" class="note note4">

</body>
</html>