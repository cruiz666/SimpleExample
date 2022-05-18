package com.example.simpleexample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.upstream.RawResourceDataSource;

import am.mediastre.mediastreamplatformsdkandroid.MediastreamPlayer;
import am.mediastre.mediastreamplatformsdkandroid.MediastreamPlayerConfig;

public class LAOD extends AppCompatActivity {
    private FrameLayout container;
    private MediastreamPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laod);

        MediastreamPlayerConfig config = new MediastreamPlayerConfig();
        config.src = RawResourceDataSource.buildRawResourceUri(R.raw.aod).toString();
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
        startActivity(new Intent(LAOD.this, MainActivity.class));
    }
}
