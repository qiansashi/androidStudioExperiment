package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaCasException;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class Main5Activity extends AppCompatActivity implements SurfaceHolder.Callback,MediaPlayer.OnErrorListener{
    private MediaPlayer mediaPlayer;
    private SurfaceHolder mSurfaceHolder;
    private SurfaceView surfaceView;
    private boolean check=true;
    private MediaPlayer mp3Player;
    private Button musicButton;
    private final String path="/home";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        surfaceView =(SurfaceView) findViewById(R.id.surfaceView);
        mediaPlayer= new MediaPlayer();
        mediaPlayer=MediaPlayer.create(this,R.raw.demo);
        final Button button=(Button) findViewById(R.id.playButton);
        musicButton=(Button) findViewById(R.id.MusicButton);
        mSurfaceHolder=surfaceView.getHolder();
        mSurfaceHolder.addCallback((SurfaceHolder.Callback) this);
        mp3Player = new MediaPlayer();
//        mp3Player = MediaPlayer.create(Main5Activity.this, R.raw.test);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check){
//                    System.out.println("p");
                    mediaPlayer.start();
                    button.setText(R.string.cease);
                    check=false;
                }else {
//                    System.out.println("s");
                    mediaPlayer.pause();
                    button.setText(R.string.play);
                    check=true;
                }
            }
        });
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra){
        return false;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){
        mediaPlayer.setDisplay(holder);//给mMediaPlayer添加预览的SurfaceHolder
        mSurfaceHolder.setFixedSize(1080,500);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void playMusic(View view) throws IOException{
        Uri uri= Uri.parse("https://yfspecialweb.cn:8889/music/ACG%E5%90%88%E9%9B%86%E2%91%A1/Sims3%20-%20The%20Young%20The%20Old%20And%20The%20Genome.mp3");
        String path = "/download/sim3.mp3";
        try {
            mp3Player=MediaPlayer.create(this, uri);
        }catch (IllegalStateException e){
            System.out.println("error!");
        }
        if (mp3Player.isPlaying() ) {
            mp3Player.pause();
        } else {
            mp3Player.start();
        }
    }
}
