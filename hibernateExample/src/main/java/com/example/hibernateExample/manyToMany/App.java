package com.example.hibernateExample.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.ArrayList;



public class App {
	public static void main(String[] args) {
		Book book = new Book("Romeo and Juliet","Romantic Fantasy");
		Book book1 = new Book("Learn Hibernate","Learn Hibernate with building projects");
		ArrayList<Book> books = new ArrayList<>();
		books.add(book1);
		books.add(book);
		
		BookCategory romantic = new BookCategory("Romantic",books);
		BookCategory programming = new BookCategory("programming",books);
		ArrayList<BookCategory> categories = new ArrayList<>();
		categories.add(programming);
		categories.add(romantic);
		book.setCategories(categories);
		book1.setCategories(categories);
		
		
		
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
												.configure()
												.build();
		MetadataSources sources = new MetadataSources(registry)
										.addAnnotatedClass(Book.class)
										.addAnnotatedClass(BookCategory.class);
		Metadata metadata = sources.getMetadataBuilder()
									.build();
		SessionFactory sessionFactory = metadata	
											.getSessionFactoryBuilder()
											.build();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(book);
		session.persist(book1);
		session.persist(romantic);
		session.persist(programming);
		transaction.commit();
		session.close();
		sessionFactory.close();
		
	}
	

}
