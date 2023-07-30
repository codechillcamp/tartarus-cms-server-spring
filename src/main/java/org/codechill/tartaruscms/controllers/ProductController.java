package org.codechill.tartaruscms.controllers;

import org.codechill.tartaruscms.CreateProductRequest;
import org.codechill.tartaruscms.dto.UpdateProductRequest;
import org.codechill.tartaruscms.entities.Product;
import org.codechill.tartaruscms.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping("/{storeId}")
    public Product create(@RequestBody CreateProductRequest product, @PathVariable Long storeId) {
        return productService.create(product, storeId);
    }

    @PatchMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody UpdateProductRequest product) {
        return productService.update(product, id);
    }

    @GetMapping("/all/{storeId}")
    public List<Product> findAllByStoreId(@PathVariable Long storeId) {
        return productService.findAllByStoreId(storeId);
    }
}
