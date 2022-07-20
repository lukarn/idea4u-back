package pl.idea4u.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class IdeaNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(IdeaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ideaNotFoundHandler(IdeaNotFoundException ex) {
        return ex.getMessage();
    }

}
