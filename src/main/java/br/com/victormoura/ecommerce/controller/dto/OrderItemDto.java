package br.com.victormoura.ecommerce.controller.dto;

public record OrderItemDto(Integer quantity,
                           Long productId) {
}
