/* Description:-To call respective html files for quiz in different modules
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */

package com.example.ill;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

public class QuizActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
			if(com.example.ill.MainActivity.var == 1) {
				pointQuiz1();
			}
			else if(com.example.ill.MainActivity.var == 2) {
				pointQuiz2();
			}else if(com.example.ill.MainActivity.var == 3) {
				scalingQuiz();
			}else if(com.example.ill.MainActivity.var == 4) {
				linequiz1();
			}else if(com.example.ill.MainActivity.var == 5) {
				lineQuiz2();
			}
	}

	private void lineQuiz2() {
		WebView webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/www/slope/slope.html");
	}

	private void linequiz1() {
		WebView webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/www/line/line.html");
	}

	private void scalingQuiz() {
		 WebView webView = (WebView) findViewById(R.id.webView1);
         webView.getSettings().setJavaScriptEnabled(true);
         webView.loadUrl("file:///android_asset/www/scaling/scalling.html");
	}

	private void pointQuiz1() {
		 WebView webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/www/point/quiz1/point1.html");
	}
	private void pointQuiz2() {
		 WebView webView = (WebView) findViewById(R.id.webView1);
       webView.getSettings().setJavaScriptEnabled(true);
       webView.loadUrl("file:///android_asset/www/point/quiz2/point2.html");
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quiz, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.refresh:
			Intent in = new Intent(QuizActivity.this, QuizActivity.class);
			startActivity(in);
			break;
		case R.id.home:
			finish();
			break;
		case R.id.scratchpad:
			Intent in3 = new Intent(QuizActivity.this, com.example.scratchpad.MainActivity.class);
			startActivity(in3);
			break;
		}
 		return true;
	}

	@Override
	protected void onPause() {
		super.onPause();
		finish();
	}
	
}
