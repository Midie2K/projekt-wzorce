package pl.edu.wszib.projekt.wzorce.ui;

public class SimpleUI {
    public SimpleUI(){}
    public void printMenu(){
        System.out.println("1. Wypisz wszystkie książki\n" +
                "2. Wypisz dostępne książki\n" +
                "3. Wyszukaj książkę\n" +
                "4. Wypożycz książkę\n" +
                "5. Oddaj książkę\n" +
                "6. Dodaj książkę\n" +
                "0. Koniec\n");
    }
    public void printBook(){
        System.out.println("\nID \t\t\t\t Tytuł \t\t\t\t Autor \t\t\t ISBN \t\t\t Dostępność");
    }

    public void printSearch(){
        System.out.print("Podaj tytuł/autora/ISBN lub frazę : ");
    }
    public void getTitle(){
        System.out.print("Podaj tytuł: ");
    }
    public void getAuthor(){
        System.out.print("Podaj Autora: ");
    }
    public void getISBN(){
        System.out.print("Podaj ISBN: ");
    }
    public void bookAdded(){
        System.out.print("Pomyślnie dodano książkę: \n");
    }
    public void addingError(){
        System.out.print("Nie podano wszystkich wartości: \n");
    }
    public void getId(){
        System.out.print("Podaj ID książki: ");
    }
    public void idError(){
        System.out.print("Książka o podanym id nie istnieje.\n");
    }
    public void bookRenting(){
        System.out.print("Książka pomyślnie wypożyczona.\n");
    }
    public void bookReturnin(){
        System.out.print("Książka pomyślnie zwrócona.\n");
    }

}
