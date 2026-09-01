package LibraryManagmentSystem;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
     
        Library library = new Library();
     
        library.addBooks(new Book(0, "Java Programming", "James Gosling"));   
     
        library.addBooks(new Book(1, "Clean Code", "Robert Martin"));   
     
        library.addBooks(new Book(2, "Effective Java", "Joshua Bloch"));   

        // add members

        library.addUsers(new User(0, "Mradul Warathe"));
        library.addUsers(new User(2, "John Wick"));

         int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Display Books");
            System.out.println("2. Display Members");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    library.displayBooks();
                    break;

                case 2:
                    library.displayUsers();
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();

                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();

                    library.issue(bookId, memberId);
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    int returnBookId = sc.nextInt();

                    library.returnBook(returnBookId);
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();

    }
}
