package models;


public class Book extends Material {
    
    
    private String author;
    private String isbn;
    private int numOfPages;
    
    public Book(String id, String title, String author, String isbn, String branch, int numOfPages){
        super(id, title, branch);
        this.author = author;
        this.isbn = isbn;
        this.numOfPages = numOfPages;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public String getIsbn(){
        return isbn;
    }
    
    public void sendRepair(){
        System.out.println("Book has been sent for repair");
    }

    @Override
    public int getLoanPeriod() {
        return 21;
    }

    @Override
    public String toString() {
        return "BOOK: " + getID() + " "  + getTitle() + " / " + getAuthor();
    }
    
    
    
    
}
