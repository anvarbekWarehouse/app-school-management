package uz.hamkorbank.appschoolmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.hamkorbank.appschoolmanagement.dto.LessonsCreateDto;
import uz.hamkorbank.appschoolmanagement.dto.LessonsResponseDto;
import uz.hamkorbank.appschoolmanagement.dto.SchoolResponseDto;
import uz.hamkorbank.appschoolmanagement.dto.UserResponseDto;
import uz.hamkorbank.appschoolmanagement.entity.Address;
import uz.hamkorbank.appschoolmanagement.entity.Lessons;
import uz.hamkorbank.appschoolmanagement.entity.Subject;
import uz.hamkorbank.appschoolmanagement.entity.User;
import uz.hamkorbank.appschoolmanagement.repository.LessonRepository;
import uz.hamkorbank.appschoolmanagement.repository.SubjectRepository;
import uz.hamkorbank.appschoolmanagement.repository.UserRepository;
import uz.hamkorbank.appschoolmanagement.service.LessonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final SubjectRepository subjectRepository;

    private final UserRepository teacherRepository;
    @Override
    public Lessons save(LessonsCreateDto dto) {

            final Optional<Subject> optionalSubject = subjectRepository.findById(dto.getSubjectId());
            if(optionalSubject.isEmpty()){
                try {
                    throw new ClassNotFoundException("Subject not found");
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
            final Subject subject = optionalSubject.get();

            final Optional<User> optionalTeacher = teacherRepository.findById(dto.getTeacherId());
            if(optionalTeacher.isEmpty()){
                try {
                    throw new ClassNotFoundException("Teacher not found");
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
            final User user = optionalTeacher.get();
            Lessons lessons = new Lessons(
                    dto.getName(),
                    dto.getMaxStudent(),
                    subject,
                    user);
            Set<Long> studentIds = dto.getStudentIds();
        List<User> studentList = new ArrayList<>();
        for (Long studentId : studentIds) {
            Optional<User> optionalStudent = teacherRepository.findById(studentId);
            if (optionalStudent.isPresent()) {
                studentList.add(optionalStudent.get());
            }
        }
        lessons.setStudents(studentList);

        Lessons saveLessons = lessonRepository.save(lessons);

        return saveLessons;
    }

    @Override
    public List<LessonsResponseDto> findAll() {
        List<Lessons> lessonsList = lessonRepository.findAll();
        List<LessonsResponseDto> lessonsResponseDtoList = new ArrayList<>();
        for (Lessons lessons : lessonsList) {
            final User teacher = lessons.getTeacher();
            final UserResponseDto teacherResponseDto = UserResponseDto.builder()
                    .id(teacher.getId())
                    .name(teacher.getName())
                    .role(teacher.getRole().getName())
                    .address(teacher.getAddress().getName())
                    .school(new SchoolResponseDto(teacher.getId(), teacher.getName(), teacher.getAddress().getName()))
                    .build();
            List<UserResponseDto> listStudent = new ArrayList<>();
            for (User student : lessons.getStudents()) {
                final UserResponseDto studentResponseDto = UserResponseDto.builder()
                        .id(teacher.getId())
                        .name(teacher.getName())
                        .role(teacher.getRole().getName())
                        .address(teacher.getAddress().getName())
                        .school(new SchoolResponseDto(teacher.getId(), teacher.getName(), teacher.getAddress().getName()))
                        .build();
                listStudent.add(studentResponseDto);
            }
            final LessonsResponseDto lesson = LessonsResponseDto.builder()
                    .id(lessons.getId())
                    .name(lessons.getName())
                    .maxStudent(lessons.getMaxStudent())
                    .subject(lessons.getSubject())
                    .teacher(teacherResponseDto)
                    .students(listStudent)
                    .build();
            lessonsResponseDtoList.add(lesson);
        }

        return lessonsResponseDtoList;
    }

    @Override
    public LessonsResponseDto findById(Long id) throws ClassNotFoundException {
        final Optional<Lessons> optionalLessons = lessonRepository.findById(id);
        if (optionalLessons.isEmpty())
            throw new ClassNotFoundException("Lessons not found with id { "+id+" }");
        final Lessons lessons = optionalLessons.get();
        final User teacher = lessons.getTeacher();
        final UserResponseDto teacherResponseDto = UserResponseDto.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .role(teacher.getRole().getName())
                .address(teacher.getAddress().getName())
                .school(new SchoolResponseDto(teacher.getId(), teacher.getName(), teacher.getAddress().getName()))
                .build();
        List<UserResponseDto> listStudent = new ArrayList<>();
        for (User student : lessons.getStudents()) {
            final UserResponseDto studentResponseDto = UserResponseDto.builder()
                    .id(teacher.getId())
                    .name(teacher.getName())
                    .role(teacher.getRole().getName())
                    .address(teacher.getAddress().getName())
                    .school(new SchoolResponseDto(teacher.getId(), teacher.getName(), teacher.getAddress().getName()))
                    .build();
            listStudent.add(studentResponseDto);
        }
        final LessonsResponseDto lesson = LessonsResponseDto.builder()
                .id(lessons.getId())
                .name(lessons.getName())
                .maxStudent(lessons.getMaxStudent())
                .subject(lessons.getSubject())
                .teacher(teacherResponseDto)
                .students(listStudent)
                .build();
        return lesson;
    }

    @Override
    public Lessons update(Long id, LessonsCreateDto dto) throws ClassNotFoundException {
        final Optional<Lessons> optionalLessons = lessonRepository.findById(id);
        if (optionalLessons.isEmpty())
            throw new ClassNotFoundException("Lessons not found with id { "+id+" }");
        final Lessons lessons = optionalLessons.get();
        final Optional<Subject> optionalSubject = subjectRepository.findById(dto.getSubjectId());
        if(optionalSubject.isEmpty()){
            try {
                throw new ClassNotFoundException("Subject not found");
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        final Subject subject = optionalSubject.get();

        final Optional<User> optionalTeacher = teacherRepository.findById(dto.getTeacherId());
        if(optionalTeacher.isEmpty()){
            try {
                throw new ClassNotFoundException("Teacher not found");
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        final User teacher = optionalTeacher.get();

        if (dto.getSubjectId() != null&&!lessons.getSubject().getId().equals(dto.getSubjectId())){
            lessons.setSubject(subject);
        }
        if (dto.getTeacherId() != null && ! lessons.getTeacher().getId().equals(dto.getTeacherId())){
            lessons.setTeacher(teacher);
        }
        if(!dto.getName().isEmpty()&&!dto.getName().isBlank()&&!lessons.getName().equals(dto.getName())){
            lessons.setName(dto.getName());
        }
        if (dto.getMaxStudent() != null &&!lessons.getMaxStudent().equals(dto.getMaxStudent())){
            lessons.setMaxStudent(dto.getMaxStudent());
        }

        Set<Long> studentIds = dto.getStudentIds();
        List<User> studentList = new ArrayList<>();
        for (Long studentId : studentIds) {
            Optional<User> optionalStudent = teacherRepository.findById(studentId);
            if(optionalStudent.isEmpty()){
                try {
                    throw new ClassNotFoundException("Student not found");
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
            studentList.add(optionalStudent.get());
        }
        lessons.setStudents(studentList);
        return  lessonRepository.save(lessons);
    }

    @Override
    public void deleteById(Long id) throws ClassNotFoundException {
        final Optional<Lessons> optionalLessons = lessonRepository.findById(id);
        if (optionalLessons.isEmpty())
            throw new ClassNotFoundException("Lessons not found with id { "+id+" }");
        lessonRepository.deleteById(id);
    }
}
