package org.codechill.tartaruscms.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class User implements Serializable {
    @Id
    Long id;

    @Column(unique = true, nullable = false)
    String name;
}
