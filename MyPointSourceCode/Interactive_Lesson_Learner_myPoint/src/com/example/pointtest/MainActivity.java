/* Description:-Assigning Questions, Options and Explanation for Quiz-it Basic Level
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */


package com.example.pointtest;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.example.ill.R;
import com.example.pointquiz.database.DataBaseHandler;
import com.example.pointquiz.database.Question;

public class MainActivity extends FragmentActivity implements
FragmentList.Callbacks {
	
	boolean[] flag = new boolean[14];
	static int[] image = new int[5];
	static int number=1;
	int count=0;
	
	DataBaseHandler db = new DataBaseHandler(this);
	
//Array consisting of questions	
	String questions[]  ={  "What quadrant is this point in?",
				"What are the Cartesian coordinates of the point A?",
				"What are the Cartesian coordinates of the point B?",
				"What are the Cartesian coordinates of the point C?",
				"What quadrant is this point in?",
				"Which point is in Quadrant I?",
				"In which quadrant is the point (4, y)?",
				"In which quadrant is / are the point(s) (x, y), such that  xy < 0?",
				"The horizontal axis is also called the _____ axis",
				"The vertical axis is also called the _____ axis",
				"Another name for the point (0,0) is ______",
				"In which quadrant, point(-3,-21) lies?",
				"In which quadrant, point (21,-3)?",
				"Describe the order of the signs of (x,y) in the IInd quadrant?"};
	
//The final list of questions and answers 
		 static String questions_final[] = new String[14];
		 static int id_final[] = new int[14];
		 static String answers_final[][] = new String[14][4];
		 static int correctAnswer[] = new int[14];
		public static int answerState[] = new int[14];
		public static  int ansSelected[] = new int[14];
		public static  String selectedAns[] = new String[14];
		public static int correct, wrong, unanswered;
		
//Answers		
		static String options[][] ={
					{"NONE","I","II","IV"},
					{"(4,2)","(2,4)","(-4,2)","(4,-2)"},
					{"(-3,5)","(3,-5)","(5,-3)","(-5,3)"},
					{"(-2,-3)","(-3,-2)","(-2,3)","(2,-3)"},
					{"Quadrant IV","Quadrant III","Quadrant II","None"},
					{"(4,4)","(-3,4)","(-4,4)","(4,-4)"},					
					{"Quadrants I and IV","Quadrants II and IV","Quadrants II and III","Quadrants III and IV"},
					{"Quadrants II and IV","Quadrants I and IV","Quadrants II and III","Quadrants III and IV"},
					{"X","Y","Z","None"}
					,{"Y","X","Z","None"}
					,{"Origin","Quadrant","Center","None"}
					,{"Quadrant III","Quadrant II","Quadrant IV","None"},
					{"Quadrant IV","Quadrant III","Quadrant II","None"}
					,{"Negative, Positive","Positive, Negative","Positive, Positive","None"}

};
		
		
String explanation[] = {
		"The given point lies on Y-axis<br>, it does not lie in any quadrant",
		"The given point \"A\" lies 4 units right to the origin<br>  i.e. (+4 ) and 2 units above i.e(+2), Therefore (4,2) are the coordinates of the given point A",
		"The given point \"B\" lies 3 units left to the origin<br>  i.e. (-3 ) and 5 units above i.e(+5), Therefore (-3,5) are the coordinates of the given point B",
		"The given point \"C\" lies 2 units left to the origin<br>  i.e. (-2 ) and 3 units below i.e(-3), Therefore (-2,-3) are the coordinates of the given point C",
		"The given point lies to the right and below the<br> origin i.e. +ve x and –ve y, Therefore the given point lies in quadrant IV",
		"As quadrant I always have +ve x and +ve y coordinates, Therefore the only point with coordinates (4,4) lies in quadrant I",
		"The given point (4,y) indicates that x coordinate is fixed and is positive i.e. it lies right to the origin whereas y coordinate may be +ve or –ve i.e. it can be above or below origin, i.e. IV quadrant ",
		"xy < 0 indicates that either x is –ve or y is –ve, both can’t be of same sign. Quadrant II has –ve x and +ve y and quadrant IV has +ve x and –ve y coordinates",
		"Horizontal line is the line moving from  left to right, named as X -axis",
		"Vertical line is the line moving from  top to bottom, named as Y -axis",
		"( 0,0 ) is the point where both X and Y axis intersects perpendicularly, named as \"Origin\"",
		"Quadrant III lies left and below origin i.e. it has both –ve x and y coordinates, Therefore ( -3, -21 ) can lie only in III quadrant",
		"Quadrant IV lies right and below origin i.e. it has +ve x and +ve y coordinates, Therefore ( 21, -3 ) can lie only in IV quadrant",
		"Quadrant II lies left to origin ( -ve x ) and above origin ( +ve y ), Therefore order of signs are \"Negative, Positive\""
		};

		
		


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pointquiz_activity_main);
		
		//ADD QUESTIONS TO THE TABLE---------------------------------
		db.remove();
				for(int j=0; j<14 ;j++){
					
					db.addQuestion(new Question(j+1, questions[j], options[j][0], options[j][1], options[j][2], options[j][3], explanation[j]));
				}
				

		
				for(int i=0 ; i<com.example.pointtest.LaunchScreen.number_questions ; i++){
					answerState[i]=0;
					ansSelected[i]=-1;					
				}
				for(int k=0; k<5 ;k++)
					image[k]=-1;
				do{
					
					int qnumber =(int) Math.floor(Math.random()*14);//Random number to select question
				
					if(flag[qnumber]==false)
					{
					 flag[qnumber]=true;			 	 
					 count++;
					}
				}while(count<com.example.pointtest.LaunchScreen.number_questions);
				
				count=0;
				for(int i=0 ; i<14;i++){
					if(flag[i]==true){
						correctAnswer[count]=(int) (1+Math.floor(Math.random()*4));//Setting the question and answers
						questions_final[count]=db.getQuestion(i+1).get_question();
						answers_final[count][0]=db.getQuestion(i+1).get_optiona();
						answers_final[count][1]=db.getQuestion(i+1).get_optionb();
						answers_final[count][2]=db.getQuestion(i+1).get_optionc();
						answers_final[count][3]=db.getQuestion(i+1).get_optiond();
						id_final[count]=db.getQuestion(i+1).get_id();
						if(i>=0 && i<5){
							 image[i]=count;
							 
						}
						count++;
						if(count==com.example.pointtest.LaunchScreen.number_questions)
							break;
					}
				}
				
				correct=wrong=unanswered=0;
					
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pointquiz_main, menu);
		return true;
	}
	
	@Override
	public void onItemSelected(String id) {
		
		// In two-pane mode, show the detail view in this activity by
		// adding or replacing the detail fragment using a
		// fragment transaction.
		
		number=Integer.parseInt(id);
		number--;
		FragmentDetails frag = (FragmentDetails) getSupportFragmentManager().findFragmentById(R.id.viewer);
		frag.setQuestion(number);
		
		}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();	
		
		finish();
	}


}
