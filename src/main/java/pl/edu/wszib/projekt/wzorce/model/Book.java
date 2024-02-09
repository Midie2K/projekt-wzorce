package pl.edu.wszib.projekt.wzorce.model;

import lombok.*;
import pl.edu.wszib.projekt.wzorce.builder.BookBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Book {
    private int id;
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    public static BookBuilder builder(){
        return new BookBuilder();
    }

    public Book(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    public Book(String title, String author, String isbn, boolean available){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = available;
    }

    @Override
    public String toString(){
        String isAvailable = available?"Dostępna":"Niedostępna";
    return id + "; " + title + "; " +
            author + "; " + isbn + "; " +
            isAvailable + ".";
    }
}
