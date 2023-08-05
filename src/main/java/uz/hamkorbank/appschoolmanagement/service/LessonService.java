package uz.hamkorbank.appschoolmanagement.service;

import uz.hamkorbank.appschoolmanagement.dto.LessonsCreateDto;
import uz.hamkorbank.appschoolmanagement.dto.LessonsResponseDto;
import uz.hamkorbank.appschoolmanagement.entity.Lessons;

import java.util.List;

public interface LessonService {
    Lessons save(LessonsCreateDto dto);

    List<LessonsResponseDto> findAll();

    LessonsResponseDto findById(Long id) throws ClassNotFoundException;

    Lessons update(Long id, LessonsCreateDto dto) throws ClassNotFoundException;

    void deleteById(Long id) throws ClassNotFoundException;


}
