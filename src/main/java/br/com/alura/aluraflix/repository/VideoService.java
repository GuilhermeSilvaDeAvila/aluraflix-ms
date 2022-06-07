package br.com.alura.aluraflix.repository;

import br.com.alura.aluraflix.exception.VideoNotFoundException;
import br.com.alura.aluraflix.mapper.VideoMapper;
import br.com.alura.aluraflix.model.Video;
import br.com.alura.aluraflix.model.VideoDTO;
import br.com.alura.aluraflix.service.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class VideoService {

    private VideoRepository videoRepository;
    private VideoMapper mapper;

    public Video create(VideoDTO videoDTO) {
        return videoRepository.save(mapper.toEntity(videoDTO));
    }

    public Video getById(Long videoId) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new VideoNotFoundException());

        return video;
    }

    public List<Video> getAll() {
        return videoRepository.findAll();
    }

    @Transactional
    public void delete(Long videoId) {
        videoRepository.deleteById(videoId);
    }
    public Video update(Long videoId, VideoDTO videoDTO) {

        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new VideoNotFoundException());

        videoDTO.setTitle(videoDTO.getTitle());
        video.setDescription(videoDTO.getDescription());
        video.setUrl(videoDTO.getUrl());

        return videoRepository.save(video);
    }
}
