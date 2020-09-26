package pl.pojechali.offdrive.trip;


import pl.pojechali.offdrive.tripCondition.TripCondition;

import java.util.List;

public interface TripService {
    void saveTrip(Trip trip);
    void saveTripCondition(TripCondition tripCondition);
    List<Trip> findUserTripList();
}
