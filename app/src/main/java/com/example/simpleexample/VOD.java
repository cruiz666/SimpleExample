package com.example.simpleexample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import am.mediastre.mediastreamplatformsdkandroid.MediastreamPlayer;
import am.mediastre.mediastreamplatformsdkandroid.MediastreamPlayerConfig;

public class VOD extends AppCompatActivity {
    private FrameLayout container;
    private MediastreamPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vod);

        MediastreamPlayerConfig config = new MediastreamPlayerConfig();
        config.id = "6284101f4373640823893cdb";
        config.accountID = "5e6f83ae335cdd1163e16b5b";
        config.type = MediastreamPlayerConfig.VideoTypes.VOD;
        config.appName = "Mediastream-Sample-Cogna";
        container = findViewById(R.id.main_media_frame);
        player = new MediastreamPlayer(this, config, container);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        player.releasePlayer();
        startActivity(new Intent(VOD.this, MainActivity.class));
    }
}
