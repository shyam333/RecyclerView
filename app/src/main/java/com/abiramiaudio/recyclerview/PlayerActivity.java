package com.abiramiaudio.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PlayerActivity extends YouTubeFailureRecoveryActivity {

    private YouTubePlayerView playerView;
    private YouTubePlayer player;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.youtube_player);
        playerView = (YouTubePlayerView) findViewById(R.id.player);

        // You can use your own button to switch to fullscreen too


        Intent intent = getIntent();
        id = intent.getStringExtra("key");

        playerView.initialize(DeveloperKey.DEVELOPER_KEY, this);

    }

    @Override
    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return playerView;
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {

        this.player = youTubePlayer;
        // Specify that we want to handle fullscreen behavior ourselves.
        player.setPlayerStyle(YouTubePlayer.PlayerStyle.MINIMAL);

        if (!wasRestored) {
            player.loadVideo(id);
        }
    }
}
