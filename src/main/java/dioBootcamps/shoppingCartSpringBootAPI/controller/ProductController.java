package dioBootcamps.shoppingCartSpringBootAPI.controller;

import dioBootcamps.shoppingCartSpringBootAPI.model.Product;
import dioBootcamps.shoppingCartSpringBootAPI.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;

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
}
