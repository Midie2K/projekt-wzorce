package pl.edu.wszib.projekt.wzorce.core;

import pl.edu.wszib.projekt.wzorce.iterator.impl.BookIterator;
import pl.edu.wszib.projekt.wzorce.model.Book;
import pl.edu.wszib.projekt.wzorce.repository.BookRepository;
import pl.edu.wszib.projekt.wzorce.ui.SimpleUI;

import java.util.Scanner;

public class Core {
    Scanner scanner = new Scanner(System.in);
    SimpleUI ui = new SimpleUI();
    private boolean running = true;
    private int selector;
    private int innerSelector;
    private String pattern;
    private BookIterator bookIterator;
    private int bookId;
    private Book book;

    public Core(){}

    public void start(){
        while(running){
            ui.printMenu();
            System.out.print("wybierz funkcje: ");
            selector = scanner.nextInt();

            switch (selector){
                case 1:
                    bookIterator = new BookIterator(BookRepository.getInstance()
                                                    .getAll());
                    ui.printBook();
                    while (bookIterator.hasNext()) {
                        System.out.println(bookIterator.next());
                    }
                    System.out.println();
                    break;
                case 2:
                    bookIterator = new BookIterator(BookRepository.getInstance()
                            .getAllAvailable());
                    ui.printBook();
                    while (bookIterator.hasNext()) {
                        System.out.println(bookIterator.next());
                    }
                    System.out.println();
                    break;
                case 3:
                    ui.printSearch();
                    pattern = scanner.next();
                    bookIterator = new BookIterator(BookRepository.getInstance()
                                                    .getBooksByPattern(pattern));
                    ui.printBook();
                    while (bookIterator.hasNext()) {
                        System.out.println(bookIterator.next());
                    }
                    System.out.println();
                    break;
                case 4:
                    bookIterator = new BookIterator(BookRepository.getInstance()
                                                    .getAllAvailable());
                    ui.printBook();
                    while (bookIterator.hasNext()) {
                        System.out.println(bookIterator.next());
                    }
                    System.out.println();
                    ui.getId();
                    bookId = scanner.nextInt();
                    book = BookRepository.getInstance().getById(bookId);
                    if(book != null && book.isAvailable()){
                        book.setAvailable(false);
                        BookRepository.getInstance().update(book);
                        ui.bookRenting();
                    }
                    else{
                        ui.idError();
                    }
                    break;
                case 5:
                    bookIterator = new BookIterator(BookRepository.getInstance()
                                                    .getAllUnavailable());
                    ui.printBook();
                    while (bookIterator.hasNext()) {
                        System.out.println(bookIterator.next());
                    }
                    System.out.println();
                    ui.getId();
                    bookId = scanner.nextInt();
                    book = BookRepository.getInstance().getById(bookId);
                    if(book != null && !book.isAvailable()){
                        book.setAvailable(true);
                        BookRepository.getInstance().update(book);
                        ui.bookReturnin();
                    }
                    else{
                        ui.idError();
                    }
                    break;
                case 6:
                    String title, author, isbn;
                    ui.getTitle();
                    title = scanner.next();
                    ui.getAuthor();
                    author = scanner.next();
                    ui.getISBN();
                    isbn = scanner.next();
                    if(title != null && author != null && isbn != null){
                        BookRepository.getInstance().addBook(
                                Book.builder()
                                        .title(title)
                                        .author(author)
                                        .isbn(isbn)
                                        .available(true)
                                        .build()
                        );
                        ui.bookAdded();
                    }
                    else {
                        ui.addingError();
                    }
                    break;
                case 0:
                    running = false;
                default:
                    break;
            }
        }


    }

}
