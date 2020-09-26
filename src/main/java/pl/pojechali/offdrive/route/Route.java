package pl.pojechali.offdrive.route;

//import io.jenetics.jpx.GPX;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.pojechali.offdrive.trip.Trip;
import pl.pojechali.offdrive.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @NotBlank
    private int length;
    @NotBlank
    private LocalDateTime publicDate;
    //https://github.com/jenetics/jpx    biblioteka do tras
//    private GPX rout;
    @NotBlank
    private int routeAltitude;
    private int tripCount;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "route")
    private List<Trip> trips;
}
