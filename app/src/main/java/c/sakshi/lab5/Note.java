package c.sakshi.lab5;

public class Note {
    private String date;
    private String username;
    private String title;
    private String content;
    Note(String d,String u,String t,String c) {
        date=d;
        username=u;
        title=t;
        content=c;
    }

    public String getDate() {
        return date;
    }

    public String getUsername() {
        return username;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}