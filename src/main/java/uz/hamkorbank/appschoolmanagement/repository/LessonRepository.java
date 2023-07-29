package uz.hamkorbank.appschoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.hamkorbank.appschoolmanagement.entity.Address;
import uz.hamkorbank.appschoolmanagement.entity.Lessons;

public interface LessonRepository extends JpaRepository<Lessons, Long> {
}
