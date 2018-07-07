package sums.smartbar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sums.smartbar.model.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {
}
