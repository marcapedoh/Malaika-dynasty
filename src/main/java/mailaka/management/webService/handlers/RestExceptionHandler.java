package mailaka.management.webService.handlers;


import mailaka.management.webService.exception.EntityNotFoundException;
import mailaka.management.webService.exception.InvalidEntityException;
import mailaka.management.webService.exception.InvalidOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDAO> handleExcpetion(EntityNotFoundException exception, WebRequest webRequest){
        final HttpStatus notfound=HttpStatus.NOT_FOUND;
        final ErrorDAO errorDTO=ErrorDAO.builder()
                .codes(exception.getErrorcodes())
                .httpCode(notfound.value())
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(errorDTO,notfound);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDAO> handleException(InvalidEntityException exception, WebRequest request){
        final HttpStatus badRequest=HttpStatus.BAD_REQUEST;

        final ErrorDAO errorDTO= ErrorDAO.builder()
                .codes(exception.getErrorCodes())
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .error(exception.getError())
                .build();
        return new  ResponseEntity<>(errorDTO,badRequest);
    }
    @ExceptionHandler(InvalidOperationException.class)
    public ResponseEntity<ErrorDAO> handleException(InvalidOperationException exception, WebRequest request){
        final HttpStatus badRequest=HttpStatus.CONFLICT;

        final ErrorDAO errorDTO= ErrorDAO.builder()
                .codes(exception.getErrorCodes())
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .error(exception.getError())
                .build();
        return new  ResponseEntity<>(errorDTO,badRequest);
    }

}
