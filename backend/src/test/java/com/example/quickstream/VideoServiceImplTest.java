package com.example.quickstream;

import com.example.quickstream.contentstore.VideoContentStore;
import com.example.quickstream.domain.Video;
import com.example.quickstream.repo.VideoRepo;
import com.example.quickstream.services.VideoService;
import com.example.quickstream.services.VideoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


public class VideoServiceImplTest {
    VideoRepo repo = mock(VideoRepo.class);
    VideoContentStore contentStore = mock(VideoContentStore.class);
    VideoService service = new VideoServiceImpl(repo, contentStore);

    // Test value for our tests
    String testName = "myVid";

    @Test
    void getVideoContent() throws IOException {
        MultipartFile file = mock(MultipartFile.class);
        byte[] expected = file.getBytes();
        Video video = new Video(testName);
        long id = video.getId();

        // When our VideoService object calls repo.findById(id), return expected
        when(repo.findById(id)).thenReturn(Optional.of(video));

        when(contentStore.getContent(video)).thenReturn(file.getInputStream());

        byte[] actual = service.getVideoContent(id);
        assertEquals(expected, actual);

        // verify both repo methods were called
        verify(repo, times(1)).findById(id);
    }

    @Test
    void getVideos() {
        // list of expected video names
        List<Video> expected = List.of(new Video("myVid"), new Video("otherVid"));

        // specify the names of the videos to be returned by our repo methods
        when(repo.findAll()).thenReturn(expected);

        // query service for video names
        List<Video> actual = service.getVideos(PageRequest.of(0, 1)).getContent();

        // assert expected == actual
        assertEquals(expected, actual);

        // verify getAll repo method was called
        verify(repo, times(1)).findAll();
    }

    @Test
    void saveVideo() throws IOException {
        // create mock MultipartFile and Video objects
        MultipartFile file = mock(MultipartFile.class);
        Video testVid = new Video(testName);

        // save test file and verify methods ran once
        service.saveVideo(file, testName);
        verify(repo, times(1)).save(testVid);
    }
}
