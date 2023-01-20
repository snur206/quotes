package quotes;

public class Quote {
    public String author;
    public String text;

    public Quote(String author, String text) {
        this.author = author;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
