package pl.pojechali.offdrive.trip;


import pl.pojechali.offdrive.tripCondition.TripCondition;

public interface TripService {
    void saveTrip(Trip trip);
    void saveTripCondition(TripCondition tripCondition);
}
