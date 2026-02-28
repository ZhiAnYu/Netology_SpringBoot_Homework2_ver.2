package ru.netology.RestHomework2_my.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.RestHomework2_my.model.Authorities;
import ru.netology.RestHomework2_my.model.User;
import ru.netology.RestHomework2_my.service.UserService;

import java.util.List;

@RestController
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@ModelAttribute @Valid User user) throws MethodArgumentNotValidException {
        // Если валидация не прошла — выбрасываем исключение,
        // которое перехватит GlobalErrorHandler
        return service.getAuthorities(user);
    }
}