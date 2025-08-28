package br.com.victormoura.ecommerce.service;

import br.com.victormoura.ecommerce.controller.dto.CreateUserDto;
import br.com.victormoura.ecommerce.entity.BillingAddressEntity;
import br.com.victormoura.ecommerce.entity.UserEntity;
import br.com.victormoura.ecommerce.repository.BillingAddressRepository;
import br.com.victormoura.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BillingAddressRepository billingAddressRepository;

    public UserService(UserRepository userRepository,
                       BillingAddressRepository billingAddressRepository) {
        this.userRepository = userRepository;
        this.billingAddressRepository = billingAddressRepository;
    }

    public UserEntity createUser(CreateUserDto dto) {

        var billingAddress = new BillingAddressEntity();
        billingAddress.setAddress(dto.address());
        billingAddress.setNumber(dto.number());
        billingAddress.setComplement(dto.complement());
        var savedBillingAddress = billingAddressRepository.save(billingAddress);

        var user = new UserEntity();
        user.setFullName(dto.fullName());
        user.setBillingAddress(savedBillingAddress);

        return userRepository.save(user);
    }
}
