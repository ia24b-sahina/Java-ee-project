package org.example.notiztenprojekt;

public class Notizen {
    private int notizenID;
    private String titel;
    private String inhalt;
    private int userID;

    public Notizen(int notizenID, String titel, String inhalt, int userID) {
        this.notizenID = notizenID;
        this.titel = titel;
        this.inhalt = inhalt;
        this.userID = userID;
    }

    public int getNotizenID() {
        return notizenID;
    }

    public void setNotizenID(int notizenID) {
        this.notizenID = notizenID;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getInhalt() {
        return inhalt;
    }

    public void setInhalt(String inhalt) {
        this.inhalt = inhalt;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }


}
