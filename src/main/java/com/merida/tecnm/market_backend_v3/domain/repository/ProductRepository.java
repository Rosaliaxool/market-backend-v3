package com.merida.tecnm.market_backend_v3.domain.repository;

import com.merida.tecnm.market_backend_v3.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product>getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional <Product> getScarceProducts (int quantity);
    Product save (Product product);
    Product delete(Product product);

}
