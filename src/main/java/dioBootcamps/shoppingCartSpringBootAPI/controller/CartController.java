package dioBootcamps.shoppingCartSpringBootAPI.controller;

import dioBootcamps.shoppingCartSpringBootAPI.model.Cart;
import dioBootcamps.shoppingCartSpringBootAPI.model.Product;
import dioBootcamps.shoppingCartSpringBootAPI.service.ICartService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @PostMapping("/{cartId}/{productId}")
    public ResponseEntity<Optional<Cart>> adicionarProdutos(
            @PathVariable Integer cartId,
            @PathVariable Integer productId
    ) {
        Optional<Cart> cart = cartService.adicionarProdutos(cartId, productId);
        return ResponseEntity.ok(cart);
    }

    @PatchMapping("/{cartId}/{productId}")
    public ResponseEntity<Cart> mudarQuantidadeDeUmProduto(
            @PathVariable Integer cartId,
            @PathVariable Integer productId,
            @RequestBody Integer newQuantity
    ) {
      Cart cart = cartService.mudarQuantidadeDeUmProduto(cartId, productId, newQuantity);
      return  ResponseEntity.ok(cart);
    };

    @DeleteMapping("/{cartId}/{productId}")
    public ResponseEntity<Cart> removerProdutos(
            @PathVariable Integer cartId,
            @PathVariable Integer productId) {
        Cart cart = cartService.removerProdutos(cartId, productId);
        return ResponseEntity.ok(cart);
    }
}
