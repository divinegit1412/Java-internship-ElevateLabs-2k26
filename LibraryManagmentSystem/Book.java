package LibraryManagmentSystem;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean issued;
    private String  issuedBy;

    public Book( int id, String  title , String author){
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
        this.issuedBy = null;
    }

    public int getId() {
        return id;
    }
    public String getAuthor(){
        return author;
    }
    public String getTitle(){
        return title;
    }
    public boolean isIssued(){
        return issued;
    }
    public String issuedBy(){
        return issuedBy;
    }

    public void issueBook(){
        issued = true;
    }
    public void returnBook(){
        issued = false;
    }
    public void setname(String name){
        issuedBy = name;
    }
    
    @Override
    public String toString() {
        return id + " | " + title + " | " + author +
               " | " + (issued ? "Issued" : "Available" + 
                " | " + (issued ? issuedBy : " ")
               );
    }


}
