package br.com.alura.aluraflix.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class VideoDTO {

    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String url;
}
