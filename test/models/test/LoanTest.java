package models.test;

import java.util.Date;
import java.util.GregorianCalendar;
import models.Book;
import models.Customer;
import models.Loan;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import utilities.GenderType;


public class LoanTest {
    
    @Test
    public void testDueDate(){
        Book book = new Book("0", "", "", "", "", 0);
        Customer customer = new Customer("", "", "", "", "", "", 0, GenderType.MALE);
        Loan loan = new Loan(1, customer, book);
        
        GregorianCalendar gcExpected = new GregorianCalendar();
        gcExpected.add(GregorianCalendar.DAY_OF_WEEK, 14);
        
        GregorianCalendar gcActual = new GregorianCalendar();
        gcActual.setTime(loan.getDueDate());
        
        
       assertEquals(gcActual.get(GregorianCalendar.YEAR), gcExpected.get(GregorianCalendar.YEAR));
       assertEquals(gcActual.get(GregorianCalendar.MONTH), gcExpected.get(GregorianCalendar.MONTH));
       assertEquals(gcActual.get(GregorianCalendar.DAY_OF_MONTH), gcExpected.get(GregorianCalendar.DAY_OF_MONTH));
    }
    
    
}
