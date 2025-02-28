package org.example.notiztenprojekt;

public class User {
    private int userID;
    private String benutzername;
    private String passwort;

    public User(int userID, String benutzername, String passwort) {
        this.userID = userID;
        this.benutzername = benutzername;
        this.passwort = passwort;
    }


    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }


}
