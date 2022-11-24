package com.example.quickstream;

import com.example.quickstream.contentstore.VideoContentStore;
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
    @Autowired VideoService service;
    @Autowired VideoRepo repo;
    @Autowired VideoContentStore contentStore;

    String testName = "myVid";

    @Test
    void getVideoContent() throws IOException {
        // create video and save to repo and content store
        Video testVideo = new Video(testName);
        MultipartFile file = mock(MultipartFile.class);
        byte[] expected = file.getBytes();

        contentStore.setContent(testVideo, file.getInputStream());
        repo.save(testVideo);

        // query service for test video content above
        byte[] actual = service.getVideoContent(testVideo.getId());

        // result from service should be the test video above
        assertEquals(expected, actual);
    }

    /*
    /*
    @Test
    void saveVideo() throws IOException {
        // create video and save using the service method
        MultipartFile file = mock(MultipartFile.class);
        InputStream is = mock(InputStream.class);

        when(file.getInputStream()).thenReturn(is);

        service.saveVideo(file, testName);

        // After saving the video, it should exist in the repo
        assertTrue(repo.existsByName(testName));
    }
     */

    @Test
    void getAllVideoNames() {
        // save a test video to the repo and add name to expected list
        List<Video> expected = List.of(new Video(testName));
        repo.save(new Video(testName));

        // query service for video names
        List<Video> actual = service.getAllVideos();

        // Check the service returns a list of the same contents as the expected list of videos
        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
    }
}