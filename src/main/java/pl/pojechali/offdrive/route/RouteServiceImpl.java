package pl.pojechali.offdrive.route;

import lombok.Data;
import org.springframework.stereotype.Service;
import pl.pojechali.offdrive.exception.RouteAlreadyExistException;
import pl.pojechali.offdrive.trip.Trip;
import pl.pojechali.offdrive.trip.TripServiceImp;
import pl.pojechali.offdrive.user.User;
import pl.pojechali.offdrive.user.UserServiceImpl;

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
    public Route createRouteFromTrip(Trip trip) throws RouteAlreadyExistException {
        if (trip == null) {
            throw new NullPointerException(" Can't created Route -> Trip is null ");
        }
        if (checkAlreadyExistRoutFromTrip(trip)) {
            throw new RouteAlreadyExistException(" Route already exist! Can't save the same. ");
        }
        Route route = new Route();
        List<Trip> tripList = new ArrayList<>(); // dodać parametry date i time
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
    public void createRouteFromTripWithUpdateTrip(Trip trip) throws RouteAlreadyExistException {
        tripService.updateRouteIdInTrip(trip, createRouteFromTrip(trip));
    }

    private String generateRouteName(Trip trip) {
        return trip.getName().concat(" by " + trip.getUser().getNickName());
    }

    private Boolean checkAlreadyExistRoutFromTrip(Trip trip) {
        if (!routeRepository.findAllByName(generateRouteName(trip)).isEmpty()) {
            return true;
        }
        return trip.getRoute() != null;
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

    /**
     * @return HashMap users who has route
     * * key = user.id
     * * value = user.nickName
     */
    public Map<Long, String> findAllIdNickNameMapWithRouts() {
        Map<Long, String> findAllIdNickNameMapFromRoute = new HashMap<>();
        for (Long l : getUniqueUserIdWhoHasRoute()) {
            findAllIdNickNameMapFromRoute.put(l, userService.findUserById(l).getNickName());
        }
        return findAllIdNickNameMapFromRoute;
    }

    /**
     * @return HashSet of User.id
     * user.id is on Set only one time
     */
    private HashSet<Long> getUniqueUserIdWhoHasRoute() {
        List<Route> routeList = routeRepository.findAll();
        HashSet<Long> userIdFromRoute = new HashSet<>();
        for (Route r : routeList) {
            if (r.getUser() != null) {
                userIdFromRoute.add(r.getUser().getId());
            }
        }
        return userIdFromRoute;
    }

    /**
     * @param id
     * @return list Routs of user who's get Id
     * method return empty list when will be error
     */
    @Override
    public List<Route> findRouteListByUserId(Long id) {
        if (id != null) {
            return routeRepository.findAllByUserId(id);
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Route findRouteById(Long id) {
        if (id != null) {
            return routeRepository.findById(id).orElseThrow(NullPointerException::new);
        } else {
            throw new NullPointerException(" can't find Route by null ");
        }

    }

    @Override
    public void updateRoute(Route route) {
        if (route == null) {
            throw new NullPointerException(" Route to update is null ");
        }
        Route routeToUpdate = routeRepository.findById(route.getId()).orElseThrow(NullPointerException::new); // TODO lepij włąsny wyjątk notfoundElemnt
        routeToUpdate.setName(route.getName());
        routeToUpdate.setLength(route.getLength());
        routeToUpdate.setRouteAltitude(route.getRouteAltitude());
        routeToUpdate.setDescription(route.getDescription());
        routeRepository.save(routeToUpdate);
    }

    @Override
    public void deleteRoute(Route route) {
        if (route == null) {
            throw new NullPointerException(" Route to delete is null ");
        }
        for (Trip t : route.getTrips()) {
            t.setRoute(null);
        }
        routeRepository.delete(route); // do analizy biznesowej możliwość pozostawienia w bazie route
    }

    @Override
    public List<Route> findAllRouteList() {
        return routeRepository.findAll();
    }

    @Override
    public List<Route> findRouteListByUser(String name) {
        if (name != null) {
            User userByEmail = userService.findUserByEmail(name);
            return routeRepository.findAllByUserId(userByEmail.getId());
        } else {
            return new ArrayList<>();
        }
    }

    public long getCurrentLoginUserId() {
        return userService.getCurrentLoginUser().getId();
    }
//
//    public static <K, V> K getKey(Map<K, V> map, V value) {
//        return map.entrySet()
//                .stream()
//                .filter(entry -> value.equals(entry.getValue()))
//                .map(Map.Entry::getKey)
//                .findFirst().get();
//    }
}
