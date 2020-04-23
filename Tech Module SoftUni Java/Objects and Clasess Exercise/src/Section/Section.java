package Section;

public class Section {
    private String title;
    private String content;
    private String author;


    public Section(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }


    private String getTitle() {
        return title;
    }

    private String getContent() {
        return content;
    }

    private String getAuthor() {
        return author;
    }



    public void edit(String content) {
         this.content = content;
    }
    public void changeAuthor (String author) {
        this.author = author;
    }
    public void rename (String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s",this.getTitle(),this.getContent(),this.getAuthor());
    }
}
