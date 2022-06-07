package br.com.alura.aluraflix.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class MessageError {
    private Integer status;
    private List<String> message = new ArrayList<>();

    public MessageError() {
    }

    public MessageError(Integer status, List<String> message) {
        this.status = status;
        this.message = message;
    }
}