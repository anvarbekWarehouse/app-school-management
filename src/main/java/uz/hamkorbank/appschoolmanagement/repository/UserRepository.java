package uz.hamkorbank.appschoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.hamkorbank.appschoolmanagement.entity.Lessons;
import uz.hamkorbank.appschoolmanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
