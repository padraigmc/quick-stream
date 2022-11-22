package com.example.quickstream;

import com.example.quickstream.domain.Video;
import com.example.quickstream.repo.VideoRepo;
import com.example.quickstream.services.VideoService;
import com.example.quickstream.services.VideoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.web.multipart.MultipartFile;
/*
    Import all the static methods in the Mockito class so we can use them as though they are methods in this class.
    These include methods such as mock, when, etc. Same with the JUnit assertions.
 */
import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


public class VideoServiceImplTest {
    VideoRepo repo = mock(VideoRepo.class);
    VideoService service = new VideoServiceImpl(repo);

    // Test value for our tests
    String testName = "myVid";

    @Test
    void getVideo() {
        Video expected = new Video(testName, null);
        // When our VideoService object calls repo.findByName(testName), return expected
        when(repo.findByName(testName)).thenReturn(expected);

        // When our VideoService object calls repo.existsByName(testName), return true
        when(repo.existsByName(testName)).thenReturn(true);

        Video actual = service.getVideo(testName);
        assertEquals(expected, actual);

        // verify both repo methods were called
        verify(repo, times(1)).existsByName(testName);
        verify(repo, times(1)).findByName(testName);
    }

    @Test
    void getAllVideoNames() {
        // list of expected video names
        List<String> expected = List.of("myVid", "otherVid");

        // specify the names of the videos to be returned by our repo mothods
        when(repo.getAllEntryNames()).thenReturn(expected);

        // query service for video names
        List<String> actual = service.getAllVideoNames();

        // assert expected == actual
        assertEquals(expected, actual);

        // verify getAll repo method was called
        verify(repo, times(1)).getAllEntryNames();
    }

    @Test
    void saveVideo() throws IOException {
        // create mock MultipartFile and Video objects
        MultipartFile file = mock(MultipartFile.class);
        Video testVid = new Video(testName, file.getBytes());

        // save test file and verify methods ran once
        service.saveVideo(file.getBytes(), testName);
        verify(repo, times(1)).existsByName(testName);
        verify(repo, times(1)).save(testVid);
    }
}
