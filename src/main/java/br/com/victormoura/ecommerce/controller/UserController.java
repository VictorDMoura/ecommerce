package br.com.victormoura.ecommerce.controller;

import br.com.victormoura.ecommerce.controller.dto.CreateUserDto;
import br.com.victormoura.ecommerce.entity.UserEntity;
import br.com.victormoura.ecommerce.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserDto dto) {

        var user = userService.createUser(dto);

        return ResponseEntity.created(URI.create("/users/" + user.getUserId())).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> findById(@PathVariable UUID userId) {
        var user = userService.findById(userId);

        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
