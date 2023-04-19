package br.com.alura.aluraflix.service;

import br.com.alura.aluraflix.constants.Bundle;
import br.com.alura.aluraflix.exception.NotFoundException;
import br.com.alura.aluraflix.model.Video;
import br.com.alura.aluraflix.model.VideoDTO;
import br.com.alura.aluraflix.repository.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class VideoService {

    private VideoRepository videoRepository;

    public Video create(VideoDTO videoDTO) {
        return videoRepository.save(Video.from(videoDTO));
    }

    public Video getById(Long videoId) {
        return videoRepository.findById(videoId)
                .orElseThrow(() -> new NotFoundException(Bundle.VIDEO_NOT_FOUND.getMessage()));
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
                .orElseThrow(() -> new NotFoundException(Bundle.VIDEO_NOT_FOUND.getMessage()));

        return videoRepository.save(Video.update(video, videoDTO));
    }
}
