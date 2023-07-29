package uz.hamkorbank.appschoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.hamkorbank.appschoolmanagement.entity.Address;

public interface TimeTableRepository extends JpaRepository<Address, Long> {
}
