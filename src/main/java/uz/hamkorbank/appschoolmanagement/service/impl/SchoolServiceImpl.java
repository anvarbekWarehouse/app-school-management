package uz.hamkorbank.appschoolmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.hamkorbank.appschoolmanagement.dto.SchoolCreateDto;
import uz.hamkorbank.appschoolmanagement.entity.Address;
import uz.hamkorbank.appschoolmanagement.entity.School;
import uz.hamkorbank.appschoolmanagement.repository.AddressRepository;
import uz.hamkorbank.appschoolmanagement.repository.SchoolRepository;
import uz.hamkorbank.appschoolmanagement.service.SchoolService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {
    private final SchoolRepository schoolRepository;
    private final AddressRepository addressRepository;
    @Override
    public School create(SchoolCreateDto dto) throws ClassNotFoundException {
       if(schoolRepository.existsByName(dto.getName()))
           throw new ClassNotFoundException("Exists by school name "+dto.getName());

        final Optional<Address> optionalAddress = addressRepository.findById(dto.getAddressId());
        if (optionalAddress.isEmpty())
            throw new ClassNotFoundException("Address not found with id "+dto.getAddressId());

        final Address address = optionalAddress.get();
       School school = School.builder()
               .name(dto.getName())
               .address(address)
               .build();
        final School saveSchool = schoolRepository.save(school);
        return saveSchool;
    }

    @Override
    public List<School> findAll() {

        return schoolRepository.findAll();
    }

    @Override
    public List<School> findSchoolWithSort(String field) throws ClassNotFoundException {
        if(field.isEmpty()&&field.isBlank())
            throw new ClassNotFoundException("Field is null and blank "+ field);

        final List<School> schoolList = schoolRepository.findAll(Sort.by(Sort.Direction.ASC, field));
        return schoolList;
    }

    @Override
    public Page<School> getSchoolWithPagination(int offset, int pageSize) {
        return schoolRepository.findAll(PageRequest.of(offset, pageSize));
    }

    @Override
    public Page<School> getSchoolWithPaginationAndSorting(int offset, int pageSize, String field) {

        Page<School> schoolPages = schoolRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return schoolPages;
    }
}
