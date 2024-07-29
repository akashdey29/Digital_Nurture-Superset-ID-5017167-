
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library(10);

        library.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book(2, "1984", "George Orwell"));
        library.addBook(new Book(3, "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book(4, "Pride and Prejudice", "Jane Austen"));

        System.out.println("All Books:");
        library.displayBooks();

        String searchTitle = "1984";
        System.out.println("\nLinear Search for title \"" + searchTitle + "\":");
        Book foundBook = library.linearSearchByTitle(searchTitle);
        if (foundBook != null) {
            System.out.println("Found: " + foundBook);
        } else {
            System.out.println("Book not found.");
        }

        searchTitle = "Pride and Prejudice";
        System.out.println("\nBinary Search for title \"" + searchTitle + "\":");
        foundBook = library.binarySearchByTitle(searchTitle);
        if (foundBook != null) {
            System.out.println("Found: " + foundBook);
        } else {
            System.out.println("Book not found.");
        }
    }
}
