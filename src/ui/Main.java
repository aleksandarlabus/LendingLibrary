package ui;


import java.util.logging.Level;
import java.util.logging.Logger;
import models.*;
import utilities.GenderType;


public class Main {
    
    public static void main(String[] args) {
        

        MaterialCatalogInterface materialCatalog = new MaterialCatalogDatabaseVersion();
        
        Book book1 = new Book("1001", "An introduction to Java", "Matt Greencroft", "12345","Anytown branch", 400);
        Book book2 = new Book("223X", "Better Java", "Joe Le Blanc", "23456","Anytown branch", 150);
        Book book3 = new Book("9120", "Learning French", "Anton Le Noir", "87654", "Anytown branch", 100);
        Book book4 = new Book("444X", "Learning More French", "Anton Le Noir", "87654", "Anytown branch", 100);
        Book book5 = new Book("3345", "Enough French Already", "Anton Le Noir", "87654", "Anytown branch", 100);
        
        DVD dvd1 = new DVD("3", "An Epic Film About Java", "Anytown branch", "Stiven Spielberg", "99887", 120);
        DVD dvd2 = new DVD("4", "An Epic Film About Java", "Anytown branch", "Stiven Spielberg", "99887", 120);
        
        //System.out.println(dvd1.getTitle());
        //book1.relocate("MyCity branch");
        
        
        materialCatalog.addMaterial(book1);
        materialCatalog.addMaterial(book2);
        materialCatalog.addMaterial(book3);
        materialCatalog.addMaterial(book4);
        materialCatalog.addMaterial(book5);
        materialCatalog.addMaterial(dvd1);
        materialCatalog.addMaterial(dvd2);
        
        System.out.println("There are: " + materialCatalog.getNumberOfMaterials() + " items in the library");
        
        try {
            Material foundMaterial = materialCatalog.findMaterial("Java");
            System.out.println(foundMaterial.getTitle());
        } catch (MaterialNotFoundException ex) {
            System.out.println("No matching items found");
        }
        
        UI ui = new UI();
        ui.printHeader();
        
        ui.printMaterialCatalogue(materialCatalog.getMaterialMap());
        
//        Book foundBook;
//        try {
//            foundBook = materialCatalog.findBook("Better");
//            System.out.println("We found: " + foundBook.getTitle());
//        } catch (BookNotFoundException ex) {
//            System.out.println("The book wasn't found");
//        }
//        
//        int myTest = 1;
//        try {
//            if (myTest != 2) {
//                throw new RuntimeException("Something went wrong");
//            }
//        } catch (RuntimeException e) {
//
//        }
        
        
        
        Customer customer = new Customer("Mr.", "Michael", "Smith", "1 The High Street", "1234", "a@b.com", 1, GenderType.MALE);
        System.out.println(customer.getExpiryDate());
        System.out.println(customer.getMailingName());
        
        System.out.println(customer);
        System.out.println(customer.equals(customer));
        
        Loan firstLoan = new Loan(1, customer, book1);
        System.out.println(firstLoan.getDueDate());
        System.out.println(firstLoan);
        
        LoanRegistry registry = new LoanRegistry();
        
        try {
            registry.addLoan(firstLoan);
            System.out.println("Add loan work");
        } catch (LoanAlreadyExistsException ex) {
            System.out.println("Add loan failed");
        }
        try {
            registry.addLoan(firstLoan);
            System.out.println("Add loan work");
        } catch (LoanAlreadyExistsException ex) {
            System.out.println("Add loan failed");
        }
        
        System.out.println(registry.isBookOnLoan(book1.getID()));
        firstLoan.endLoan();
        System.out.println(registry.isBookOnLoan(book1.getID()));
        
    }
    
}
