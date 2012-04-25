package com.genesi.videoclient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.ProgressBar;
import android.widget.VideoView;

public class VideoPlayer 
extends Activity
implements OnPreparedListener, OnCompletionListener
{
	private VideoView mVideo;
	private ProgressBar mProgressBar;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.video);

	    // TODO Auto-generated method stub
	    Bundle extras = getIntent().getExtras();
	    if (extras == null) {
	    		return;
	    }
	    // Get data via the key
	    String URL = extras.getString("URL");
	    Log.i("VideoPlayer", URL);
	    
	    
	    mVideo = (VideoView) this.findViewById(R.id.videoView1);
	    mProgressBar = (ProgressBar) this.findViewById(R.id.progressBar1);
		mProgressBar.setVisibility(View.VISIBLE);
		mProgressBar.setSystemUiVisibility(View.STATUS_BAR_HIDDEN);

	    mVideo.setVideoPath(URL);
	    //mVideo.setMediaController(new MediaController(this));
	    mVideo.requestFocus();
	    mVideo.start();
	    mVideo.setOnPreparedListener(this);
	    mVideo.setOnCompletionListener(this);
	}

	public void onPrepared(MediaPlayer mp) {
		mProgressBar.setVisibility(View.INVISIBLE);
	}

	public void onCompletion(MediaPlayer mp) {
		finish();		
	}

}
