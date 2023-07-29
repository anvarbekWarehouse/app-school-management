package uz.hamkorbank.appschoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.hamkorbank.appschoolmanagement.entity.Mark;
import uz.hamkorbank.appschoolmanagement.entity.User;

public interface MarkRepository extends JpaRepository<Mark, Long> {
}
