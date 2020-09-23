package pl.pojechali.offdrive.user;

import pl.pojechali.offdrive.security.UserAlreadyExistException;

public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User user) throws UserAlreadyExistException;
}
