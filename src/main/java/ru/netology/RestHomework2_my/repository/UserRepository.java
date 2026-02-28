package ru.netology.RestHomework2_my.repository;

import org.springframework.stereotype.Repository;
import ru.netology.RestHomework2_my.model.Authorities;

import java.util.List;

@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        if ("admin".equals(user) && "123".equals(password)) {
            return List.of(Authorities.DELETE, Authorities.READ, Authorities.WRITE);
        }
        if ("user".equals(user) && "234".equals(password)) {
            return List.of(Authorities.READ);
        }
        return List.of();
    }
}
