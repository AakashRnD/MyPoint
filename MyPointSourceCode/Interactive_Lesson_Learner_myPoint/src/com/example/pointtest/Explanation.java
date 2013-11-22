/* Description:-Assigning explanation to the corresponding Questions of test 
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */

package com.example.pointtest;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ill.R;
import com.example.pointquiz.database.DataBaseHandler;
import com.example.pointquiz.database.Question;

public class Explanation extends Activity {

	DataBaseHandler db = new DataBaseHandler(this);
	Question q1 = new Question();
	TextView q, corr, sel, exp;
	ImageView iv;
	Button next, previous;
	int i=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pointquiz_activity_explanation);
		
		q = (TextView) findViewById(R.id.exp_q);
		corr = (TextView) findViewById(R.id.correct_ans);
		sel = (TextView) findViewById(R.id.ans_selected);
		exp = (TextView) findViewById(R.id.explanation);
		iv = (ImageView) findViewById(R.id.imageView1);
		next = (Button) findViewById(R.id.button1);
		previous = (Button) findViewById(R.id.button2);
		
		iv.getLayoutParams().height=180;
		iv.getLayoutParams().width=200;
		
		q1 = db.getQuestion(com.example.pointtest.MainActivity.id_final[i]);
		
		q.setText(q1.get_question());
		corr.setText(Html.fromHtml("<br>The correct answer is " + "<b><font color=green >" + q1.get_optiona() + "</font></b>"));
		if(com.example.pointtest.MainActivity.ansSelected[i]!=-1)
			sel.setText(Html.fromHtml("You selected: "+"<b><font color=blue>"+com.example.pointtest.MainActivity.selectedAns[i]+"</font></b>"));
		else
			sel.setText(Html.fromHtml("<font color=red>"+"You did not select an option"+"</font>"));
		exp.setText(Html.fromHtml("<i><b><br>Explanation:<br> "+"</b></i>"+q1.get_explanation()));
		
		if(i == com.example.pointtest.MainActivity.image[0]){
			iv.setVisibility(View.VISIBLE);
			iv.setImageResource(R.drawable.a1);
		}
		else if(i == com.example.pointtest.MainActivity.image[1]){
			iv.setVisibility(View.VISIBLE);
			iv.setImageResource(R.drawable.a2);
		}
		else if(i == com.example.pointtest.MainActivity.image[2]){
			iv.setVisibility(View.VISIBLE);
			iv.setImageResource(R.drawable.a3);
		}
		else if(i == com.example.pointtest.MainActivity.image[3]){
			iv.setVisibility(View.VISIBLE);
			iv.setImageResource(R.drawable.a4);
		}
		else if(i == com.example.pointtest.MainActivity.image[4]){
			iv.setVisibility(View.VISIBLE);
			iv.setImageResource(R.drawable.a6);
		}
		else
			iv.setVisibility(View.GONE);
		
		if(com.example.pointtest.LaunchScreen.number_questions==1)next.setVisibility(View.INVISIBLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pointquiz_explanation, menu);
		return true;
	}
	
	
//NEXT BUTTON--------------
	public void next(View v){
		
		if(i<com.example.pointtest.LaunchScreen.number_questions-1){		
			previous.setVisibility(View.VISIBLE);
			next.setVisibility(View.VISIBLE);
			i++;
		
		if(i==com.example.pointtest.LaunchScreen.number_questions-1)	next.setVisibility(View.INVISIBLE);
		
		q1 = db.getQuestion(com.example.pointtest.MainActivity.id_final[i]);
		q.setText(q1.get_question());		
		corr.setText(Html.fromHtml("<br>The correct answer is " + "<b><font color=green >" + q1.get_optiona() + "</font></b>"));
		
		if(com.example.pointtest.MainActivity.ansSelected[i]!=-1)
			sel.setText(Html.fromHtml("You selected: "+"<b><font color=blue>"+com.example.pointtest.MainActivity.selectedAns[i]+"</font></b>"));
		else
			sel.setText(Html.fromHtml("<font color=red>"+"You did not select an option"+"</font>"));
		exp.setText(Html.fromHtml("<i><b><br>Explanation:<br> "+"</b></i>"+q1.get_explanation()));
		
			
		if(i == com.example.pointtest.MainActivity.image[0]){
			iv.setVisibility(View.VISIBLE);
			iv.setImageResource(R.drawable.a1);
		}
		else if(i == com.example.pointtest.MainActivity.image[1]){
			iv.setVisibility(View.VISIBLE);
			iv.setImageResource(R.drawable.a2);
		}
		else if(i == com.example.pointtest.MainActivity.image[2]){
			iv.setVisibility(View.VISIBLE);
			iv.setImageResource(R.drawable.a3);
		}
		else if(i == com.example.pointtest.MainActivity.image[3]){
			iv.setVisibility(View.VISIBLE);
			iv.setImageResource(R.drawable.a4);
		}
		else if(i == com.example.pointtest.MainActivity.image[4]){
			iv.setVisibility(View.VISIBLE);
			iv.setImageResource(R.drawable.a6);
		}
		else{
			iv.setVisibility(View.GONE);
		}
		
		
		}
		else{
			next.setVisibility(View.INVISIBLE);
		}
	}
	
//PREVIOUS BUTTON--------------
public void previous(View v){
		
		if(i>0){
			previous.setVisibility(View.VISIBLE);
			next.setVisibility(View.VISIBLE);
		i--;
		if(i==0){
			previous.setVisibility(View.INVISIBLE);
			next.setVisibility(View.VISIBLE);
		}
		q1 = db.getQuestion(com.example.pointtest.MainActivity.id_final[i]);
		q.setText(q1.get_question());		
		corr.setText(Html.fromHtml("<br>The correct answer is " + "<b><font color=green >" + q1.get_optiona() + "</font></b>"));
		
		if(com.example.pointtest.MainActivity.ansSelected[i]!=-1)
			sel.setText(Html.fromHtml("You selected: "+"<b><font color=blue>"+com.example.pointtest.MainActivity.answers_final[i][com.example.pointtest.MainActivity.ansSelected[i]-1]+"</font></b>"));
		else
			sel.setText(Html.fromHtml("<font color=red>"+"You did not select an option"+"</font>"));
		exp.setText(Html.fromHtml("<i><b><br>Explanation:<br> "+"</b></i>"+q1.get_explanation()));
		
		if(i == com.example.pointtest.MainActivity.image[0]){
			iv.setVisibility(View.VISIBLE);
			iv.setImageResource(R.drawable.a1);
		}
		else if(i == com.example.pointtest.MainActivity.image[1]){
			iv.setVisibility(View.VISIBLE);
			iv.setImageResource(R.drawable.a2);
		}
		else if(i == com.example.pointtest.MainActivity.image[2]){
			iv.setVisibility(View.VISIBLE);
			iv.setImageResource(R.drawable.a3);
		}
		else if(i == com.example.pointtest.MainActivity.image[3]){
			iv.setVisibility(View.VISIBLE);
			iv.setImageResource(R.drawable.a4);
		}
		else if(i == com.example.pointtest.MainActivity.image[4]){
			iv.setVisibility(View.VISIBLE);
			iv.setImageResource(R.drawable.a6);
		}
		else{
			iv.setVisibility(View.GONE);
		}
		
		
		}
		else{
			previous.setVisibility(View.INVISIBLE);
		}
			
		
		
		
	}

	
	
}
