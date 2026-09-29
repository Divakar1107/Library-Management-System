public class Book {

    private int bookId;
    private String title;
    private String author;
    private boolean available;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public void displayBook() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + available);
    }
    

    public void issueBook() {

        if (available) {
            available = false;
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book is already issued.");
        }
    }

    public void returnBook() {

        available = true;
        System.out.println("Book returned successfully.");
    }

    public int getBookId() {
        return bookId;
    }

    public boolean isAvailable() {
        return available;
    }
}