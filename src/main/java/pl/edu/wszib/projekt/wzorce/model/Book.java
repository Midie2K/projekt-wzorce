package pl.edu.wszib.projekt.wzorce.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;

}
