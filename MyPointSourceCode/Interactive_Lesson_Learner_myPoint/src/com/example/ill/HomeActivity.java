/* Description:-Assigning functions to buttons on Home Screen
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */
package com.example.ill;

import java.io.IOException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends Activity {
	static int count = 0;
	MediaPlayer mp;
	int audio_flag=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		Button b1, b2, b3, btn_audio;
		/*Button for Main Screen*/
		b1 = (Button)findViewById(R.id.button_hm_1);
		mp = MediaPlayer.create(HomeActivity.this, R.raw.application_guide);
		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent in = new Intent(HomeActivity.this, MainActivity.class);
				mp.stop();
				audio_flag=0;
				startActivity(in);
			}
		});
		
		
		/*Button for Information about project*/
		b2 = (Button)findViewById(R.id.button_tour);
		b2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				final Dialog dialog = new Dialog(HomeActivity.this);
				dialog.setContentView(R.layout.projecttour);
				dialog.setTitle(Html.fromHtml("<font color=#085D04><strong>myPoint - Application Guide</strong></font>"));
				// set the custom dialog components - text, image and button
				count = 0;
				TextView txt = (TextView)dialog.findViewById(R.id.textView_tour);
				txt.setTextSize(17);
				txt.setText(" Instructions To Use My Point App :\n\n myPoint Application provides efficient platform for learning,  practising & quizzing Cartesian Coordinate System.\n\n The app has been categorized into 5 modules named as:\n\n 1. C-plane : It explains Cartesian Coordinate Plane.\n\n 2. Plotting : It explains point & its plotting on graph.");
				dialog.show();
				Button prevBtn = (Button) dialog.findViewById(R.id.tourback);
				prevBtn.setVisibility(View.INVISIBLE);
				Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
				// if button is clicked, close the custom dialog
				dialogButton.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
				Button nextBtn = (Button) dialog.findViewById(R.id.tournext);
				nextBtn.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						if(count == 0) {
						TextView txt = (TextView)dialog.findViewById(R.id.textView_tour);
						Button prevBtn = (Button) dialog.findViewById(R.id.tourback);
						prevBtn.setVisibility(View.VISIBLE);
						txt.setTextSize(17);
						txt.setText(" 3. Scaling  : It explains scaling in graphs.\n\n 4. Line : It explains line & its plotting on graphs.\n\n 5. Quiz-It  : It enables user to evaluate his/her acquired skills.\n\n Press \"Start myPoint Button\" to enter into these modules.");
						count = 1;
						}
						else if(count == 1) {
							TextView txt = (TextView)dialog.findViewById(R.id.textView_tour);
							txt.setTextSize(17);
							txt.setText(" Use the following sequence to make the best use of each modules in the app :\n\n 1. Read & Understand \"Real Life Example\" about the respective concept.\n\n 2. Read & Understand the concept explanation.\n\n 3. Read & Understand the solved examples.\n\n 4. Practice the concept.\n\n 5. Test your learning.");							
							count = 2;
						}
						else if(count == 2) {
							TextView txt = (TextView)dialog.findViewById(R.id.textView_tour);
							txt.setTextSize(17);
							Button nextBtn = (Button) dialog.findViewById(R.id.tournext);
							nextBtn.setVisibility(View.INVISIBLE);
							txt.setText(" Optional Audio explanation in Indian Regional Languages is provided in each module.\n\n Scratchpad is provided to perform calculations.\n\n \"Save Screenshots\" enables user to export plotted graphs to use for assignments etc");
							count = 3;
						}
						
					}
				});
				
				prevBtn.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						
							if(count == 1) {
							TextView txt = (TextView)dialog.findViewById(R.id.textView_tour);
							txt.setTextSize(17);
							txt.setText(" Instructions To Use My Point App :\n\n myPoint Application provides efficient platform for learning,  practising & quizzing Cartesian Coordinate System.\n\n The app has been categorized into 5 modules named as:\n\n 1. C-plane : It explains Cartesian Coordinate Plane.\n\n 2. Plotting : It explains point & its plotting on graph.");
							Button prevBtn = (Button) dialog.findViewById(R.id.tourback);
							prevBtn.setVisibility(View.INVISIBLE);
							count = 0;
						}
						else if(count == 2) {
								TextView txt = (TextView)dialog.findViewById(R.id.textView_tour);
								txt.setTextSize(17);
								txt.setText(" 3. Scaling  : It explains scaling in graphs.\n\n 4. Line : It explains line & its plotting on graphs.\n\n 5. Quiz-It  : It enables user to evaluate his/her acquired skills.\n\n Press \"Start myPoint Button\" to enter into these modules.");
								Button prevBtn = (Button) dialog.findViewById(R.id.tourback);
								prevBtn.setVisibility(View.VISIBLE);
								count = 1;
							}
							else if(count == 3) {
								TextView txt = (TextView)dialog.findViewById(R.id.textView_tour);
								Button nextBtn = (Button) dialog.findViewById(R.id.tournext);
								nextBtn.setVisibility(View.VISIBLE);
								txt.setTextSize(17);
								txt.setText("Use the following sequence to make the best use of each module in the app :\n\n 1. Read & Understand \"Real Life Example\" about the respective concept.\n\n 2. Read & Understand the concept explanation.\n\n 3. Read & Understand the solved examples.\n\n 4. Practice the concept.\n\n 5. Test your learning.");
								count = 2;
							}						
					}
				});
				
			}
		});
				/*Button b1 , b2 ;
				b1 = (Button)findViewById(R.id.tournext);
				b1.setVisibility(0);
				b2 = (Button)findViewById(R.id.tourback);
				b2.setVisibility(0);*/
		
		
		
	}

	public void onBackPressed() {
		new AlertDialog.Builder(this)
        .setIcon(android.R.drawable.ic_dialog_alert)
        .setTitle("Closing myPoint")
        .setMessage("Are you sure you want to close My Point?")
        .setPositiveButton("Yes", new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialog, int which) {
        	mp.release();
            finish();    
        }
        })
        .setNegativeButton("No", null)
        .show();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.aboutus:
			Intent in  = new Intent(this, AboutUs.class);
			mp.stop();
			audio_flag=0;
			startActivity(in);
			break;
		case R.id.audio_guide:
			if(audio_flag==0){
				mp = MediaPlayer.create(HomeActivity.this, R.raw.application_guide);
	    		mp.start();
	    		audio_flag=1;
	    		
	    	}
	    	else{	    		
	    		mp.stop();	            		
	    		audio_flag=0;	    		
	    		
	    	}
			break;
		}
		return true;
	}
	
	@Override
	public void onPause(){
		super.onPause();
		try{
		mp.stop();
		}catch(Exception e){}
		audio_flag=0;
	}
	
}
