/* Description:-To switch between different images in practical example and solved example 
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
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class PointActivity extends Activity implements OnGestureListener {

	
	private GestureDetector gDetector;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_point);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		gDetector = new GestureDetector(this);
		if(com.example.ill.MainActivity.pointSelect == 1)
		GenExample();
		else if(com.example.ill.MainActivity.pointSelect == 2)
				SolvedExamples();
		else if(com.example.ill.MainActivity.pointSelect == 3) {
			/*Gen example of scaling*/
			GenExampleScaling();
		}else if(com.example.ill.MainActivity.pointSelect == 4) {
			/*Solved of scaling*/
			SolvedExampleScaling();
		}else if(com.example.ill.MainActivity.pointSelect == 5) {
			/*Gen Example of line*/
			//GenExampleLine();
		}
		else if(com.example.ill.MainActivity.pointSelect == 6) {
			/*Solved Example of line*/
			SolvedExampleLine();
		}
	}
	int count = 0;
	private void SolvedExampleLine() {
		final RelativeLayout rl = (RelativeLayout)findViewById(R.id.relativelayout);
		rl.setBackgroundResource(R.drawable.linesolve1eg);
		final Button btn = (Button)findViewById(R.id.button_point_next);
		final Button btn2 = (Button)findViewById(R.id.button_point_prev);
		btn.setBackgroundResource(R.drawable.next);
		btn2.setBackgroundResource(R.drawable.previous);
		//		Button btn3=(Button)findViewById(R.id.button1);
		//btn3.setVisibility(View.INVISIBLE);
		count=0;
		btn.setVisibility(View.INVISIBLE);
		if(count==0){
			btn2.setVisibility(View.INVISIBLE);
		}
		btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(count == 0) {
			//		ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.linesolve1egsol);	
					count++;
				}
				else 
				if(count == 1) {
			//		ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.linesolve2eg);
					count++;
				}
				else if(count == 2) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.linesolve2egsol);
					count++;
				}
				if(count!=0 && count <3){
					btn.setVisibility(View.INVISIBLE);
					btn2.setVisibility(View.INVISIBLE);
				}
				if(count==3){
					btn.setVisibility(View.INVISIBLE);
				}
			}
		});
		
		btn2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(count == 1) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.linesolve1eg);	
					count--;
				}
				else 
				if(count == 2) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.linesolve1egsol);
					count--;
				}
				else if(count == 3) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.linesolve2eg);
					count--;
				}
				if(count==0){
					btn2.setVisibility(View.INVISIBLE);
				}
				else{
					btn.setVisibility(View.INVISIBLE);
					btn2.setVisibility(View.INVISIBLE);
				}
				
			}
		});
	}
	private void SolvedExampleScaling() {
		final RelativeLayout rl = (RelativeLayout)findViewById(R.id.relativelayout);
		rl.setBackgroundResource(R.drawable.scalingsolved1eg);
		final Button btn = (Button)findViewById(R.id.button_point_next);
		final Button btn2 = (Button)findViewById(R.id.button_point_prev);
		//Button btn3=(Button)findViewById(R.id.button1);
		//btn3.setVisibility(View.INVISIBLE);
		btn.setBackgroundResource(R.drawable.next);
		btn2.setBackgroundResource(R.drawable.previous);
		count=0;
		btn.setVisibility(View.INVISIBLE);
		if(count==0){
			btn2.setVisibility(View.INVISIBLE);
		}
		btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(count == 0) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.scalingsolved1egsol);	
					count++;
				}
				else 
				if(count == 1) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.scalingsolved2eg);
					count++;
				}
				else if(count == 2) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.scalingsolved2egsol);
					count++;
				}
				if(count!=0 && count <3){
					btn.setVisibility(View.INVISIBLE);
					btn2.setVisibility(View.INVISIBLE);
				}
				if(count==3){
					btn.setVisibility(View.INVISIBLE);
				}			
			}
		});
		
		btn2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(count == 1) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.scalingsolved1eg);	
					count--;
				}
				else 
				if(count == 2) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.scalingsolved1egsol);
					count--;
				}
				else if(count == 3) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.scalingsolved2eg);
					count--;
				}
				if(count==0){
					btn2.setVisibility(View.INVISIBLE);
				}
				else{
					btn.setVisibility(View.INVISIBLE);
					btn2.setVisibility(View.INVISIBLE);
				}
			}
		});
	}
	private void GenExampleScaling() {

		final RelativeLayout rl = (RelativeLayout)findViewById(R.id.relativelayout);
		rl.setBackgroundResource(R.drawable.genexample10);
		final Button btn = (Button)findViewById(R.id.button_point_next);
		final Button btn2 = (Button)findViewById(R.id.button_point_prev);
		btn.setBackgroundResource(R.drawable.next1);
		btn2.setBackgroundResource(R.drawable.prev1);
		//final Button btn3=(Button)findViewById(R.id.button1);
		//btn3.setBackgroundResource(R.drawable.roundshapebtn);
		count=0;
		btn.setVisibility(View.INVISIBLE);	
		//btn3.setVisibility(View.INVISIBLE);
		//btn3.setText("Go to Explanation");
		if(count==0){
			btn2.setVisibility(View.INVISIBLE);
		}
		btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(count == 0) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.genexample11);	
					count++;
				}
				else 
				if(count == 1) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.genexample12);
					count++;
				}
				else if(count == 2) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.genexample13);
					count++;
				}
				else if(count == 3) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.genexample20);
					count++;
				}
				else if(count == 4) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.genexample21);
					count++;
				}
				else if(count == 5) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.genexample22);
					count++;
				}
				else if(count == 6) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.genexample23);
					count++;
				}
				if(count!=0 && count <7){
					btn.setVisibility(View.INVISIBLE);
					btn2.setVisibility(View.INVISIBLE);
			//		btn3.setVisibility(View.INVISIBLE);
				}
				if(count==7){
					btn.setVisibility(View.INVISIBLE);
				//	btn3.setVisibility(View.VISIBLE);
				}
			}
		});
		
		
		btn2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(count == 1) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.genexample10);	
					count--;
				}
				else 
				if(count == 2) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.genexample11);
					count--;
				}
				else if(count == 3) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.genexample12);
					count--;
				}
				else if(count == 4) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.genexample13);
					count--;
				}
				else if(count == 5) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.genexample20);
					count--;
				}
				else if(count == 6) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.genexample21);
					count--;
				}
				else if(count == 7) {
					//ImageView im =(ImageView)findViewById(R.id.imageView1);
					rl.setBackgroundResource(R.drawable.genexample22);
					count--;
				}
				
				if(count==0){
					btn2.setVisibility(View.INVISIBLE);
				}
				else{
					btn.setVisibility(View.INVISIBLE);
					btn2.setVisibility(View.INVISIBLE);
					//btn3.setVisibility(View.INVISIBLE);
				}
			}
		});
	}
	public void GenExample() {
		final RelativeLayout rl = (RelativeLayout)findViewById(R.id.relativelayout);
		rl.setBackgroundResource(R.drawable.genexample1);
		final Button btn = (Button)findViewById(R.id.button_point_next);
		final Button btn2 = (Button)findViewById(R.id.button_point_prev);
		btn.setBackgroundResource(R.drawable.next1);
		btn2.setBackgroundResource(R.drawable.prev1);
		count=0;
		btn.setVisibility(View.INVISIBLE);
		if(count==0){
			btn2.setVisibility(View.INVISIBLE);
		}
		btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(count == 0) {
					rl.setBackgroundResource(R.drawable.genexample2);	
					count++;
				}
				else 
				if(count == 1) {
					rl.setBackgroundResource(R.drawable.genexample3);
					count++;
				}
				else if(count == 2) {
					rl.setBackgroundResource(R.drawable.genexample4);
					count++;
				}
				else if(count == 3) {
					rl.setBackgroundResource(R.drawable.genexample5);
					count++;
				}
				if(count!=0 && count <4){
					btn.setVisibility(View.INVISIBLE);
					btn2.setVisibility(View.INVISIBLE);
				}
				if(count==4){
					btn.setVisibility(View.INVISIBLE);
				}
				
			}
		});
		btn2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(count == 1) {
					rl.setBackgroundResource(R.drawable.genexample1);	
					count--;
				}
				else 
				if(count == 2) {
					rl.setBackgroundResource(R.drawable.genexample2);
					count--;
				}
				else if(count == 3) {
					rl.setBackgroundResource(R.drawable.genexample3);
					count--;
				}
				else if(count == 4) {
					rl.setBackgroundResource(R.drawable.genexample4);
					count--;
				}
				if(count==0){
					btn2.setVisibility(View.INVISIBLE);
				}
				else{
					btn.setVisibility(View.INVISIBLE);
					btn2.setVisibility(View.INVISIBLE);
				}
			}
		});
		
	}
	public void SolvedExamples() {	
		//count  = 0;
		final RelativeLayout rl = (RelativeLayout)findViewById(R.id.relativelayout);
		rl.setBackgroundResource(R.drawable.solvedex1);
		count=0;
		final Button btn = (Button) findViewById(R.id.button_point_next);
		final Button btn2 = (Button) findViewById(R.id.button_point_prev);
		btn.setBackgroundResource(R.drawable.next);
		btn2.setBackgroundResource(R.drawable.previous);
		btn.setVisibility(View.INVISIBLE);
		if(count==0){
			btn2.setVisibility(View.INVISIBLE);
		}
		btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(count == 0) {
					rl.setBackgroundResource(R.drawable.solvedex1sol);	
					count++;
				}
				else if(count == 1) {
					rl.setBackgroundResource(R.drawable.solvedex2);
					count++;
				}
				else if(count == 2) {
						rl.setBackgroundResource(R.drawable.solvedex2sol);
						count++;
				}
				else if(count == 3) {
							rl.setBackgroundResource(R.drawable.solvedex3);
							count++;
				}
				else if(count == 4) {
						rl.setBackgroundResource(R.drawable.solvedex3sol);
						count++;
				}
				else if(count == 5) {
						rl.setBackgroundResource(R.drawable.solvedex4);
						count++;
				}
				else if(count == 6) {
						rl.setBackgroundResource(R.drawable.solvedex4sol);
						count++;
				}
				if(count!=0 && count <7){
					btn.setVisibility(View.INVISIBLE);
					btn2.setVisibility(View.INVISIBLE);
				}
				if(count==7){
					btn.setVisibility(View.INVISIBLE);
				}	
			}
		});
	
		
		btn2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(count == 1) {
					rl.setBackgroundResource(R.drawable.solvedex1);
					count--;
				}
				else if(count == 2) {
					rl.setBackgroundResource(R.drawable.solvedex1sol);
					count--;
				}
				else if(count ==3) {
						rl.setBackgroundResource(R.drawable.solvedex2);
						count--;
				}
				else if(count == 4) {
							//ImageView im =(ImageView)findViewById(R.id.imageView1);
							rl.setBackgroundResource(R.drawable.solvedex2sol);
							count--;
				}
				else if(count == 5) {
						//ImageView im =(ImageView)findViewById(R.id.imageView1);
						rl.setBackgroundResource(R.drawable.solvedex3);
						count--;
				}
				else if(count == 6) {
						//ImageView im =(ImageView)findViewById(R.id.imageView1);
						rl.setBackgroundResource(R.drawable.solvedex3sol);
						count--;
				}
				else if(count == 7) {
						//ImageView im =(ImageView)findViewById(R.id.imageView1);
						rl.setBackgroundResource(R.drawable.solvedex4);
						count--;
				}
				if(count==0){
					btn2.setVisibility(View.INVISIBLE);
				}
				else{
					btn.setVisibility(View.INVISIBLE);
					btn2.setVisibility(View.INVISIBLE);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.point, menu);
		return true;
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
	protected void onPause() {
		super.onPause();
		finish();
	}
	
	
	@Override
	  public boolean onTouchEvent(MotionEvent event) {
	   
		
		return gDetector.onTouchEvent(event);
		
	}
	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		Button b1 = (Button) findViewById(R.id.button_point_next);
		Button b2 = (Button) findViewById(R.id.button_point_prev);
		
		if(e1.getX() - e2.getX() > 0 ) {
			b1.performClick();
		}
		
		else if(e2.getX() - e1.getX() > 0 ) {
			b2.performClick();
		}
		
		return true;
	}
	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
