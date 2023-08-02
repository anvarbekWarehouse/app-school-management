package uz.hamkorbank.appschoolmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.hamkorbank.appschoolmanagement.dto.AddressCreateDto;
import uz.hamkorbank.appschoolmanagement.entity.Address;
import uz.hamkorbank.appschoolmanagement.service.AddressService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/addresses")
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody AddressCreateDto dto) throws ClassNotFoundException {
        Address address = addressService.save(dto);
        return ResponseEntity.ok(address);
    }
}
