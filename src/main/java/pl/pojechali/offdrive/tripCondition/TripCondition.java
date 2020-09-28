package pl.pojechali.offdrive.tripCondition;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.pojechali.offdrive.trip.Trip;

import javax.persistence.*;

@Entity
@Table(name = TripCondition.TABLE)
@Getter
@Setter
@RequiredArgsConstructor
public class TripCondition {
    public final static String TABLE = "t_trip_condition";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String landscape;
    private String mainGround;
    private String waterLevel;
    private String mud;
    private Boolean waterCrossing;
    private String weather;
    private Boolean useWinch;
    private Boolean useSandLadder;
    private Integer temperature;
    @OneToOne
    private Trip trip;



}
