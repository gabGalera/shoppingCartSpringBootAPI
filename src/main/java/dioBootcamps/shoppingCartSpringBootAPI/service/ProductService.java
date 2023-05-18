package dioBootcamps.shoppingCartSpringBootAPI.service;


import dioBootcamps.shoppingCartSpringBootAPI.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product cadastrar(Product product);
    Product atualizar(Product product);
    List<Product> findAll();
    Optional<Product> findById(Long id);
    String deletar(Long id);

}
