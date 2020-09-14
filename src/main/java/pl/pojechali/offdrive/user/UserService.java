package pl.pojechali.offdrive.user;

public interface UserService {// na kiego nam ten Interface?????
    User findUserByEmail(String email);
    void saveUser(User user);
}
