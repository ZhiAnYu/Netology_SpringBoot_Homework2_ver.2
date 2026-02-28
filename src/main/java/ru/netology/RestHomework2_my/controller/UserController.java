package ru.netology.RestHomework2_my.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.RestHomework2_my.annotations.MyAuthQuery;
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
    public List<Authorities> getAuthorities(@MyAuthQuery User user) {
        // ✅ Объект уже валиден! Резолвер выбросит исключение, если нет.
        return service.getAuthorities(user);
    }
}

//🎮 Шаг 4: Обновляем контроллер