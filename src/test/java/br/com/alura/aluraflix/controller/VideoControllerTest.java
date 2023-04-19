package br.com.alura.aluraflix.controller;

import br.com.alura.aluraflix.model.Video;
import br.com.alura.aluraflix.model.VideoDTO;
import br.com.alura.aluraflix.service.VideoService;
import br.com.alura.aluraflix.util.Builder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VideoControllerTest {

    @InjectMocks
    private VideoController controller;

    @Mock
    private VideoService service;

    private Video video;
    private VideoDTO videoDTO;
    private List<Video> videoList;

    @BeforeEach
    public void init(){
        this.video = Builder.video();
        this.videoDTO = Builder.videoDTO();
        this.videoList = Builder.listVideo();
    }

    @Test
    void testRegisterVideo(){
        when(service.create(any(VideoDTO.class))).thenReturn(video);

        ResponseEntity<VideoDTO> response = controller.createVideo(videoDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testGetAllVideo(){
        when(service.getAll()).thenReturn(videoList);

        ResponseEntity<List<VideoDTO>> response = controller.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testGetByIdVideo(){
        when(service.getById(anyLong())).thenReturn(video);

        ResponseEntity<VideoDTO> response = controller.getById(video.getId());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testDeleteVideo(){
        doNothing().when(service).delete(anyLong());

        ResponseEntity<Void> response = controller.deleteById(video.getId());

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void testUpdateVideo(){
        video.setTitle("titulo video - atualizado");

        when(service.update(anyLong(), any(VideoDTO.class))).thenReturn(video);

        ResponseEntity<VideoDTO> response = controller.update(video.getId(), videoDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}