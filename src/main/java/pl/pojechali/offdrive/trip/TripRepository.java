package pl.pojechali.offdrive.trip;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findAllByUserId(long id);

//    java.sql.SQLIntegrityConstraintViolationException: Cannot delete or update a parent row: a foreign key constraint
//    fails (`offdrive`.`t_trip`, CONSTRAINT `FKdyeipp948ahnlx8hn9nf1ebb0` FOREIGN KEY (`route_id`) REFERENCES `t_route` (`id`))
    @Modifying
    @Query("update Trip t set t.route=null where t.route=?1")
    default void updateRouteIdForNull(long id) {

    }
}
