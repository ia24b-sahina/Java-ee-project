package org.example.notiztenprojekt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotizenDAO {

    public static boolean createNote(int userID, String title, String content) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Notizen (Titel, Inhalt, UserID) VALUES (?, ?, ?)");
            stmt.setString(1, title);
            stmt.setString(2, content);
            stmt.setInt(3, userID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<String> getNotes(int userID) {
        List<String> notes = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT Titel FROM Notizen WHERE UserID = ? ORDER BY NotizenID DESC");
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                notes.add(rs.getString("Titel"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notes;
    }

    public static boolean deleteNote(int noteID, int userID) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Notizen WHERE NotizenID = ? AND UserID = ?");
            stmt.setInt(1, noteID);
            stmt.setInt(2, userID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
