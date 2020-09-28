package pl.pojechali.offdrive.route;

import pl.pojechali.offdrive.exception.RouteAlreadyExistException;
import pl.pojechali.offdrive.trip.Trip;

import java.util.List;

public interface RouteService {
    Route saveRouteFromTrip(Trip trip) throws RouteAlreadyExistException;
    void saveRouteFromFile(); // do stworzenia trasy wcześniej przejechanej z zaimportowanego pliku
    List<Route> findRoutesByName(String name); // wyszukaj trasy po liście
    List<Route> findRoutesByCoordinates(); //wyszukaj route po współrzędnych
    List<Route> findUserRouteList(); // wyszukaj wszystkie route aktywnego user
    List<Route> findRouteListByUserId(long id); // wszystkie route wskazanego user

}
