package pl.pojechali.offdrive.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.pojechali.offdrive.security.UserAlreadyExistException;
import pl.pojechali.offdrive.user.role.Role;
import pl.pojechali.offdrive.user.role.RoleRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public void saveUser(User user) throws UserAlreadyExistException {
        if(checkIfUserExist(user.getEmail())) {
            throw new UserAlreadyExistException ("User already exists for this email");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        user.setCreationDate(LocalDateTime.now());
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    public boolean checkIfUserExist(String email) {
        return userRepository.findUserByEmail(email) != null ? true : false;
    }



}
