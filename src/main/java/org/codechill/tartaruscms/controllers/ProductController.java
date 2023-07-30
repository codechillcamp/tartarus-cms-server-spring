package org.codechill.tartaruscms.controllers;

import org.codechill.tartaruscms.dto.CreateProductRequest;
import org.codechill.tartaruscms.dto.UpdateProductRequest;
import org.codechill.tartaruscms.entities.Product;
import org.codechill.tartaruscms.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/v1/products")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/api/v1/products/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping("/api/v1/products/store/{storeId}")
    public Product create(@RequestBody CreateProductRequest product, @PathVariable Long storeId) {
        return productService.create(product, storeId);
    }

    @PatchMapping("/api/v1/products/{id}")
    public Product update(@PathVariable Long id, @RequestBody UpdateProductRequest product) {
        return productService.update(product, id);
    }

    @GetMapping("/api/v1/products/all/{storeId}")
    public List<Product> findAllByStoreId(@PathVariable Long storeId) {
        return productService.findAllByStoreId(storeId);
    }
}
