package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagement {
    private String libraryName;
    private String libraryAddress;
    private int libraryPinCode;
    private List<Book> books;
    private Scanner scanner;

    public LibraryManagement() {
        this.books = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        initializeLibrary();
    }

    private void initializeLibrary() {
        System.out.print("Enter the name of the library: ");
        libraryName = scanner.nextLine();
        System.out.print("Enter the address of the library: ");
        libraryAddress = scanner.nextLine();
        System.out.print("Enter the pin code of the library: ");
        try {
            libraryPinCode = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid pin code. Using default (0).");
            libraryPinCode = 0;
        }
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
                    addBook();
                    break;
                case 2:
                    updateBook();
                    break;
                case 3:
                    getBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    listAllBooks();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private void addBook() {
        System.out.print("Enter book name: ");
        String bookName = scanner.nextLine();
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine();

        if (bookName == null || bookName.trim().isEmpty()) {
            System.out.println("Failed to add book. Name cannot be empty.");
            return;
        }

        Book book = new Book(bookName, authorName);
        books.add(book);
        System.out.println("Book added successfully.");
    }

    private void updateBook() {
        System.out.print("Enter the name of the book to update: ");
        String oldBookName = scanner.nextLine();
        Book book = findBook(oldBookName);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        System.out.print("Enter new book name (press Enter to skip): ");
        String newBookName = scanner.nextLine();
        System.out.print("Enter new author name (press Enter to skip): ");
        String newAuthorName = scanner.nextLine();

        if (!newBookName.isEmpty()) {
            book.setBookName(newBookName);
        }
        if (!newAuthorName.isEmpty()) {
            book.setBookAuthor(newAuthorName);
        }
        System.out.println("Book updated successfully.");
    }

    private void getBook() {
        System.out.print("Enter book name to search: ");
        String bookName = scanner.nextLine();
        Book book = findBook(bookName);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }

    private void deleteBook() {
        System.out.print("Enter book name to delete: ");
        String bookName = scanner.nextLine();
        Book book = findBook(bookName);
        if (book != null) {
            books.remove(book);
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private Book findBook(String bookName) {
        for (Book book : books) {
            if (book.getBookName().equalsIgnoreCase(bookName)) {
                return book;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LibraryManagement libraryManagement = new LibraryManagement();
        libraryManagement.run();
    }
}