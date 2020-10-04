package pl.pojechali.offdrive.route;

import lombok.Data;
import org.springframework.stereotype.Service;
import pl.pojechali.offdrive.exception.RouteAlreadyExistException;
import pl.pojechali.offdrive.trip.Trip;
import pl.pojechali.offdrive.trip.TripServiceImp;
import pl.pojechali.offdrive.user.User;
import pl.pojechali.offdrive.user.UserServiceImpl;

import javax.persistence.NonUniqueResultException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Data
@Service
@Transactional
public class RouteServiceImpl implements RouteService {
    private final TripServiceImp tripService;
    private final RouteRepository routeRepository;
    private final UserServiceImpl userService;

    /**
     * save Route from exist Trip
     * sprawdzenie czy route juz istnieje po nazwie i wpisie w trip.route_id
     *
     * @param trip
     * @return
     */
    @Override
    public Route saveRouteFromTrip(Trip trip) throws RouteAlreadyExistException {
        if (trip == null) {
            throw new NullPointerException(" Can't created Route Trip is null ");
        }
        if (checkAlreadyExistRoutFromTrip(trip)) {
            throw new RouteAlreadyExistException(" Route already exist! Can't save the same. ");
        }
        Route route = new Route();
        List<Trip> tripList = new ArrayList<>(); // doda parametry date i time
        tripList.add(trip);
        route.setCratedDate(LocalDate.now());
        route.setCreatedTime(LocalTime.now());
        route.setLength(trip.getLength());
        route.setPublicDate(LocalDateTime.now());
        route.setName(generateRouteName(trip));
        route.setUser(userService.getCurrentLoginUser());
        route.setRouteAltitude(trip.getTripAltitude());
        route.setTrips(tripList);
        route.setDescription(trip.getDescription());
        routeRepository.saveAndFlush(route);
        return route;
    }

    /**
     * Uprade Trip.Route_id on new saved Route
     * <p>
     * If you wont save route From Trip this is final method!
     *
     * @param trip
     * @throws RouteAlreadyExistException
     */
    public void saveRouteFromTripWithUpdateTrip(Trip trip) throws RouteAlreadyExistException {
        tripService.updateRouteIdInTrip(trip, saveRouteFromTrip(trip));
    }

    private String generateRouteName(Trip trip) {
        return trip.getName().concat(" by " + trip.getUser().getNickName());
    }

    private Boolean checkAlreadyExistRoutFromTrip(Trip trip) {
        if (!routeRepository.findAllByName(generateRouteName(trip)).isEmpty()) {
            return true;
        }
        if (trip.getRoute() != null) {
            return true;
        }
        return false;
    }

    @Override
    public void saveRouteFromFile() {

    }

    @Override
    public List<Route> findRoutesByName(String name) {

        return routeRepository.findAllByNameContains(name);
    }

    @Override
    public List<Route> findRoutesByCoordinates() {
        return null;
    }

    @Override
    public List<Route> findUserRouteList() {
        return routeRepository.findAllByUserId(userService.getCurrentLoginUser().getId());

    }
    public Map<Long, String> findAllIdNickNameMap(){
        return userService.findAllIdNickNameMap();
    }

    @Override
    public List<Route> findRouteListByUserId(Long id) {
        return routeRepository.findAllByUserId(id);
    }


    @Override
    public List<Route> findRouteListByUser(String name) {
        Map<Long, String> map = userService.findUserByNickname(name);
        if (map.size()<=1) {
            return routeRepository.findAllByUserId(getKey(map,name));
        }

        return null;
    }

    public static <K, V> K getKey(Map<K, V> map, V value) {
        return map.entrySet()
                .stream()
                .filter(entry -> value.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst().get();
    }
}
