package model;

public class Book {
    private final int id;
    private final String name;
    private final String author;
    private final String genre;
    private boolean isAvailable;

    public Book(int id, String name, String author, String genre, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}