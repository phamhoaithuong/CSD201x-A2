
import util.Input;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TrongDuyDao
 */
public class Main {
    private static BookList books = new BookList();
    
    public static void main(String[] args) {
        System.out.println("Book list");
        System.out.println("1.Input Book and add to the end");
        System.out.println("2.Display books");
        System.out.println("3.Search by code");
        System.out.println("4.Input Book and add to beginning");
        System.out.println("5.Add Book after position k");
        System.out.println("6.Delete Book at position k");
        System.out.println("0.Exit");
        int choice = Input.inputInt("Your choice: ");
        switch (choice) {
            case 0:
                System.exit(0);
                break;
            case 1:
                books.addLast();
                break;
            case 2:
                books.list();
                break;
            case 3:
                books.search();
                break;
            case 4:
                books.addFirst();
                break;
            case 5:
                books.addAfter();
                break;
            case 6:
                books.deleteAt();
                break;
            default:
                System.out.println("Unknown, please input again!");
        }   
        Input.pause();
        main(args);
    }
}
