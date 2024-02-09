package pl.edu.wszib.projekt.wzorce.builder;

import lombok.NoArgsConstructor;
import pl.edu.wszib.projekt.wzorce.model.Book;
@NoArgsConstructor
public class BookBuilder {
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    public BookBuilder title(String title){
        this.title = title;
        return this;
    }
    public BookBuilder author(String author){
        this.author = author;
        return this;
    }
    public BookBuilder isbn(String isbn){
        this.isbn = isbn;
        return this;
    }
    public BookBuilder available(boolean available){
        this.available = available;
        return this;
    }
    public Book build(){
        return new Book(title, author, isbn, available);
    }

}
