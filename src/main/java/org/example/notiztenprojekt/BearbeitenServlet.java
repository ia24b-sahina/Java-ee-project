package org.example.notiztenprojekt;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/BearbeitenServlet")
public class BearbeitenServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        String noteIDParam = request.getParameter("noteID");
        int noteID = noteIDParam.isEmpty() ? -1 : Integer.parseInt(noteIDParam);

        if ("Löschen".equals(action)) {
            BearbeitenDAO.deleteNote(noteID);
        } else if ("Speichern".equals(action)) {
            String title = request.getParameter("title");
            String content = request.getParameter("content");

            if (noteID == -1) {
                response.sendRedirect("bearbeiten.jsp");
                return;
            } else {
                BearbeitenDAO.updateNote(noteID, title, content);
            }
        }

        response.sendRedirect("bearbeiten.jsp");
    }
}
