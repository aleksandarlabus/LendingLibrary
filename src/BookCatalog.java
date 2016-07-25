
public class BookCatalog {
    
    private Book[] bookArray = new Book[100];
    private int nextPosition = 0;
    
    
    public Book[] getBookArray(){
        return bookArray;
    }
    
    public void addBook(Book newBook){
        bookArray[nextPosition] = newBook;
        nextPosition ++;
    }
    
    public Book findBook(String title){
                
        for (Book book : bookArray) {
            if (book.getTitle().equalsIgnoreCase(title)){
                return book;
            }
            
        }
        return null;
    }
    
}
