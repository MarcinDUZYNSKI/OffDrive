package pl.pojechali.offdrive.trip;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.pojechali.offdrive.tripCondition.TripCondition;

@Getter
@Setter
@RequiredArgsConstructor
public class TripWithTripCondition {
    private Trip trip;
    private TripCondition tripCondition;
}
