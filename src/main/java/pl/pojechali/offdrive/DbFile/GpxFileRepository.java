package pl.pojechali.offdrive.DbFile;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface GpxFileRepository extends JpaRepository<GpxFile, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = "data")
    GpxFile findWithDataById(Long id);
//    void save(GpxFile gpxFile);
}
