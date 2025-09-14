package br.com.victormoura.ecommerce.controller.dto;

import br.com.victormoura.ecommerce.entity.OrderItemEntity;

import java.math.BigDecimal;

public record OrderItemResponseDto(BigDecimal salePrice,
                                   Integer quantity,
                                   ProductResponseDto product) {

    public static OrderItemResponseDto fromEntity(OrderItemEntity entiry) {
        return  new OrderItemResponseDto(
                entiry.getSalePrice(),
                entiry.getQuantity(),
                ProductResponseDto.fromEntity(entiry.getId().getProductEntity())
        );
    }
}
