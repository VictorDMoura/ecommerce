package br.com.victormoura.ecommerce.controller.dto;

import br.com.victormoura.ecommerce.entity.TagEntity;

public record TagResponseDto(Long tagId,
                             String tagName) {
    public static TagResponseDto fromEntity(TagEntity tagEntity) {
        return new TagResponseDto(
                tagEntity.getTagId(),
                tagEntity.getName()
        );
    }
}
