package pl.pojechali.offdrive.route;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RouteRepository extends JpaRepository <Route, Long> {

    List<Route> findAllByNameLike(String nameSentence);
}
