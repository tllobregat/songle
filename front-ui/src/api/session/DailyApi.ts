import { HttpMethod } from 'simple-http-request-builder';
import { HttpPromise } from 'simple-http-rest-client';
import ApiHttpClient from '../ApiHttpClient';

export type GuessOption = {
  value: string,
  id: string,
}

export type YoutubeVideo = {
  trackName: string;
  artist: string;
  videoId: string;
}

export type DailyResponse = {
  youtubeVideo: YoutubeVideo,
  guessOptions: GuessOption[],
};

/**
 * A sample API that can be copied to call real API.
 * After it has been copied, this file should be deleted :)
 */
export default class DailyApi {
  constructor(private readonly httpClient: ApiHttpClient) {
  }

  getDaily(): HttpPromise<DailyResponse> {
    return this
      .httpClient
      .restRequest<DailyResponse>(HttpMethod.GET, `/daily`)
      .execute();
  }
}
