package com.qwicko.services.youtube;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.qwicko.services.youtube.bean.YoutubeVideo;
import lombok.SneakyThrows;

import java.util.List;

public class YoutubeService {

    private static final String API_KEY = "";

    public List<YoutubeVideo> getAllYoutubeVideos() {
        return List.of(
            YoutubeVideo.of("Party Rock Anthem ft. Lauren Bennett, GoonRock", "LMFAO", "KQ6zr6kCPj8"),
            YoutubeVideo.of("Shape of You", "Ed Sheeran", "JGwWNGJdvx8"),
            YoutubeVideo.of("Despacito", "Luis Fonsi ft. Daddy Yankee", "kJQP7kiw5Fk"),
            YoutubeVideo.of("Uptown Funk", "Mark Ronson ft. Bruno Mars", "OPf0YbXqDm0"),
            YoutubeVideo.of("Thinking Out Loud", "Ed Sheeran", "lp-EO5I60KA"),
            YoutubeVideo.of("Someone Like You", "Adele", "hLQl3WQQoQ0"),
            YoutubeVideo.of("Happy", "Pharrell Williams", "ZbZSe6N_BXs"),
            YoutubeVideo.of("Rolling in the Deep", "Adele", "rYEDA3JcQqw"),
            YoutubeVideo.of("Blurred Lines", "Robin Thicke ft. T.I. and Pharrell Williams", "yyDUC1LUXSU"),
            YoutubeVideo.of("Closer", "The Chainsmokers ft. Halsey", "0zGcUoRlhmw"),
            YoutubeVideo.of("Shake It Off", "Taylor Swift", "nfWlot6h_JM"),
            YoutubeVideo.of("Hello", "Adele", "YQHsXMglC9A"),
            YoutubeVideo.of("Bad Guy", "Billie Eilish", "DyDfgMOUjCI"),
            YoutubeVideo.of("All About That Bass", "Meghan Trainor", "7PCkvCPvDXk"),
            YoutubeVideo.of("Radioactive", "Imagine Dragons", "w3viBe2Q0P8"),
            YoutubeVideo.of("Hotline Bling", "Drake", "uxpDa-c-4Mc"),
            YoutubeVideo.of("Havana", "Camila Cabello ft. Young Thug", "BQ0mxQXmLsk"),
            YoutubeVideo.of("Old Town Road", "Lil Nas X ft. Billy Ray Cyrus", "r7qovpFAGrQ"),
            YoutubeVideo.of("Wrecking Ball", "Miley Cyrus", "My2FRPA3Gf8"),
            YoutubeVideo.of("Gangnam Style", "PSY", "9bZkp7q19f0"),
            YoutubeVideo.of("We Found Love", "Rihanna ft. Calvin Harris", "tg00YEETFzg"),
            YoutubeVideo.of("Royals", "Lorde", "nlcIKh6sBtc"),
            YoutubeVideo.of("Blank Space", "Taylor Swift", "e-ORhEE9VVg"),
            YoutubeVideo.of("Don't Stop Believin'", "Journey", "1k8craCGpgs"),
            YoutubeVideo.of("Bad Romance", "Lady Gaga", "qrO4YZeyl0I"),
            YoutubeVideo.of("Counting Stars", "OneRepublic", "hT_nvWreIhg"),
            YoutubeVideo.of("Cheap Thrills", "Sia ft. Sean Paul", "nYh-n7EOtMA"),
            YoutubeVideo.of("Sorry", "Justin Bieber", "fRh_vgS2dFE"),
            YoutubeVideo.of("Love Yourself", "Justin Bieber", "oyEuk8j8imI"),
            YoutubeVideo.of("Stay with Me", "Sam Smith", "pB-5XG-DbAA"),
            YoutubeVideo.of("Dance Monkey", "Tones and I", "q0hyYWKXF0Q"),
            YoutubeVideo.of("Poker Face", "Lady Gaga", "bESGLojNYSo"),
            YoutubeVideo.of("Titanium", "David Guetta ft. Sia", "JRfuAukYTKg"),
            YoutubeVideo.of("Rude", "MAGIC!", "PIh2xe4jnpk"),
            YoutubeVideo.of("Shape of My Heart", "Backstreet Boys", "OT5msu-dap8"),
            YoutubeVideo.of("Hey, Soul Sister", "Train", "kVpv8-5XWOI"),
            YoutubeVideo.of("Waka Waka (This Time for Africa)", "Shakira ft. Freshlyground", "Ntn1-SocNiY"),
            YoutubeVideo.of("Viva la Vida", "Coldplay", "dvgZkm1xWPE"),
            YoutubeVideo.of("Hey Ya!", "OutKast", "PWgvGjAhvIw"),
            YoutubeVideo.of("Get Lucky", "Daft Punk ft. Pharrell Williams", "5NV6Rdv1a3I"),
            YoutubeVideo.of("Sweet Child o' Mine", "Guns N' Roses", "1w7OgIMMRc4"),
            YoutubeVideo.of("Pompeii", "Bastille", "F90Cw4l-8NY"),
            YoutubeVideo.of("See You Again", "Wiz Khalifa ft. Charlie Puth", "RgKAFK5djSk"),
            YoutubeVideo.of("Love Story", "Taylor Swift", "8xg3vE8Ie_E"),
            YoutubeVideo.of("Firework", "Katy Perry", "QGJuMBdaqIw"),
            YoutubeVideo.of("Photograph", "Ed Sheeran", "nSDgHBxUbVQ"),
            YoutubeVideo.of("Let It Go", "Idina Menzel (from the movie Frozen)", "moSFlvxnbgk"),
            YoutubeVideo.of("The Middle", "Zedd, Maren Morris, Grey", "M3mJkSqZbX4"),
            YoutubeVideo.of("Just the Way You Are", "Bruno Mars", "LjhCEhWiKXk"),
            YoutubeVideo.of("Shallow", "Lady Gaga, Bradley Cooper", "bo_efYhYU2A"),
            YoutubeVideo.of("Dark Horse", "Katy Perry ft. Juicy J", "0KSOMA3QBU0"),
            YoutubeVideo.of("Ho Hey", "The Lumineers", "zvCBSSwgtg4"),
            YoutubeVideo.of("Wake Me Up", "Avicii", "IcrbM1l_BoI"),
            YoutubeVideo.of("Chandelier", "Sia", "2vjPBrBU-TM"),
            YoutubeVideo.of("Love Me Like You Do", "Ellie Goulding", "AJtDXIazrMo"),
            YoutubeVideo.of("Roar", "Katy Perry", "CevxZvSJLk8"),
            YoutubeVideo.of("Rather Be", "Clean Bandit ft. Jess Glynne", "m-M1AtrxztU"),
            YoutubeVideo.of("Locked Out of Heaven", "Bruno Mars", "e-fA-gBCkj0"),
            YoutubeVideo.of("Happier", "Marshmello ft. Bastille", "m7Bc3pLyij0"),
            YoutubeVideo.of("Can't Feel My Face", "The Weeknd", "KEI4qSrkPAs"),
            YoutubeVideo.of("Hey There Delilah", "Plain White T's", "h_m-BjrxmgI"),
            YoutubeVideo.of("All of Me", "John Legend", "450p7goxZqg"),
            YoutubeVideo.of("Believer", "Imagine Dragons", "7wtfhZwyrcc"),
            YoutubeVideo.of("Waves", "Mr. Probz", "pUjE9H8QlA4"),
            YoutubeVideo.of("Umbrella", "Rihanna ft. Jay-Z", "CvBfHwUxHIk"),
            YoutubeVideo.of("Hello", "Martin Solveig ft. Dragonette", "LnET4RKXx5k"),
            YoutubeVideo.of("Just Give Me a Reason", "P!nk ft. Nate Ruess", "OpQFFLBMEPI"),
            YoutubeVideo.of("I Will Always Love You", "Whitney Houston", "3JWTaaS7LdU"),
            YoutubeVideo.of("Perfect", "Ed Sheeran", "2Vv-BfVoq4g"),
            YoutubeVideo.of("Don't You Worry Child", "Swedish House Mafia ft. John Martin", "1y6smkh6c-0"),
            YoutubeVideo.of("Skyfall", "Adele", "DeumyOzKqgI"),
            YoutubeVideo.of("Sorry", "Beyoncé", "QxsmWxxouIM"),
            YoutubeVideo.of("Born This Way", "Lady Gaga", "wV1FrqwZyKw"),
            YoutubeVideo.of("Can't Stop the Feeling!", "Justin Timberlake", "ru0K8uYEZWw"),
            YoutubeVideo.of("Chasing Cars", "Snow Patrol", "GemKqzILV4w"),
            YoutubeVideo.of("Demons", "Imagine Dragons", "mWRsgZuwf_8"),
            YoutubeVideo.of("Love Me Harder", "Ariana Grande ft. The Weeknd", "g5qU7p7yOY8"),
            YoutubeVideo.of("Love on the Brain", "Rihanna", "QMP-o8WXSPM"),
            YoutubeVideo.of("Payphone", "Maroon 5 ft. Wiz Khalifa", "KRaWnd3LJfs"),
            YoutubeVideo.of("Say Something", "A Great Big World ft. Christina Aguilera", "-2U0Ivkn2Ds"),
            YoutubeVideo.of("Send My Love (To Your New Lover)", "Adele", "fk4BbF7B29w"),
            YoutubeVideo.of("Stressed Out", "Twenty One Pilots", "pXRviuL6vMY"),
            YoutubeVideo.of("Sugar", "Maroon 5", "09R8_2nJtjg")
        );
    }

    @SneakyThrows
    public static void main(String[] args) {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

        YouTube youTube = new YouTube.Builder(httpTransport, jsonFactory, httpRequest -> {
            // No-op for API key only
        })
            .setApplicationName("Songle")
            .build();

        List<YoutubeVideo> youtubeVideosToGuess = List.of(
            YoutubeVideo.of("This Is What You Came For", "Calvin Harris ft. Rihanna", ""),
            YoutubeVideo.of("Viva la Vida", "Coldplay", ""),
            YoutubeVideo.of("Wake Me Up", "Avicii", "")
        );

        for (YoutubeVideo youtubeVideo : youtubeVideosToGuess) {
            SearchListResponse searchResponse = youTube
                .search()
                .list(List.of("id", "snippet"))
                .setKey(API_KEY)
                .setQ(youtubeVideo.getArtist() + "+" + youtubeVideo.getTrackName())
                .setType(List.of("Video"))
                .setMaxResults(1L)
                .execute();

            System.out.println(
                "YoutubeVideo.of(\"" + youtubeVideo.getTrackName() + "\", \"" + youtubeVideo.getArtist() + "\", \"" + searchResponse.getItems().get(0).getId().getVideoId() + "\"),"
            );
        }
    }
}
