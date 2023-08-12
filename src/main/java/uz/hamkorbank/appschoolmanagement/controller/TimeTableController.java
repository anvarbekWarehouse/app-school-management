package uz.hamkorbank.appschoolmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.hamkorbank.appschoolmanagement.dto.TimeTableCreateDto;
import uz.hamkorbank.appschoolmanagement.service.TimeTableService;

@RestController
@RequestMapping("/api/v1/time_table")
@RequiredArgsConstructor

public class TimeTableController {

    private final TimeTableService timeTableService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody TimeTableCreateDto dto){
        return ResponseEntity.ok(timeTableService.save(dto));
    }
}
