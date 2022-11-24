package com.example.quickstream.services;

import com.example.quickstream.domain.Video;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VideoService {
    byte[] getVideoContent(Long id) throws IOException;

    void saveVideo(MultipartFile file, String name) throws IOException;

    List<Video> getAllVideos();
}
