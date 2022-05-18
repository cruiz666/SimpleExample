package com.example.simpleexample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import am.mediastre.mediastreamplatformsdkandroid.MediastreamPlayer;
import am.mediastre.mediastreamplatformsdkandroid.MediastreamPlayerCallback;
import am.mediastre.mediastreamplatformsdkandroid.MediastreamPlayerConfig;
import am.mediastre.mediastreamplatformsdkandroid.MediastreamPlayerService;

public class SAOD extends AppCompatActivity {
    private FrameLayout container;
    private MediastreamPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saod);

        MediastreamPlayerConfig config = new MediastreamPlayerConfig();
        config.id = "62753d0d703b383658d00519";
        config.accountID = "5e6f83ae335cdd1163e16b5b";
        config.type = MediastreamPlayerConfig.VideoTypes.VOD;
        config.playerType = MediastreamPlayerConfig.PlayerType.AUDIO;
        config.videoFormat = MediastreamPlayerConfig.AudioVideoFormat.MP3;
        config.appName = "Mediastream-Sample-Cogna";
        config.NotificationImageUrl = "https://s3-symbol-logo.tradingview.com/cogna--600.png";
        container = findViewById(R.id.main_media_frame);
        startService(config, this, container, null);
    }

    void startService(MediastreamPlayerConfig config, Context context, FrameLayout container, MediastreamPlayerCallback callback) {
        MediastreamPlayerService.setupService(config, context, container, callback);
        Intent serviceIntent = new Intent(this, MediastreamPlayerService.class);
        serviceIntent.setAction(getPackageName()+".action.startforeground");
        ContextCompat.startForegroundService(this, serviceIntent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MediastreamPlayerService.getMsPlayer().releasePlayer();
        Intent serviceIntent = new Intent(this, MediastreamPlayerService.class);
        serviceIntent.setAction(getPackageName()+".action.stopforeground");
        try {
            ContextCompat.startForegroundService(this, serviceIntent);
            startActivity(new Intent(SAOD.this, MainActivity.class));
        } catch (Exception e) {
            e.printStackTrace();
            startActivity(new Intent(SAOD.this, MainActivity.class));
        }
    }
}
