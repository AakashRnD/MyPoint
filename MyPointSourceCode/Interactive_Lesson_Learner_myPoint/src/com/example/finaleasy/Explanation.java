/* Description:-Assigning corresponding explanation to the Questions of test 
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */

package com.example.finaleasy;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ill.R;
import com.example.linequiz.database.DataBaseHandler;
import com.example.linequiz.database.Question;

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
		setContentView(R.layout.finaleasy_activity_explanation);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		q = (TextView) findViewById(R.id.exp_q);
		corr = (TextView) findViewById(R.id.correct_ans);
		sel = (TextView) findViewById(R.id.ans_selected);
		exp = (TextView) findViewById(R.id.explanation);
		next = (Button) findViewById(R.id.button1);
		previous = (Button) findViewById(R.id.button2);
		
		q1 = db.getQuestion(com.example.finaleasy.MainActivity.id_final[i]);
		
		q.setText(q1.get_question());
		corr.setText(Html.fromHtml("<br>The correct answer is " + "<b><font color=green >" + q1.get_optiona() + "</font></b>"));
		if(com.example.finaleasy.MainActivity.ansSelected[i]!=-1)
			sel.setText(Html.fromHtml("You selected: "+"<b><font color=blue>"+com.example.finaleasy.MainActivity.selectedAns[i]+"</font></b>"));
		else
			sel.setText(Html.fromHtml("<font color=red>"+"You did not select an option"+"</font>"));
		exp.setText(Html.fromHtml("<i><b><br>Explanation:<br> "+"</b></i>"+q1.get_explanation()));
		
				
		if(15==1)next.setVisibility(View.INVISIBLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.linequiz_explanation, menu);
		return true;
	}
	
	
//NEXT BUTTON--------------
	public void next(View v){
		
		if(i<15-1){		
			previous.setVisibility(View.VISIBLE);
			next.setVisibility(View.VISIBLE);
			i++;
		
		if(i==15-1)	next.setVisibility(View.INVISIBLE);
		
		q1 = db.getQuestion(com.example.finaleasy.MainActivity.id_final[i]);
		q.setText(q1.get_question());		
		corr.setText(Html.fromHtml("<br>The correct answer is " + "<b><font color=green >" + q1.get_optiona() + "</font></b>"));
		
		if(com.example.finaleasy.MainActivity.ansSelected[i]!=-1)
			sel.setText(Html.fromHtml("You selected: "+"<b><font color=blue>"+com.example.finaleasy.MainActivity.selectedAns[i]+"</font></b>"));
		else
			sel.setText(Html.fromHtml("<font color=red>"+"You did not select an option"+"</font>"));
		exp.setText(Html.fromHtml("<i><b><br>Explanation:<br> "+"</b></i>"+q1.get_explanation()));
		
			
			
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
		q1 = db.getQuestion(com.example.finaleasy.MainActivity.id_final[i]);
		q.setText(q1.get_question());		
		corr.setText(Html.fromHtml("<br>The correct answer is " + "<b><font color=green >" + q1.get_optiona() + "</font></b>"));
		
		if(com.example.finaleasy.MainActivity.ansSelected[i]!=-1)
			sel.setText(Html.fromHtml("You selected: "+"<b><font color=blue>"+com.example.finaleasy.MainActivity.answers_final[i][com.example.finaleasy.MainActivity.ansSelected[i]-1]+"</font></b>"));
		else
			sel.setText(Html.fromHtml("<font color=red>"+"You did not select an option"+"</font>"));
		exp.setText(Html.fromHtml("<i><b><br>Explanation:<br> "+"</b></i>"+q1.get_explanation()));
		
		}
		else{
			previous.setVisibility(View.INVISIBLE);
		}
			
		
		
		
	}

	
	
}
