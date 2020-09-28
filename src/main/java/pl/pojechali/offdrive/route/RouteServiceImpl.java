package pl.pojechali.offdrive.route;

import lombok.Data;
import org.springframework.stereotype.Service;
import pl.pojechali.offdrive.exception.RouteAlreadyExistException;
import pl.pojechali.offdrive.trip.Trip;
import pl.pojechali.offdrive.trip.TripServiceImp;
import pl.pojechali.offdrive.user.UserServiceImpl;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
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
    public void saveRouteFromTrip(Trip trip) throws RouteAlreadyExistException {
        if (trip == null){
           throw new  NullPointerException (" Can't created Route Trip is null ");
        }
        if (checkAlreadyExistRoutFromTrip(trip)){
            throw new RouteAlreadyExistException(" Route already exist! Can't save the same. ");
        }
        Route route = new Route();
        List<Trip> tripList = new ArrayList<>();
        tripList.add(trip);
        route.setLength(trip.getLength());
        route.setPublicDate(LocalDateTime.now());
        route.setName(trip.getName().concat(" by " + trip.getUser().getNickName()));
        route.setUser(userService.getCurrentLoginUser());
        route.setRouteAltitude(trip.getTripAltitude());
//        route.setTripCount(1); // dodatkowo update na tripa.route_id
        route.setTrips(tripList);
        route.setDescription(trip.getDescription());
        routeRepository.save(route);
    }

    private String generateRouteName(Trip trip){
        return trip.getName().concat(" by " + trip.getUser().getNickName());
    }

    private Boolean checkAlreadyExistRoutFromTrip(Trip trip){
        if(!routeRepository.findAllByName(generateRouteName(trip)).isEmpty()){
            return true;
        }
        if(trip.getRoute() != null){
            return true;
        }
        return false;
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

    @Override
    public List<Route> findUserRouteList() {
        return routeRepository.findAllByUserId(userService.getCurrentLoginUser().getId());

    }

    @Override
    public List<Route> findRouteListByUserId(long id) {
        return routeRepository.findAllByUserId(id);
    }
}
