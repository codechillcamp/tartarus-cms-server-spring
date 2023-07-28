package org.codechill.tartaruscms.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "Store")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Store implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_sequence")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "logo_url")
    private String logoURL;
}
