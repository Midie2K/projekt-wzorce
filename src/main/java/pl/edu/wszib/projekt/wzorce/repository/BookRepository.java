package pl.edu.wszib.projekt.wzorce.repository;

import pl.edu.wszib.projekt.wzorce.iterator.impl.BookIterator;
import pl.edu.wszib.projekt.wzorce.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<Book> books = new ArrayList<>();
    private static BookRepository INSTANCE = new BookRepository();

    public static final BookRepository getInstance() {
        return INSTANCE;
    }

    public List<Book> getAll() {
        return books;
    }
    public List<Book> getAllAvailable(){
        List<Book> newList = new ArrayList<>();
        BookIterator bookIterator = new BookIterator(books);
        while (bookIterator.hasNext()){
            Book book = bookIterator.next();
            if(book.isAvailable()){
                newList.add(book);
            }
        }
        return newList;
    }
    public List<Book> getAllUnavailable(){
        List<Book> newList = new ArrayList<>();
        BookIterator bookIterator = new BookIterator(books);
        while (bookIterator.hasNext()){
            Book book = bookIterator.next();
            if(!book.isAvailable()){
                newList.add(book);
            }
        }
        return newList;
    }


    public List<Book> getBooksByPattern(String pattern){
        List<Book> newList = new ArrayList<>();
        BookIterator bookIterator = new BookIterator(books);
        while (bookIterator.hasNext()){
            Book book = bookIterator.next();
            if(book.getTitle().toLowerCase().contains(pattern.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(pattern.toLowerCase()) ||
                book.getIsbn().contains(pattern)){
                newList.add(book);
            }
        }
        return newList;
    }
    public void addBook(Book book){
        book.setId(books.size());
        this.books.add(book);
    }
    public Book getById(int id) {
        Book book;
        BookIterator bookIterator = new BookIterator(books);
        while (bookIterator.hasNext()){
            book = bookIterator.next();
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }

    public void update(Book updatedBook){
        Book book;
        BookIterator bookIterator = new BookIterator(books);
        while (bookIterator.hasNext()){
            book = bookIterator.next();
            if(book.getId() == updatedBook.getId()){
                this.books.set(updatedBook.getId(), updatedBook);
            }
        }
    }

    private BookRepository() {
        this.books.add(new Book(books.size(), "Java: The Complete Reference, Twelfth Edition",
                "Herbert Schildt","978-83-832-2156-4",true));
        this.books.add(new Book(books.size(),"C# 12 in a Nutshell",
                "Joseph Albahari","978-10-981-4740-2",true));
        this.books.add(new Book(books.size(),"Python Data Science Handbook: Essential Tools for Working with Data, 2nd Edition",
                "Jake VanderPlas","978-83-289-0068-4",true));
        this.books.add(new Book(books.size(), "SQL QuickStart Guide: The Simplified Beginner's Guide to Managing, Analyzing, and Manipulating Data With SQL",
                "Walter Shields","978-83-832-2657-6",true));
        this.books.add(new Book(books.size(),"Linux dla admina. Najlepsze praktyki. O czym pamiętać podczas projektowania i zarządzania systemami",
                "Scott Alan Miller","978-83-289-0071-4",true));
        this.books.add(new Book(books.size(),"Serwer Ubuntu. Kompletny przewodnik po Ubuntu Server 22.04. Wydanie IV",
                "Jay LaCroix","978-83-832-2592-0",true));
        this.books.add(new Book(books.size(),"Microsoft Power BI. Jak modelować i wizualizować dane oraz budować narracje cyfrowe. Wydanie III",
                "Devin Knight","978-83-832-2724-5",true));
        this.books.add(new Book(books.size(), "Docker. Niezawodne kontenery produkcyjne. Praktyczne zastosowania. Wydanie III",
                "Sean Kane","978-83-289-0371-5",true));
        this.books.add(new Book(books.size(),"Elektronika. Projekty dla pasjonatów",
                "Witold Wrotek","978-83-289-1119-2",true));
        this.books.add(new Book(books.size(), "Arduino od podstaw",
                "Witold Wrotek","978-83-283-9715-6",true));
    }
}
