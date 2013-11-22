/* Description:-Display Splash Screen and disclaimer of application
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */

package com.example.ill;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;

import com.example.ill.util.SystemUiHider;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class MainScreenActivity extends Activity {
	/**
	 * Whether or not the system UI should be auto-hidden after
	 * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
	 */
	int cc = 0;
	private static final boolean AUTO_HIDE = true;
	MediaPlayer mp;

	/**
	 * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
	 * user interaction before hiding the system UI.
	 */
	private static final int AUTO_HIDE_DELAY_MILLIS = 7000;

	/**
	 * If set, will toggle the system UI visibility upon interaction. Otherwise,
	 * will show the system UI visibility upon interaction.
	 */
	private static final boolean TOGGLE_ON_CLICK = false;

	/**
	 * The flags to pass to {@link SystemUiHider#getInstance}.
	 */
	private static final int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;

	/**
	 * The instance of the {@link SystemUiHider} for this activity.
	 */
	private SystemUiHider mSystemUiHider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main_screen);
		final boolean firstboot = getSharedPreferences("BOOT_PREF", MODE_PRIVATE).getBoolean("firstboot", true);
		mp = MediaPlayer.create(MainScreenActivity.this, R.raw.welcome_marathi);
		

        if (firstboot){
            // 1) Launch the authentication activity
        	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainScreenActivity.this);
        	SpannableString s = new SpannableString("myPoint application is released under GNUv3 license.<br>Your use of this application may be subject to data traffic charges depending on your internet subscription with your service provider.<br>I consent to the myPoint <a href =\"http://www.gnu.org/licenses/gpl-3.0.html\">Terms of use.</a>");
        	Linkify.addLinks(s, Linkify.WEB_URLS);
    			// set title
    			alertDialogBuilder.setTitle("Terms and conditions");
     
    			// set dialog message
    			alertDialogBuilder
    				.setMessage(Html.fromHtml(""+s))
    				.setCancelable(false)
    				.setPositiveButton("Accept",new DialogInterface.OnClickListener() {
    					public void onClick(DialogInterface dialog,int id) {
    						// if this button is clicked, close
    						// current activity
    						cc = 1;
    						dialog.cancel();
    						getSharedPreferences("BOOT_PREF", MODE_PRIVATE)
    		                .edit()
    		                .putBoolean("firstboot", false)
    		                .commit();
    						
    						
    						new Thread(new Runnable() {
    							  public void run() {
    								  try {
    									Thread.sleep(4000);
    									mp.start();
    								} catch (InterruptedException e) {
    									e.printStackTrace();
    								}
    								  if(!firstboot || cc==1){
    									Intent in = new Intent(MainScreenActivity.this, HomeActivity.class);
    									mp.release();
    									startActivity(in);    									
    									finish();
    									}
    							  }
    						       }).start();
    						
    							}
    						
    				  })
    				.setNegativeButton("Decline",new DialogInterface.OnClickListener() {
    					public void onClick(DialogInterface dialog,int id) {
    						// if this button is clicked, just close
    						// the dialog box and do nothing
    						mp.release();
    						MainScreenActivity.this.finish();
    			            // 2) Then save the state
    		    			
    						getSharedPreferences("BOOT_PREF", MODE_PRIVATE)
    		                .edit()
    		                .putBoolean("firstboot", true)
    		                .commit();
    					}
    				});
     
    				// create alert dialog
    				AlertDialog alertDialog = alertDialogBuilder.create();
    				alertDialog.show();
    				 ((TextView)alertDialog.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());
        }

		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		final View controlsView = findViewById(R.id.fullscreen_content_controls);
		final View contentView = findViewById(R.id.fullscreen_content);

		// Set up an instance of SystemUiHider to control the system UI for
		// this activity.
		mSystemUiHider = SystemUiHider.getInstance(this, contentView,
				HIDER_FLAGS);
		mSystemUiHider.setup();
		mSystemUiHider.toggle();
		mSystemUiHider
				.setOnVisibilityChangeListener(new SystemUiHider.OnVisibilityChangeListener() {
					// Cached values.
					int mControlsHeight;
					int mShortAnimTime;
					
					@Override
					@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
					public void onVisibilityChange(boolean visible) {
						if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
							// If the ViewPropertyAnimator API is available
							// (Honeycomb MR2 and later), use it to animate the
							// in-layout UI controls at the bottom of the
							// screen.
							if (mControlsHeight == 0) {
								mControlsHeight = controlsView.getHeight();
							}
							if (mShortAnimTime == 0) {
								mShortAnimTime = getResources().getInteger(
										android.R.integer.config_shortAnimTime);
							}
							controlsView
									.animate()
									.translationY(visible ? 0 : mControlsHeight)
									.setDuration(mShortAnimTime);
						} else {
							// If the ViewPropertyAnimator APIs aren't
							// available, simply show or hide the in-layout UI
							// controls.
							controlsView.setVisibility(visible ? View.GONE
									: View.GONE);
						}

						if (visible && AUTO_HIDE) {
						}
					}
				});

		// Set up the user interaction to manually show or hide the system UI.
		contentView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
			}
		});
		new Thread(new Runnable() {
			  public void run() {
				  try {
					mp.start();
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				  if(!firstboot || cc==1){
					Intent in = new Intent(MainScreenActivity.this, HomeActivity.class);
					mp.release();
					startActivity(in);					
					finish();}
			  }
		       }).start();
	}
}
