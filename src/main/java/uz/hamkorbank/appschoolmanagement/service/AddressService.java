package uz.hamkorbank.appschoolmanagement.service;

import uz.hamkorbank.appschoolmanagement.dto.AddressCreateDto;
import uz.hamkorbank.appschoolmanagement.entity.Address;

import java.util.List;

public interface AddressService {


    Address save(AddressCreateDto dto) throws ClassNotFoundException;

    List<Address> getAll();

    Address findById(Long id) throws ClassNotFoundException;

    Address update(Long id, AddressCreateDto dto) throws ClassNotFoundException;

    void delete(Long id) throws ClassNotFoundException;
}
