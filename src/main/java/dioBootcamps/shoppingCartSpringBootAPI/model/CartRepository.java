package dioBootcamps.shoppingCartSpringBootAPI.model;

import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
