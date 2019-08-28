package org.jpractice.springboot.h2.product.services;


import org.jpractice.springboot.h2.product.domain.Product;

public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}
