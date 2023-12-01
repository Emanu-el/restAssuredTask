package models;

public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;

    public int getUserId() { return userId; }
    public void setUserId(int value) { this.userId = value; }

    public int getID() { return id; }
    public void setID(int value) { this.id = value; }

    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }

    public String getBody() { return body; }
    public void setBody(String value) { this.body = value; }
}
