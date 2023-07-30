package org.codechill.tartaruscms.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "product_image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public Product(String name, float price, String image, Store store) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.store = store;
    }
}
