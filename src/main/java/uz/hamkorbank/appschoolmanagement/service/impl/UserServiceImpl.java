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

 import java.util.List;
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

 @Override
 public List<User> findAll() {
  return userRepository.findAll();
 }

 @Override
 public User findById(Long id) throws ClassNotFoundException {
  Optional<User> optionalUser = userRepository.findById(id);
  if (optionalUser.isEmpty())
      throw new ClassNotFoundException("User not found with Id {"+id+"}");
  User user = optionalUser.get();

  return user;
 }

 @Override
 public User findByEmail(String email) throws ClassNotFoundException {
  Optional<User> byEmail = userRepository.findByEmail(email);
  if (byEmail.isEmpty())
   throw new ClassNotFoundException("User not found with Id {"+email+"}");
  User user = byEmail.get();
  return user;
 }

 @Override
 public User update(Long id, UserCreateDto dto) throws ClassNotFoundException {
  Optional<User> optionalUser = userRepository.findById(id);
  if (optionalUser.isEmpty())
   throw new ClassNotFoundException("User not found with Id {"+id+"}");
  User user = optionalUser.get();

  Optional<Address> optionalAddress = addressRepository.findById(dto.getAddressId());
  if (optionalAddress.isEmpty())
   throw new ClassNotFoundException("Address Not found with ID { "+dto.getAddressId()+" }");

  Optional<Role> optionalRole = roleRepository.findById(dto.getRoleId());
  if (optionalRole.isEmpty())
   throw new ClassNotFoundException("Role not found with ROLE ID {"+dto.getRoleId()+" }");

  final Optional<School> optionalSchool = schoolRepository.findById(dto.getSchoolId());
  if (optionalSchool.isEmpty())
   throw new ClassNotFoundException("School not found with SCHOOL ID { "+ dto.getSchoolId() +" }");

  if(dto.getAddressId() != null && !user.getAddress().getId().equals(dto.getAddressId())){
     Address address = optionalAddress.get();
     user.setAddress(address);
  }

  if (!user.getRole().getId().equals(dto.getRoleId())){
   user.setRole(optionalRole.get());
  }

  if (!user.getSchool().equals(dto.getSchoolId())){
   user.setSchool(optionalSchool.get());
  }

  if (!dto.getName().isEmpty()&&!dto.getName().isBlank()&&!user.getName().equals(dto.getName())){
   user.setName(dto.getName());
  }
  if (!dto.getEmail().isEmpty()&&!dto.getEmail().isBlank()&&!user.getEmail().equals(dto.getEmail())){
   user.setEmail(dto.getEmail());
  }

  final User saveUser = userRepository.save(user);
  return saveUser;
 }
}
