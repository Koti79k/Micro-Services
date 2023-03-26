package User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import User.Model.User;
import User.Service.UserService;
import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserService uService;
	
    @PostMapping("/user/register")
    public User registerUser(@Valid @RequestBody User user){

        return uService.registerUser(user);

    }
}
