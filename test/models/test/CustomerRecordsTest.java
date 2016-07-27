/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.test;

import models.Customer;
import models.CustomerNotFoundException;
import models.CustomerRecords;
import org.junit.Test;
import static org.junit.Assert.*;
import utilities.GenderType;

/**
 *
 * @author aleksandar.labus
 */
public class CustomerRecordsTest {
    CustomerRecords records; 
    
    public CustomerRecordsTest(){
        records = new CustomerRecords();
        Customer newCustomer = new Customer("Mrs.", "Sandra", "Smith", "2 Hihg Street", "12346", "sandra@matt.com", 3, GenderType.FEMALE);
        records.add(newCustomer);
    }
    
    @Test
    public void testAddCustomer(){
        Customer newCustomer = new Customer("Mr.", "Matt", "Greencroft", "1 Hihg Street", "12345", "matt@matt.com", 1, GenderType.MALE);
        int initialSize = records.getNumberOfCustomers();
        
        records.add(newCustomer);
        
        assertTrue(initialSize == records.getNumberOfCustomers() -1);
    }
    
    @Test
    public void testFindCustomer(){
        try {
            Customer foundCustomer = records.findByName("Mrs. S Smith");
        } catch (CustomerNotFoundException ex) {
            fail("Customer not found");
        }
    }
    
    @Test
    public void testNoDuplicates(){
        Customer newCustomer = new Customer("Mrs.", "Sandra", "Smith", "2 Hihg Street", "12346", "sandra@matt.com", 3, GenderType.FEMALE);
        records.add(newCustomer);
        records.add(newCustomer);
        records.add(newCustomer);
        records.add(newCustomer);
        
        assertEquals(1, records.getNumberOfCustomers());
    }
}
