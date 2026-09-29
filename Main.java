import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Book[] books = new Book[10];
        Student[] students = new Student[10];
        Issue[] issues = new Issue[10];

        int bookCount = 0;
        int studentCount = 0;
        int issueCount = 0;

        int choice;

        do {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add Student");
            System.out.println("3. Display Books");
            System.out.println("4. Display Students");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Search Book");
            System.out.println("8. Display Issued Books");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                // ADD BOOK
                case 1:

                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    books[bookCount] = new Book(bookId, title, author);
                    bookCount++;

                    BookDAO.addBook(bookId, title, author);
                    System.out.println("Book added successfully.");

                    break;


                // ADD STUDENT
                case 2:

                    System.out.print("Enter Student ID: ");
                    int studentId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    students[studentCount] =
                            new Student(studentId, name, department);

                    studentCount++;

                    StudentDAO.addStudent(studentId, name, department);

                    
                    System.out.println("Student added successfully.");

                    break;


                // DISPLAY BOOKS
                case 3:
/* 
                    if (bookCount == 0) {

                        System.out.println("No books available.");

                    } else {

                        for (int i = 0; i < bookCount; i++) {

                            System.out.println("\nBook " + (i + 1));

                            books[i].displayBook();
                        }
                    }
*/
                    BookDAO.displayBooks();
                    break;


                // DISPLAY STUDENTS
                case 4:
/* 
                    if (studentCount == 0) {

                        System.out.println("No students available.");

                    } else {

                        for (int i = 0; i < studentCount; i++) {

                            System.out.println("\nStudent " + (i + 1));

                            students[i].displayStudent();
                        }
                    }
*/                 StudentDAO.displayStudents();

                    break;


                // ISSUE BOOK
                case 5:

                    System.out.print("Enter Student ID: ");
                    int issueStudentId = sc.nextInt();

                    System.out.print("Enter Book ID: ");
                    int issueBookId = sc.nextInt();

                    System.out.print("Enter Issue ID: ");
                    int issueId = sc.nextInt();

                    IssueDAO.issueBook(
                    issueId,
                    issueBookId,
                    issueStudentId
                    );

                    break;


                // RETURN BOOK
                case 6:

                    System.out.print("Enter Book ID: ");
                    int returnBookId = sc.nextInt();

                    IssueDAO.returnBook(returnBookId);

                    break;


                // SEARCH BOOK
                case 7:

                    System.out.print("Enter Book ID to search: ");
                    int searchBookId = sc.nextInt();

                    BookDAO.searchBook(searchBookId);
                    break;


                  // DISPLAY CURRENTLY ISSUED BOOKS
              case 8:

                    IssueDAO.displayIssuedBooks();

                    break;


                // EXIT
                case 9:

                    System.out.println(
                            "Thank you for using the Library Management System."
                    );

                    break;


                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);

        sc.close();
    }
}