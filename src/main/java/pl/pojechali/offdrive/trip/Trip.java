package pl.pojechali.offdrive.trip;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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

}
