 package com.example.hibernateExample.oneToMany;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    
    @ManyToOne
    BookCategory category;

    public Book(String name, String description) {
        this.name = name;
        this.description = description;
    }


}