package dioBootcamps.shoppingCartSpringBootAPI.service;


import dioBootcamps.shoppingCartSpringBootAPI.model.Product;

import java.util.Optional;

public interface IProductService {
    Product cadastrar(Product product);
    Product atualizar(Product product);
    Iterable<Product> findAll();
    Optional<Product> findById(Integer id);
    String deletar(Integer id);

}
