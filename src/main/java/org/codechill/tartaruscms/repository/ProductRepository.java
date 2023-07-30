package org.codechill.tartaruscms.repository;

import org.codechill.tartaruscms.entities.Product;
import org.codechill.tartaruscms.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}