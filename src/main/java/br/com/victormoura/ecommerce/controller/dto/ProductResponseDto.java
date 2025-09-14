package br.com.victormoura.ecommerce.controller.dto;

import br.com.victormoura.ecommerce.entity.ProductEntity;
import br.com.victormoura.ecommerce.entity.TagEntity;

import java.math.BigDecimal;
import java.util.List;

public record ProductResponseDto(Long productId,
                                 String productName,
                                 BigDecimal price,
                                 List<TagResponseDto> tags) {
    public static ProductResponseDto fromEntity(ProductEntity productEntity) {

        return new ProductResponseDto(
                productEntity.getProductId(),
                productEntity.getName(),
                productEntity.getPrice(),
                getTags(productEntity.getTags())
        );
    }

    private static List<TagResponseDto> getTags(List<TagEntity> tags) {
        return tags.stream()
                .map(TagResponseDto::fromEntity)
                .toList();
    }
}
