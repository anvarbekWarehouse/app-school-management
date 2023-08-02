package uz.hamkorbank.appschoolmanagement.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.hamkorbank.appschoolmanagement.dto.UserCreateDto;
import uz.hamkorbank.appschoolmanagement.entity.User;
import uz.hamkorbank.appschoolmanagement.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserCreateDto dto) throws ClassNotFoundException {
        return ResponseEntity.ok(userService.save(dto));
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @SneakyThrows
    @GetMapping("/by_email/{email}")
    public ResponseEntity<?> findById(@PathVariable("email") String email){
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @SneakyThrows
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UserCreateDto dto){
        return ResponseEntity.ok(userService.update(id, dto));
    }


}