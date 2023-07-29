package uz.hamkorbank.appschoolmanagement.service.impl;

 import lombok.RequiredArgsConstructor;
 import org.springframework.stereotype.Service;
 import uz.hamkorbank.appschoolmanagement.dto.UserCreateDto;
 import uz.hamkorbank.appschoolmanagement.entity.*;
 import uz.hamkorbank.appschoolmanagement.repository.AddressRepository;
 import uz.hamkorbank.appschoolmanagement.repository.RoleRepository;
 import uz.hamkorbank.appschoolmanagement.repository.SchoolRepository;
 import uz.hamkorbank.appschoolmanagement.repository.UserRepository;
 import uz.hamkorbank.appschoolmanagement.service.UserService;

 import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

 private final UserRepository userRepository;
 private final RoleRepository roleRepository;

 private final AddressRepository addressRepository;

 private final SchoolRepository schoolRepository;

 @Override
 public User save(UserCreateDto dto) throws ClassNotFoundException {
  Optional<Role> optionalRole = roleRepository.findById(dto.getRoleId());
  if (optionalRole.isEmpty())
   throw new ClassNotFoundException("Such Role Id Not Found");
  Role role = optionalRole.get();

  Optional<Address> optionalAddress = addressRepository.findById(dto.getAddressId());
  if (optionalAddress.isEmpty())
   throw new ClassNotFoundException("Such Address Id Not Found");
  Address address = optionalAddress.get();

  Optional<School> optionalSchool = schoolRepository.findById(dto.getSchoolId());
  if (optionalSchool.isEmpty())
   throw new ClassNotFoundException("Such School Id Not Found");
  School school = optionalSchool.get();
  User user = new User(dto.getName(), dto.getEmail(), role, address, school);

  return userRepository.save(user);
 }
}
