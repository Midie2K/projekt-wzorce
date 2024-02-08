package pl.edu.wszib.projekt.wzorce.iterator.impl;

import pl.edu.wszib.projekt.wzorce.iterator.Iterator;
import pl.edu.wszib.projekt.wzorce.model.Book;

import java.util.List;

public class BookIterator implements Iterator<Book> {
    private List<Book> books;
    private int currentIndex = 0;

    public BookIterator(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < books.size();
    }

    @Override
    public Book next() {
        return books.get(currentIndex++);
    }
}
