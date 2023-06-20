import { Autocomplete, TextField } from '@mui/material';
import dayjs, { Dayjs } from 'dayjs';
import { getGlobalInstance } from 'plume-ts-di';
import React, { useEffect, useRef } from 'react';
import { useState } from 'react';
import { toast } from 'react-toastify';
import YouTube from 'react-youtube';
import DailyApi, { DailyResponse, GuessOption, YoutubeVideo } from '../../api/session/DailyApi';
import Vinyl from '../../../assets/icons/vynil.png'
import PlayCircleIcon from '@mui/icons-material/PlayCircle';
import useMessages from '../../i18n/hooks/messagesHook';
import ShareIcon from '@mui/icons-material/Share';

export default function Home() {
  const dailyApi = getGlobalInstance(DailyApi);
  const { messages } = useMessages();

  const [musicPlaying, setMusicPlaying] = useState<boolean>();
  const [guess, setGuess] = useState<string>();
  const [toGuess, setToGuess] = useState<YoutubeVideo>();
  const [guessTime, setGuessTime] = useState<Dayjs>();
  const [guessTimeStart, setGuessTimeStart] = useState<Dayjs>();
  const [guessOptions, setGuessOptions] = useState<GuessOption[]>([]);
  const youtubeRef = useRef<YouTube | null>();

  const copyToClipboard = () => {
    if (guessTime) {
      navigator.clipboard.writeText(messages['home.shareContent'](guessTime.diff(guessTimeStart, 'millisecond') / 1000))
      toast.success(messages['home.copied']);
    }
  }

  const playMusic = () => {
    setMusicPlaying(true);
    youtubeRef.current?.internalPlayer.playVideo();
    if (!guessTimeStart) {
      setGuessTimeStart(dayjs());
    }
  }

  useEffect(() => {
    dailyApi
      .getDaily()
      .then((response: DailyResponse) => {
        setToGuess(response.youtubeVideo)
        setGuessOptions(response.guessOptions.sort((a, b) => a.value.localeCompare(b.value)));
      });
  }, []);

  if (!guessTime && toGuess && toGuess.videoId === guess) {
    setGuessTime(dayjs());
  }

  return <div id="home-layout">
    <div className="main-content">
      <h2>{messages['home.question']}</h2>
      <br />
      <div className="play-song">
        <img src={Vinyl} alt="Play the song !" className={musicPlaying ? 'playing' : ''} />
        <button onClick={playMusic}>
          <PlayCircleIcon />
          {messages['action.play']}
        </button>
      </div>
      <div
        className={guessTimeStart ? "guess-song" : "guess-song guess-song--disabled"}
        title={!guessTimeStart ? messages['home.not-allowed'] : ''}>
        <Autocomplete
          disablePortal
          options={guessOptions}
          getOptionLabel={(guessOption: GuessOption) => guessOption.value}
          sx={{ width: 300 }}
          disabled={!guessTimeStart}
          onChange={(_, value) => setGuess(value?.id)}
          renderInput={(params) => <TextField {...params} label={messages['home.guess-placeholder']} />}
        />
        {
          guessTime && guessTimeStart && toGuess && guess === toGuess.videoId && <div className="guess-result">
            {messages['home.guess-result'](guessTime.diff(guessTimeStart, 'millisecond') / 1000)}
            <button onClick={copyToClipboard}>
              <ShareIcon />
              {messages['home.share']}
            </button>
          </div>
        }
        {
          toGuess && <YouTube
            videoId={toGuess.videoId}
            ref={(ref) => youtubeRef.current = ref}
            style={{ display: guess === toGuess.videoId ? 'initial' : 'none' }}
          />
        }
      </div>
    </div>
    <footer>
      Icon by <a href="https://www.flaticon.com/">flaticon</a>
      <br />
      Developped using <a href={"https://github.com/Coreoz/Plume"}>Plume Framework</a>
    </footer>
  </div>;
}
