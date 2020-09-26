package pl.pojechali.offdrive.trip;

import org.junit.jupiter.api.Test;
import pl.pojechali.offdrive.tripCondition.TripCondition;

import java.util.List;

class TripServiceTest {

//    @Before("")
//    public void prepairTest(){
//        emptyTrip = new Trip();
//    }

    @Test
    public void giveNewTrip_whenSave_thenTripIsSave() {
        Trip trip = new Trip();
        TripService tripService = new TripService() {
            @Override
            public void saveTrip(Trip trip1) {
            }

            @Override
            public void saveTripCondition(TripCondition tripCondition) {

            }

            @Override
            public List<Trip> findUserTripList() {
                return null;
            }
        };
    }

    @Test
    public void givenNewTripCondition_whenSaveTripCondition_thenConditionIsSave() {

    }


    // stwórz mowy trip

    //edytuj trip

    //usuń trip

    //wyszukaj tripy usera

}


// testujemy poprawność założeń do zapisu usera np uniq czy notBlank

//@SpringBootTest
//@ActiveProfiles("local")    tu trzeba użyć lokalnego profilu z bazą danych h4 żeby za każdym razem się czyściła
//class UserRepositoryTest {
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private EntityManager entityManager;
//    @Test
//    public void givenValidUser_whenSave_shouldBeSaved() {
//        User user = new User("username", "password");
//        user.getRoles().add("ROLE_USER");
//        user.getDetails().setEmail("email");
//        user.getDetails().setFirstName("firstName");
//        user.getDetails().setLastName("lastName");
//        userRepository.save(user);
//        assertNotNull(entityManager.find(User.class, user.getId()));
//    }
//    @Test
//    public void givenTwoUsersWithSameUsername_whenSaveBoth_thenThrowException() {
//        User user1 = new User("username", "password");
//        User user2 = new User("username", "password");
//        userRepository.save(user1);
//        assertThrows(DataIntegrityViolationException.class, () -> userRepository.save(user2));
//    }
//}