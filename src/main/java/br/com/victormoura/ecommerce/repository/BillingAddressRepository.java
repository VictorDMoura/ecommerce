package br.com.victormoura.ecommerce.repository;

import br.com.victormoura.ecommerce.entity.BillingAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingAddressRepository extends JpaRepository<BillingAddressEntity, Long> {
}
