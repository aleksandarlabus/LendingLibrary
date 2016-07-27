
package models;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.LoanStatus;

public class LoanRegistry {
    private ArrayList<Loan> registry;
    private int nextPosition;
    
    public LoanRegistry(){
        registry = new ArrayList<>();
        
    }
    
    public void addLoan(Loan loan) throws LoanAlreadyExistsException{
        if(registry.contains(loan)){
            throw new LoanAlreadyExistsException();
        }
        registry.add(loan);
        
    }
    
    public Loan findLoan(String bookID) throws LoanNotFoundException {
        for (Loan loan : registry) {
            if(loan.getBook().getID().equals(bookID) && loan.getStatus() == LoanStatus.CURRENT){
                return loan;
            }
        }
        
        
        throw new LoanNotFoundException();
    }
    
    public boolean isBookOnLoan(String bookID){
        try {
            Loan foundLoan = findLoan(bookID);
            return true;
        } catch (LoanNotFoundException ex) {
            return false;
        }
    }
    
}
