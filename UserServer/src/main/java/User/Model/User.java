package User.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "users")
public class User {

    @Id
    private String id;
    
    @NotBlank
    private String name;
    
    @Pattern(regexp = "^([a-zA-Z0-9_-]{4,20})@([a-zA-Z]{3,6})\\.([a-zA-Z]{2,5})$", message = "Please enter valid email.")
    private String email;
    
    @Pattern(regexp = "^([+]\\d{2})?\\d{10}$", message = "Please enter valid mobile number.")
    private String mobile;
    
    @Pattern(regexp = "^(?=.*\\d).{4,12}$", message = "Please enter valid password.")
    private String password;
    
    private Date insertDate;
    
    private Date expireDate;
    
    @AssertTrue(message = "(email or mobile) is mandatory field.")
    private boolean isValid(){
        return this.email !=null || this.mobile !=null;
    }
}
