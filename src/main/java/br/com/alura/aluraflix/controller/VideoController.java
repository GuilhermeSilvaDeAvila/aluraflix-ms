package br.com.alura.aluraflix.controller;

import br.com.alura.aluraflix.model.Video;
import br.com.alura.aluraflix.model.VideoDTO;
import br.com.alura.aluraflix.service.VideoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/video")
public class VideoController {

    private VideoService videoService;

    @PostMapping
    public ResponseEntity<VideoDTO> createVideo(@Valid @RequestBody VideoDTO videoDTO){
        Video video = videoService.create(videoDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(VideoDTO.from(video));
    }

    @GetMapping
    public ResponseEntity<List<VideoDTO>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(VideoDTO.from(videoService.getAll()));
    }

    @GetMapping("/{videoId}")
    public ResponseEntity<VideoDTO> getById(@PathVariable Long videoId){

        return ResponseEntity.status(HttpStatus.OK).body(VideoDTO.from(videoService.getById(videoId)));
    }


    @DeleteMapping("/{videoId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long videoId){

        videoService.delete(videoId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{videoId}")
    public ResponseEntity<VideoDTO> update(@PathVariable Long videoId, @Valid @RequestBody VideoDTO videoDTO){

        return ResponseEntity.status(HttpStatus.OK).body(VideoDTO.from(videoService.update(videoId, videoDTO)));
    }
}
