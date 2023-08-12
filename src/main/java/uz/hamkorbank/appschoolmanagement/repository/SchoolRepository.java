package uz.hamkorbank.appschoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.hamkorbank.appschoolmanagement.entity.Lessons;
import uz.hamkorbank.appschoolmanagement.entity.School;

public interface SchoolRepository extends JpaRepository<School, Long> {
    boolean existsByName(String name);
}
