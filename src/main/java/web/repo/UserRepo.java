package web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import web.models.User;

public interface UserRepo extends JpaRepository<User, Integer> {
}
