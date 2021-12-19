package model;

public class BoardVO {
    private int bid;
    private int uid;
    private String date;
    private String title;
    private String content;
    private int favcnt;

    public void setBid(int bid) {
        this.bid = bid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFavcnt(int favcnt) {
        this.favcnt = favcnt;
    }

    public int getBid() {
        return bid;
    }

    public int getUid() {
        return uid;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getFavcnt() {
        return favcnt;
    }
}
