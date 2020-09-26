package pl.pojechali.offdrive.route;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository <Route, Long> {

    List<Route> findAllByNameLike(String nameSentence);
}
