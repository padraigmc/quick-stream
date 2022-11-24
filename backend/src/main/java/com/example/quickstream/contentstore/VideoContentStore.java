package com.example.quickstream.contentstore;

import com.example.quickstream.domain.Video;
import org.springframework.content.commons.repository.ContentStore;

public interface VideoContentStore extends ContentStore<Video, String> {
}
