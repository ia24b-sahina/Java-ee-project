package org.example.notiztenprojekt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BearbeitenDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/notizen_db";
    private static final String USER = "root";
    private static final String PASS = "";

    public static List<String[]> getNotes(int userID) {
        List<String[]> notes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("SELECT Titel, Inhalt, NotizenID FROM Notizen WHERE UserID = ?")) {

            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                notes.add(new String[]{rs.getString("Titel"), rs.getString("Inhalt"), rs.getString("NotizenID")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notes;
    }

    public static void updateNote(int noteID, String title, String content) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("UPDATE Notizen SET Titel = ?, Inhalt = ? WHERE NotizenID = ?")) {

            stmt.setString(1, title);
            stmt.setString(2, content);
            stmt.setInt(3, noteID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteNote(int noteID) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM Notizen WHERE NotizenID = ?")) {

            stmt.setInt(1, noteID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
