package com.example.quickstream.services;

import com.example.quickstream.domain.Video;
import com.example.quickstream.exceptions.VideoAlreadyExistsException;
import com.example.quickstream.exceptions.VideoNotFoundException;
import com.example.quickstream.repo.VideoRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {
    private VideoRepo repo;

    @Override
    public Video getVideo(String name) {
        if(!repo.existsByName(name)){
            throw new VideoNotFoundException();
        }
        return repo.findByName(name);
    }

    @Override
    public List<String> getAllVideoNames() {
        return repo.getAllEntryNames();
    }

    @Override
    public void saveVideo(byte[] data, String name) throws IOException {
        if (repo.existsByName(name)){
            throw new VideoAlreadyExistsException();
        }

        // create video object and save data to db
        Video newVid = new Video(name, data);
        repo.save(newVid);
    }
}
