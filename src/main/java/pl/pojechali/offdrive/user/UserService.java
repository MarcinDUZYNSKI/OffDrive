package pl.pojechali.offdrive.user;

import pl.pojechali.offdrive.exception.UserAlreadyExistException;

public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User user) throws UserAlreadyExistException;
//    void RegisterUserResponce registerUser (RegisterUserRequest request);
}
