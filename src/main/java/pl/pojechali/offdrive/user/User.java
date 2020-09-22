package pl.pojechali.offdrive.user;

import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.pojechali.offdrive.route.Route;
import pl.pojechali.offdrive.trip.Trip;
import pl.pojechali.offdrive.user.role.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @NotBlank(message = "Please provide an email")
    @Email(message = "Please provide a valid Email")
    @Column(unique = true)
//    @UniqueElements //to działa na kolekci tu trzeba stworzyć włąsny walidator
    private String email;
    @NotBlank(message = "Please provide first name")
    private String firstName;
    @NotBlank(message = "Please provide last name")
    private String lastName;
    @NotBlank(message = "Please provide password")
    @Size(min = 8, max = 100)
    private String password;
    private String nickName;
    @Column(nullable = false, updatable = false)
    private LocalDateTime creationDate;
    private String language;
    private LocalDateTime lastActivityDate;
    @OneToMany(mappedBy = "user")
    private List<Trip> trips;
    @OneToMany(mappedBy = "user")
    private List<Route> routes;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = ROLETABLE)
    private Set<Role> roles;
    private int enabled;

}
