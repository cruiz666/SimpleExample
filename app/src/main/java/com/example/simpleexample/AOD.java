package com.example.simpleexample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import am.mediastre.mediastreamplatformsdkandroid.MediastreamPlayer;
import am.mediastre.mediastreamplatformsdkandroid.MediastreamPlayerConfig;

public class AOD extends AppCompatActivity {
    private FrameLayout container;
    private MediastreamPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aod);

        MediastreamPlayerConfig config = new MediastreamPlayerConfig();
        config.id = "62753d0d703b383658d00519";
        config.accountID = "5e6f83ae335cdd1163e16b5b";
        config.type = MediastreamPlayerConfig.VideoTypes.VOD;
        config.playerType = MediastreamPlayerConfig.PlayerType.AUDIO;
        config.videoFormat = MediastreamPlayerConfig.AudioVideoFormat.MP3;
        config.appName = "Mediastream-Sample-Cogna";
        container = findViewById(R.id.main_media_frame);
        player = new MediastreamPlayer(this, config, container);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        player.releasePlayer();
        startActivity(new Intent(AOD.this, MainActivity.class));
    }
}
