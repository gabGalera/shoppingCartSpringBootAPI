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
    public Optional<Cart> adicionarProdutos(Integer cartId, Integer productId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        Optional<Product> product = productRepository.findById(productId);

        if (cart.isPresent() && product.isPresent()) {
            List<Product> cartProducts = cart.get().getProducts();
            BigDecimal oldTotalPrice = cart.get().getTotalPrice();
            BigDecimal productPrice = product.get().getTotalPrice();
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
    public Cart mudarQuantidadeDeUmProduto(Integer cartId, Integer productId, Integer newQuantity) {
        Cart cart = cartRepository.findById(cartId).get();
        List<Product> oldListOfProducts = cart.getProducts();
        List<Product> product = oldListOfProducts
                .stream()
                .filter(entry -> entry.getId().equals(productId))
                .toList();
        if(!product.isEmpty()) {
            oldListOfProducts.remove(product.get(0));
            product.get(0).setQuantity(newQuantity);
            oldListOfProducts.add(product.get(0));
            cart.setProducts(oldListOfProducts);
            return cartRepository.save(cart);
        }

        return null;
    }

    @Override
    public String removerProdutos(Integer cartId, Integer productId) {
        return null;
    }
}
