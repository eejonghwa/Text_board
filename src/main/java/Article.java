import java.util.Date;

public class Article {

    // 게시물 번호
    private int id;
    // 제목
    private String title;
    // 내용
    private String content;

    private Date date;
    // 작성자
    // 조회수
    // ....

    public Article(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = new Date();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
