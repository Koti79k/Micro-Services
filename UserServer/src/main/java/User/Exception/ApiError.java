package User.Exception;
import org.springframework.http.HttpStatus;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ApiError {
    private HttpStatus status;
    private List<String> errors;
    private LocalDateTime timestamp;
    private String path;
}
