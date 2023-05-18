package dioBootcamps.shoppingCartSpringBootAPI.controller;

import dioBootcamps.shoppingCartSpringBootAPI.model.Product;
import dioBootcamps.shoppingCartSpringBootAPI.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private IProductService productService;

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

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll() {
        Iterable<Product> listOfProducts = productService.findAll();
        return ResponseEntity.ok(listOfProducts);
    }
}
