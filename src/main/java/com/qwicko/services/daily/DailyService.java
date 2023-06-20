package com.qwicko.services.daily;

import com.qwicko.services.youtube.YoutubeService;
import com.qwicko.services.youtube.bean.YoutubeVideo;
import com.qwicko.webservices.api.data.Daily;
import com.qwicko.webservices.api.data.GuessOption;
import lombok.SneakyThrows;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class DailyService {

    private final YoutubeService youtubeService;

    private final Map<LocalDate, Daily> dailyMap = new HashMap<>();

    @Inject
    private DailyService(YoutubeService youtubeService) {
        this.youtubeService = youtubeService;
    }

    @SneakyThrows
    public Daily getDailySong() {
        if (dailyMap.get(LocalDate.now()) == null) {
            List<YoutubeVideo> youtubeVideoList = youtubeService.getAllYoutubeVideos();

            dailyMap.put(
                LocalDate.now(),
                Daily.of(
                    youtubeVideoList.get((int) Math.floor(Math.random() * youtubeVideoList.size())),
                    youtubeVideoList
                        .stream()
                        .map(youtubeVideo -> GuessOption.of(
                                youtubeVideo.getArtist() + " - " + youtubeVideo.getTrackName(),
                                youtubeVideo.getVideoId()
                            )
                        )
                        .toList()
                )
            );
        }

        return dailyMap.get(LocalDate.now());
    }
}
