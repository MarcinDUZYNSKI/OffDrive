package pl.pojechali.offdrive.trip;

import lombok.Data;
import org.springframework.stereotype.Service;
import pl.pojechali.offdrive.exception.RouteAlreadyExistException;
import pl.pojechali.offdrive.route.Route;
import pl.pojechali.offdrive.tripCondition.TripCondition;
import pl.pojechali.offdrive.tripCondition.TripConditionsRepository;
import pl.pojechali.offdrive.user.UserServiceImpl;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
        trip.setCreatedDate(LocalDate.now());
        trip.setCreatedTime(LocalTime.now());
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

    @Override
    public void updateTrip(Trip trip) {
        if (trip == null) {
            throw new NullPointerException(" Trip is Null");
        }
        Trip tripToUpdate = tripRepository.findById(trip.getId()).get();
        tripToUpdate.setName(trip.getName());
        tripToUpdate.setTripTime(trip.getTripTime());
        tripToUpdate.setLength(trip.getLength());
        tripToUpdate.setTripAltitude(trip.getTripAltitude());
        tripToUpdate.setDescription(trip.getDescription());
        trip.getTripCondition().setId(tripToUpdate.getTripCondition().getId());
        trip.getTripCondition().setTrip(tripToUpdate.getTripCondition().getTrip());
        tripToUpdate.setTripCondition(trip.getTripCondition());
        tripRepository.save(tripToUpdate);
    }

    @Override
    public TripCondition findTripConditionByTripId(long id) {
        return tripConditionsRepository.findByTripId(id);
    }

    public Trip findTripById(long id) {
        return tripRepository.findById(id).get();

    }

    public void updateRouteIdInTrip(Trip trip, Route route) throws RouteAlreadyExistException {
        if (trip == null) {
            throw new NullPointerException(" Trip is Null");
        }
        Trip tripToUpdate = tripRepository.findById(trip.getId()).get();
        if (tripToUpdate.getRoute() != null) {
            throw new RouteAlreadyExistException(" Route wos already create from this Trip");
        } else {
            tripToUpdate.setRoute(route);
        }
        tripRepository.save(trip);
    }
}

