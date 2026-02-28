package ru.netology.RestHomework2_my.service;

import org.springframework.stereotype.Service;
import ru.netology.RestHomework2_my.exception.InvalidCredentialException;
import ru.netology.RestHomework2_my.exception.UnauthorizedUserException;
import ru.netology.RestHomework2_my.model.Authorities;
import ru.netology.RestHomework2_my.model.User;
import ru.netology.RestHomework2_my.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        //проверяем на пустые user и password в query
        if (isEmpty(user.getUser()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentialException("User name or password is empty");
        }

        //получаем список разрешений из репозитория для user и password
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);

        //если список пустой (неправильный пароль, нет user в списке)
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUserException("Unknown user " + user.getUser());
        }

        //если все в порядке возвращаем список разрешений
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
