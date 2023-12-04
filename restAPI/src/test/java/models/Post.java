package models;

public class Post {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;

    public Integer getUserId() { return userId; }
    public void setUserId(Integer value) { this.userId = value; }

    public Integer getId() { return id; }
    public void setId(Integer value) { this.id = value; }

    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }

    public String getBody() { return body; }
    public void setBody(String value) { this.body = value; }
}
