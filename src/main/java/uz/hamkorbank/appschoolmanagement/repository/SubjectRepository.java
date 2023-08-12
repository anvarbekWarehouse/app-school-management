package uz.hamkorbank.appschoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.hamkorbank.appschoolmanagement.entity.Address;
import uz.hamkorbank.appschoolmanagement.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    boolean existsByName(String name);
}
