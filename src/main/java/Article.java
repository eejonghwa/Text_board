import java.util.ArrayList;
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

    private int views;

    private ArrayList<String> comments;

    private  int likes;

    public Article(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = new Date();
        this.views = 0;
        this.likes = 0;
        this.comments = new ArrayList<>();
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

    public void increaseViews(){
        this.views++;
    }

    public int getViews() {
        return views;
    }
    public void addComment(String comment){
        comments.add(comment);
    }
    public void like(){
        likes++;
    }
}
