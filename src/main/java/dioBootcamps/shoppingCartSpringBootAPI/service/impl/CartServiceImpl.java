package dioBootcamps.shoppingCartSpringBootAPI.service.impl;

import dioBootcamps.shoppingCartSpringBootAPI.model.Cart;
import dioBootcamps.shoppingCartSpringBootAPI.model.CartRepository;
import dioBootcamps.shoppingCartSpringBootAPI.model.Product;
import dioBootcamps.shoppingCartSpringBootAPI.model.ProductRepository;
import dioBootcamps.shoppingCartSpringBootAPI.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Cart criarCarrinho() {
        Cart emptyCart = new Cart();
        return cartRepository.save(emptyCart);
    }

    @Override
    public Optional<Cart> adicionarProdutos(Long cartId, Long productId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        Optional<Product> product = productRepository.findById(productId);

        if (cart.isPresent() && product.isPresent()) {
            List<Product> cartProducts = cart.get().getProducts();
            BigDecimal oldTotalPrice = cart.get().getTotalPrice();
            BigDecimal productPrice = product.get().getPrice();
            Integer newQuantity = cart.get().getNumberOfProducts();

            if(cartProducts.stream().anyMatch(product1 -> product1.getId().equals(productId))){
                 throw new ArrayStoreException("Product já inserido no carrinho");
            }

            if(oldTotalPrice == null) {
                oldTotalPrice = new BigDecimal("0.00");
            }
            if(newQuantity == null){
                newQuantity = 0;
            }

            cartProducts.add(product.get());
            cart.get().setProducts(cartProducts);
            cart.get().setTotalPrice(oldTotalPrice.add(productPrice));
            cart.get().setNumberOfProducts(newQuantity + 1);
            cartRepository.save(cart.get());

            return cart;
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
