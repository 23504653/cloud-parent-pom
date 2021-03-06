package cc.coopersoft.authentication.dto;

import cc.coopersoft.authentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameOrEmailOrPhone(String userName, String email, String phone);

    boolean existsByUsernameOrPhone(String userName, String phone);

//    List<User> findAllBy

}