package br.com.victormoura.ecommerce.repository;


import br.com.victormoura.ecommerce.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity, Long> {
}
