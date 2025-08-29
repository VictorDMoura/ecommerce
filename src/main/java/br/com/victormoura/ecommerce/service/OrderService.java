package br.com.victormoura.ecommerce.service;

import br.com.victormoura.ecommerce.controller.dto.CreateOrderDto;
import br.com.victormoura.ecommerce.controller.dto.OrderItemDto;
import br.com.victormoura.ecommerce.entity.*;
import br.com.victormoura.ecommerce.exception.CreateOrderException;
import br.com.victormoura.ecommerce.repository.OrderRepository;
import br.com.victormoura.ecommerce.repository.ProductRepository;
import br.com.victormoura.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(UserRepository userRepository,
                        OrderRepository orderRepository,
                        ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public OrderEntity createOrder(CreateOrderDto dto) {

        var order = new OrderEntity();
        var user = validateUser(dto);
        var oderItems = validateOrderItems(dto, order);
        var total = calculateTotal(oderItems);

        order.setOrderDate(LocalDateTime.now());
        order.setTotal(total);
        order.setUser(user);
        order.setOrderItems(oderItems);

        return orderRepository.save(order);
    }

    private BigDecimal calculateTotal(List<OrderItemEntity> oderItems) {
        return oderItems.stream()
                .map(item -> item.getSalePrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private List<OrderItemEntity> validateOrderItems(CreateOrderDto dto, OrderEntity order) {

        if (dto.items().isEmpty()) {
            throw new CreateOrderException("items cannot be empty");
        }

        return dto.items()
                .stream()
                .map(orderItemDto -> getOrderOtem(orderItemDto, order))
                .toList();
    }

    private OrderItemEntity getOrderOtem(OrderItemDto orderItemDto, OrderEntity order) {
        var orderItem = new OrderItemEntity();
        var id = new OrderItemId();
        var product = getProduct(orderItemDto.productId());

        id.setOrderEntity(order);
        id.setProductEntity(product);

        orderItem.setId(id);
        orderItem.setQuantity(orderItemDto.quantity());
        orderItem.setSalePrice(product.getPrice());

        return orderItem;
    }

    private ProductEntity getProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new CreateOrderException("Product not found"));

    }

    private UserEntity validateUser(CreateOrderDto dto) {
        return userRepository.findById(dto.userId())
                .orElseThrow(() -> new CreateOrderException("User not found"));

    }

}
