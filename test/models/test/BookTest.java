/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.test;

import models.Book;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aleksandar
 */
public class BookTest {
    
    @Test
    public void test2EqualBooks(){
        Book book1 = new Book("0", "", "", "", "", 0);
        Book book2 = new Book("0", "", "", "", "", 0);
        
        assertTrue(book1.equals(book2));
        
        
    }
    @Test
    public void test2NonEqualBooks(){
        Book book2 = new Book("0", "", "", "", "", 0);
        Book book3 = new Book("1", "", "", "", "", 0);
        
        assertFalse(book2.equals(book3));
    }
}