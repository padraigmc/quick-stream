package com.example.quickstream.controllers;

import com.example.quickstream.domain.Video;
import com.example.quickstream.services.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("video")
@AllArgsConstructor
public class VideoController {
    private VideoService videoService;

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllVideos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int limit
    ){
        Pageable paging = PageRequest.of(page, limit);
        Page<Video> pageVideos = videoService.getVideos(paging);

        Map<String, Object> response = new HashMap<>();
        response.put("videos", pageVideos.getContent());
        response.put("currentPage", pageVideos.getNumber());
        response.put("totalItems", pageVideos.getTotalElements());
        response.put("totalPages", pageVideos.getTotalPages());

        return ResponseEntity.ok(response);
    }

    // Each parameter annotated with @RequestParam corresponds to a form field where the String argument is the name of the field
    @PostMapping()
    public ResponseEntity<String> saveVideo(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) throws IOException {
        videoService.saveVideo(file, name);
        return ResponseEntity.ok("Video saved successfully.");
    }

    // {id} is a path variable in the url. It is extracted as the String parameter annotated with @PathVariable
    @GetMapping("{id}")
    public ResponseEntity<Resource> getVideoContentById(@PathVariable("id") Long id) throws IOException {
        return ResponseEntity
                .ok(new ByteArrayResource(videoService.getVideoContent(id)));
    }
}