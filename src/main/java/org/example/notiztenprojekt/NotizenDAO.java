package org.example.notiztenprojekt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotizenDAO {

    public static boolean createNote(int userID, String title, String content) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Notizen (Titel, Inhalt, UserID) VALUES (?, ?, ?)");
            stmt.setString(1, title);
            stmt.setString(2, content);
            stmt.setInt(3, userID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Methode gibt Titel + Inhalt zurück!
    public static List<String[]> getNotes(int userID) {
        List<String[]> notes = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT Titel, Inhalt FROM Notizen WHERE UserID = ? ORDER BY NotizenID DESC");
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                notes.add(new String[]{rs.getString("Titel"), rs.getString("Inhalt")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notes;
    }
}
