/* Description:-To link respective html files to display flowchart
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */


package com.example.ill;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class PointFDMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_point_fdmain);
		if(com.example.pointfragment.MainActivity.seletion == 3) {
			WebView webView = (WebView) findViewById(R.id.webView1);
	        webView.getSettings().setJavaScriptEnabled(true);
	        webView.loadUrl("file:///android_asset/www/flow_chart/point/change_image.html");
		}
		else if(com.example.pointfragment.MainActivity.seletion == 6) {
			WebView webView = (WebView) findViewById(R.id.webView1);
	        webView.getSettings().setJavaScriptEnabled(true);
	        webView.loadUrl("file:///android_asset/www/flow_chart/line/change_image.html");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.point_fdmain, menu);
		return true;
	}

}
