package com.example.quickstream.domain;

import com.example.quickstream.controllers.VideoController;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class VideoModelAssembler extends RepresentationModelAssemblerSupport<Video, VideoModel> {
    public VideoModelAssembler() {
        super(VideoController.class, VideoModel.class);
    }

    @Override
    public VideoModel toModel(Video entity) {
        VideoModel model = new VideoModel();
        // Both CustomerModel and Customer have the same property names. So copy the values from the Entity to the Model
        BeanUtils.copyProperties(entity, model);
        return model;
    }
}