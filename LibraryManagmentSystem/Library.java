package LibraryManagmentSystem;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addBooks(Book book){
        books.add(book);
    }
    public void addUsers(User user){
        users.add(user);
    }
    public void issue(int bookId , int userId){
        Book book  = findbook(bookId);
        User user = finduser(userId);

        if(book == null){
            System.out.println("Book not found");
            return;
        }
        if( user == null){
            System.out.println("Member not found");
            return;
        }

         if (book.isIssued()) {
            System.out.println("Book is already issued.");
            return;
        }
          book.issueBook();
          book.setname(user.getName());
          return;
    }

    public void returnBook(int bookId){
        Book book  = findbook(bookId);

        if(book == null){
            System.out.println("Book not found");
            return;
        }
        
        if (!book.isIssued()) {
            System.out.println("Book is already not owned to you!.");
            return;
        }
    
          book.returnBook();
          book.setname(null);
          return;
    }
    private User finduser(int userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                return user;
            }
        }

        return null;
    }
    private Book findbook(int bookId) {
        
        for (Book book : books) {
            if (book.getId() == bookId) {
                return book;
            }
        }

        return null; 
    }

    public void displayBooks(){
        if(books == null){
            System.out.println("Book not found");
        }

         System.out.println("\n---BOOKS---");
        
        for(Book book : books){
            System.out.println(book);
        }
    }
    public void displayUsers(){
        if(users == null){
            System.out.println("Book not found");
        }
        
        System.out.println("\n---USERS---");
        for(User user : users){
            System.out.println(user);
        }
    }
}
