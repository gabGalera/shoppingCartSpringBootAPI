package dioBootcamps.shoppingCartSpringBootAPI.service;

import dioBootcamps.shoppingCartSpringBootAPI.model.Cart;
import dioBootcamps.shoppingCartSpringBootAPI.model.Product;

import java.util.Optional;

public interface ICartService {
    Cart criarCarrinho();
    Optional<Cart> adicionarProdutos(Integer cartId, Integer productId);
    Cart mudarQuantidadeDeUmProduto(Integer cartId, Integer productId, Integer newQuantity);
    String removerProdutos(Integer cartId, Integer productId);
}
