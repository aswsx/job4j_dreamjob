package ru.job4j.dreamjob.service;

import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.models.User;
import ru.job4j.dreamjob.persistence.UserDBStore;

import java.util.Optional;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 28/03/2022 - 9:41
 */
@Service
public class UserService {
    private final UserDBStore store;

    public UserService(UserDBStore store) {
        this.store = store;
    }

    public Optional<User> addUser(User user) {
        return store.addUser(user);
    }

    public void updateUser(User user) {
        store.updateUser(user);
    }

    public Optional<User> findUserByEmailAndPwd(String email, String password) {
        return store.findUserByEmailAndPwd(email, password);
    }
}
