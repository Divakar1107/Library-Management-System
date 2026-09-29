public class Issue {

    private int issueId;
    private Book book;
    private Student student;
    private boolean active;

    public Issue(int issueId, Book book, Student student) {
        this.issueId = issueId;
        this.book = book;
        this.student = student;
        this.active = true;
    }

    public void displayIssue() {

        System.out.println("Issue ID: " + issueId);

        System.out.println("Book:");
        book.displayBook();

        System.out.println();

        System.out.println("Student:");
        student.displayStudent();

        System.out.println("Issue Active: " + active);
    }

    public boolean getActive() {
        return active;
    }

    public void closeIssue() {
        active = false;
    }

    public int getBookId() {
        return book.getBookId();
    }
}