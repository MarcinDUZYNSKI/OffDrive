package pl.pojechali.offdrive.trip;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.pojechali.offdrive.carAttribute.CarAttribute;
import pl.pojechali.offdrive.route.Route;
import pl.pojechali.offdrive.tripCondition.TripCondition;
import pl.pojechali.offdrive.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name = Trip.TABLE)
@Getter
@Setter
@RequiredArgsConstructor
public class Trip {
    public final static String TABLE = "t_trip";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    @NotBlank
    private LocalDate tripDate;
    @NotBlank
    private Time tripTime;
    @NotBlank
    private int length;
    private int tripAltitude;
    @ManyToOne
    private User user;
    @ManyToOne
    private Route route;
    @OneToOne(mappedBy = "trip")   //jeden Trip posiada jedne warunki (nie posiada wiele warónków)
    private TripCondition tripCondition;
    @OneToOne(mappedBy = "trip")   // jeden trip posiada jedenCarAttribiute bo jedzie tylko jeden sanochód na jednej wyciczce
    private CarAttribute carAttribute;

}
