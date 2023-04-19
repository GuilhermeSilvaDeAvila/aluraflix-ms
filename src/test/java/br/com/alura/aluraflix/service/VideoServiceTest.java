package br.com.alura.aluraflix.service;

import br.com.alura.aluraflix.exception.NotFoundException;
import br.com.alura.aluraflix.model.Video;
import br.com.alura.aluraflix.model.VideoDTO;
import br.com.alura.aluraflix.repository.VideoRepository;
import br.com.alura.aluraflix.util.Builder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VideoServiceTest {

    @InjectMocks
    private VideoService service;

    @Mock
    private VideoRepository repository;

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
    void testCreateVideo(){
        when(repository.save(any(Video.class))).thenAnswer(i -> i.getArgument(0));

        Video response = service.create(videoDTO);

        assertNotNull(response);
        verify(repository, times(1)).save(any(Video.class));
    }

    @Test
    void testGetVideoById(){
        when(repository.findById(anyLong())).thenReturn(Optional.of(video));

        Video response = service.getById(video.getId());

        assertNotNull(response);
        verify(repository, times(1)).findById(anyLong());
    }


    @Test
    void testGetVideoByIdWhenNotFound(){
        when(repository.findById(anyLong())).thenThrow(NotFoundException.class);

        assertThrows(NotFoundException.class, () ->  service.getById(video.getId()));
    }

    @Test
    void testGetAllVideo(){
        when(repository.findAll()).thenReturn(videoList);

        List<Video> response = service.getAll();

        assertNotNull(response);
        verify(repository, times(1)).findAll();
    }

    @Test
    void testDeleteVideoById(){
        doNothing().when(repository).deleteById(anyLong());

        service.delete(video.getId());

        verify(repository, times(1)).deleteById(anyLong());
    }

    @Test
    void testUpdateVideo(){
        videoDTO.setTitle("titulo video - atualizado");
        when(repository.save(any(Video.class))).thenAnswer(i -> i.getArgument(0));
        when(repository.findById(anyLong())).thenReturn(Optional.of(video));

        Video response = service.update(video.getId(), videoDTO);

        assertNotNull(response);
        assertEquals(videoDTO.getTitle(), response.getTitle());
        verify(repository, times(1)).findById(anyLong());
        verify(repository, times(1)).save(any(Video.class));
    }

}