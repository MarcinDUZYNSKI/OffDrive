package pl.pojechali.offdrive.user;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultRegistrationService implements RegistrationServices {

  private final UserRepository userRepository;

  @Override
  public RegisterUserResponse registerUser(RegisterUserRequest request) {
    // tworzymy czysty czytelny kod
    if(userRepository.existsByEmail(request.getEmail())) {
      throw new IllegalArgumentException("User with " + request.getEmail() + " already exists");
    }
//    RegisterUserResponse response = new RegisterUserResponse();
    User user = createUser(request);
//    response.setUserId(user.getId());
//    return response;
    return validResponse(user);
  }

  private RegisterUserResponse validResponse(User user) {
    return new RegisterUserResponse(user.getId());
  }

  private User createUser(RegisterUserRequest request) {
    User user = new User();
    user.setEmail(request.getEmail());
    user.setPassword(request.getPassword());
    userRepository.save(user);
    return user;
  }
}
