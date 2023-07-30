package org.codechill.tartaruscms.services;

import org.codechill.tartaruscms.CreateProductRequest;
import org.codechill.tartaruscms.dto.UpdateProductRequest;
import org.codechill.tartaruscms.entities.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll();
    public Product create(CreateProductRequest product, Long storeId);
    public Product update(UpdateProductRequest product, Long id);
    public Product findById(Long id);
    public List<Product> findAllByStoreId(Long id);
}
