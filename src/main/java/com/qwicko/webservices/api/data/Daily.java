package com.qwicko.webservices.api.data;

import com.qwicko.services.youtube.bean.YoutubeVideo;
import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class Daily {
	YoutubeVideo youtubeVideo;
	List<GuessOption> guessOptions;
}
