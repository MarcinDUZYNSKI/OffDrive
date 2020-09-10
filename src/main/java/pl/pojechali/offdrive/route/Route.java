package pl.pojechali.offdrive.route;

import io.jenetics.jpx.GPX;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

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
    private LocalDate publicDate;

    //https://github.com/jenetics/jpx    biblioteka do tras
    private GPX rout;
    @NotBlank
    private int routeAltitude;
    private int tripCount;
}
