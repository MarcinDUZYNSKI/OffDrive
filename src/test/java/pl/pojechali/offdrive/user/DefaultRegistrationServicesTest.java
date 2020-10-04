package pl.pojechali.offdrive.user;


import java.util.Random;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

@DisplayName("Unit tests for DefaultRegistrationService")
class DefaultRegistrationServicesTest {

  private UserRepository userRepository;
  private DefaultRegistrationService service;

  @BeforeEach
  public void prepare() {
    userRepository = Mockito.mock(UserRepository.class);
    service = new DefaultRegistrationService(userRepository);
  }

  @Nested
  @DisplayName("Inits tests for DefaultRegistrationService::registerUser")
  class RegisterUser {

    @Test
    @DisplayName("Response should not be null")
    public void responseShouldNotBeNull() {
//      org.assertj.core.api.Assertions -> Główna klasa z asercjami
//      org.mockito.Mockito -> Tworzy mocki
//      org.mockito.ArgumentMatchers -> Tworzy mocki argumentów
//      org.mockito.ArgumentCaptor -> Do przechwytywania argumentów
      RegisterUserRequest request = new RegisterUserRequest();
      RegisterUserResponse response = service.registerUser(request);
      Assertions.assertThat(response).isNotNull();
    }

    @Test
    @DisplayName("Should use UserRepository")
    public void shouldUseUserRepository() {
      Mockito.when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(new User());
      RegisterUserRequest request = new RegisterUserRequest();
      RegisterUserResponse response = service.registerUser(request);

      Mockito.verify(userRepository, Mockito.times(1)).save(ArgumentMatchers.any(User.class));
    }

    @Test
    @DisplayName("Should use username and password from request")
    public void shouldUseUsernameAndPasswordFromRequest() {
      ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
      Mockito.when(userRepository.save(userCaptor.capture())).thenReturn(new User());

      RegisterUserRequest request = new RegisterUserRequest("m@op.pl", "hello");
      RegisterUserResponse response = service.registerUser(request);

      User user = userCaptor.getValue();
      Assertions.assertThat(user).isNotNull();
      Assertions.assertThat(user).extracting(User::getEmail).isNotNull()
          .isEqualTo(request.getEmail());
      Assertions.assertThat(user).extracting(User::getPassword).isNotNull()
          .isEqualTo(request.getPassword());
    }

    @Test
    @DisplayName("Response should contains register user id")
    public void responseShouldContainsRegisterUserId() {
      Long randomId = new Random().nextLong();

      Mockito.when(userRepository.save(ArgumentMatchers.any(User.class))).then(invocation -> {
        User userArg = invocation.getArgument(0, User.class);
        userArg.setId(randomId);
        return userArg;
      });
      RegisterUserRequest request = new RegisterUserRequest("m@op.pl", "hello");
      RegisterUserResponse response = service.registerUser(request);

      Assertions.assertThat(response.getUserId()).isNotNull().isEqualTo(randomId);
    }
    @Test
    @DisplayName("Should throw RuntimeException when user already exists")
    public void shouldThrowRuntimeExceptionWhenEmailAlreadyExists(){

      Mockito.when(userRepository.existsByEmail("ma@op.pl")).thenReturn(true);
      RegisterUserRequest request = new RegisterUserRequest("ma@op.pl", "hello");
      RegisterUserResponse response = service.registerUser(request);

      Assertions.assertThatThrownBy(() -> service.registerUser(request))
          .hasNoCause()
          .hasMessageContaining("ma@op.pl")
          .hasMessageContaining("already exist")
          .isInstanceOf(RuntimeException.class);
    }

  }


}