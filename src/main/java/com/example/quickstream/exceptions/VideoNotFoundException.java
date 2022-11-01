package com.example.quickstream.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "A video with this name was not found")
public class VideoNotFoundException extends RuntimeException {

}
