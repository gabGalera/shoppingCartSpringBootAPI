package dioBootcamps.shoppingCartSpringBootAPI.service.impl;

import dioBootcamps.shoppingCartSpringBootAPI.model.Cart;
import dioBootcamps.shoppingCartSpringBootAPI.model.CartRepository;
import dioBootcamps.shoppingCartSpringBootAPI.model.Product;
import dioBootcamps.shoppingCartSpringBootAPI.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart criarCarrinho() {
        Cart emptyCart = new Cart();
        return cartRepository.save(emptyCart);
    }

    @Override
    public Optional<Cart> adicionarProdutos(Long cartId, Product product) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if (cart.isPresent()) {
            List<Product> cartProducts = cart.get().getProducts();
            cartProducts.add(product);
            cart.get().setProducts(cartProducts);
            return cartRepository.save(cart.get());
        }
        return Optional.empty();
    }

    @Override
    public Cart mudarQuantidadeDeUmProduto(Long newQuantity) {
        return null;
    }

    @Override
    public String removerProdutos(Long cartId, Long productId) {
        return null;
    }
}
