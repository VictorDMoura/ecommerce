package br.com.victormoura.ecommerce.controller.dto;

import br.com.victormoura.ecommerce.entity.OrderEntity;
import br.com.victormoura.ecommerce.entity.OrderItemEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record OrderResponseDto(Long orderId,
                               BigDecimal total,
                               LocalDateTime orderDate,
                               UUID userId,
                               List<OrderItemResponseDto> items) {


    public static OrderResponseDto fromEntity(OrderEntity entity) {
        return new OrderResponseDto(
                entity.getOrderId(),
                entity.getTotal(),
                entity.getOrderDate(),
                entity.getUser().getUserId(),
                getItems(entity.getOrderItems())
        );
    }

    private static List<OrderItemResponseDto> getItems(List<OrderItemEntity> orderItems) {
        return orderItems
                .stream()
                .map(OrderItemResponseDto::fromEntity)
                .toList();

    }
}
