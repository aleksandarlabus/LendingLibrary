
package models;

import java.util.Date;
import java.util.GregorianCalendar;
import utilities.LoanStatus;

public class Loan {
    private int id;
    private Customer customer;
    private Book book;
    private Date startDate;
    private Date dueDate;
    private Date returnDate;
    private LoanStatus status;

    public Loan(int id, Customer customer, Book book) {
        this.id = id;
        this.customer = customer;
        this.book = book;
        startDate = new Date();
        GregorianCalendar gCal = new GregorianCalendar();
        gCal.add(GregorianCalendar.DAY_OF_MONTH, 14);
        this.dueDate = gCal.getTime();
        
        status = LoanStatus.CURRENT;
    }

    @Override
    public String toString() {
        return "Loan{" + "id=" + id + ", customer=" + customer.getMailingName() + ", book=" + book.getTitle() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Loan other = (Loan) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Book getBook() {
        return book;
    }

    public Date getDueDate() {
        return dueDate;
    }
    
    public void endLoan(){
        returnDate = new Date();
        status = LoanStatus.HISTORIC;
    }
    
    public LoanStatus getStatus(){
        return status;
    }
    
    
}
