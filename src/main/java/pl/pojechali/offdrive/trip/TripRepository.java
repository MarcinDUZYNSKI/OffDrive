package pl.pojechali.offdrive.trip;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findAllByUserId(long id);
}
