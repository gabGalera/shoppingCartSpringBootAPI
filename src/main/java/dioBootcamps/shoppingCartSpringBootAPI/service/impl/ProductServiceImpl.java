package dioBootcamps.shoppingCartSpringBootAPI.service.impl;

import dioBootcamps.shoppingCartSpringBootAPI.model.Product;
import dioBootcamps.shoppingCartSpringBootAPI.model.ProductRepository;
import dioBootcamps.shoppingCartSpringBootAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product cadastrar(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product atualizar(Product product) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String deletar(Long id) {
        return null;
    }

    ;
}
