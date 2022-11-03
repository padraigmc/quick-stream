package com.example.quickstream.services;

import com.example.quickstream.domain.Video;
import com.example.quickstream.exceptions.VideoAlreadyExistsException;
import com.example.quickstream.exceptions.VideoNotFoundException;
import com.example.quickstream.repo.VideoRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
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
    public void saveVideo(MultipartFile file, String name) throws IOException {
        if(repo.existsByName(name)){
            throw new VideoAlreadyExistsException();
        }
        Video newVid = new Video(name, file.getBytes());
        repo.save(newVid);
    }
}
