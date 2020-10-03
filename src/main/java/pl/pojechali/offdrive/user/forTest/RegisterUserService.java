package pl.pojechali.offdrive.user.forTest;

import pl.pojechali.offdrive.user.forTest.RegisterUserRequest;
import pl.pojechali.offdrive.user.forTest.RegisterUserResponce;

public interface RegisterUserService {

    RegisterUserResponce registerUser(RegisterUserRequest request);
}
