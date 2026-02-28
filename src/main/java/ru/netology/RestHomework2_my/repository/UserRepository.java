package ru.netology.RestHomework2_my.repository;

import org.springframework.stereotype.Repository;
import ru.netology.RestHomework2_my.model.Authorities;
import ru.netology.RestHomework2_my.model.User;

import java.util.List;

@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(User user) {
        if ("admin".equals(user.getUser()) && "123".equals(user.getPassword())) {
            return List.of(Authorities.DELETE, Authorities.READ, Authorities.WRITE);
        }
        if ("user".equals(user.getUser()) && "234".equals(user.getPassword())) {
            return List.of(Authorities.READ);
        }
        return List.of();
    }
}
