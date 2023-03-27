package User.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import User.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
	User findByEmail(String email);
}
