/* Description:-Display the result for Quiz
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */


package com.example.linetest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

import com.example.ill.R;


class DrawView extends View{
	
	Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	int correct = com.example.linetest.MainActivity.correct;
	int wrong = com.example.linetest.MainActivity.wrong;
	int unanswered = com.example.linetest.MainActivity.unanswered;
	float canvas_width;
	float canvas_height;
	public DrawView(Context context){
		super(context);
	
	}
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		canvas_width=canvas.getWidth();
		canvas_height=canvas.getHeight();
		RectF rectf = new RectF(canvas.getWidth()/2+100,canvas.getHeight()/2-90, canvas.getWidth()/2+300, canvas.getHeight()/2+90);
		RectF roundF = new RectF(canvas.getWidth()/2-58,canvas.getHeight()-100, canvas.getWidth()/2+62, canvas.getHeight()-60);
		paint.setColor(Color.BLACK);
		canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), paint);
		
	//Write title
		paint.setTextSize(38);
		paint.setTextAlign(Align.CENTER);
		paint.setColor(Color.WHITE);		
		canvas.drawText("You have finished the test", canvas.getWidth()/2, 40, paint);
		
	//Display the results
		paint.setTypeface(Typeface.DEFAULT_BOLD);
		paint.setTextSize(25);
		paint.setTextAlign(Align.RIGHT);
		paint.setColor(Color.WHITE);
		canvas.drawText("Correct Answers: "+correct, 240, canvas.getHeight()/2-40, paint);
		canvas.drawText("Wrong Answers: "+wrong, 240,canvas.getHeight()/2, paint);
		canvas.drawText("Unanswered: "+unanswered, 240, canvas.getHeight()/2+40, paint);
		
	//Drawing pie-graph	
		paint.setColor(Color.GREEN);
		canvas.drawRect(260, canvas.getHeight()/2-60, 280, canvas.getHeight()/2-40, paint);
		canvas.drawArc(rectf, 0,correct*360/com.example.linetest.LaunchScreen.number_questions , true, paint);
		
		paint.setColor(Color.RED);
		canvas.drawRect(260, canvas.getHeight()/2-20, 280, canvas.getHeight()/2, paint);
		canvas.drawArc(rectf, correct*360/com.example.linetest.LaunchScreen.number_questions,wrong*360/com.example.linetest.LaunchScreen.number_questions , true, paint);
		
		paint.setColor(Color.BLUE);
		canvas.drawRect(260, canvas.getHeight()/2+20, 280, canvas.getHeight()/2+40, paint);
		canvas.drawArc(rectf,correct*360/com.example.linetest.LaunchScreen.number_questions + wrong*360/com.example.linetest.LaunchScreen.number_questions, 360-correct*360/com.example.linetest.LaunchScreen.number_questions-wrong*360/com.example.linetest.LaunchScreen.number_questions ,  true, paint);
		
	//Draw Next Button
		paint.setTypeface(Typeface.DEFAULT);
		paint.setColor(Color.WHITE);
		canvas.drawRoundRect(roundF,3,3, paint);
		paint.setTextSize(15);
		paint.setColor(Color.BLACK);
		paint.setTextAlign(Align.RIGHT);
		canvas.drawText("View Solutions",canvas.getWidth()/2+52, canvas.getHeight()-70, paint);
		
	}
	
}



public class Results extends Activity {

	
	DrawView drawview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		com.example.linetest.MainActivity.unanswered=0;
		com.example.linetest.MainActivity.wrong=0;
		com.example.linetest.MainActivity.correct=0;
		
		for(int i=0 ;i<com.example.linetest.LaunchScreen.number_questions ;i++){
			switch (com.example.linetest.MainActivity.answerState[i]){
			case 0:
				com.example.linetest.MainActivity.unanswered++;
		break;
			case	 1:
		com.example.linetest.MainActivity.correct++;
			break;
			case -1:
				com.example.linetest.MainActivity.wrong++;
		break;
			}	
		}
		

		
		drawview = new DrawView(this);
		setContentView(drawview);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.linequiz_results, menu);
		return true;
	}
	@Override
    public boolean onTouchEvent (MotionEvent event) {
		
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN : 
                if(event.getX()>drawview.canvas_width/2-58 && event.getX()<drawview.canvas_width/2+62 && event.getY()>drawview.canvas_height-110 && event.getY()<drawview.canvas_width-85){
                	Intent in = new Intent(this, Explanation.class);
                	startActivity(in);
                	
                }
                break;
        }

        return true;

    }
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();	
		finish();
	}

}
