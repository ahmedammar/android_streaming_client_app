package com.genesi.videoclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity 
extends Activity 
implements OnClickListener
{
	private EditText mURL;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.main);
        
        Button mButton = (Button) this.findViewById(R.id.button1);
        mButton.setSystemUiVisibility(View.STATUS_BAR_HIDDEN);

        mURL = (EditText) this.findViewById(R.id.editText1);
        mButton.setOnClickListener(this);
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i = new Intent(this, VideoPlayer.class);
		i.putExtra("URL", mURL.getText().toString());
		Log.i("StreamingActivity", mURL.getText().toString());
		startActivity(i);
	}
}