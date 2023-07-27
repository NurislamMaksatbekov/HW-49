package com.example.hw49.service;

import com.example.hw49.dao.UserDao;
import com.example.hw49.dto.UserDto;
import com.example.hw49.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;
    private final FileService fileService;
    private static final String SUB_DIR = "images";

    public Optional<User> findUserByName(String name) {
        // Поиск пользователей по имени
        return userDao.findUserByName(name);
    }

    public Optional<User> findUserByPhoneNumber(String number) {
        // Поиск пользователей по номеру телефона
        return userDao.findUserByPhoneNumber(number);
    }

    public String findUserEmail(Long email) {
        // Поиск пользователей по адресу почты
        return userDao.findUserEmail(email);

    }

    public boolean checkUser(String email) {
        // Проверка на наличие пользователя в системе по email
        return userDao.checkUser(email);
    }

    public List<UserDto> getUserByResponds(Long vacancyId) {
        List<User> users = userDao.getUserByResponds(vacancyId);

        return users.stream()
                .map(u -> UserDto.builder()
                        .name(u.getName())
                        .surname(u.getSurname())
                        .username(u.getUsername())
                        .email(u.getEmail())
                        .phoneNumber(u.getPhoneNumber())
                        .accountType(u.getAccountType())
                        .build()).toList();
    }

    public UserDto findApplicant(String email) {
        User user = userDao.findApplicant(email);
        return UserDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .username(user.getUsername())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .accountType(user.getAccountType())
                .build();
    }

    public UserDto findEmployer(String email) {
        User user = userDao.findEmployer(email);
        return UserDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .username(user.getUsername())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .accountType(user.getAccountType())
                .build();
    }

    public void saveUser(UserDto user) {
        userDao.save(User.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .username(user.getUsername())
                .email(user.getEmail().toLowerCase())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .accountType(user.getAccountType().toUpperCase())
                .build());
        log.info("Пользователь сохранен");
    }

    public void uploadImage(UserDto userDto) {
        String photo = fileService.saveUploadedFile(userDto.getPhoto(), SUB_DIR);
        User user = User.builder()
                .photo(photo)
                .email(userDto.getEmail())
                .build();
        userDao.saveImage(user);
    }


}
