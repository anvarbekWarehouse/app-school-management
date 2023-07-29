package uz.hamkorbank.appschoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.hamkorbank.appschoolmanagement.entity.Role;
import uz.hamkorbank.appschoolmanagement.entity.User;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
