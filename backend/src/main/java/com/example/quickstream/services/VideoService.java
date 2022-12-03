package com.example.quickstream.services;

import com.example.quickstream.domain.Video;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.data.domain.Pageable;
import java.io.IOException;
import java.util.List;

public interface VideoService {
    byte[] getVideoContent(Long id) throws IOException;

    void saveVideo(MultipartFile file, String name) throws IOException;

    Page<Video> getVideos(Pageable pageing);
}
