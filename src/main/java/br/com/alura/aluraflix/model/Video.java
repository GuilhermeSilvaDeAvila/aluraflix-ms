package br.com.alura.aluraflix.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Builder
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;

    private String description;

    private String url;

    public static Video from(VideoDTO videoDTO) {
        return Video.builder()
                .title(videoDTO.getTitle())
                .description(videoDTO.getDescription())
                .url(videoDTO.getUrl()).build();
    }

    public static Video update(Video video, VideoDTO videoDTO) {
        return Video.builder()
                .id(video.getId())
                .title(videoDTO.getTitle())
                .description(videoDTO.getDescription())
                .url(videoDTO.getUrl()).build();
    }
}
