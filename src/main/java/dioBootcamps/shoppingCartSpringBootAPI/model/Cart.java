package dioBootcamps.shoppingCartSpringBootAPI.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Optional<List<Product>> cart;
    private BigDecimal totalPrice;
    private Integer numberOfProducts;

    public Optional<List<Product>> getCart() {
        return cart;
    }

    public void setCart(Optional<List<Product>> cart) {
        this.cart = cart;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(Integer numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
