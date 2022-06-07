package br.com.alura.aluraflix.mapper;


import br.com.alura.aluraflix.model.Video;
import br.com.alura.aluraflix.model.VideoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VideoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public VideoDTO toDTO(Video video){
        return modelMapper.map(video, VideoDTO.class);
    }

    public Video toEntity(VideoDTO videoDTO){
        return modelMapper.map(videoDTO, Video.class);
    }

    public List<VideoDTO> toCollection(List<Video> video){
        return video.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
