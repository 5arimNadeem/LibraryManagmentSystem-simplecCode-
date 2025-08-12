package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagement {
    private List<Book> books;
    private Scanner scanner;
    private Methods methods;

    public LibraryManagement() {
        this.books = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.methods = new Methods();
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Get Book");
            System.out.println("4. Delete Book");
            System.out.println("5. List All Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 0:
                    System.out.println("Exiting application...");
                    running = false;
                    break;
                case 1:
                    methods.addBook();
                    break;
                case 2:
                    methods.updateBook();
                    break;
                case 3:
                    methods.getBook();
                    break;
                case 4:
                    methods.deleteBook();
                    break;
                case 5:
                    methods.listAllBooks();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        LibraryManagement libraryManagement = new LibraryManagement();
        libraryManagement.run();
    }
}