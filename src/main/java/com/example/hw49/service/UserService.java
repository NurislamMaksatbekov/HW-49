package com.example.hw49.service;

import com.example.hw49.dao.UserDao;
import com.example.hw49.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

    public Optional<User> findUserByName(String name){
        return userDao.findUserByName(name);
    }
}
