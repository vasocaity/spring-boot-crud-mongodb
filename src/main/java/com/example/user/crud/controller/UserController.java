package com.example.user.crud.controller;

import com.example.user.crud.model.User;
import com.example.user.crud.model.UserRequest;
import com.example.user.crud.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService service;


    @GetMapping()
    public ResponseEntity<List<User>> findAll() {
        return  ResponseEntity.ok(service.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable("id") String id) {
        Optional<User> user =  service.findById(id);
        if (user.isPresent()) {
            return  ResponseEntity.ok(user.get());
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity<User> create(@PathVariable("id") String id, @Valid @RequestBody(required = true) UserRequest userRequest) {
        try {
            Optional<User> user = service.findById(id);
            if (!user.isPresent()) {
                return ResponseEntity.badRequest().build();
            }
            service.update(user.get(), userRequest);
            return ResponseEntity.ok(user.get());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping()
    public  ResponseEntity<String> create(@Valid @RequestBody(required = true) UserRequest userRequest) {
        try {
            service.create(userRequest);
            return ResponseEntity.ok("success");
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        try {
         service.delete(id);
            return ResponseEntity.status( HttpStatus.OK).build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
