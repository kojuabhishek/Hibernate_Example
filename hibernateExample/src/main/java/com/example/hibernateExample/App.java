package com.example.hibernateExample;

import java.util.List;

import net.javaguides.hibernate.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguides.hibernate.util.HibernateUtil;

public class App {
	public static void main(String[] args) {

		Book book = new Book("Core Java", "Learn Core Java with Coding Examples");
		Book book1 = new Book("Learn Hibernate", "Learn Hibernate with building projects");
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the book objects
			session.persist(book);
			session.persist(book1);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<Book> books = session.createQuery("from Book", Book.class).list();
			books.forEach(b -> {
				System.out.println("Print book name : " + b.getName());
			});
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}