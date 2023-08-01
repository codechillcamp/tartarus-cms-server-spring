package org.codechill.tartaruscms.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "subject", "action" }))
public class AppPermission implements Serializable {
  @Id
  private Long id;

  private String subject;
  private String action;

  @ManyToMany(mappedBy = "permissions")
  private AppRole[] roles;
}
