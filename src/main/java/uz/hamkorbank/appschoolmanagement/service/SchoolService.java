package uz.hamkorbank.appschoolmanagement.service;

import org.springframework.data.domain.Page;
import uz.hamkorbank.appschoolmanagement.dto.SchoolCreateDto;
import uz.hamkorbank.appschoolmanagement.entity.School;

import java.util.List;

public interface SchoolService {
    School create(SchoolCreateDto dto) throws ClassNotFoundException;

    List<School> findAll();

    List<School> findSchoolWithSort(String field) throws ClassNotFoundException;

    Page<School> getSchoolWithPagination(int offset, int pageSize);

    Page<School> getSchoolWithPaginationAndSorting(int offset, int pageSize, String field);
}
