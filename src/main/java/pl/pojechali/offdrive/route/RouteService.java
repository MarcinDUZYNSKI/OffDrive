package pl.pojechali.offdrive.route;

import pl.pojechali.offdrive.exception.RouteAlreadyExistException;
import pl.pojechali.offdrive.trip.Trip;

import java.util.List;

public interface RouteService {
    Route createRouteFromTrip(Trip trip) throws RouteAlreadyExistException;
    void saveRouteFromFile(); // do stworzenia trasy wcześniej przejechanej z zaimportowanego pliku
    List<Route> findRoutesByName(String name); // wyszukaj trasy po liście
    List<Route> findRoutesByCoordinates(); //wyszukaj route po współrzędnych
    List<Route> findUserRouteList(); // wyszukaj wszystkie route aktywnego user
    List<Route> findRouteListByUser(String name); // wszystkie route wskazanego user po emailu
    List<Route> findRouteListByUserId(Long id); // wszystkie route wskazanego user po jego Id
    Route findRouteById(Long id);
    void updateRoute(Route route);
    void deleteRoute(Route route);
    List<Route> findAllRouteList();
}
