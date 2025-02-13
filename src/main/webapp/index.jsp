<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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
<%
    List<String> notes = (List<String>) session.getAttribute("notes");
    if (notes != null) {
        for (String note : notes) {
%>
<p><%= note %></p>
<%
    }
} else {
%>
<p>Keine Notizen vorhanden.</p>
<% } %>

<a href="manage.jsp">Notizen verwalten</a> | <a href="login.jsp">Logout</a>
</body>
</html>
