package pl.pojechali.offdrive.route;

//import io.jenetics.jpx.GPX;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.pojechali.offdrive.trip.Trip;
import pl.pojechali.offdrive.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = Route.TABLE)
@Getter
@Setter
@RequiredArgsConstructor
public class Route {
    public static final String TABLE = "t_route";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    @NotNull
    private Integer length;
    // przez ciekawość jaka tu powinna być prawidłowa adnotacja  dla validacji ???
    private LocalDateTime publicDate;
    private LocalDate cratedDate;
    private LocalTime createdTime;
    //https://github.com/jenetics/jpx    biblioteka do tras   rozwojowo do wykorzystania i połączenia z GpxFile
//    private GPX rout;
//    @NotNull
    private Integer routeAltitude;
//    private Integer tripCount;  // do usunięcia
    @Column(columnDefinition = "text", length = 3000) // jak zrobić żeby to pole w banie miało tą długość???
    private String description;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "route")
    private List<Trip> trips;
}
