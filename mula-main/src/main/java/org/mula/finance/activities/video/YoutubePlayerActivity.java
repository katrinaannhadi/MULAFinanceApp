package org.mula.finance.activities.video;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import org.mula.finance.R;

public class YoutubePlayerActivity extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener {



    private static final String TAG = "YoutubeActivity";
    static final String GOOGLE_API_KEY = "AIzaSyBmb_Zr5HP6FUiuGCIiwbW3fhdgy9XZGPE";
    static final String YOUTUBE_VIDEO_ID = "gnWj97CEjeo";
    static final String YOUTUBE_PLAYLIST_1 = "PL9ECA8AEB409B3E4F";
    static final String YOUTUBE_PLAYLIST_3 = "PLECECA66C0CE68B1E";
    static final String YOUTUBE_PLAYLIST_2 = "PLEAWiihj06OL80BfkpXVh2AQ-AYe04xiU";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO check the root whether it's correct
        //inflates the xml and assigns the view that is created to the layout variable and passes the view to set content view
        ConstraintLayout layout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_video,null);
        setContentView(layout);

        //adding the youtube player view widget to the layout
        YouTubePlayerView playerView = new YouTubePlayerView(this);
        playerView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layout.addView(playerView);
        //initialises the player view and gives it the API KEY
        playerView.initialize(GOOGLE_API_KEY, this);
    }

    // Create a success method and plays the video
    // Referenced the YouTubeInitialisation documentation on for Android Player API
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        Log.d(TAG, "onInitializationSuccess: provider is " + provider.getClass().toString());

        //create a toast to tell the user that something has gone wrong
        Toast.makeText(this, "Initialized Youtube Player successfully", Toast.LENGTH_LONG).show();

        //setting up the relevant listeners to the methods defined below
        //find methods to call back when an event happens
        youTubePlayer.setPlaybackEventListener(playbackEventListener);
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);

        //checks to see whether the youtube video was restored and if not cue the video from start
        if(!wasRestored) {
            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
        }

    }


    //Creates a failure method on does not play the video
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        //creates a constant
        final int REQUEST_CODE = 1;

        //Check to see if the result is something that the user can fix
        //Displays the error dialogue
        if(youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this, REQUEST_CODE).show();
            //Otherwise display toast with error message
        } else {
            String errorMessage = String.format("There was an error initializing the YoutubePlayer (%1$s)", youTubeInitializationResult.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {
            Toast.makeText(YoutubePlayerActivity.this, "Video playing ok", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPaused() {
            Toast.makeText(YoutubePlayerActivity.this, "Video has paused", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onStopped() {
            Toast.makeText(YoutubePlayerActivity.this, "Video has stopped", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {
            Toast.makeText(YoutubePlayerActivity.this, "Click Ad now, make the video creator rich!", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onVideoStarted() {
            Toast.makeText(YoutubePlayerActivity.this, "Video has started", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onVideoEnded() {
            Toast.makeText(YoutubePlayerActivity.this, "Congratulations! You've completed another video.", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };
}

