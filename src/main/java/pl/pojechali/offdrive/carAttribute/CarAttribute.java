package pl.pojechali.offdrive.carAttribute;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = CarAttribute.TABLE)
@Getter
@Setter
@RequiredArgsConstructor
public class CarAttribute {
    public final static String TABLE = "t_car_attribute";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tireSize;
    private int weight;
    private int lift;
    private boolean hasWinch;
    private boolean hasSandLadder;
}
