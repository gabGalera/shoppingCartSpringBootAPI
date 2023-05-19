package dioBootcamps.shoppingCartSpringBootAPI.service;

import dioBootcamps.shoppingCartSpringBootAPI.model.Cart;
import dioBootcamps.shoppingCartSpringBootAPI.model.Product;

import java.util.Optional;

public interface ICartService {
    Cart criarCarrinho();
    Optional<Cart> adicionarProdutos(Long cartId, Long productId);
    Cart mudarQuantidadeDeUmProduto(Long newQuantity);
    String removerProdutos(Long cartId, Long productId);
}
