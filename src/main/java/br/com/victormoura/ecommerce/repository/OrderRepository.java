package br.com.victormoura.ecommerce.repository;

import br.com.victormoura.ecommerce.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
