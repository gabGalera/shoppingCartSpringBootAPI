package dioBootcamps.shoppingCartSpringBootAPI.controller;

import dioBootcamps.shoppingCartSpringBootAPI.model.Product;
import dioBootcamps.shoppingCartSpringBootAPI.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll() {
        Iterable<Product> listOfProducts = productService.findAll();
        return ResponseEntity.ok(listOfProducts);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Integer id) {
        Optional<Product> listOfProducts = productService.findById(id);
        return ResponseEntity.ok(listOfProducts);
    }
    @PostMapping
    public ResponseEntity<Product> cadastrar(@RequestBody @Valid Product product) {
        productService.cadastrar(product);
        return ResponseEntity.ok(product);
    }
    @PatchMapping
    public ResponseEntity<Product> atualizar(@RequestBody @Valid Product product) {
        productService.atualizar(product);
        return ResponseEntity.ok(product);
    }
    @DeleteMapping
    public ResponseEntity<String> atualizar(@RequestBody Integer id) {
        return ResponseEntity.ok(productService.deletar(id));
    }
}
