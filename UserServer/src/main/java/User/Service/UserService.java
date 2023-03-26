package User.Service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import User.Model.User;
import User.Repositery.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo uRepo;
	
	public User registerUser(User user) {
        user.setInsertDate(new Date());
        user.setId(UUID.randomUUID().toString());

        user.setPassword(securePassword(user.getPassword()));
        User savedUser = uRepo.save(user);

        return savedUser;
	}
	
    private String securePassword(String password) {
        return null;
    }
}


