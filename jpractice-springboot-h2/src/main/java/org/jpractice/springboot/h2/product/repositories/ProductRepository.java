package org.jpractice.springboot.h2.product.repositories;

import org.jpractice.springboot.h2.product.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Integer>{
}
