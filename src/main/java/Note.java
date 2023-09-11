public class Note{
    private String title;
    private String content;

    public Note(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
    public void printNote(){
        System.out.println("제목" + title);
        System.out.println("내용" + content);

    }
}
