 package com.example.hibernateExample.manyToMany;



import java.util.List;

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
    
    @ManyToMany(mappedBy = "books" )
    List<BookCategory> categories;

    public Book(String name, String description) {
        this.name = name;
        this.description = description;
    }


}