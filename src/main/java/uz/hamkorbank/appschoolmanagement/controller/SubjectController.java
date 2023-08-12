package uz.hamkorbank.appschoolmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.hamkorbank.appschoolmanagement.dto.SubjectCreateDto;
import uz.hamkorbank.appschoolmanagement.service.SubjectService;

@RestController
@RequestMapping("/api/v1/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody SubjectCreateDto dto) throws ClassNotFoundException {
        return ResponseEntity.ok(subjectService.create(dto));
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(subjectService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) throws ClassNotFoundException {
        return ResponseEntity.ok(subjectService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody SubjectCreateDto dto) throws ClassNotFoundException {
        return ResponseEntity.ok(subjectService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) throws ClassNotFoundException {
        subjectService.delete(id);
        return ResponseEntity.ok("Delete subject with id "+id);
    }
}
