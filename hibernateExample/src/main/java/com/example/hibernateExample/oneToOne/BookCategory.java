package com.example.hibernateExample.oneToOne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="book_categories")


public class BookCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	int id;
	@Column(name = "category_name",unique = true)
	String name;
	@OneToOne //(mappedBy = "category")
	Book book;
	public BookCategory(String name,Book book) {
		super();
		this.name = name;
		this.book = book;
	}

}
