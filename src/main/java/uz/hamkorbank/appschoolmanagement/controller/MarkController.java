package uz.hamkorbank.appschoolmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.hamkorbank.appschoolmanagement.dto.MarkCreateDto;
import uz.hamkorbank.appschoolmanagement.service.MarkService;

@RestController
@RequestMapping("/api/v1/marks")
@RequiredArgsConstructor
public class MarkController {

    private final MarkService markService;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody MarkCreateDto dto) throws ClassNotFoundException {
        return ResponseEntity.ok(markService.save(dto));
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(markService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findbyId(@PathVariable("id") Long id){
        return ResponseEntity.ok(markService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody MarkCreateDto dto) throws ClassNotFoundException {
        return ResponseEntity.ok(markService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        markService.delete(id);
        return ResponseEntity.ok("Delete mark with id "+id);
    }
}
