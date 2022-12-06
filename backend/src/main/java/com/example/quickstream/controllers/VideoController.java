package com.example.quickstream.controllers;

import com.example.quickstream.domain.Video;
import com.example.quickstream.domain.VideoModel;
import com.example.quickstream.domain.VideoModelAssembler;
import com.example.quickstream.services.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("video")
@AllArgsConstructor
public class VideoController {
    private VideoService videoService;

    @Autowired
    private VideoModelAssembler videoModelAssembler;

    @Autowired
    private PagedResourcesAssembler<Video> pagedResourcesAssembler;

    @GetMapping()
    public ResponseEntity<PagedModel<VideoModel>> getAllVideos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        Page<Video> videoPage = videoService.getVideos(page, size);

        return ResponseEntity.ok(pagedResourcesAssembler.toModel(videoPage, videoModelAssembler));
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