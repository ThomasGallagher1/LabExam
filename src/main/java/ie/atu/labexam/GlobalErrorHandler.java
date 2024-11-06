package ie.atu.labexam;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> showErrors(MethodArgumentNotValidException ex){
        Map<String, String> errorList = new HashMap<>();
        Map<String, Object> errorResponse = new HashMap<>();
        for(FieldError error : ex.getFieldErrors()){
            String err_name = error.getField();
            String err_message = error.getDefaultMessage();
            errorList.put(err_name, err_message);
    }
        errorResponse.put("TimeStamp", LocalDateTime.now());
        errorResponse.put("Errors", errorList);

        return ResponseEntity.status(400).body(errorResponse);
    }
}
