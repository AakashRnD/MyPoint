/* Description:- MainActivity for scratchpad  
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */

package com.example.scratchpad;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ill.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		BrushView view=new BrushView(this);
        setContentView(view);
        
	}
	
	 @Override
	    protected void onPause() {
	        super.onPause();
	        finish();
	    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.scratchpad_activity_main, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.back:
			finish();
			break;
		case R.id.reset:
			com.example.scratchpad.BrushView.reset_flag=true;
			BrushView view=new BrushView(this);
	        setContentView(view);
			break;
		
		}
	
			return true;
	}
}




 