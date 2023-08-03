package uz.hamkorbank.appschoolmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.hamkorbank.appschoolmanagement.dto.LessonsCreateDto;
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
}
