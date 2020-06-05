package com.example.muiska.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.muiska.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;
    private String titleVideo;
    private String currentUser;
    private String tituloStation;
    private String idEstacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(Config.YOUTUBE_API_KEY, this);
        Bundle extras = getIntent().getExtras();
        currentUser = extras.getString("EXTRA_CURRENT_USER");
        titleVideo = extras.getString("EXTRA_ID_VIDEO");
        tituloStation = extras.getString("EXTRA_TITLE_STATION");
        idEstacion = extras.getString("EXTRA_ID_STATION");
        TextView titleVideoTv = findViewById(R.id.titleVideo);
        titleVideoTv.setText(tituloStation);
    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (!b) {
            //youTubePlayer.setFullscreen(true);
            youTubePlayer.loadVideo(this.titleVideo);
            youTubePlayer.play();
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), errorReason.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(Config.YOUTUBE_API_KEY, this);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return youTubeView;
    }

    public  void cambiarActivity(View view){
        Intent intent = new Intent(this, QuestionActivity.class);
        Bundle extras = new Bundle();
        extras.putString("EXTRA_ID_STATION",this.idEstacion);
        extras.putString("EXTRA_TITLE_STATION", String.valueOf(this.tituloStation));
        extras.putString("EXTRA_CURRENT_USER",this.currentUser);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
