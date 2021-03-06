package pl.pojechali.offdrive.user;

import pl.pojechali.offdrive.exception.UserAlreadyExistException;

import java.util.Map;

public interface UserService {

  User findUserByEmail(String email);

  void saveUser(User user) throws UserAlreadyExistException;

  Map<Long, String> findUserByNickname(String nickName);

  User findUserById(Long l);

  User updateUser(User user) throws UserAlreadyExistException;

  void deleteUser(User user);
}
