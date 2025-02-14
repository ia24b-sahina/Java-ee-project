<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<html>
<head><title>Notizen</title></head>
<body>
<h1>Neue Notiz</h1>
<form action="note" method="post">
    Titel: <input type="text" name="title" required><br>
    Beschreibung: <textarea name="content" required></textarea><br>
    <input type="submit" value="Speichern">
</form>

<h2>Letzte 4 Notizen</h2>
<c:choose>
    <c:when test="${not empty sessionScope.notes}">
        <c:forEach var="note" items="${sessionScope.notes}">
            <p>${note}</p>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>Keine Notizen vorhanden.</p>
    </c:otherwise>
</c:choose>

<a href="manage.jsp">Notizen verwalten</a> | <a href="login.jsp">Logout</a>
</body>
</html>
