package org.codechill.tartaruscms.services;

import org.codechill.tartaruscms.entities.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll();
    public Product create(Product product, Long storeId);
    public Product update(Product product, Long id);
    public Product findById(Long id);
}
