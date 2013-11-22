/* Description:- To display the graph of scaling practice 
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */

package com.example.scalingpractice.view.viewgroup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.example.ill.R;


public class DrawView extends View implements OnGestureListener{

//------VARIABLES USED-----------------	
	int y,x, ctr=0;
	float eventX = 0, eventY = 0, prevX=0, prevY=0,prevA=0, prevB=0;
	Paint paint = new Paint();
	float originX, originY;
	boolean moving=false,touched=false,new_touch=false;;
	public String b,l;
	private GestureDetector gDetector;
	EditText x_input,y_input;
	float canvas_width,canvas_height;
	

//------CONSTRUCTORS FOR CLASS----------------	
	@SuppressWarnings("deprecation")
	public DrawView(Context context){
		super(context);
		
		y=0;
		x=0;
		gDetector = new GestureDetector(this);
		x_input = (EditText) findViewById(R.id.x_edit);
		y_input = (EditText) findViewById(R.id.y_edit);
		
	}
	
	
	@SuppressWarnings("deprecation")
	public DrawView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        y=0;
		x=0;
		gDetector = new GestureDetector(this);
		x_input = (EditText) findViewById(R.id.x_edit);
		y_input = (EditText) findViewById(R.id.y_edit);
	    
    }
    @SuppressWarnings("deprecation")
	public DrawView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        y=0;
		x=0;
		gDetector = new GestureDetector(this);
		x_input = (EditText) findViewById(R.id.x_edit);
		y_input = (EditText) findViewById(R.id.y_edit);
		
    }
	
	
	
	
	
//----------ON DRAW FUNCTION--------------------	
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
				
		canvas_width=canvas.getWidth();
		canvas_height=canvas.getHeight();
//translate graph if moving		
		if(moving){
			
		canvas.translate(eventX-canvas.getWidth()/2,eventY-canvas.getHeight()/2);
		originX = eventX-canvas.getWidth()/2;
		originY=eventY-canvas.getHeight()/2;
		}
		
		else
			canvas.translate(originX, originY);
		
//scale graph based on scale value of seekbar		
		canvas.scale(com.example.scalingpractice.SampleActivity.scale, com.example.scalingpractice.SampleActivity.scale, canvas.getWidth()/2, canvas.getHeight()/2);
		
		
		
		
	
		//HORIZONTAL LINES ABOVE X-AXIS
		ctr=1;
		for(int i =canvas.getHeight()/2-10; i >=-2000; i=i-10,ctr++)
		{
		
		if(ctr%10==0 && ctr!=0) { //Every 10th line is bold and red
			
			paint.setStrokeWidth((float) 2.0/com.example.scalingpractice.SampleActivity.scale);
			paint.setColor(Color.RED);
		}
		else{
			paint.setStrokeWidth((float) 1.0/com.example.scalingpractice.SampleActivity.scale);
			paint.setColor(Color.GREEN);			
		}
		canvas.drawLine(-2000,i,canvas.getWidth()+2000,i,paint);
		}

		
		//HORIZONTAL BELOW ABOVE X-AXIS
		ctr=1;
		for(int i =canvas.getHeight()/2+10; i <=canvas.getHeight()+2000; i=i+10,ctr++)
		{
		
		if(ctr%10==0 && ctr!=0) { //Every 10th line is bold and red
			paint.setStrokeWidth((float) 2.0/com.example.scalingpractice.SampleActivity.scale);
			paint.setColor(Color.RED);
		}
		else{
			paint.setColor(Color.GREEN);
			paint.setStrokeWidth((float) 1.0/com.example.scalingpractice.SampleActivity.scale);
		}
		canvas.drawLine(-2000,i,canvas.getWidth()+2000,i,paint);
		}

		
		//VERTICAL LINES TO RIGHT OF Y-AXIS
				ctr=1;
				for(int i =canvas.getWidth()/2+10; i <=canvas.getWidth()+2000; i=i+10,ctr++)
				{
				
				if(ctr%10==0 && ctr!=0) { //Every 10th line is bold and red
					paint.setStrokeWidth((float) 2.0/com.example.scalingpractice.SampleActivity.scale);
					paint.setColor(Color.RED);
				}
				else{
					paint.setColor(Color.GREEN);
					paint.setStrokeWidth((float) 1.0/com.example.scalingpractice.SampleActivity.scale);
				}
				canvas.drawLine(i,canvas.getHeight()-2000,i,canvas.getHeight()+2000,paint);
				}
				
		
				
				
			//VERTICAL LINES TO LEFT OF Y-AXIS
						ctr=1;
						for(int i =canvas.getWidth()/2-10; i >=-2000; i=i-10,ctr++)
						{
						
						if(ctr%10==0 && ctr!=0) { //Every 10th line is bold and red
							paint.setStrokeWidth((float) 2.0/com.example.scalingpractice.SampleActivity.scale);
							paint.setColor(Color.RED);
						}
						else{
							paint.setColor(Color.GREEN);
							paint.setStrokeWidth((float) 1.0/com.example.scalingpractice.SampleActivity.scale);
						}
						canvas.drawLine(i,canvas.getHeight()-2000,i,canvas.getHeight()+2000,paint);
						}
		
		
	//DRAW XY AXIS	
		paint.setStrokeWidth((float)3/com.example.scalingpractice.SampleActivity.scale);
		paint.setColor(Color.BLACK);

			//broken x-axis
			if(com.example.scalingpractice.SampleActivity.x_break_value==0){
				canvas.drawLine(-2000,canvas.getHeight()/2,canvas.getWidth()+2000, canvas.getHeight()/2, paint);
			}
			else{
			canvas.drawLine(-2000,canvas.getHeight()/2,canvas.getWidth()/2-100, canvas.getHeight()/2, paint);
			canvas.drawLine(canvas.getWidth()/2+100,canvas.getHeight()/2,canvas.getWidth()+2000, canvas.getHeight()/2, paint);
			
			canvas.drawLine(canvas.getWidth()/2, canvas.getHeight()/2, canvas.getWidth()/2+66, canvas.getHeight()/2+10, paint);
			canvas.drawLine(canvas.getWidth()/2+66, canvas.getHeight()/2+10, canvas.getWidth()/2+33, canvas.getHeight()/2-10, paint);
			canvas.drawLine(canvas.getWidth()/2+33, canvas.getHeight()/2-10, canvas.getWidth()/2+100, canvas.getHeight()/2, paint);

			canvas.drawLine(canvas.getWidth()/2, canvas.getHeight()/2, canvas.getWidth()/2-66, canvas.getHeight()/2+10, paint);
			canvas.drawLine(canvas.getWidth()/2-66, canvas.getHeight()/2+10, canvas.getWidth()/2-33, canvas.getHeight()/2-10, paint);
			canvas.drawLine(canvas.getWidth()/2-33, canvas.getHeight()/2-10, canvas.getWidth()/2-100, canvas.getHeight()/2, paint);
			}
			
			//broken y-axis
			if(com.example.scalingpractice.SampleActivity.y_break_value==0){
				canvas.drawLine(canvas.getWidth()/2,-2000, canvas.getWidth()/2, canvas.getHeight()+2000, paint);
			}
			else{
			canvas.drawLine(canvas.getWidth()/2,-2000, canvas.getWidth()/2, canvas.getHeight()/2-100, paint);
			canvas.drawLine(canvas.getWidth()/2,canvas.getHeight()/2+100, canvas.getWidth()/2, canvas.getHeight()+2000, paint);
			
			canvas.drawLine(canvas.getWidth()/2, canvas.getHeight()/2, canvas.getWidth()/2-10, canvas.getHeight()/2-66, paint);
			canvas.drawLine(canvas.getWidth()/2-10, canvas.getHeight()/2-66, canvas.getWidth()/2+10, canvas.getHeight()/2-33, paint);
			canvas.drawLine(canvas.getWidth()/2+10, canvas.getHeight()/2-33, canvas.getWidth()/2, canvas.getHeight()/2-100, paint);
			
			canvas.drawLine(canvas.getWidth()/2, canvas.getHeight()/2, canvas.getWidth()/2-10, canvas.getHeight()/2+66, paint);
			canvas.drawLine(canvas.getWidth()/2-10, canvas.getHeight()/2+66, canvas.getWidth()/2+10, canvas.getHeight()/2+33, paint);
			canvas.drawLine(canvas.getWidth()/2+10, canvas.getHeight()/2+33, canvas.getWidth()/2, canvas.getHeight()/2+100, paint);

			}
			
		
				
//WRITING AXIS NAMES AND NUMBERS ON THE LINE
		
		paint.setTypeface(Typeface.DEFAULT_BOLD);
		if(com.example.scalingpractice.SampleActivity.scale<1)
			paint.setTextSize(20/com.example.scalingpractice.SampleActivity.scale);
		else if(com.example.scalingpractice.SampleActivity.scale>1)
			paint.setTextSize(20-3*com.example.scalingpractice.SampleActivity.scale);
		else
			paint.setTextSize(20);
		
		paint.setColor(Color.BLUE);
		if(com.example.scalingpractice.SampleActivity.breaking==false)
		canvas.drawText("(0, 0)", canvas.getWidth()/2+5, canvas.getHeight()/2-10,paint);
		
		if(com.example.scalingpractice.SampleActivity.scale<1)
			paint.setTextSize(16/com.example.scalingpractice.SampleActivity.scale);
		else if(com.example.scalingpractice.SampleActivity.scale>1)
			paint.setTextSize(16-3*com.example.scalingpractice.SampleActivity.scale);
		else
			paint.setTextSize(16);
			
		
		canvas.drawText("X-AXIS",canvas.getWidth()/2 + (canvas.getWidth()/2-originX-70)/com.example.scalingpractice.SampleActivity.scale,canvas.getHeight()/2-10, paint);
		canvas.drawText("Y-AXIS",canvas.getWidth()/2+10, canvas.getHeight()/2 - (canvas.getHeight()/2+originY-20)/com.example.scalingpractice.SampleActivity.scale, paint);
		paint.setTypeface(Typeface.DEFAULT);
		paint.setTextAlign(Align.RIGHT);
		
//WRITING NUMBERS ON THE AXES		
		if(com.example.scalingpractice.SampleActivity.x_break_value==0){
		for(int i=1*com.example.scalingpractice.SampleActivity.x_value, j=1 ; i<30*com.example.scalingpractice.SampleActivity.x_value && j<30 ; i+=com.example.scalingpractice.SampleActivity.x_value, j++)
		{
			canvas.drawText((i+com.example.scalingpractice.SampleActivity.x_break_value)+"", canvas.getWidth()/2+100*j, canvas.getHeight()/2+15/com.example.scalingpractice.SampleActivity.scale, paint);
			canvas.drawText((-i-com.example.scalingpractice.SampleActivity.x_break_value)+"", canvas.getWidth()/2-100*j, canvas.getHeight()/2+15/com.example.scalingpractice.SampleActivity.scale, paint);
		}
		}
		else{

			canvas.drawText((com.example.scalingpractice.SampleActivity.x_break_value)+"", canvas.getWidth()/2+100, canvas.getHeight()/2+15/com.example.scalingpractice.SampleActivity.scale, paint);
			canvas.drawText((-com.example.scalingpractice.SampleActivity.x_break_value)+"", canvas.getWidth()/2-100, canvas.getHeight()/2+15/com.example.scalingpractice.SampleActivity.scale, paint);

			
			for(int i=1*com.example.scalingpractice.SampleActivity.x_value, j=2 ; i<30*com.example.scalingpractice.SampleActivity.x_value && j<30 ; i+=com.example.scalingpractice.SampleActivity.x_value, j++)
			{
				canvas.drawText((i+com.example.scalingpractice.SampleActivity.x_break_value)+"", canvas.getWidth()/2+100*j, canvas.getHeight()/2+15/com.example.scalingpractice.SampleActivity.scale, paint);
				canvas.drawText((-i-com.example.scalingpractice.SampleActivity.x_break_value)+"", canvas.getWidth()/2-100*j, canvas.getHeight()/2+15/com.example.scalingpractice.SampleActivity.scale, paint);
			}
			
		}
		
		if(com.example.scalingpractice.SampleActivity.y_break_value==0){
		for(int i=1*com.example.scalingpractice.SampleActivity.y_value, j=1 ; i<30*com.example.scalingpractice.SampleActivity.y_value && j<30 ; i+=com.example.scalingpractice.SampleActivity.y_value, j++)
		{		
			canvas.drawText((-i-com.example.scalingpractice.SampleActivity.y_break_value)+"", canvas.getWidth()/2-20/com.example.scalingpractice.SampleActivity.scale, canvas.getHeight()/2+100*j, paint);
			canvas.drawText((i+com.example.scalingpractice.SampleActivity.y_break_value)+"", canvas.getWidth()/2-20/com.example.scalingpractice.SampleActivity.scale, canvas.getHeight()/2-100*j, paint);
		}
		}
		else{
				
			canvas.drawText((-com.example.scalingpractice.SampleActivity.y_break_value)+"", canvas.getWidth()/2-20/com.example.scalingpractice.SampleActivity.scale, canvas.getHeight()/2+100, paint);
			canvas.drawText((com.example.scalingpractice.SampleActivity.y_break_value)+"", canvas.getWidth()/2-20/com.example.scalingpractice.SampleActivity.scale, canvas.getHeight()/2-100, paint);
			
			for(int i=1*com.example.scalingpractice.SampleActivity.y_value, j=2 ; i<30*com.example.scalingpractice.SampleActivity.y_value && j<30 ; i+=com.example.scalingpractice.SampleActivity.y_value, j++)
			{		
				canvas.drawText((-i-com.example.scalingpractice.SampleActivity.y_break_value)+"", canvas.getWidth()/2-20/com.example.scalingpractice.SampleActivity.scale, canvas.getHeight()/2+100*j, paint);
				canvas.drawText((i+com.example.scalingpractice.SampleActivity.y_break_value)+"", canvas.getWidth()/2-20/com.example.scalingpractice.SampleActivity.scale, canvas.getHeight()/2-100*j, paint);
			}
			
			
		}

		
		paint.setTextAlign(Align.LEFT);
		
		
//------------PLOTTING A POINT ON TAP-------------------------------
			if(touched==true){
			float x,y,a,b;	
		//calculate value to print
			float scale = com.example.scalingpractice.SampleActivity.scale;
			if(new_touch==true){
			x = (eventX-canvas.getWidth()/2-originX)/100/scale*com.example.scalingpractice.SampleActivity.x_value;
			y = (eventY - canvas.getHeight()/2-originY)/100*-1/scale*com.example.scalingpractice.SampleActivity.y_value;
			
			if(x>0)
				x = Math.round(x*10)/10.0f+com.example.scalingpractice.SampleActivity.x_break_value;
			else
				x = Math.round(x*10)/10.0f-com.example.scalingpractice.SampleActivity.x_break_value;
			if(y>0)
				y = Math.round(y*10)/10.0f+com.example.scalingpractice.SampleActivity.y_break_value;
			else
				y = Math.round(y*10)/10.0f-com.example.scalingpractice.SampleActivity.y_break_value;
			
			
			if(x>0 && com.example.scalingpractice.SampleActivity.x_break_value!=0)
				x = Math.round(x*10)/10.0f-com.example.scalingpractice.SampleActivity.x_value;
			else if(x<0 && com.example.scalingpractice.SampleActivity.x_break_value!=0)
				x = Math.round(x*10)/10.0f+com.example.scalingpractice.SampleActivity.x_value;
			if(y>0 && com.example.scalingpractice.SampleActivity.y_break_value!=0)
				y = Math.round(y*10)/10.0f-com.example.scalingpractice.SampleActivity.y_value;
			else if(y<0 && com.example.scalingpractice.SampleActivity.y_break_value!=0)
				y = Math.round(y*10)/10.0f+com.example.scalingpractice.SampleActivity.y_value;
			
			
			prevX=x;
			prevY=y;
			}
			else{
				x=prevX;
				y=prevY;
			}
			
			paint.setTextSize(18/scale);
			paint.setColor(Color.BLUE);
			
		//calculate position of text
			if(new_touch==true){
			a = canvas.getWidth()/2 + (eventX-canvas.getWidth()/2-originX)/scale;
			b = canvas.getHeight()/2 + (eventY-canvas.getHeight()/2-originY)/scale;
			prevA=a;
			prevB=b;
			}
			else{
			
				a=prevA;
				b=prevB;
			}
			
			y = Math.round(y*10)/10.0f;
			x = Math.round(x*10)/10.0f;
			
			Log.d("ab",a+","+b);
			if(x!=0 && y!=0){
			paint.setTextSize(30/scale);
			canvas.drawText(".", a-3, b, paint);
			paint.setTextSize(18/scale);
			canvas.drawText("("+x+","+y+")", a, b-10/scale, paint);
}
			
			touched=false;
			paint.setColor(Color.BLACK);
			
		}

			
//-------------PLOTTING A POINT BASED ON INPUT----------------------------------			
	/*		if(com.example.scalingpractice.SampleActivity.plotting==true){
				
			float x = com.example.scalingpractice.SampleActivity.x_value;
			float y = com.example.scalingpractice.SampleActivity.y_value;
			float scale = com.example.scalingpractice.SampleActivity.scale;
			
			float x1 = x*100*scale+canvas.getWidth()/2-originX;
			float y1 = (y*-100*scale+canvas.getHeight()/2-originY);

			float a = canvas.getWidth()/2 + (x1-canvas.getWidth()/2+originX)/scale;
			float b = canvas.getHeight()/2 + (y1-canvas.getHeight()/2+originY)/scale;			
			
			
			
			paint.setColor(Color.BLUE);
			paint.setTextSize(30/scale);
			canvas.drawText(".", a-3, b, paint);
			paint.setTextSize(18/scale);
			canvas.drawText("("+x+","+y+")", a, b-10, paint);
			
			
			
			}
		*/	
			
			if(com.example.scalingpractice.SampleActivity.getReset()==true){
				
				com.example.scalingpractice.SampleActivity.scale=(float)1.0;
				originX=0;originY=0;
				eventX=0;eventY=0;
				moving=false;
				com.example.scalingpractice.SampleActivity.setReset(false);
				com.example.scalingpractice.SampleActivity.plotting=false;
				invalidate();	
			}
			
			invalidate();
			touched=true;
			new_touch=false;
			
	}
	
//---------------------------------------------------------------------
	
	@Override
	  public boolean onTouchEvent(MotionEvent event) {
	   
		
		return gDetector.onTouchEvent(event);
		
/*		eventX = event.getX();
		eventY = event.getY();
		
		switch (event.getAction()) {
	    case MotionEvent.ACTION_DOWN:
	    	moving=false;
	    	return true;
	    case MotionEvent.ACTION_MOVE:
	    	moving=true;
	    	invalidate();
	      return true;
	    case MotionEvent.ACTION_UP:
	      // nothing to do
	      break;
	    default:
	      return false;
	    }

	    // Schedules a repaint.
	    invalidate();
	    return true;*/
	  }

//-------------------GESTURE FUNCTIONS------------------------
	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		moving=false;
		
		return true;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override//USED TO TRANSLATE
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		
		float a = canvas_width/2 + (e1.getX()-canvas_width/2-originX)/com.example.scalingpractice.SampleActivity.scale;
		float b = canvas_height/2 + (e1.getY()-canvas_height/2-originY)/com.example.scalingpractice.SampleActivity.scale;
		
		if((a>=canvas_width/2-50 && a<=canvas_width/2+50) && (b>=canvas_height/2-50 && b<=canvas_height/2+50) || moving==true){
		
		moving=true;		
		eventX=e2.getX();
		eventY=e2.getY();
		}
		else
			moving=false;
		
		invalidate();
		return true;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override//USED TO PLOT POINT
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		eventX = e.getX();
		eventY = e.getY();
		new_touch=true;
		touched=true;
		invalidate();
		return true;
	}
}