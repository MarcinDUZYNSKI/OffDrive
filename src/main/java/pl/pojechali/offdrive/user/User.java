package pl.pojechali.offdrive.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;
import pl.pojechali.offdrive.route.Route;
import pl.pojechali.offdrive.trip.Trip;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = User.TABLE)
@Getter
@Setter
@RequiredArgsConstructor
public class User {
    public final static String TABLE ="t_user";
    private final static String ROLETABLE ="t_user_role";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Email
    @UniqueElements
    private String email;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String password;
    private String nickName;
    private LocalDate creationDate;
    private String language;
    private LocalDate lastActivityDate;
    @OneToMany(mappedBy = "user")
    private List<Trip> trips;
    @OneToMany(mappedBy = "user")
    private List<Route> routes;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = ROLETABLE)
    private Set<Role> roles;
    private int enabled;

}
