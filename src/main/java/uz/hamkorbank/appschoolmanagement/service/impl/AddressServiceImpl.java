package uz.hamkorbank.appschoolmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.hamkorbank.appschoolmanagement.dto.AddressCreateDto;
import uz.hamkorbank.appschoolmanagement.entity.Address;
import uz.hamkorbank.appschoolmanagement.repository.AddressRepository;
import uz.hamkorbank.appschoolmanagement.service.AddressService;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    @Override
    public Address save(AddressCreateDto dto) throws ClassNotFoundException {
        if (addressRepository.existsByName(dto.getName())){
            throw new ClassNotFoundException("Exists " + dto.getName());
        }
        Address address = new Address(dto.getName());

        return addressRepository.save(address);
    }
}
