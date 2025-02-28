package org.example.notiztenprojekt;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/note")
public class NoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        HttpSession session = request.getSession();

        int userID = (int) session.getAttribute("userId"); // Falls Login-System existiert, echte User-ID setzen

        // Notiz speichern
        NotizenDAO.createNote(userID, title, content);

        // Direkt zurück zur index.jsp (die Notizen selbst lädt)
        response.sendRedirect("index.jsp");
    }
}
