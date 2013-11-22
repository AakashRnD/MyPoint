/* Description:-To display the recap(animation) in Cartesian coordinates.
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */


package com.example.ill;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class AnimationActivity extends Activity {
	DemoView demoview;
    int mCount = 0;
    int mListSize = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animation);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		Paint paint = new Paint();
        paint.setColor(Color.BLUE);

        List<Coords> coordList = new ArrayList<Coords>();
        // Load up the coordinates
        for(int i=0 ; i<150; i++){
        	coordList.add(new Coords(210+i, 210));	
        }
        for(int i=0 ; i<150; i++){
        	coordList.add(new Coords(210, 210-i));	
        }
        for(int i=0 ; i<150; i++){
        	coordList.add(new Coords(210-i, 210));	
        }
        for(int i=0 ; i<150; i++){
        	coordList.add(new Coords(210, 210+i));	
        }
        for(int i=0 ; i<50; i++){
        	coordList.add(new Coords(210, 210));	
        }
        for(int i=0 ; i<50; i++){
        	coordList.add(new Coords(210, 210));	
        }
        for(int i=0 ; i<50; i++){
        	coordList.add(new Coords(210, 210));	
        }
        for(int i=0 ; i<50; i++){
        	coordList.add(new Coords(210, 210));	
        }
     
        
        
        
        
        
        mListSize = coordList.size();
        demoview = new DemoView(this, paint, coordList);
        setContentView(demoview);
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            public void run() {
                mCount++;
                demoview.postInvalidate();
                Log.d("LINES", "Timer triggered");
                if (mCount >= mListSize) {
                    Log.d("LINES", "All done, cancelling timer");
                    cancel();
                }
            }
        }, 20, 20);
	
	
	}
	 private class Coords {
	        // little class to hold the coordinates
	        float mSx; float mSy;;

	        public Coords(float sx, float sy) {
	            mSx = sx;   mSy = sy; // start/end x/y
	           
	        }
	    }
	 
	 private class DemoView extends View {

	        Paint mPaint;
	        List<Coords> mcList;
	        public DemoView(Context context, Paint paint, List<Coords> cList) {
	            super(context);
	            mPaint = paint;
	            mcList = cList;
	        }
	        @Override
	        protected void onDraw(Canvas canvas) {
	        	mPaint.setStrokeWidth(5);

	            super.onDraw(canvas);
	            int count = 0;
	            int flag=0;
	            Log.d("LINES", "mcount" + mCount);
	            for (Coords c : mcList) { // draw all the lines
	                if (count >= mCount){flag=1;
	                    break; // up to the number in mCount
	                }
	                canvas.drawPoint(c.mSx, c.mSy, mPaint);
	                
	                count++;
	            }
	            Paint painta = new Paint();
	            painta.setColor(Color.GREEN);
	            painta.setAlpha(50);
	            painta.setStrokeWidth(5);
	            canvas.drawRect(0, 0, 800, 500, painta);

	            mPaint.setTextSize(20);
	            canvas.drawText("0,0", 220,230, mPaint);
	            canvas.drawText("drawing +ve x axis", 500,100, mPaint); 
	            if (count>=150)
	          {
	           canvas.drawText("+ve x axis", 320,225, mPaint);
	           canvas.drawText("drawing +ve y axis", 500,150, mPaint); 
	          }
	            if (count>=300)
	          {
	            canvas.drawText("+ve y axis", 220,65, mPaint);
	            canvas.drawText("drawing -ve x axis", 500,200, mPaint);
	          } 
	            if (count>=450)
		          {
		           canvas.drawText("-ve x axis", 65,225, mPaint);
		           canvas.drawText("drawing -ve y axis", 500,250, mPaint);
		          }
		            if (count>=600)
		            {
		            canvas.drawText("-ve y axis", 220,360, mPaint);
		          } 
		            
		            if (count>=650)
		            {		          
		            //For quadrants
		            Paint paint1 = new Paint();
		            paint1.setColor(Color.BLUE);
		            paint1.setAlpha(50);
		            paint1.setStrokeWidth(5);
		            canvas.drawRect(211, 209, 360, 70, paint1);	
		            canvas.drawText("1st Quadrant", 230,140, mPaint);
		            canvas.drawRect(590, 110, 730, 130, paint1);
		            canvas.drawText("1st quadrant", 600,125, mPaint);
				        
		                	
		            
		            }
		            if (count>=700)
		            {
		            Paint paint2 = new Paint();
		            paint2.setColor(Color.CYAN);
		            paint2.setAlpha(50);
		            paint2.setStrokeWidth(5);
		            canvas.drawRect(209, 209, 70, 70, paint2);	
                	canvas.drawText("2nd Quadrant", 80,140, mPaint);
                	canvas.drawRect(590, 160, 730, 180, paint2);
		            canvas.drawText("2nd quadrant", 600,175, mPaint);
		           }
		            
		            if (count>=750)
		            {
		            Paint paint3 = new Paint();
		            paint3.setColor(Color.GREEN);
		            paint3.setAlpha(50);
		            paint3.setStrokeWidth(5);
		            canvas.drawRect(209, 211, 70, 360, paint3);	
                   	canvas.drawText("3rd Quadrant", 80,285, mPaint);
                   	canvas.drawRect(590, 210, 730, 230, paint3);
		            canvas.drawText("3rd quadrant", 600,225, mPaint);
                   	
		            }
		            if (count>=800)
		            {
		            Paint paint4 = new Paint();
		            paint4.setColor(Color.YELLOW);
		            paint4.setAlpha(50);
		            paint4.setStrokeWidth(5);
		            canvas.drawRect(211, 211, 360, 360, paint4);	
                    canvas.drawText("4th Quadrant", 230,285, mPaint);
                    canvas.drawRect(590, 260, 730, 280, paint4);
		            canvas.drawText("4th quadrant", 600,275, mPaint);
                    
                    canvas.drawText("0,0", 220,230, mPaint);
                    canvas.drawText("+ve x axis", 320,225, mPaint);
                    canvas.drawText("+ve y axis", 220,65, mPaint);
                    canvas.drawText("-ve x axis", 65,225, mPaint);
                    canvas.drawText("-ve y axis", 220,360, mPaint);

		             }
	        }
	    }
	
	 @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.animation, menu);
		return true;
	}
	 public void onPause() {
		 super.onPause();
		 finish();
	 }
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.refresh:
			Intent in = new Intent(AnimationActivity.this, AnimationActivity.class);
			startActivity(in);
			break;
		case R.id.home:
			Intent in2 = new Intent(AnimationActivity.this, MainActivity.class);
			startActivity(in2);
			break;
		}
 		return true;
	}
}
