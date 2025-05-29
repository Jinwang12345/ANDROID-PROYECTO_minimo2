package dsa.upc.edu.listapp;

public class Issue {
    public String date;
    public String title;
    public String message;
    public String sender;

    public Issue() {
        // Constructor vacío
    }

    public Issue(String date, String title, String message, String sender) {
        this.date = date;
        this.title = title;
        this.message = message;
        this.sender = sender;
    }

    // Getters y setters
    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }
}
