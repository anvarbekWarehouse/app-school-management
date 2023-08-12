package uz.hamkorbank.appschoolmanagement.service;

import uz.hamkorbank.appschoolmanagement.dto.MarkCreateDto;
import uz.hamkorbank.appschoolmanagement.dto.MarkResponseDto;
import uz.hamkorbank.appschoolmanagement.entity.Mark;

import java.util.List;

public interface MarkService {
    Mark save(MarkCreateDto dto) throws ClassNotFoundException;

    List<MarkResponseDto> findAll();

    MarkResponseDto findById(Long id);

    Mark update(Long id, MarkCreateDto dto) throws ClassNotFoundException;

    void delete(Long id);
}
