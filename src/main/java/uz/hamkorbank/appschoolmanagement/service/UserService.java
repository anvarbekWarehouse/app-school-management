package uz.hamkorbank.appschoolmanagement.service;

import uz.hamkorbank.appschoolmanagement.dto.UserCreateDto;
import uz.hamkorbank.appschoolmanagement.entity.User;

import java.util.List;

public interface UserService {
    User save(UserCreateDto dto) throws ClassNotFoundException;

    List<User> findAll();

    User findById(Long id) throws ClassNotFoundException;

    User findByEmail(String email) throws ClassNotFoundException;

    User update(Long id, UserCreateDto dto) throws ClassNotFoundException;
}
