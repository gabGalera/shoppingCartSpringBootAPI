package dioBootcamps.shoppingCartSpringBootAPI.service.impl;

import dioBootcamps.shoppingCartSpringBootAPI.model.Product;
import dioBootcamps.shoppingCartSpringBootAPI.model.ProductRepository;
import dioBootcamps.shoppingCartSpringBootAPI.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product cadastrar(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product atualizar(Product product) {
        Optional<Product> actualData = productRepository.findById(product.getId());
        if(actualData.isPresent()) {
            actualData.get().setName(product.getName());
            actualData.get().setPrice(product.getPrice());
            return productRepository.save(actualData.get());
        }
        return productRepository.save(product);
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            return product;
        }
        return Optional.empty();
    }

    @Override
    public String deletar(Long id) {
        productRepository.deleteById(id);
        return "Product deleted";
    }

    ;
}
