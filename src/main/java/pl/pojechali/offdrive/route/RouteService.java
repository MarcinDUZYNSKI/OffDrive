package pl.pojechali.offdrive.route;

import pl.pojechali.offdrive.trip.Trip;

import java.util.List;

public interface RouteService {
    void saveRouteFromTrip(Trip trip);
    void saveRouteFromFile(); // do stworzenia trasy wcześniej przejechanej z zaimportowanego pliku
    List<Route> findRoutesByName(); // wyszukaj trasy po liście
    List<Route> findRoutesByCoordinates(); //wyszukaj route po współrzędnych

}
