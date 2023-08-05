package uz.hamkorbank.appschoolmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.hamkorbank.appschoolmanagement.dto.AddressCreateDto;
import uz.hamkorbank.appschoolmanagement.entity.Address;
import uz.hamkorbank.appschoolmanagement.repository.AddressRepository;
import uz.hamkorbank.appschoolmanagement.service.AddressService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    @Override
    public Address save(AddressCreateDto dto) throws ClassNotFoundException {
        if (addressRepository.existsByName(dto.getName())){
            throw new ClassNotFoundException("Exists " + dto.getName());
        }
        Address address = new Address(dto.getName());

        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAll() {

        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) throws ClassNotFoundException {
        final Optional<Address> byId = addressRepository.findById(id);
        if (!byId.isPresent())
            throw new ClassNotFoundException("Address not found by id { "+id+" }");
        return byId.get();
    }

    @Override
    public Address update(Long id, AddressCreateDto dto) throws ClassNotFoundException {
        final Optional<Address> byId = addressRepository.findById(id);
        if (!byId.isPresent())
            throw new ClassNotFoundException("Address not found by id { "+id+" }");
        if (addressRepository.existsByName(dto.getName())){
            throw new ClassNotFoundException("Exists " + dto.getName());
        }
        final Address address = byId.get();
        address.setName(dto.getName());
        return addressRepository.save(address);
    }

    @Override
    public void delete(Long id) throws ClassNotFoundException {
        final Optional<Address> byId = addressRepository.findById(id);
        if (!byId.isPresent())
            throw new ClassNotFoundException("Address not found by id { "+id+" }");
        addressRepository.delete(byId.get());

    }
}
