import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {
    private ArrayList<Book> books;
    private Scanner scanner;

    public LibraryApp() {
        this.books = new ArrayList<>();
        this.scanner = new Scanner(System.in);

    }

    public void run() {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    printAllBooks();
                    break;
                case 2:
                    addNewBook();
                    break;
                case 3:
                    searchBooksByTitle();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    deleteBook();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();
        }
        scanner.close();
    }

    private void printMenu() {
        System.out.println("Welcome to Library App!");
        System.out.println("1. Print all books");
        System.out.println("2. Add new book");
        System.out.println("3. Search books by title");
        System.out.println("4. Borrow a book");
        System.out.println("5. Return a book");
        System.out.println("6. Delete a book by id");
        System.out.println("7. Quit");
    }


    private void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("empty");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private void addNewBook() {
        System.out.println("\nAdd New Book");
        try {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();

            System.out.print("Enter author: ");
            String author = scanner.nextLine();

            System.out.print("Enter year: ");
            int year = Integer.parseInt(scanner.nextLine());

            Book newBook = new Book(title, author, year);
            books.add(newBook);
            System.out.println("Book added. ID: " + newBook.getId());
        } catch (NumberFormatException e) {
            System.out.println("Invalid year format");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void searchBooksByTitle() {
        System.out.println("\nSearch Books by Title");
        System.out.print("Enter title: ");
        String searchTerm = scanner.nextLine().toLowerCase();

        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchTerm)) {
                foundBooks.add(book);
            }
        }

        if (foundBooks.isEmpty()) {
            System.out.println("No books found with title containing: " + searchTerm);
        } else {
            System.out.println("Found " + foundBooks.size() + " book(s):");
            for (Book book : foundBooks) {
                System.out.println(book);
            }
        }
    }

    private void borrowBook() {
        System.out.println("\nBorrow a Book");
        System.out.print("Enter book ID: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Book book = findBookById(id);

            if (book == null) {
                System.out.println("Book with ID " + id + " not found");
            } else if (!book.getAvailable()) {
                System.out.println("Book is already borrowed");
            } else {
                book.markAsBorrowed();
                System.out.println("Book borrowed successfully!");
                System.out.println(book);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format");
        }
    }

    private void returnBook() {
        System.out.println("\nReturn a Book");
        System.out.print("Enter book ID: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Book book = findBookById(id);

            if (book == null) {
                System.out.println("Book with ID " + id + " not found");
            } else if (book.getAvailable()) {
                System.out.println("Book was not borrowed");
            } else {
                book.markAsReturned();
                System.out.println("Book returned successfully!");
                System.out.println(book);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format");
        }
    }

    private void deleteBook() {
        System.out.println("\nDelete a Book");
        System.out.print("Enter book ID: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Book book = findBookById(id);

            if (book == null) {
                System.out.println("Book with ID " + id + " not found");
            } else {
                books.remove(book);
                System.out.println("Book deleted successfully!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format");
        }
    }

    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        app.run();
    }

    private int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}