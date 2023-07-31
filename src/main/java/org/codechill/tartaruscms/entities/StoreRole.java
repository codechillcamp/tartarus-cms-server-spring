package org.codechill.tartaruscms.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "store_role")
@Data
public class StoreRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_role_sequence")
    private Long id;

    @ManyToOne
    @JoinColumn
    private Store store;

    private String name;
}
