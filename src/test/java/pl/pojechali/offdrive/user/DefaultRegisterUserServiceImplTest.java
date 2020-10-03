package pl.pojechali.offdrive.user;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import pl.pojechali.offdrive.user.forTest.DefaultRegisterUserServiceImpl;
import pl.pojechali.offdrive.user.forTest.RegisterUserRequest;
import pl.pojechali.offdrive.user.forTest.RegisterUserResponce;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@DisplayName("Unit test for DeafultRegidtrationServiceImpl")
class DefaultRegisterUserServiceImplTest {

    private DefaultRegisterUserServiceImpl service;
    private UserRepository userRepository;

    //classa do classy testującej
    @BeforeEach
    public void prepare() {
        userRepository = Mockito.mock(UserRepository.class);  // tworzymy mocka dzięki temu nie musimy pisać fake obiektu jak na samym dole "FakeUserRepository"
        service = new DefaultRegisterUserServiceImpl(userRepository);
    }

    //poziom zagnieżdżenia
    //tworzymy wewnętrzną classe testującą jedną  metodę
    @Nested
    @DisplayName("Unit test for DefaultRegidtrationService::ragidterUser")
    class RegisterUser {
        @Test
        @DisplayName("Responce shuld not be null")
        public void responceShouldNotByNull() {
//            org.assertj.core.api.Assertions   <-- główna klasa z asercjami
//            org.mockito.Mockito   <-- Tworzy mocki   do uniezależnianie od zewnętrznych zależności
//                org.mockito.ArgumentMatchers <-- tworzy mocki argumentów
//                org.mockito.ArgumentCaptor  <-- do przechwytywanie argumentów
            RegisterUserRequest request = new RegisterUserRequest();
            RegisterUserResponce response = service.registerUser(request);

            Assertions.assertThat(response).isNotNull();
        }

        @Test
        @DisplayName("Should use UserRepository")
        public void shouldUseUserRepository() {
            //nagrywamu zamkowaną metodę
            Mockito.when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(new User());   // zostaje wywołana metoda save z jakim kolwiek obiektem klasy user
            RegisterUserRequest request = new RegisterUserRequest();
            RegisterUserResponce response = service.registerUser(request);

            Mockito.verify(userRepository, Mockito.times(1)).save(ArgumentMatchers.any(User.class));

        }

        @Test
        @DisplayName("Should use username and password from request")
        public void shouldUseUsernameAndPasswordFromRequest() {
            // interesuje masz czy do repo sostały przekane dane
            ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class); // musimy mieś oddzielną zmienną bo na koniec testów będziemy ją veryfikować
            Mockito.when(userRepository.save(userCaptor.capture())).thenReturn(new User());
            RegisterUserRequest request = new RegisterUserRequest("joeSmith", "s3crt3t");
            RegisterUserResponce responce = service.registerUser(request);

            User user = userCaptor.getValue(); // żeby dostać wartość
            Assertions.assertThat(user).isNotNull();
            Assertions.assertThat(user).extracting(User::getEmail)
                    .isNotNull()
                    .isEqualTo(request.getEmail());
            Assertions.assertThat(user).extracting(User::getPassword)
                    .isNotNull()
                    .isEqualTo(request.getPassword());

        }

        @Test
        @DisplayName("Responce Should register User id")
        public void responceShouldContainsRegisteresUserId() {
            Long randomId = new Random().nextLong();
            Mockito.when(userRepository.save(ArgumentMatchers.any(User.class)))
                    .then(invocationOnMock -> {
                        User userArg = invocationOnMock.getArgument(0, User.class);
                        userArg.setId(randomId);
                        return userArg;

//                        invocationOnMock.getArgument(0, User.class).setId(id);
//                        return invocationOnMock.getArgument(0, User.class);
                    });

            RegisterUserRequest request = new RegisterUserRequest("joeSmith", "s3cr3t");
            RegisterUserResponce responce = service.registerUser(request);

            Assertions.assertThat(responce.getUserId()).isNotNull().isEqualTo(randomId);


        }

        @Test
        @DisplayName("Sholud throw RuntimeException when usernsme (email) already exisrts")
        public void shouldThrowRuntimeExceptionWhenUsernameAlreadyExist(){
            Mockito.when(userRepository.existsByUsername("joesmith")).thenReturn(true);

            RegisterUserRequest request = new RegisterUserRequest("joesmith", "s3cr3t");
//            RegisterUserResponce responce = service.registerUser(request);
            Assertions.assertThatThrownBy(() -> service.registerUser(request))
                    .hasNoCause()
                    .hasMessageContaining("joesmith")
                    .hasMessageContaining("already exists")
                    .isInstanceOf(RuntimeException.class);
        }


    }


    //  potrzebne do shoulduseUserRepository to można tak zostabić ale boli  dlatego sięgamy po biblioteki mokujące
    class FakeUserRepository implements UserRepository {
        @Override
        public User findUserByEmail(String email) {
            return null;
        }

        @Override
        public boolean existsByUsername(String username) {
            return false;
        }

        @Override
        public List<User> findAll() {
            return null;
        }

        @Override
        public List<User> findAll(Sort sort) {
            return null;
        }

        @Override
        public Page<User> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public List<User> findAllById(Iterable<Long> iterable) {
            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(User user) {

        }

        @Override
        public void deleteAll(Iterable<? extends User> iterable) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends User> S save(S s) {
            return null;
        }

        @Override
        public <S extends User> List<S> saveAll(Iterable<S> iterable) {
            return null;
        }

        @Override
        public Optional<User> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends User> S saveAndFlush(S s) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<User> iterable) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public User getOne(Long aLong) {
            return null;
        }

        @Override
        public <S extends User> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends User> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends User> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends User> boolean exists(Example<S> example) {
            return false;
        }
    }


// możemy stosować 2 poziomy zagnieżdzania jeną dla testów które przechdzą a drugą dla testów które nie przechodzą
}