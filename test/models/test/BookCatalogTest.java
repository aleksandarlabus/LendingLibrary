/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.test;

import models.Book;
import models.BookCatalog;
import models.BookNotFoundException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aleksandar
 */
public class BookCatalogTest {
    private BookCatalog bc;
    private Book book1;
    
    public BookCatalogTest(){
        bc = new BookCatalog();
        book1 = new Book("2", "Learning Java", "", "", "", 0);
        bc.addBook(book1);
    }
    
    @Test
    public void testAddBook(){
        int initialNumber = bc.getNumberOfBooks();
        System.out.println(initialNumber);
        
        Book book = new Book("1", "", "", "", "", 0);
        bc.addBook(book);
        
        assertTrue(initialNumber == bc.getNumberOfBooks() - 1);
        
    }
    
    @Test
    public void testFindBook(){
                
        try {
            Book foundBook = bc.findBook("Learning Java");
        } catch (BookNotFoundException ex) {
            fail("Book not found");
        }
           
    }
    
    @Test
    public void testFindBookIgnoreCase(){
                
        try {
            Book foundBook = bc.findBook("learning java");
        } catch (BookNotFoundException ex) {
            fail("Book not found");
        }
        
        
        
    }
    
     @Test
    public void testFindBookWithExtraSpaces(){
                
        try {
            Book foundBook = bc.findBook(" learning java ");
        } catch (BookNotFoundException ex) {
            fail("Book not found");
        }
        
        
        
    }
    
    @Test(expected = BookNotFoundException.class)
    public void testFindBookThatDoesntExist() throws BookNotFoundException{
                
        Book foundBook = bc.findBook("Learning More Java");
            
        
        
        
        
    }
    
    
}