<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="org.example.notiztenprojekt.BearbeitenDAO, java.util.List" %>

<%
    int userID = 1; // Platzhalter für den Nutzer (später durch Login ersetzen)
    List<String[]> notes = BearbeitenDAO.getNotes(userID);
    request.setAttribute("notes", notes);

    // Werte für Bearbeitungsformular auslesen
    String editID = request.getParameter("editID");
    String editTitle = "";
    String editContent = "";

    if (editID != null) {
        for (String[] note : notes) {
            if (note[2].equals(editID)) {
                editTitle = note[0];
                editContent = note[1];
                break;
            }
        }
    }
%>

<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Notizen bearbeiten</title>
    <link rel="stylesheet" href="bearbeiten.css">
</head>
<body>

<div class="titel-container">
    <h1>Notizen bearbeiten</h1>
</div>

<div class="notes-container">
    <h1>Gespeicherte Notizen</h1>
    <c:choose>
        <c:when test="${not empty notes}">
            <c:forEach var="note" items="${notes}">
                <div class="note-item">
                    <h3>${note[0]}</h3> <!-- Titel -->
                    <p>${note[1]}</p>  <!-- Inhalt -->

                    <!-- Bearbeiten-Formular, um Daten an bearbeiten.jsp zu senden -->
                    <form action="bearbeiten.jsp" method="get" style="display:inline;">
                        <input type="hidden" name="editID" value="${note[2]}">
                        <input type="submit" value="Bearbeiten">
                    </form>

                    <!-- Löschen-Formular -->
                    <form action="BearbeitenServlet" method="post" style="display:inline;">
                        <input type="hidden" name="noteID" value="${note[2]}">
                        <input type="submit" name="action" value="Löschen" class="delete-btn">
                    </form>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p>Keine Notizen vorhanden.</p>
        </c:otherwise>
    </c:choose>
</div>
<div class="note-form-container">
    <h2>Notiz bearbeiten</h2>
    <form action="BearbeitenServlet" method="post">
        <%--@declare id="title"--%><%--@declare id="content"--%><input type="hidden" name="noteID" value="<%= editID != null ? editID : "" %>">

        <label for="title">Titel:</label>
        <input type="text" name="title" value="<%= editTitle %>" required>

        <label for="content">Inhalt:</label>
        <textarea name="content" required><%= editContent %></textarea>

        <input type="submit" name="action" value="Speichern">
    </form>
</div>

<div class="links">
    <a href="index.jsp">Notizen erstellen</a> | <a href="login.jsp">Logout</a>
</div>

</body>
</html>
