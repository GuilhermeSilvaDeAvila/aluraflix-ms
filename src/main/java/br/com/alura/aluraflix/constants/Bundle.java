package br.com.alura.aluraflix.constants;

import lombok.Getter;
public enum Bundle {

    VIDEO_NOT_FOUND("video nao encontrado");

    @Getter
    private String message;

    Bundle(String message){
        this.message = message;
    }
}
