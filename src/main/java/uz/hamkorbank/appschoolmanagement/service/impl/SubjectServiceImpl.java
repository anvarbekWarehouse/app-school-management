package uz.hamkorbank.appschoolmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.hamkorbank.appschoolmanagement.dto.SubjectCreateDto;
import uz.hamkorbank.appschoolmanagement.entity.Subject;
import uz.hamkorbank.appschoolmanagement.repository.SubjectRepository;
import uz.hamkorbank.appschoolmanagement.service.SubjectService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    @Override
    public Subject create(SubjectCreateDto dto) throws ClassNotFoundException {
        if (subjectRepository.existsByName(dto.getName())){
            throw new ClassNotFoundException("Exixts by subject name "+ dto.getName());
        }
        Subject subject = Subject.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();

        return  subjectRepository.save(subject);
    }

    @Override
    public List<Subject> findAll() {
        final List<Subject> subjectList = subjectRepository.findAll();
        return subjectList;
    }

    @Override
    public Subject findById(Long id) throws ClassNotFoundException {
        final Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isEmpty())
            throw new ClassNotFoundException("Subject not found with id " + id);
        return optionalSubject.get();
    }

    @Override
    public Subject update(Long id, SubjectCreateDto dto) throws ClassNotFoundException {
        final Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isEmpty())
            throw new ClassNotFoundException("Subject not found with id " + id);
        final Subject subject = optionalSubject.get();
        subject.setName(dto.getName());
        subject.setDescription(dto.getDescription());
        return  subjectRepository.save(subject);
    }

    @Override
    public void delete(Long id) throws ClassNotFoundException {
        final Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isEmpty())
            throw new ClassNotFoundException("Subject not found with id " + id);

        subjectRepository.deleteById(optionalSubject.get().getId());
    }
}
