package pl.pojechali.offdrive.route;

import lombok.Data;
import org.springframework.stereotype.Service;
import pl.pojechali.offdrive.trip.Trip;
import pl.pojechali.offdrive.trip.TripServiceImp;
import pl.pojechali.offdrive.user.UserServiceImpl;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Service
@Transactional
public class RouteServiceImpl implements RouteService{
    private final TripServiceImp tripService;
    private final RouteRepository routeRepository;
    private final UserServiceImpl userService;

    /**
     * save Route from exist Trip
     * @param trip
     */
    @Override
    public void saveRouteFromTrip(Trip trip) {
        if (trip == null){
            NullPointerException tripNPE;
        }
        Route route = new Route();
        List<Trip> tripList = new ArrayList<>();
        tripList.add(trip);
        route.setLength(trip.getLength());
        route.setPublicDate(LocalDateTime.now());
        route.setName(trip.getName().concat(" by " + trip.getUser().getNickName()));
        route.setUser(userService.getCurrentLoginUser());
        route.setRouteAltitude(trip.getTripAltitude());
        route.setTripCount(1);
        route.setTrips(tripList);
        route.setDescription(trip.getDescription());
        routeRepository.save(route);
    }

    @Override
    public void saveRouteFromFile() {

    }

    @Override
    public List<Route> findRoutesByName(String name) {
        return routeRepository.findAllByNameLike(name);
    }

    @Override
    public List<Route> findRoutesByCoordinates() {
        return null;
    }
}
