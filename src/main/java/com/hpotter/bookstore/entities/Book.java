package com.hpotter.bookstore.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name = "book")
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false, columnDefinition="text", length=10485760)
    private String description;

    @Column(name = "quantity", nullable = false)
    private String quantity;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "cover", nullable = false)
    private String cover;
}
