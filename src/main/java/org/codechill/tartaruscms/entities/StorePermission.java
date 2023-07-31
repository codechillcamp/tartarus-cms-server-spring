package org.codechill.tartaruscms.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "store_permission",
uniqueConstraints = {
        @UniqueConstraint(name = "UniqueSubjectAndAction", columnNames = {"subject", "action"})
})
@Data
public class StorePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_permission_sequence")
    private Long id;

    private String subject;

    private String action;
}
