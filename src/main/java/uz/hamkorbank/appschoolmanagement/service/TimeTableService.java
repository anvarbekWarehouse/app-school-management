package uz.hamkorbank.appschoolmanagement.service;

import uz.hamkorbank.appschoolmanagement.dto.TimeTableCreateDto;
import uz.hamkorbank.appschoolmanagement.entity.TimeTable;

public interface TimeTableService {
    TimeTable save(TimeTableCreateDto dto);
}
