package com.alejandroct.taskerdone.service;

import com.alejandroct.taskerdone.model.User;

import java.util.Optional;

public interface IUserService {

    Optional<User> findByEmail(String email);
}
