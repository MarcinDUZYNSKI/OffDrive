package pl.pojechali.offdrive.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.pojechali.offdrive.exception.UserAlreadyExistException;
import pl.pojechali.offdrive.user.role.Role;
import pl.pojechali.offdrive.user.role.RoleRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserUtils userUtils;

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public void saveUser(User user) throws UserAlreadyExistException {
        if (checkIfUserExist(user.getEmail())) {
            throw new UserAlreadyExistException("User already exists for this email");
        }
        if (user.getPassword() == null) {
            throw new NullPointerException("Password is null");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        user.setCreationDate(LocalDateTime.now());
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public Map<Long, String> findUserByNickname(String nickName) {
        Set<User> userSet = userRepository.findUserByNickNameContains(nickName);
        Map<Long, String> userMap = new HashMap<>();
        for (User u : userSet) {
            userMap.put(u.getId(), u.getNickName());
        }
        return userMap;
    }

    @Override
    public User findUserById(Long l) {
        return userRepository.findUserById(l);
    }

    @Override
    public User updateUser(User user) throws UserAlreadyExistException {
        User userToUpdate = userRepository.findUserByEmail(user.getEmail());
        if (userToUpdate == null) {
            throw new NoSuchElementException(" user doesn't exist! can't Update ");
        }
        if (!userToUpdate.getEmail().equals(user.getEmail())) {
            if (checkIfUserExist(
                    user.getEmail())) {
                throw new UserAlreadyExistException();
            }
        }
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setFirstName(user.getFirstName());
//        userToUpdate.setPassword(passwordEncoder.encode(userToUpdate.getPassword()));
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setNickName(user.getNickName());
        userRepository.save(userToUpdate);
        return userToUpdate;
    }

    public User getCurrentLoginUser() {
        return (userRepository.findUserByEmail(userUtils.getCurrentLoginUser()));
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public boolean checkIfUserExist(String email) {
        return userRepository.findUserByEmail(email) != null ? true : false;
    }

}

