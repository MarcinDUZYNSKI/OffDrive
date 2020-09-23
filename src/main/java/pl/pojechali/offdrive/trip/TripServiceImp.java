package pl.pojechali.offdrive.trip;

import lombok.Data;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.pojechali.offdrive.tripCondition.TripCondition;
import pl.pojechali.offdrive.tripCondition.TripConditionsRepository;
import pl.pojechali.offdrive.user.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Data
@Service
@Transactional
public class TripServiceImp implements TripService {
    private final TripRepository tripRepository;
    private final TripConditionsRepository tripConditionsRepository;
    private final UserRepository userRepository;

    @Override
    public void saveTrip(Trip trip) {
        String username;
        trip.setTripDate(LocalDateTime.now());
        //get current login user
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
             username = ((UserDetails)principal).getUsername();
        } else {
             username = principal.toString();
        }
        trip.setUser(userRepository.findUserByEmail(username));
        tripRepository.save(trip);
    }

    @Override
    public void saveTripCondition(TripCondition tripCondition) {
        tripConditionsRepository.save(tripCondition);
    }
}
