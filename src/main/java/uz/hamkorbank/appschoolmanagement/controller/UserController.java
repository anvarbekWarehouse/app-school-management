package uz.hamkorbank.appschoolmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.hamkorbank.appschoolmanagement.dto.UserCreateDto;
import uz.hamkorbank.appschoolmanagement.entity.User;
import uz.hamkorbank.appschoolmanagement.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping("/api/users")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserCreateDto dto) throws ClassNotFoundException {
        return ResponseEntity.ok(userService.save(dto));
    }
}