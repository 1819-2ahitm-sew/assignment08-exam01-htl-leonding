package at.htl.exam01.document;

public abstract class Document {

    private String author;

    public Document(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}
