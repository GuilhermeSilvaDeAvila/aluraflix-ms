package br.com.alura.aluraflix.repository;

import br.com.alura.aluraflix.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
    Optional<Video> findById(Long videoId);

    void deleteById(Long videoId);
}
