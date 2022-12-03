package com.example.quickstream.services;

import com.example.quickstream.contentstore.VideoContentStore;
import com.example.quickstream.domain.Video;
import com.example.quickstream.exceptions.VideoNotFoundException;
import com.example.quickstream.repo.VideoRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.data.domain.Pageable;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {
    @Autowired private VideoRepo repo;
    @Autowired private VideoContentStore contentStore;

    @Override
    public byte[] getVideoContent(Long id) throws IOException {
        Optional<Video> video = repo.findById(id);
        if (video.isEmpty()) { throw new VideoNotFoundException(); }

        InputStream videoInputStream = contentStore.getContent(video.get());
        if (videoInputStream == null) { throw new VideoNotFoundException(); }

        return videoInputStream.readAllBytes();
    }

    @Override
    public Page<Video> getVideos(Pageable paging) {
        return repo.findAll(paging);
    }

    @Override
    public void saveVideo(MultipartFile file, String name) throws IOException {
        // create video object
        Video newVideo = repo.save(new Video(name));

        // save video file against created video object in content store
        contentStore.setContent(newVideo, file.getInputStream());

        // create database entry in video repository
        repo.save(newVideo);
    }
}
