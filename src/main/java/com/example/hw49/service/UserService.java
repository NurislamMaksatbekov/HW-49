package com.example.hw49.service;

import com.example.hw49.dao.UserDao;
import com.example.hw49.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

    public Optional<User> findUserByName(String name){
        // Поиск пользователей по имени
        return userDao.findUserByName(name);
    }

    public Optional<User> findUserByPhoneNumber(String number){
        // Поиск пользователей по номеру телефона
        return userDao.findUserByPhoneNumber(number);
    }

    public Optional<User> findUserByEmail(String email){
        // Поиск пользователей по адресу почты
        return userDao.findUserByEmail(email);
    }

    public boolean checkUser(String email){
        // Проверка на наличие пользователя в системе по email
        return userDao.checkUser(email);
    }

    public List<User> getUserByResponds(Long vacancyId){
        // Выборка откликнувшихся соискателей на вакансию.
        return userDao.getUserByResponds(vacancyId);
    }
}
