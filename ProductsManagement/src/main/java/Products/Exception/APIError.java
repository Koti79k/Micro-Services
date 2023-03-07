package Products.Exception;

import java.util.List;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class APIError {
    private HttpStatus status;
    private List<String> errors;
    private LocalDateTime timeStamp;
    private String pathUri;
}
