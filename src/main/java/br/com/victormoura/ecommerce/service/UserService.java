package br.com.victormoura.ecommerce.service;

import br.com.victormoura.ecommerce.controller.dto.CreateUserDto;
import br.com.victormoura.ecommerce.entity.BillingAddressEntity;
import br.com.victormoura.ecommerce.entity.UserEntity;
import br.com.victormoura.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(CreateUserDto dto) {

        var billingAddress = new BillingAddressEntity();
        billingAddress.setAddress(dto.address());
        billingAddress.setNumber(dto.number());
        billingAddress.setComplement(dto.complement());

        var user = new UserEntity();
        user.setFullName(dto.fullName());
        user.setBillingAddress(billingAddress);

        return userRepository.save(user);
    }

    public Optional<UserEntity> findById(UUID userId) {
        return userRepository.findById(userId);
    }

    public boolean deleteById(UUID userId) {

        var user = userRepository.findById(userId);

        if (user.isPresent()) {
            userRepository.delete(user.get());
            return true;
        }

        return false;
    }
}
