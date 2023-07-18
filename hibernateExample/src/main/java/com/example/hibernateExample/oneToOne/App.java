package com.example.hibernateExample.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class App {
	public static void main(String[] args) {
		Book book = new Book("Romeo and Juliet","Romantic Fantasy");
		BookCategory romantic = new BookCategory("Romantic",book);
		book.setCategory(romantic);
		//Book book1 = new Book("Learn Hibernate","Learn Hibernate with building projects");
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
		session.persist(romantic);
		transaction.commit();
		session.close();
		sessionFactory.close();
		
	}
	

}
