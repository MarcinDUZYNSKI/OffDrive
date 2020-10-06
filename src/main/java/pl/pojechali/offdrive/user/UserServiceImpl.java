package pl.pojechali.offdrive.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public void saveUser(User user) throws UserAlreadyExistException {
        if (checkIfUserExist(user.getEmail())) {
            throw new UserAlreadyExistException("User already exists for this email");
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
    public void updateUser(User user) throws UserAlreadyExistException {
        User userToUpdate = userRepository.findUserById(user.getId());
        if (userToUpdate==null){
            throw new NoSuchElementException(" user doesn't exist! can't Update ");
        }
        if (checkIfUserExist(user.getEmail())){
            throw new UserAlreadyExistException();
        }
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setPassword(passwordEncoder.encode(user.getPassword()));
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setNickName(user.getNickName());
        userRepository.save(userToUpdate);
    }

    public Map<Long, String> findAllIdNickNameMap() {
        return userRepository.findAllIdNickNameMap();
    }

    public boolean checkIfUserExist(String email) {
        return userRepository.findUserByEmail(email) != null;
    }

    public User getCurrentLoginUser() {
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return (userRepository.findUserByEmail(username));
    }
}

