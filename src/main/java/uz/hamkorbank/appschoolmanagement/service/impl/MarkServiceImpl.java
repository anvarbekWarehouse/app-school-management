package uz.hamkorbank.appschoolmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.hamkorbank.appschoolmanagement.dto.*;
import uz.hamkorbank.appschoolmanagement.entity.Lessons;
import uz.hamkorbank.appschoolmanagement.entity.Mark;
import uz.hamkorbank.appschoolmanagement.entity.User;
import uz.hamkorbank.appschoolmanagement.repository.LessonRepository;
import uz.hamkorbank.appschoolmanagement.repository.MarkRepository;
import uz.hamkorbank.appschoolmanagement.repository.UserRepository;
import uz.hamkorbank.appschoolmanagement.service.MarkService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarkServiceImpl implements MarkService {
    private final MarkRepository markRepository;

    private final UserRepository studentRepository;

    private final LessonRepository lessonRepository;

    @Override
    public Mark save(MarkCreateDto dto) throws ClassNotFoundException {
        final Optional<User> optionalStudent = studentRepository.findById(dto.getStudentId());
        if(optionalStudent.isEmpty()){
            try {
                throw new ClassNotFoundException("Student not found with id { "+dto.getStudentId()+ " }");
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }

        final Optional<Lessons> optionalLessons = lessonRepository.findById(dto.getLessonId());
        if (optionalLessons.isEmpty())
            throw new ClassNotFoundException("Lessons not found with id { "+dto.getLessonId()+" }");
        Mark mark = Mark.builder()
                .score(dto.getScore())
                .givenDateTime(dto.getGivenDateTime())
                .student(optionalStudent.get())
                .lessons(optionalLessons.get())
                .build();

        final Mark saveMark = markRepository.save(mark);
        return saveMark;
    }

    @Override
    public List<MarkResponseDto> findAll() {
        final List<Mark> markList = markRepository.findAll();
        List<MarkResponseDto> markResponseDtoList = new ArrayList<>();
        for (Mark mark : markList) {
            UserForMarkResponseDto userForMarkResponseDto = new UserForMarkResponseDto(
                    mark.getStudent().getId(),
                    mark.getStudent().getName()
            );
            LessonsForMarkResponseDto lessonsForMarkResponseDto = new LessonsForMarkResponseDto(
                    mark.getLessons().getId(),
                    mark.getLessons().getName(),
                    mark.getLessons().getSubject().getName(),
                    mark.getLessons().getTeacher().getId(),
                    mark.getLessons().getTeacher().getName()
            );

            markResponseDtoList.add(new MarkResponseDto(
                         mark.getId(),
                         mark.getScore(),
                         mark.getGivenDateTime(),
                         userForMarkResponseDto,
                         lessonsForMarkResponseDto
            ));

        }
        return markResponseDtoList;
    }

    @Override
    public MarkResponseDto findById(Long id) {
        final Optional<Mark> optionalMark = markRepository.findById(id);
        if(optionalMark.isEmpty()){
            try {
                throw new ClassNotFoundException("Mark not found with id { "+id+ " }");
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        final Mark mark = optionalMark.get();
        UserForMarkResponseDto userForMarkResponseDto = new UserForMarkResponseDto(
                mark.getStudent().getId(),
                mark.getStudent().getName()
        );
        LessonsForMarkResponseDto lessonsForMarkResponseDto = new LessonsForMarkResponseDto(
                mark.getLessons().getId(),
                mark.getLessons().getName(),
                mark.getLessons().getSubject().getName(),
                mark.getLessons().getTeacher().getId(),
                mark.getLessons().getTeacher().getName()
        );
        MarkResponseDto markResponseDto = new MarkResponseDto( mark.getId(),
                mark.getScore(),
                mark.getGivenDateTime(),
                userForMarkResponseDto,
                lessonsForMarkResponseDto);
        return markResponseDto;
    }

    @Override
    public Mark update(Long id, MarkCreateDto dto) throws ClassNotFoundException {
        final Optional<Mark> optionalMark = markRepository.findById(id);
        if(optionalMark.isEmpty()){
            try {
                throw new ClassNotFoundException("Mark not found with id { "+id+ " }");
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        final Optional<User> optionalStudent = studentRepository.findById(dto.getStudentId());
        if(optionalStudent.isEmpty()){
            try {
                throw new ClassNotFoundException("Student not found with id { "+dto.getStudentId()+ " }");
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }

        final Optional<Lessons> optionalLessons = lessonRepository.findById(dto.getLessonId());
        if (optionalLessons.isEmpty())
            throw new ClassNotFoundException("Lessons not found with id { "+dto.getLessonId()+" }");

        final Mark mark = optionalMark.get();
        if (dto.getStudentId() != null && !mark.getStudent().getId().equals(dto.getStudentId())){
            mark.setStudent(optionalStudent.get());
        }

        if (dto.getLessonId() != null && !mark.getLessons().getId().equals(dto.getLessonId())){
            mark.setLessons(optionalLessons.get());
        }

        if(dto.getScore() != null && !mark.getScore().equals(dto.getScore())){
            mark.setScore(dto.getScore());
        }

        if (dto.getGivenDateTime() != null && !mark.getGivenDateTime().equals(dto.getGivenDateTime())){
            mark.setGivenDateTime(dto.getGivenDateTime());
        }


        return markRepository.save(mark);
    }

    @Override
    public void delete(Long id) {
        final Optional<Mark> optionalMark = markRepository.findById(id);
        if(optionalMark.isEmpty()){
            try {
                throw new ClassNotFoundException("Mark not found with id { "+id+ " }");
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        markRepository.deleteById(id);
    }
}
