package br.com.alura.aluraflix.config;

import br.com.alura.aluraflix.exception.NotFoundException;
import br.com.alura.aluraflix.model.MessageError;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestControllerAdvice
public class Handler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        MessageError response  = new MessageError();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<String> message = new ArrayList<>();

        fieldErrors.forEach(e ->{
            Integer statusError = status.value();
            String error = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            String field =  e.getField();

            message.add(field.concat(" " + error));

            response.setStatus(statusError);
            response.setMessage(message);
        });

        return handleExceptionInternal(ex, response, headers, status, request);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handlerNotFoundException(NotFoundException ex, WebRequest request){
        return handleExceptionInternal(ex, "", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
