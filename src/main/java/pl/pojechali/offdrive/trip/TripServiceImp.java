package pl.pojechali.offdrive.trip;

import lombok.Data;
import org.springframework.stereotype.Service;
import pl.pojechali.offdrive.tripCondition.TripCondition;
import pl.pojechali.offdrive.tripCondition.TripConditionsRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Data
@Service
@Transactional
public class TripServiceImp implements TripService {
    private final TripRepository tripRepository;
    private final TripConditionsRepository tripConditionsRepository;

    @Override
    public void saveTrip(Trip trip) {
        trip.setTripDate(LocalDateTime.now());
        tripRepository.save(trip);
    }

    @Override
    public void saveTripCondition(TripCondition tripCondition) {
        tripConditionsRepository.save(tripCondition);
    }
}
