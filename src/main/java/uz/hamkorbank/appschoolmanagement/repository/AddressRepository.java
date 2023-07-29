package uz.hamkorbank.appschoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.hamkorbank.appschoolmanagement.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
