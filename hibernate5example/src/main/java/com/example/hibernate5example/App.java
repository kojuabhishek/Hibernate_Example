package com.example.hibernate5example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App 
{
    public static void main( String[] args )
    {
        
    	//create
    	Account account = new Account(12367,"Ramesh Shrestha",4534321f);
        Configuration con = new Configuration()
        					.configure()
        					.addAnnotatedClass(Account.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(account);
        tx.commit();
        
        
        
        
        //read
        tx = session.beginTransaction();
        List<Account> accounts  = session.createQuery("from Account",Account.class).list();
        accounts.forEach(System.out::println);
        tx.commit();
        
        tx= session.beginTransaction();
        Long accountId = 9L; // ID of the row you want to fetch
        Query<Account> query = session.createQuery("FROM Account WHERE id = :accountId", Account.class);
        query.setParameter("accountId", accountId);
        Account ac1 = query.uniqueResult();
        System.out.println(ac1);
        tx.commit();
        
        
        //delete
        tx = session.beginTransaction();
        Long accountIdToDelete = 19L; // ID of the row you want to delete
        Account accountToDelete = session.get(Account.class, accountIdToDelete);
        if (accountToDelete != null) {
            session.delete(accountToDelete);
            System.out.println("Row with ID " + accountIdToDelete + " deleted successfully.");
        } else {
            System.out.println("No row found with ID " + accountIdToDelete + ". No deletion performed.");
        }
        tx.commit();

        tx = session.beginTransaction();
        List<Account> accountsAfterDeletion = session.createQuery("from Account", Account.class).list();
        System.out.println("Accounts after deletion:");
        accountsAfterDeletion.forEach(System.out::println);
        tx.commit();
        
        
        //update
        tx = session.beginTransaction();
        Long accountIdToUpdate = 12L; // ID of the row you want to update
        Account accountToUpdate = session.get(Account.class, accountIdToUpdate);
        if (accountToUpdate != null) {
            // Update the account details
            accountToUpdate.setAccountNo(28765);
            accountToUpdate.setAccountHoldersName("Legal Document");
            accountToUpdate.setBalance(2010000f);
            
            session.update(accountToUpdate);
            System.out.println("Row with ID " + accountIdToUpdate + " updated successfully.");
        } else {
            System.out.println("No row found with ID " + accountIdToUpdate + ". No update performed.");
        }
        tx.commit();

        tx = session.beginTransaction();
        List<Account> accountsAfterUpdate = session.createQuery("from Account", Account.class).list();
        System.out.println("Accounts after deletion:");
        accountsAfterDeletion.forEach(System.out::println);
        tx.commit();

        
        
        
        
        
       
        
        session.close();
        sf.close();
        
        
        
        
        
        
        System.out.println("Hello World!");
    }
}
