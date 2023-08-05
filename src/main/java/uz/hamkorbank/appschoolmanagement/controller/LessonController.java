package uz.hamkorbank.appschoolmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.hamkorbank.appschoolmanagement.dto.LessonsCreateDto;
import uz.hamkorbank.appschoolmanagement.service.LessonService;

@RestController
@RequestMapping("/api/v1/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody LessonsCreateDto dto){
        return ResponseEntity.ok(lessonService.save(dto));

    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(lessonService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) throws ClassNotFoundException {
        return ResponseEntity.ok(lessonService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody LessonsCreateDto dto) throws ClassNotFoundException {
        return ResponseEntity.ok(lessonService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>  delete(@PathVariable(name = "id") Long id) throws ClassNotFoundException {
        lessonService.deleteById(id);
        return ResponseEntity.ok("Delete lessons by id { "+ id+ " }");
    }
}
