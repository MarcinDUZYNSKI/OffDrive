package pl.pojechali.offdrive.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@Transactional // czy to jest na pewno dobry import
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

    Set<User> findUserByNickNameContains(String nickName);

    //    List<User> findAllNickName();
    default Map<Long, String> findAllIdNickNameMap() {
        return findAll().stream().collect(Collectors.toMap(User::getId, User::getNickName));
    }
}
