/* Description:- Class defined for drawing the line for the given equation.
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */


package com.example.linepractice;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.ill.R;

class DrawView extends View{
	
	Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	float canvas_width;
	float canvas_height;
	float originX, originY;
	int ctr;
	float scale=(float)0.5;
	float x1,x2,x3,y1,y2,y3;
	public DrawView(Context context){
		super(context);
	
	}
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		canvas_width=canvas.getWidth();
		canvas_height=canvas.getHeight();
		
		
		x1 = com.example.linepractice.Solve.x1;
		y1 = com.example.linepractice.Solve.y1;
		x2 = com.example.linepractice.Solve.x2;
		y2 = com.example.linepractice.Solve.y2;
		x3 = com.example.linepractice.Solve.x3;
		y3 = com.example.linepractice.Solve.y3;
		
		
		canvas.scale(scale, scale, canvas.getWidth()/2, canvas.getHeight()/2);
		//HORIZONTAL LINES ABOVE X-AXIS
		ctr=1;
		for(int i =canvas.getHeight()/2-10; i >=-2000; i=i-10,ctr++)
		{
		
		if(ctr%10==0 && ctr!=0) { //Every 10th line is bold and red
			
			paint.setStrokeWidth((float) 2.0/scale);
			paint.setColor(Color.RED);
		}
		else{
			paint.setStrokeWidth((float) 1.0/scale);
			paint.setColor(Color.GREEN);			
		}
		canvas.drawLine(-2000,i,canvas.getWidth()+2000,i,paint);
		}

		
		//HORIZONTAL BELOW ABOVE X-AXIS
		ctr=1;
		for(int i =canvas.getHeight()/2+10; i <=canvas.getHeight()+2000; i=i+10,ctr++)
		{
		
		if(ctr%10==0 && ctr!=0) { //Every 10th line is bold and red
			paint.setStrokeWidth((float) 2.0/scale);
			paint.setColor(Color.RED);
		}
		else{
			paint.setColor(Color.GREEN);
			paint.setStrokeWidth((float) 1.0/scale);
		}
		canvas.drawLine(-2000,i,canvas.getWidth()+2000,i,paint);
		}

		
		//VERTICAL LINES TO RIGHT OF Y-AXIS
				ctr=1;
				for(int i =canvas.getWidth()/2+10; i <=canvas.getWidth()+2000; i=i+10,ctr++)
				{
				
				if(ctr%10==0 && ctr!=0) { //Every 10th line is bold and red
					paint.setStrokeWidth((float) 2.0/scale);
					paint.setColor(Color.RED);
				}
				else{
					paint.setColor(Color.GREEN);
					paint.setStrokeWidth((float) 1.0/scale);
				}
				canvas.drawLine(i,canvas.getHeight()-2000,i,canvas.getHeight()+2000,paint);
				}
				
		
				
				
			//VERTICAL LINES TO LEFT OF Y-AXIS
						ctr=1;
						for(int i =canvas.getWidth()/2-10; i >=-2000; i=i-10,ctr++)
						{
						
						if(ctr%10==0 && ctr!=0) { //Every 10th line is bold and red
							paint.setStrokeWidth((float) 2.0/scale);
							paint.setColor(Color.RED);
						}
						else{
							paint.setColor(Color.GREEN);
							paint.setStrokeWidth((float) 1.0/scale);
						}
						canvas.drawLine(i,canvas.getHeight()-2000,i,canvas.getHeight()+2000,paint);
						}
		
		
	//DRAW XY AXIS	
		paint.setStrokeWidth((float)3/scale);
		paint.setColor(Color.BLACK);
		canvas.drawLine(-2000,canvas.getHeight()/2,canvas.getWidth()+2000, canvas.getHeight()/2, paint);
		
		//broken y-axis
		if(com.example.linepractice.Solve.ybreak==0){
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
		if(scale<1)
			paint.setTextSize(20/scale);
		else if(scale>1)
			paint.setTextSize(20-3*scale);
		else
			paint.setTextSize(20);
		
		paint.setColor(Color.BLUE);
		canvas.drawText("(0, 0)", canvas.getWidth()/2+5, canvas.getHeight()/2-10,paint);
		
		if(scale<1)
			paint.setTextSize(16/scale);
		else if(scale>1)
			paint.setTextSize(16-3*scale);
		else
			paint.setTextSize(16);
			
		
		canvas.drawText("X-AXIS",canvas.getWidth()/2 + (canvas.getWidth()/2-originX-70)/scale,canvas.getHeight()/2-10, paint);
		canvas.drawText("Y-AXIS",canvas.getWidth()/2+10, canvas.getHeight()/2 - (canvas.getHeight()/2+originY-20)/scale, paint);
		paint.setTypeface(Typeface.DEFAULT);
		for(int i=1 ; i<30 ; i++)
		{
			canvas.drawText(i+"", canvas.getWidth()/2+100*i, canvas.getHeight()/2+15/scale, paint);
			canvas.drawText(-i+"", canvas.getWidth()/2-100*i, canvas.getHeight()/2+15/scale, paint);
			
		}
		paint.setTextAlign(Align.RIGHT);
		for(int i=(int) (1*com.example.linepractice.Solve.range), j=1 ; i<30*com.example.linepractice.Solve.range && j<30 ; i+=com.example.linepractice.Solve.range, j++)
		{		
			canvas.drawText((-i-com.example.linepractice.Solve.ybreak)+"", canvas.getWidth()/2-20/scale, canvas.getHeight()/2+100*j, paint);
			canvas.drawText((i+com.example.linepractice.Solve.ybreak)+"", canvas.getWidth()/2-20/scale, canvas.getHeight()/2-100*j, paint);
		}
		paint.setTextAlign(Align.LEFT);
		
//-----------------DRAWING LINE--------------------------------------
		float ybreak = com.example.linepractice.Solve.ybreak;
		float x11 = x1*100*scale+canvas.getWidth()/2-originX;
		float y11 = ((y1+ybreak)*-100*scale/com.example.linepractice.Solve.range+canvas.getHeight()/2-originY);
		
		float x22 = x2*100*scale+canvas.getWidth()/2-originX;
		float y22 = ((y2+ybreak)*-100*scale/com.example.linepractice.Solve.range+canvas.getHeight()/2-originY);
		
		float x33 = x3*100*scale+canvas.getWidth()/2-originX;
		float y33 = ((y3+ybreak)*-100*scale/com.example.linepractice.Solve.range+canvas.getHeight()/2-originY);
		
		Log.d("y11,y22",y11+","+y22);
		
		float a1 = canvas.getWidth()/2 + (x11-canvas.getWidth()/2+originX)/scale;
		float b1 = canvas.getHeight()/2 + (y11-canvas.getHeight()/2+originY)/scale;			

		float a2 = canvas.getWidth()/2 + (x22-canvas.getWidth()/2+originX)/scale;
		float b2 = canvas.getHeight()/2 + (y22-canvas.getHeight()/2+originY)/scale;
		
		float a3 = canvas.getWidth()/2 + (x33-canvas.getWidth()/2+originX)/scale;
		float b3 = canvas.getHeight()/2 + (y33-canvas.getHeight()/2+originY)/scale;
		
		paint.setColor(Color.BLUE);
		paint.setTextSize(30/scale);
		canvas.drawText(".", a1-3, b1, paint);
		paint.setTextSize(14/scale);
		canvas.drawText("("+x1+","+y1+")", a1, b1-10, paint);
		
		paint.setColor(Color.BLUE);
		paint.setTextSize(30/scale);
		canvas.drawText(".", a2-3, b2, paint);
		paint.setTextSize(14/scale);
		canvas.drawText("("+x2+","+y2+")", a2, b2-10, paint);
		
		paint.setColor(Color.BLUE);
		paint.setTextSize(30/scale);
		canvas.drawText(".", a2-3, b2, paint);
		paint.setTextSize(14/scale);
		canvas.drawText("("+x3+","+y3+")", a3, b3-10, paint);
		
		
		canvas.drawLine(a1, b1, a3, b3, paint);
		
}

}

public class DrawLine extends Activity {

	
	DrawView drawview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		drawview = new DrawView(this);
		setContentView(drawview);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.draw_line, menu);
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
	public void onPause(){
		super.onPause();
		finish();
	}
}
