package org.codechill.tartaruscms.services;

import org.codechill.tartaruscms.entities.Product;
import org.codechill.tartaruscms.entities.Store;
import org.codechill.tartaruscms.repository.ProductRepository;
import org.codechill.tartaruscms.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StoreRepository storeRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product create(Product product, Long storeId) {
        Optional<Store> optionalStore = storeRepository.findById(storeId);
        Store dbStore = null;

        if(optionalStore.isPresent()) {
            dbStore = optionalStore.get();
            productRepository.save(product);

            List<Product> products = dbStore.getProducts();
            products.add(product);
            dbStore.setProducts(products);
            storeRepository.save(dbStore);

            return product;
        }

        return null;
    }

    public Product update(Product product, Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product dbProduct = null;

        if (optionalProduct.isPresent()) {
            dbProduct = optionalProduct.get();
            dbProduct.setName(product.getName());
            productRepository.save(dbProduct);
        }

        return dbProduct;
    }

    public Product findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product dbProduct = null;

        if (optionalProduct.isPresent()) {
            dbProduct = optionalProduct.get();
        }

        return dbProduct;
    }
}
