
package models;

import java.util.HashMap;
import java.util.HashSet;

public class CustomerRecords {
    private HashSet<Customer> records;
    
    public CustomerRecords(){
        records = new HashSet<>();
    }
    
    public void add(Customer newCustomer){
        records.add(newCustomer);
    }
    
    public Customer findByName(String name) throws CustomerNotFoundException{
        for (Customer customer : records) {
            if(customer.getMailingName().equals(name)){
                return customer;
            }
        }
        
        throw new CustomerNotFoundException();
    }
    
    public int getNumberOfCustomers(){
        return records.size();
    }
}
