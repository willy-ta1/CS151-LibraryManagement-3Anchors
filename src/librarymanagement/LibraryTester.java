package librarymanagement;

public class LibraryTester {
    public static void main(String[] args) {
        Library library = new Library("Lib");
        library.addBook(new Book("Book", "?", 15761));
        User u = new User("test user");
        library.addUser(u);
        library.displayBooks();
        System.out.println("-----");
        library.displayUsers();
        System.out.println("-----");
        library.checkOutBook(u, "Book");
        System.out.println("-----");
        library.displayBooks();
        System.out.println("-----");
        library.displayUsers();
    }
}