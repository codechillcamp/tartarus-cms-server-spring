package org.codechill.tartaruscms.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_sequence")
    private Long id;

    private String name;

    @ManyToOne
    private User owner;
}
