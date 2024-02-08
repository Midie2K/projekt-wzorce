package pl.edu.wszib.projekt.wzorce;

import pl.edu.wszib.projekt.wzorce.iterator.impl.BookIterator;
import pl.edu.wszib.projekt.wzorce.repository.BookRepository;

public class App {
    public static void main(String[] args) {
        BookIterator iterator = new BookIterator(BookRepository.getInstance().getBooks());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
