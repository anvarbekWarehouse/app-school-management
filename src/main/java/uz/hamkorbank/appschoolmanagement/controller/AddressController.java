package uz.hamkorbank.appschoolmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.hamkorbank.appschoolmanagement.dto.AddressCreateDto;
import uz.hamkorbank.appschoolmanagement.entity.Address;
import uz.hamkorbank.appschoolmanagement.service.AddressService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/addresses")
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody AddressCreateDto dto) throws ClassNotFoundException {
        Address address = addressService.save(dto);
        return ResponseEntity.ok(address);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(addressService.getAll());
    }

    @GetMapping("/adress/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) throws ClassNotFoundException {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody AddressCreateDto dto) throws ClassNotFoundException {
        return ResponseEntity.ok(addressService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) throws ClassNotFoundException {
        addressService.delete(id);
        return ResponseEntity.ok("Delete Address id +{ "+id+" }");
    }

}
