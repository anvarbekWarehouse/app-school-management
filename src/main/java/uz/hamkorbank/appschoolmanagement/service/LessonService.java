package uz.hamkorbank.appschoolmanagement.service;

import uz.hamkorbank.appschoolmanagement.dto.LessonsCreateDto;
import uz.hamkorbank.appschoolmanagement.entity.Lessons;

public interface LessonService {
    Lessons save(LessonsCreateDto dto);
}
