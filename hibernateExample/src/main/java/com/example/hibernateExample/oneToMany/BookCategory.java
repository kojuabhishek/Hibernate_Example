package com.example.hibernateExample.oneToMany;




import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	@OneToMany //(mappedBy = "category")
	List<Book> books;
	public BookCategory(String name,List<Book> books) {
		super();
		this.name = name;
		this.books = books;
	}

}
