package br.com.alura.aluraflix.util;

import br.com.alura.aluraflix.model.Video;
import br.com.alura.aluraflix.model.VideoDTO;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    private static final Long ID = 1L;
    private static final String TITLE = "titulo video";
    private static final String DESCRIPTION = "descricao";
    private static final String URL = "www.teste.com";

    public static Video video() {
        return Video.builder().id(ID).title(TITLE).description(DESCRIPTION).url(URL).build();
    }

    public static VideoDTO videoDTO() {
        return VideoDTO.from(video());
    }


    public static List<Video> listVideo(){
        List<Video> videoList = new ArrayList<>();

        for(int i = 0; i <= 9; i++){
            videoList.add(video());
        }

        return videoList;
    }

    public static List<VideoDTO> listVideoDTO(){
        List<VideoDTO> videoDTOList = new ArrayList<>();

        for(int i = 0; i <= 9; i++){
            videoDTOList.add(videoDTO());
        }

        return videoDTOList;
    }

}
