package com.example.quickstream.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class VideoModel extends RepresentationModel<VideoModel> {
    private Long id;
    private String name;
    private String contentId;
    private long contentLength;
    private String contentMimeType;

}
