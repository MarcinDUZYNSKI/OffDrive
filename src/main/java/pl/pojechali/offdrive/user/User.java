package pl.pojechali.offdrive.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = User.TABLE)
@Getter
@Setter
@RequiredArgsConstructor
public class User {
    public final static String TABLE ="t_user";
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


}
