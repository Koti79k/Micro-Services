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
	
	@Autowired
	private PasswordService pService;
	
	public User registerUser(User user) {
        user.setInsertDate(new Date());
        user.setId(UUID.randomUUID().toString());

        user.setPassword(pService.securePassword(user.getPassword()));
        User savedUser = uRepo.save(user);

        savedUser.setPassword("******");
        return savedUser;
	}
	
}


