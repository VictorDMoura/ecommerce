package br.com.victormoura.ecommerce.repository;

import br.com.victormoura.ecommerce.entity.OrderItemEntity;
import br.com.victormoura.ecommerce.entity.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, OrderItemId> {
}
