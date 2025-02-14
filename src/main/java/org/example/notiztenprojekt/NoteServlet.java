package org.example.notiztenprojekt;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/note")
public class NoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        List<String> notes = (List<String>) session.getAttribute("notes");

        if (notes == null) {
            notes = new LinkedList<>();
            session.setAttribute("notes", notes);
        }

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        notes.add(0, title + ": " + content);

        if (notes.size() > 4) {
            notes.remove(4);
        }

        response.sendRedirect("index.jsp");
    }
}
