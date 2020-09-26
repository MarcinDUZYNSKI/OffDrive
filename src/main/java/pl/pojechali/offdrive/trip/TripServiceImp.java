package pl.pojechali.offdrive.trip;

import lombok.Data;
import org.springframework.stereotype.Service;
import pl.pojechali.offdrive.tripCondition.TripCondition;
import pl.pojechali.offdrive.tripCondition.TripConditionsRepository;
import pl.pojechali.offdrive.user.UserServiceImpl;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Service
@Transactional
public class TripServiceImp implements TripService {
    private final TripRepository tripRepository;
    private final TripConditionsRepository tripConditionsRepository;
    private final UserServiceImpl userService;

    @Override
    public void saveTrip(Trip trip) {
        trip.setTripDate(LocalDateTime.now());
        trip.setUser(userService.getCurrentLoginUser());
        tripRepository.save(trip);
    }

    @Override
    public void saveTripCondition(TripCondition tripCondition) {
        tripConditionsRepository.save(tripCondition);
    }

    /**
     * Return Array list of Trip Current login user
     *
     * @return
     */
    @Override
    public List<Trip> findUserTripList() {
        return tripRepository.findAllByUserId(userService.getCurrentLoginUser().getId());
    }

    public Trip findTripById(long id) {
        return tripRepository.findById(id).get();

    }
}

