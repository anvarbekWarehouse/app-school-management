package uz.hamkorbank.appschoolmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.hamkorbank.appschoolmanagement.dto.ApiResponse;
import uz.hamkorbank.appschoolmanagement.dto.SchoolCreateDto;
import uz.hamkorbank.appschoolmanagement.entity.School;
import uz.hamkorbank.appschoolmanagement.service.SchoolService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody SchoolCreateDto dto) throws ClassNotFoundException {
        return ResponseEntity.ok(schoolService.create(dto));

    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(schoolService.findAll());
    }

    @GetMapping("/sort/{field}")
    public ApiResponse<List<School>> getSchoolWithSort(@PathVariable String field) throws ClassNotFoundException {
        List<School> schoolList = schoolService.findSchoolWithSort(field);
        return new ApiResponse<>(schoolList.size(), schoolList);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public ApiResponse<Page<School>> getSchoolWithPagination(@PathVariable int offset, @PathVariable int pageSize){
        Page<School> schoolPaginationList = schoolService.getSchoolWithPagination(offset, pageSize);
        return new ApiResponse<>(schoolPaginationList.getSize(), schoolPaginationList);
    }

    @GetMapping("/paginationAndSorting/{offset}/{pageSize}/{field}")
    public ApiResponse<Page<School>> getSchoolWithPaginationAndSorting(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field){
        Page<School> schoolPageList  = schoolService.getSchoolWithPaginationAndSorting(offset, pageSize, field);
        return new ApiResponse<>(schoolPageList.getSize(), schoolPageList);
    }
}
