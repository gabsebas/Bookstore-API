package com.group25.geektext.Repo;
import com.group25.geektext.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MySqlRepository extends JpaRepository<User,Integer>{
    Optional<User> findByUsername(String username);
}
