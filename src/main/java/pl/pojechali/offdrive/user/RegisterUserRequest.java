package pl.pojechali.offdrive.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//z zajęć nie do projektu
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {
private String email;
private  String password;

}
