<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="org.example.notiztenprojekt.NotizenDAO, java.util.List" %>

<%
    int userID = 1;
    List<String[]> notes = NotizenDAO.getNotes(userID);
    request.setAttribute("notes", notes);
%>

<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Notizen</title>
    <link rel="stylesheet" href="notizen.css">

</head>
<body>
<div class="titel-container">
    <h1>Notizen erstellen</h1>
</div>
<div class="note-form-container">
    <h1>Neue Notiz</h1>
    <form action="note" method="post">
        <label for="title">Titel:</label>
        <input type="text" id="title" name="title" required>

        <label for="content">Beschreibung:</label>
        <textarea id="content" name="content" required></textarea>

        <input type="submit" value="Speichern">
    </form>
</div>

<div class="notes-container">
    <h2>Gespeicherte Notizen</h2>
    <c:choose>
        <c:when test="${not empty notes}">
            <c:forEach var="note" items="${notes}">
                <div class="note-item">
                    <h3>${note[0]}</h3> <!-- Titel -->
                    <p>${note[1]}</p>  <!-- Inhalt -->
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p>Keine Notizen vorhanden.</p>
        </c:otherwise>
    </c:choose>
</div>

<div class="links">
    <a href="bearbeiten.jsp">Notizen verwalten</a> | <a href="login.jsp">Logout</a>
</div>
</body>
</html>
