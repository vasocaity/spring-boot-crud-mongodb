package com.example.user.crud.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class UserRequest {
    @NotEmpty
    public String username;
    @NotNull
    public Date birthday;
}
