package br.com.alura.aluraflix.handler;

import br.com.alura.aluraflix.config.Handler;
import br.com.alura.aluraflix.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HandlerTest {

    @InjectMocks
    private Handler handler;

    @Mock
    private WebRequest request;

    @Test
    void testHandlerNotFoundException(){
        ResponseEntity<Object> response = handler.handlerNotFoundException(new NotFoundException(), request);

        assertNotNull(response);
    }
}