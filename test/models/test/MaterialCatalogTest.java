/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.test;

import models.Book;
import models.Material;
import models.MaterialCatalogMemoryVersion;
import models.MaterialNotFoundException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aleksandar
 */
public class MaterialCatalogTest {
    private MaterialCatalogMemoryVersion bc;
    private Book book1;
    
    public MaterialCatalogTest(){
        bc = new MaterialCatalogMemoryVersion();
        book1 = new Book("2", "Learning Java", "", "", "", 0);
        bc.addMaterial(book1);
    }
    
    @Test
    public void testAddBook(){
        int initialNumber = bc.getNumberOfMaterials();
        System.out.println(initialNumber);
        
        Book book = new Book("1", "", "", "", "", 0);
        bc.addMaterial(book);
        
        assertTrue(initialNumber == bc.getNumberOfMaterials() - 1);
        
    }
    
    @Test
    public void testFindMaterial(){
                
        try {
            Material foundBook = bc.findMaterial("Learning Java");
        } catch (MaterialNotFoundException ex) {
            fail("Book not found");
        }
           
    }
    
    @Test
    public void testFindBookIgnoreCase(){
                
        try {
            Material foundBook = bc.findMaterial("learning java");
        } catch (MaterialNotFoundException ex) {
            fail("Book not found");
        }
        
        
        
    }
    
     @Test
    public void testFindBookWithExtraSpaces(){
                
        try {
            Material foundBook = bc.findMaterial(" learning java ");
        } catch (MaterialNotFoundException ex) {
            fail("Book not found");
        }
        
        
        
    }
    
    @Test(expected = MaterialNotFoundException.class)
    public void testFindBookThatDoesntExist() throws MaterialNotFoundException{
                
        Material foundBook = bc.findMaterial("Learning More Java");
            
        
        
        
        
    }
    
    
}