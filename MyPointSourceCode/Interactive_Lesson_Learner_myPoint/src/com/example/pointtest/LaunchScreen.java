/* Description:- Start screen of point test 
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */


package com.example.pointtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ill.R;

public class LaunchScreen extends Activity {

	EditText no_of_questions;
	Button start;
	static int number_questions;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pointquiz_activity_launch_screen);
		no_of_questions  = (EditText) findViewById(R.id.no_of_questions);
		start = (Button) findViewById(R.id.start);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pointquiz_launch_screen, menu);
		return true;
	}
	
	public void start(View view){
		if(no_of_questions.getText().toString().equals("")==false){
			number_questions=Integer.parseInt(no_of_questions.getText().toString());
			
		  if(number_questions>=1 && number_questions<=10){
			Intent in = new Intent(this, com.example.pointtest.MainActivity.class);
			startActivity(in);
		  }
		  else{
			  Toast.makeText(this, "Enter a number between 1 and 10", Toast.LENGTH_SHORT).show();
			  no_of_questions.setText("");
		  }
		 }
		
		  else{
			  Toast.makeText(this, "Enter a number between 1 and 10", Toast.LENGTH_SHORT).show();
			  no_of_questions.setText("");
		  }
		  		
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		finish();
	}
}
