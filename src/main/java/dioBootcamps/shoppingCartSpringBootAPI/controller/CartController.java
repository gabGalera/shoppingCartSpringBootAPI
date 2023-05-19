package dioBootcamps.shoppingCartSpringBootAPI.controller;

import dioBootcamps.shoppingCartSpringBootAPI.model.Cart;
import dioBootcamps.shoppingCartSpringBootAPI.model.Product;
import dioBootcamps.shoppingCartSpringBootAPI.service.ICartService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carts")
public class CartController {
    @Autowired
    private ICartService cartService;

    @PostMapping
    public ResponseEntity<Cart> criarCarrinho() {
        Cart cart = cartService.criarCarrinho();
        return ResponseEntity.ok(cart);
    }
}
