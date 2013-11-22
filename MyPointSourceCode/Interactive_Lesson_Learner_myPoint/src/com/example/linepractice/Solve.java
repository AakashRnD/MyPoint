/* Description:- Class providing the method for solving the given equation.
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */


package com.example.linepractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.ill.R;

public class Solve extends Activity {

	TextView equation,x_zero,x_one, x_two;
	String equ;
	int x,y,c;
	static float x1, x2, x3, y1, y2, y3, min, max, range, ybreak;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linepractice_activity_solve);
		
	//---------GET X,Y,C, FROM PREVIOUS ACTIVITY-----------------
		x=com.example.linepractice.MainActivity.x;
		y=com.example.linepractice.MainActivity.y;
		c=com.example.linepractice.MainActivity.c;
		
		
		String equ = x+"X + "+ y+"Y + "+c+" = 0" ; //FORM THE EQUATION
		
	//---------INITIALIZE TEXTVIEW WIDGETS------------------------
		equation = (TextView) findViewById(R.id.equation);
		x_zero = (TextView) findViewById(R.id.x_zero);
		x_one = (TextView) findViewById(R.id.x_one);
		x_two = (TextView) findViewById(R.id.x_two);
		
		equation.setText(equ);
		//----when c not 0-------
		if(c!=0){
		x_two.setVisibility(View.VISIBLE);
	//-------------------WHEN X=0---------------------
		x1=0;
		y1=(float)-c/y;
		String xzero = "<font color=blue>"+"When x = 0"+"</font>"+", "+x+"*0 + "+y+"y + "+c+" = 0,  ==> y = "+(-c)+"/"+y+" = "+"<font color = green><i>"+y1+"</i></font>";
		x_zero.setText(Html.fromHtml(xzero));
		
		
	//-------------------WHEN X=1---------------------
		
		x2=1;
		y2=(float)(-c-x)/y;
		String xone = "<font color=blue>"+"When x = 1"+"</font>"+", "+x+"*1 + "+y+"y + "+c+" = 0, ==> y = "+(-c-x)+"/"+y+" = "+"<font color = green><i>"+y2+"</i></font>";
		x_one.setText(Html.fromHtml(xone));
		

		//-------------------WHEN X=2---------------------
			
		x3=2;
		y3=(float)(-c-2*x)/y;
		String xtwo = "<font color=blue>"+"When x = 2"+"</font>"+", "+x+"*2 + "+y+"y + "+c+" = 0, ==> y = "+(-c-2*x)+"/"+y+" = "+"<font color = green><i>"+y3+"</i></font>";
		x_two.setText(Html.fromHtml(xtwo));
		
		}
		
		else{
			//-------------------WHEN X=1---------------------
			x1=1;
			y1=(float)x/y;
			String xzero = "<font color=blue>"+"When x = 1"+"</font>"+", "+y+"y = "+x+" ==> y = "+x+"/"+y+" = "+"<font color = green><i>"+y1+"</i></font>";
			x_zero.setText(Html.fromHtml(xzero));
			
			
		//-------------------WHEN Y=1---------------------
			
			y2=1;
			x2=(float)y/x;
			String yzero = "<font color=blue>"+"When y = 1"+"</font>"+", "+y+" = "+x+"x "+" ==> x = "+(y)+"/"+x+" = "+"<font color = green><i>"+x2+"</i></font>";
			x_one.setText(Html.fromHtml(yzero));
			
			x3=y3=0;
			x_two.setVisibility(View.INVISIBLE);
			
		}

//-----------------CALCULATING SCALE--------------------------------
		
		if(y1>y2){
			if(y2>y3){
				min=y3;
				max=y1;
			}
			else{
				min=y2;
				max=y1;
			}
		}
		else if(y2>y1){
				if(y1>y3){
					min=y3;
					max=y2;
				}
				else{
					min=y1;
					max=y2;
				}
		}
		else if(y3>y1){
			if(y1>y2){
				min=y2;
				max=y3;
			}
			else{
				min=y1;
				max=y3;
			}
				
		}
		
		y1=Math.round(y1*10)/10.0f;
		y2=Math.round(y2*10)/10.0f;
		y3=Math.round(y3*10)/10.0f;
		
		
		range = (float) Math.round(((max-min)/3));
		range++;
		
		range=Math.round(range*10)/10.0f;
		
		if(min>=4)ybreak=min-range;
		if(max<=-4)ybreak = -max-range;
		
		Log.d("range,break",range+","+ybreak);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.linepractice_solve, menu);
		return true;
	}
	
	public void drawline(View view){
		Intent in = new Intent(this, DrawLine.class);
		startActivity(in);
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
