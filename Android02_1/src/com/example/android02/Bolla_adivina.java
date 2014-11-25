package com.example.android02;

import java.util.Random;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class Bolla_adivina extends Activity {
	private TextView texto;
	private ImageView imagen;
	private MagicBall mb;
	private AnimationDrawable ad;
	private AlphaAnimation aAni;
	private MediaPlayer mp;
	
	private static final float OPACO=1;
	private static final float TRANSPARENTE=0;
	private static final int DURACION=1500;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_bolla_adivina); 
    	texto=(TextView)findViewById(R.id.texto);//Relacionarlos el elemento del layout
    	imagen= (ImageView)findViewById(R.id.imageview);
        
    }
    
    public void respuestas(View v)
    {
    	animateBall();
    	
    	
    	mb = new MagicBall();
		texto.setText(mb.getPrediccion(getResources()));
		animateAnswer();
		playSound();
    }
    public void animateBall()
    {
    	imagen.setImageResource(R.drawable.ball_animation);
    	ad = (AnimationDrawable) imagen.getDrawable();
    	
    	if(ad.isRunning())
    	{
    		ad.stop();
    	}
    	ad.start();
    	
    }
    
    public void animateAnswer()
    {
    	aAni= new AlphaAnimation(TRANSPARENTE, OPACO);
    	aAni.setDuration(DURACION);
    	aAni.setFillAfter(true);
    	
    	texto=(TextView)findViewById(R.id.texto);
    	texto.setAnimation(aAni);
    	
    }
    
    private void playSound()
    {
    	mp = new MediaPlayer().create(this, R.raw.magic_ball);
    	mp.start();
    	
    	mp.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				mp.release();
			}
		});
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
    	
    	
    	
        getMenuInflater().inflate(R.menu.bolla_adivina, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
