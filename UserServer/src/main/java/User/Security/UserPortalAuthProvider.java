package User.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import User.Exception.UserNotFoundException;
import User.Model.User;
import User.Repositery.UserRepo;
import User.Service.PasswordService;

@Component
public class UserPortalAuthProvider implements AuthenticationProvider{
	
	@Autowired
    private PasswordService passwordService;

	@Autowired
    private UserRepo userRepository;

	//added unimplemented methods
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username=authentication.getName();
		User user=userRepository.findByEmail(username);
		 if(user == null){
	            throw new UserNotFoundException("User not found with email - " + username);
	      }
		 if(passwordService.validatePassword(user.getPassword(), authentication.getCredentials().toString())) {
			 return new UsernamePasswordAuthenticationToken(username, authentication.getCredentials(),null);
		 }
		throw new BadCredentialsException("Login Failed...");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	

}
