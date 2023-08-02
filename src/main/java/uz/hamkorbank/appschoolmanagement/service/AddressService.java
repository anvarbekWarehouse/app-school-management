package uz.hamkorbank.appschoolmanagement.service;

import uz.hamkorbank.appschoolmanagement.dto.AddressCreateDto;
import uz.hamkorbank.appschoolmanagement.entity.Address;

public interface AddressService {


    Address save(AddressCreateDto dto) throws ClassNotFoundException;
}
