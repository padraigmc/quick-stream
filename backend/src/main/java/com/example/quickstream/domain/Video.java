package com.example.quickstream.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.content.commons.annotations.ContentId;
import org.springframework.content.commons.annotations.ContentLength;

import javax.persistence.*;

@Entity
@Table(name="videos")
@Getter @Setter @ToString
@NoArgsConstructor
public class Video{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ContentId private String contentId;
    @ContentLength private long contentLength;
    private String contentMimeType = "video/mp4";

    public Video(String name) {
        this.name = name;
    }
}