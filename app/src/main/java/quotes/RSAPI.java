package quotes;

public class RSAPI {
    private String author;
    private String quote;

    public RSAPI(String quote) {
        this.author = "Ron Swanson";
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "RSAPI{" +
                "author='" + author + '\'' +
                ", quote='" + quote + '\'' +
                '}';
    }
}
