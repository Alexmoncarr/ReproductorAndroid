package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private SoundPool soundPool;
    private int shortSoundId;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        shortSoundId = soundPool.load(this, R.raw.sonido_corto, 1);

        mediaPlayer = MediaPlayer.create(this, R.raw.compresssion_1);

        Button btnShortSound = findViewById(R.id.btnShortSound);
        btnShortSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playShortSound();
            }
        });

        Button btnLongSound = findViewById(R.id.btnLongSound);
        btnLongSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playLongSound();
            }
        });
    }
    private void playShortSound() {
        soundPool.play(shortSoundId, 1, 1, 0, 0, 1);
    }

    private void playLongSound() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        mediaPlayer.release();
    }
}