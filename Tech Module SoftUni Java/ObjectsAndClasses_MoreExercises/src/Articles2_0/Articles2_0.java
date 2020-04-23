package Articles2_0;

public class Articles2_0 {
    private String title;
    private String content;
    private String author;

    public Articles2_0(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getAuthor() {
        return this.author;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s",
                this.getTitle(),
                this.getContent(),
                this.getAuthor());
    }
}
