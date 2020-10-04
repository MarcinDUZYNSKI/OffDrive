package pl.pojechali.offdrive.route;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public interface RouteRepository extends JpaRepository<Route, Long> {

    List<Route> findAllByNameContains(String nameSentence);

    List<Route> findAllByUserId(long id);

    List<Route> findAllByName(String routeName);

}
