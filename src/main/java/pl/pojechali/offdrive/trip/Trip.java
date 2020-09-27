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
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
    @NotBlank(message = "Please provide name")  //nie działa walidacja wyświetla 500
    private String name;
    private LocalDate createdDate;
    private LocalTime createdTime;
    private LocalDateTime tripDate;
    @NotNull(message = "Please provide trip time")
    private int tripTime;
    @NotNull(message = "Please provide trip length")
    private int length;
    private int tripAltitude;
    @Column(columnDefinition = "text", length = 3000)
    private String description;
    @ManyToOne
    private User user;
    @ManyToOne
    private Route route;
    @OneToOne(mappedBy = "trip")   //jeden Trip posiada jedne warunki (nie posiada wiele warónków)
    private TripCondition tripCondition;
    @OneToOne(mappedBy = "trip")   // jeden trip posiada jedenCarAttribiute bo jedzie tylko jeden sanochód na jednej wyciczce
    private CarAttribute carAttribute;

}
