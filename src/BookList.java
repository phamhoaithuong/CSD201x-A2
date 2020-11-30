/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import entity.Book;
import java.util.Scanner;
import util.MyList;
import util.Node;
import static util.Input.*;

/**
 *
 * @author TrongDuyDao
 */

public class BookList {

    private static final Scanner INPUT = new Scanner(System.in);
    //a list of book
    private MyList books;

    public MyList getBooks() {
        return books;
    }
    
    public BookList() {
        books = new MyList();
    }

    //1.0 accept information of a Book
    private Book getBook() {
        System.out.println("Enter the infomation of a Book");
        String bCode;
        while (true) {
            bCode = inputStr("Book code: ");
            if (books.search(bCode) == null) break;
            else System.out.println("Book code must be unique");
        }
        String title = inputStr("Book Title: ");
        int quantity = inputInt("Book quantity: ");
        int lended = inputInt("Book lended: ");        
        double price = inputDouble("Book price: ");
        return new Book(bCode, title, quantity, lended, price);
    }
    
    //1.1 accept and add a new Book to the end of book list
    public void addLast() {
        books.addLast(getBook());
    }

    //1.2 output information of book list
    public void list() {
        System.out.println(String.format("%-10s%-20s%-10s%-10s%-10s%-10s", "Code", "Title",
                "Quantity", "Lender", "Price", "Value"));
        books.traverse();
    }

    //1.3 search book by book code
    public void search() {
        String bCode = inputStr("Enter Book Code: ");
        Node<Book> book = books.search(bCode);
        if (book != null) { 
            System.out.println(String.format("%-10s%-20s%-10s%-10s%-10s%-10s", "Code", "Title",
                "Quantity", "Lender", "Price", "Value"));
            System.out.println(book.info);
        } else { 
            System.out.println("Not found!");
        }
    }

    //1.4 accept and add a new Book to the begining of book list
    public void addFirst() {
        books.addFirst(getBook());
        System.out.println("A new book has been added to the beginning of book list");
    }

    //1.5 Add a new Book after a position k
    public void addAfter() {
        Book b = getBook();
        int k = inputInt("Enter adding position: ");
        try {        
            books.addAfter(b, k);
            System.out.printf("A new book has been added after position %s%n", k);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Invalid position!");
            addAfter();
        }
    }

    //1.6 Delete a Book at position k
    public void deleteAt() {
        int k = inputInt("Enter deleting position: ");
        try {
            books.deleteAt(k);
            System.out.printf("Deleted book at position %s%n", k);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Invalid position!");
            deleteAt();
        }
    }
}
