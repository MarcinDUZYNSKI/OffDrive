package pl.pojechali.offdrive.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional // czy to jest na pewno dobry import
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

    long findUserByNickNameContains(String nickName);
}
