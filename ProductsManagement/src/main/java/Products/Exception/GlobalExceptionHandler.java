package Products.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
    @ExceptionHandler({OfferNotValidException.class, ProductNotFoundException.class})
    ResponseEntity<?> offerNotValidHandler(Exception exc, ServletWebRequest request) {

        APIError apiError = new APIError();

        apiError.setTimeStamp(LocalDateTime.now());
        apiError.setPathUri(request.getDescription(true));
        apiError.setStatus(HttpStatus.BAD_REQUEST);
        apiError.setErrors(Arrays.asList(exc.getMessage()));

        return new ResponseEntity(apiError, new HttpHeaders(), apiError.getStatus());
    }
}
