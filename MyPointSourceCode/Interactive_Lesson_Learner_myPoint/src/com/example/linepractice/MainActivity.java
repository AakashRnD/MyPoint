/* Description:- To get inputs for equation of line in practice.
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */

package com.example.linepractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ill.R;

public class MainActivity extends Activity {

	static int x,y,c;
	EditText x_input, y_input, constant_input;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linepractice_activity_main);
		x_input = (EditText) findViewById(R.id.x_input);
		y_input = (EditText) findViewById(R.id.y_input);
		constant_input = (EditText) findViewById(R.id.constant_input);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.linepractice_main, menu);
		return true;
	}
	
	public void start(View view){
		
		if(x_input.getText().toString().equals("") || y_input.getText().toString().equals("") || constant_input.getText().toString().equals("")){
			Toast.makeText(this, "Fill in all fields", Toast.LENGTH_SHORT).show();
		}
		else{
			x=Integer.parseInt(x_input.getText().toString());
			y=Integer.parseInt(y_input.getText().toString());
			c=Integer.parseInt(constant_input.getText().toString());
			Intent in = new Intent(this, Solve.class);
			startActivity(in);
		}
	}
	
	
	@Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    
	    case R.id.home:
	    	finish();
			break;    
	    }
	    return true;
	}
	
	@Override
	public void onPause(){
		super.onPause();
		finish();
	}
	

}
