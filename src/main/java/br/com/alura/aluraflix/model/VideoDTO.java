package br.com.alura.aluraflix.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class VideoDTO {

    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String url;

    public static VideoDTO from(Video video) {
        return VideoDTO.builder()
                .title(video.getTitle())
                .description(video.getDescription())
                .url(video.getUrl())
                .build();
    }

    public static List<VideoDTO> from(List<Video> videos) {
        return videos.stream().map(VideoDTO::from).collect(Collectors.toList());
    }
}
