package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Methods {
    Scanner scanner;
//    Book books;
    private final List<Book> books;

    public Methods(){
        this.scanner = new Scanner(System.in);
        this.books = new ArrayList<>();
    }

    public void addBook() {
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

    public void updateBook() {
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

    public void getBook() {
        System.out.print("Enter book name to search: ");
        String bookName = scanner.nextLine();
        Book book = findBook(bookName);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }

    public void deleteBook() {
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

    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public Book findBook(String bookName) {
        for (Book book : books) {
            if (book.getBookName().equalsIgnoreCase(bookName)) {
                return book;
            }
        }
        return null;
    }
}