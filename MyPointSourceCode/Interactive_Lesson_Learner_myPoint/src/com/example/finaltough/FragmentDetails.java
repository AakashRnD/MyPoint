/* Description:-Class to display the questions for test and setting of options for questions
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */

 
 package com.example.finaltough;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ill.MainActivity;
import com.example.ill.PointActivity;
import com.example.ill.R;
 
public class FragmentDetails extends Fragment{
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";
	/**
	 * The dummy content this fragment is presenting.
	 */
	private DummyContent.DummyItem mItem;
	
	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public FragmentDetails() {		
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
			setHasOptionsMenu(true);
			
	}
	
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
	    // TODO Add your menu entries here
	    super.onCreateOptionsMenu(menu, inflater);
	    inflater.inflate(R.menu.linequiz_submit, menu);
	    
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.finaltough_fragment_detail,
				container, false);
		setHasOptionsMenu(true);
		// Show the dummy content as text in a TextView.
		
					
		return rootView;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.submit:
			Intent in = new Intent(getActivity(), Results.class);
			getActivity().finish();
			startActivity(in);
			break;
		case R.id.scratchpad:
			Intent in1 = new Intent(getActivity(), com.example.scratchpad.MainActivity.class);
			startActivity(in1);
			break;
		
		default:
			break;
		}
		return true;
	}
	
	
	public void setQuestion(int id){			
		TextView tv =((TextView) getView().findViewById(R.id.items_detail)); 
		tv.setVisibility(View.VISIBLE);
		tv.setText("Q"+(id+1)+".\n"+com.example.finaltough.MainActivity.questions_final[id]+"\n");
		
		RadioGroup rg = (RadioGroup) getView().findViewById(R.id.answers);
		final RadioButton answer1 = (RadioButton) getView().findViewById(R.id.answer1);
		final RadioButton answer2 = (RadioButton) getView().findViewById(R.id.answer2);
		final RadioButton answer3 = (RadioButton) getView().findViewById(R.id.answer3);
		final RadioButton answer4 = (RadioButton) getView().findViewById(R.id.answer4);
		rg.setVisibility(View.VISIBLE);
		rg.setPadding(30, 20, 0, 0);
		answer1.setVisibility(View.VISIBLE);
		answer2.setVisibility(View.VISIBLE);
		answer3.setVisibility(View.VISIBLE);
		answer4.setVisibility(View.VISIBLE);
		ImageView iv = (ImageView) getView().findViewById(R.id.imageView);
		iv.getLayoutParams().height=180;
		iv.getLayoutParams().width=200;
		
//Set image if question needs one		
		
		
		if(com.example.finaltough.MainActivity.correctAnswer[id]==1){
			answer1.setText(com.example.finaltough.MainActivity.answers_final[id][0]);
			answer2.setText(com.example.finaltough.MainActivity.answers_final[id][1]);
			answer3.setText(com.example.finaltough.MainActivity.answers_final[id][2]);
			answer4.setText(com.example.finaltough.MainActivity.answers_final[id][3]);
		}
		else if(com.example.finaltough.MainActivity.correctAnswer[id]==2){
			answer1.setText(com.example.finaltough.MainActivity.answers_final[id][1]);
			answer2.setText(com.example.finaltough.MainActivity.answers_final[id][0]);
			answer3.setText(com.example.finaltough.MainActivity.answers_final[id][2]);
			answer4.setText(com.example.finaltough.MainActivity.answers_final[id][3]);
		}
		else if(com.example.finaltough.MainActivity.correctAnswer[id]==3){
			answer1.setText(com.example.finaltough.MainActivity.answers_final[id][2]);
			answer2.setText(com.example.finaltough.MainActivity.answers_final[id][1]);
			answer3.setText(com.example.finaltough.MainActivity.answers_final[id][0]);
			answer4.setText(com.example.finaltough.MainActivity.answers_final[id][3]);
		}
		else if(com.example.finaltough.MainActivity.correctAnswer[id]==4){
			answer1.setText(com.example.finaltough.MainActivity.answers_final[id][1]);
			answer2.setText(com.example.finaltough.MainActivity.answers_final[id][3]);
			answer3.setText(com.example.finaltough.MainActivity.answers_final[id][2]);
			answer4.setText(com.example.finaltough.MainActivity.answers_final[id][0]);
		}
		
			switch(com.example.finaltough.MainActivity.ansSelected[id]){
			
			case 1:
				answer1.setChecked(true);
				break;
			case 2:
				answer2.setChecked(true);
				break;
			case 3:
				answer3.setChecked(true);
				break;
			case 4:
				answer4.setChecked(true);
				break;
			case -1:
				rg.clearCheck();
				break;
				
			}
		
		
		

		rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// 	TODO Auto-generated method stub
				
				int id = com.example.finaltough.MainActivity.number;
				
				
				if(answer1.isChecked()){
					com.example.finaltough.MainActivity.ansSelected[id]=1;
					com.example.finaltough.MainActivity.selectedAns[id]=answer1.getText().toString();
				}
				if(answer2.isChecked()){
					com.example.finaltough.MainActivity.ansSelected[id]=2;
					com.example.finaltough.MainActivity.selectedAns[id]=answer2.getText().toString();
				}
				if(answer3.isChecked()){
					com.example.finaltough.MainActivity.ansSelected[id]=3;
					com.example.finaltough.MainActivity.selectedAns[id]=answer3.getText().toString();
				}
				if(answer4.isChecked()){
					com.example.finaltough.MainActivity.ansSelected[id]=4;
					com.example.finaltough.MainActivity.selectedAns[id]=answer4.getText().toString();
				}
				
				if(com.example.finaltough.MainActivity.correctAnswer[id]==1 && com.example.finaltough.MainActivity.ansSelected[id]!=-1){
					if(checkedId == R.id.answer1 )
						com.example.finaltough.MainActivity.answerState[id]=1;
					else
						com.example.finaltough.MainActivity.answerState[id]=-1;
					
					
				}
				else if(com.example.finaltough.MainActivity.correctAnswer[id]==2   && com.example.finaltough.MainActivity.ansSelected[id]!=-1){
					if(checkedId == R.id.answer2)
						com.example.finaltough.MainActivity.answerState[id]=1;
					else
						com.example.finaltough.MainActivity.answerState[id]=-1;
		
				}
				
				else if(com.example.finaltough.MainActivity.correctAnswer[id]==3 && com.example.finaltough.MainActivity.ansSelected[id]!=-1){
					if(checkedId == R.id.answer3 )
						com.example.finaltough.MainActivity.answerState[id]=1;
					else
						com.example.finaltough.MainActivity.answerState[id]=-1;
	
				}
	
				else if(com.example.finaltough.MainActivity.correctAnswer[id]==4  && com.example.finaltough.MainActivity.ansSelected[id]!=-1){
					if(checkedId == R.id.answer4)
						com.example.finaltough.MainActivity.answerState[id]=1;
					else
						com.example.finaltough.MainActivity.answerState[id]=-1;
					
				}
			}



		});
		
	}

	
}

