package com.example.user.crud.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Document
public class User {
    @Id
    public String id;
    public String username;
    public Date birthday;
}
