package uz.hamkorbank.appschoolmanagement.service;

import uz.hamkorbank.appschoolmanagement.dto.SubjectCreateDto;
import uz.hamkorbank.appschoolmanagement.entity.Subject;

import java.util.List;

public interface SubjectService {
    Subject create(SubjectCreateDto dto) throws ClassNotFoundException;

    List<Subject> findAll();

    Subject findById(Long id) throws ClassNotFoundException;

    Subject update(Long id, SubjectCreateDto dto) throws ClassNotFoundException;

    void delete(Long id) throws ClassNotFoundException;
}
