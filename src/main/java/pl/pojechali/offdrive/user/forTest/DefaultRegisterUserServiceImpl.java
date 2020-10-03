package pl.pojechali.offdrive.user.forTest;

import lombok.RequiredArgsConstructor;
import pl.pojechali.offdrive.user.*;

@RequiredArgsConstructor
public class DefaultRegisterUserServiceImpl implements RegisterUserService {

    private final UserRepository userRepository;

    @Override
    public RegisterUserResponce registerUser(RegisterUserRequest request) {
        validIfExist(request);
        User user = createUserFromRequest(request);
//        userRepository.save(user);// to można też gdzieś przenieść
        return validResponce(user);
    }

    private void validIfExist(RegisterUserRequest request) {
        if (userRepository.existsByUsername(request.getEmail())){
            throw new IllegalStateException("Username with "+ request.getEmail() + " already exists" );
        }
    }

    private RegisterUserResponce validResponce(User user){
        return new RegisterUserResponce(user.getId());
    }

//    @org.jetbrains.annotations.NotNull
    private User createUserFromRequest(RegisterUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        userRepository.save(user);
        return user;
    }
}
