package com.example.quickstream.services;

import com.example.quickstream.domain.Video;

import java.io.IOException;
import java.util.List;

public interface VideoService {
    Video getVideo(Long id);

    void saveVideo(byte[] file, String name) throws IOException;

    List<String> getAllVideoNames();
}
