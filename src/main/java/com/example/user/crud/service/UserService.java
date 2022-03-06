package com.example.user.crud.service;

import com.example.user.crud.model.User;
import com.example.user.crud.model.UserRequest;
import com.example.user.crud.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;

    public List<User> findAll() {
        return  repository.findAll();
    }

    public Optional<User> findById(String id) {
        return  repository.findById(id);
    }

    public void create(UserRequest request) {
        User user = new User();
        user.username = request.username;
        user.birthday = request.birthday;
        repository.insert(user);
    }

    public void update(User user, UserRequest userRequest) {
        user.username = userRequest.username;
        user.birthday = userRequest.birthday;
        repository.save(user);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
