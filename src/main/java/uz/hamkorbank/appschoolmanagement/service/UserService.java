package uz.hamkorbank.appschoolmanagement.service;

import uz.hamkorbank.appschoolmanagement.dto.UserCreateDto;
import uz.hamkorbank.appschoolmanagement.entity.User;

public interface UserService {
    User save(UserCreateDto dto) throws ClassNotFoundException;
}
