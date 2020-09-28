package pl.pojechali.offdrive.trip;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.pojechali.offdrive.tripCondition.TripCondition;

import javax.validation.Valid;

@Getter
@Setter
@RequiredArgsConstructor

public class TripWithTripCondition {
    @Valid
    private Trip trip;
    @Valid
    private TripCondition tripCondition;
}
