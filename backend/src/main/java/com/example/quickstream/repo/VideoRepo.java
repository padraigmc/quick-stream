package com.example.quickstream.repo;

import com.example.quickstream.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path="video", collectionResourceRel="videos")
public interface VideoRepo extends JpaRepository<Video, Long> {
}
