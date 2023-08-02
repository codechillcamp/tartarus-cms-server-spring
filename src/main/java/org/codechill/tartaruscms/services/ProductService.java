package org.codechill.tartaruscms.services;

import org.codechill.tartaruscms.dto.CreateProductRequest;
import org.codechill.tartaruscms.dto.UpdateProductRequest;
import org.codechill.tartaruscms.entities.Product;
import org.codechill.tartaruscms.entities.Store;
import org.codechill.tartaruscms.repository.ProductRepository;
import org.codechill.tartaruscms.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Product create(CreateProductRequest productRequest, Long storeId) {
        Store dbStore = storeRepository
                .findById(storeId)
                .orElse(null);

        if (dbStore == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Invalid Store Provided"
            );
        }

        Product product = new Product(
                productRequest.getName(),
                productRequest.getPrice(),
                productRequest.getImage(),
                dbStore);

        try {
            productRepository.save(product);
        } catch (Error error) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Conflict trying to save product:" + product.getName()
            );
        }

        return product;
    }

    public Product update(UpdateProductRequest product, Long id) {
        Product dbProduct = productRepository
                .findById(id)
                .orElse(null);

        if (dbProduct == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Product " + product.getName() + " Not Found"
            );
        }
        dbProduct.setName(product.getName());
        dbProduct.setPrice(product.getPrice());
        dbProduct.setImage(product.getImage());
        return productRepository.save(dbProduct);
    }

    public Product findById(Long id) {
        Product dbProduct = productRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Product with id " + id + " Not Found"
                        ));

        return dbProduct;
    }

    public List<Product> findAllByStoreId(Long id) {
        List<Product> productList = productRepository
                .findAllByStoreId(id)
                .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Store with id " + id + " Not Found"
        ));

        return productList;
    }
}
