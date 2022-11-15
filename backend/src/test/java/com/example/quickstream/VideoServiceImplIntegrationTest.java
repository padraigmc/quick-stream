package com.example.quickstream;

import com.example.quickstream.domain.Video;
import com.example.quickstream.repo.VideoRepo;
import com.example.quickstream.services.VideoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@Transactional
public class VideoServiceImplIntegrationTest {
    @Autowired
    VideoService service;

    @Autowired
    VideoRepo repo;

    String testName = "myVid";

    @Test
    void getVideo() {
        // create video and save to repo
        Video expected = new Video(testName, null);
        repo.save(expected);

        // query service for test video above
        Video actual = service.getVideo(testName);

        // result from service should be the test video above
        assertEquals(expected, actual);
    }

    @Test
    void saveVideo() throws IOException {
        // create video and save using the service method
        MultipartFile file = mock(MultipartFile.class);
        service.saveVideo(file, testName);

        // After saving the video, it should exist in the repo
        assertTrue(repo.existsByName(testName));
    }

    @Test
    void getAllVideoNames() {
        // save a test video to the repo and add name to expected list
        List<String> expected = List.of(testName);
        repo.save(new Video(testName, null));

        // query service for video names
        List<String> actual = service.getAllVideoNames();

        // Check the service returns a list of the same contents as the expected list of videos
        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
    }
}