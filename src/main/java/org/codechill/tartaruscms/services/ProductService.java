package org.codechill.tartaruscms.services;

import org.codechill.tartaruscms.CreateProductRequest;
import org.codechill.tartaruscms.dto.UpdateProductRequest;
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

    public Product create(CreateProductRequest productRequest, Long storeId) {
        Store dbStore = storeRepository
                .findById(storeId)
                .orElse(null);

        if(dbStore != null) {
            Product product = new Product(
                    productRequest.getName(),
                    productRequest.getPrice(),
                    productRequest.getImage(),
                    dbStore);

            productRepository.save(product);

            return product;
        }

        return null;
    }

    public Product update(UpdateProductRequest product, Long id) {
        Product dbProduct = productRepository
                .findById(id)
                .orElse(null);

        if (dbProduct != null) {
            dbProduct.setName(product.getName());
            dbProduct.setPrice(product.getPrice());
            dbProduct.setImage(product.getImage());
            productRepository.save(dbProduct);
        }

        return dbProduct;
    }

    public Product findById(Long id) {
        Product dbProduct = productRepository
                .findById(id)
                .orElse(null);

        return dbProduct;
    }

    public List<Product> findAllByStoreId(Long id) {
        List<Product> productList = productRepository
                .findAllByStoreId(id)
                .orElse(null);

        return productList;
    }
}
