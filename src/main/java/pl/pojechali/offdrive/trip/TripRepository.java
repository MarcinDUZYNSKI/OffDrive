package pl.pojechali.offdrive.trip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findAllByUserId(long id);
}
