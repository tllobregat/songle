package com.qwicko.services.youtube.bean;

import lombok.Value;

@Value(staticConstructor = "of")
public class YoutubeVideo {
    String trackName;
    String artist;
    String videoId;
}
