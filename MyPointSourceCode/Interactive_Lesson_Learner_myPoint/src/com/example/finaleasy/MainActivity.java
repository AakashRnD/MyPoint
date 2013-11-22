/* Description:-Assigning Questions, Options and Explanation for Quiz-it Basic Level
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */


package com.example.finaleasy;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;

import com.example.ill.R;
import com.example.linequiz.database.DataBaseHandler;
import com.example.linequiz.database.Question;

public class MainActivity extends FragmentActivity implements
FragmentList.Callbacks {
	
	boolean[] flag = new boolean[21];
	
	static int number=1;
	int count=0;
	DataBaseHandler db = new DataBaseHandler(this);
	
//Array consisting of questions	
	String questions[]  ={  "Which point is in Quadrant I?",
							"What is the X-intercept of the line x=3?",
							"What is the X-intercept of the line y=5?",
							"What is the X-intercept of the line y=2x+4?",
							"The point (1,-2) lies on which of the following lines?",
							"Which of the following lines pass through the origin?",
							"What is the slope of the line 2x=3y+5?",
							"Which of the following lines have a slope of -2?",
							"In which quadrant is the point (4, y)?",
							"In which quadrant is / are the point(s) (x, y), such that  xy < 0?",
							"The horizontal axis is also called the _____ axis",
							"The vertical axis is also called the _____ axis",
							"Another name for the point (0,0) is ______",
							"In which quadrant, point(-3,-21) lies?",
							"In which quadrant, point (21,-3)?",
							"Describe the order of the signs of (x,y) in the IInd quadrant?",
							"The line passing through (2,5) and (2,-9) is parallel to which axis?",
							"Which of the following points pass through the line 2x-3y=12?",
							"What is the slope of the line passing through (1,2) and (4,6) ?",
							"Which of the following lines pass through the point (2,-3)?",
							"The line passing through (3,6) and (-3,-6) is parallel to which axis?"
							
							
							};
				
	
//The final list of questions and answers 
		 static String questions_final[] = new String[15];
		 static int id_final[] = new int[15];
		 static String answers_final[][] = new String[15][4];
		 static int correctAnswer[] = new int[15];
		public static int answerState[] = new int[15];
		public static  int ansSelected[] = new int[15];
		public static  String selectedAns[] = new String[15];
		public static int correct, wrong, unanswered;
		
//Answers		
		static String options[][] ={
									{"(4,4)","(-3,4)","(-4,4)","(4,-4)"},
									{"3","-3","0","Not defined"},
									{"Not defined","-5","0","5"},
									{"-2","2","0","Not defined"},
									{"x+y=-1","y=2x-3","4x-6=0","None of these"},
									{"Both","x=-y","x=y","None of these"},
									{"2/3","-2/5","3/5","-3/5"},
									{"2y+4x=3","y=2x+2","2x=2y-3","2y=4x+7"},
									{"Quadrants I and IV","Quadrants II and IV","Quadrants II and III","Quadrants III and IV"},
									{"Quadrants II and IV","Quadrants I and IV","Quadrants II and III","Quadrants III and IV"},
									{"X","Y","Z","None"}
									,{"Y","X","Z","None"}
									,{"Origin","Quadrant","Center","None"}
									,{"Quadrant III","Quadrant II","Quadrant IV","None"},
									{"Quadrant IV","Quadrant III","Quadrant II","None"},
									{"Negative, Positive","Positive, Negative","Positive, Positive","None"},
									{"Y","X","Z","None of these"},
									{"(3,-2)","(-3,-2)","(2,-3)","(-3,2)"},
									{"4/3","-4/3","-3/4","3/4"},	
									{"None of these","2x+3y=0","3x-2y=11","y=x+5"},
									{"None of these","Y","Z","X"}
				};


		String explanation[] = {
							"As quadrant I always have +ve x and +ve y coordinates, Therefore the only point with coordinates (4,4) lies in quadrant I",
							"X-intercept is the x value where y=0, X=3 clearly indicates that x intercept is 3",
							"X-intercept is the x value where y=0, Y = 5 does not give the value of x when y = 0. Therefore, equation y = 5 do not define y intercept ",
							"X-intercept is the x value where y=0. Therefore equation y = 2x + 4 can be written as 2x = y – 4.	For y = 0,  2x = - 4 or x = -2. Therefore x intercept  is - 2",
							"To find the existence of point in a line, substitute values of x and y coordinates in line equations.	Point ( 1, - 2 ) satisfies equation x + y =-1, since,  [ ( 1 ) + ( -2 ) = - 1]. Therefore ( 1, -2) lies on x + y = -1",
							"To find the existence of point in a line, substitute values of x and y coordinates in line equations. Origin is [ 0 , 0 ] and satisfies both the equations x = - y [ 0=0 ] and x = y [ 0=0 ]",
							"m indicates slope in standard line equation y = mx + c. Equation 2x = 3y + 5 can be rewritten in the form of y = mx + c as y = 2/3x – 5/3,	where 2/3 represents m, i.e. slope of line 2x = 3y + 5 is 2/3",
							"m indicates slope in standard line equation y = mx + c. Equation 2y + 4x = 3 can be rewritten in the form of y = mx + c as y = -4/2x + 3/2 i.e. y= -2x + 3/2, where -2 represents m, i.e. slope of line 2y + 4x = 3",						
							"The given point (4,y) indicates that x coordinate is fixed and is positive i.e. it lies right to the origin whereas y coordinate may be +ve or –ve i.e. it can be above or below origin, i.e. IV quadrant ",
							"xy < 0 indicates that either x is –ve or y is –ve, both can’t be of same sign. Quadrant II has –ve x and +ve y and quadrant IV has +ve x and –ve y coordinates",
							"Horizontal line is the line moving from  left to right, named as X -axis",
							"Vertical line is the line moving from  top to bottom, named as Y -axis",
							"( 0,0 ) is the point where both X and Y axis intersects perpendicularly, named as \"Origin\"",
							"Quadrant III lies left and below origin i.e. it has both –ve x and y coordinates, Therefore ( -3, -21 ) can lie only in III quadrant",
							"Quadrant IV lies right and below origin i.e. it has +ve x and +ve y coordinates, Therefore ( 21, -3 ) can lie only in IV quadrant",
							"Quadrant II lies left to origin ( -ve x ) and above origin ( +ve y ), Therefore order of signs are \"Negative, Positive\"",
							"Line passing through points ( 2,5 ), ( 2,-9 ) has constant x value which indicates that line is parallel to y axis.",
							"To find the existence of point in a line, substitute values of x and y coordinates in line equations. Point ( 3, -2 ) satisfies equation 2x – 3y = 12,	[2(3) – 3(-2) = 6 + 6 =12]",
							"Calculate slope using two paired numbers and slope formula m = ( y2 – y1 )/( x2 – x1). For points ( 1,2 ) and ( 4,6 ), m=( 6-2 )/( 4-1 ) = 4/3",
							"To find the existence of point in a line, substitute values of x and y coordinates in line equations. None of these equations satisfy the point ( 2,-3 )",
							"Calculate slope using two paired numbers and slope formula m = ( y2 – y1 )/( x2 – x1). For points ( 3,6 ) and ( -3,-6 ), m=( -6 -6 )/( -3 -3 ) = 12/6 = 2. Since slope is +ve , it is increasing and is not parallel to either of the axis"
							
		};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.finaleasy_activity_main);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		//ADD QUESTIONS TO THE TABLE---------------------------------
		db.remove();
				for(int j=0; j<21 ;j++){
					
					db.addQuestion(new Question(j+1, questions[j], options[j][0], options[j][1], options[j][2], options[j][3], explanation[j]));
				}
				
				for(int i=0 ; i<15 ; i++){
					answerState[i]=0;
					ansSelected[i]=-1;					
				}
				do{
					
					int qnumber =(int) Math.floor(Math.random()*21);//Random number to select question
				
					if(flag[qnumber]==false)
					{
					 flag[qnumber]=true;			 	 
					 count++;
					}
				}while(count<15);
				
				count=0;
				for(int i=0 ; i<21;i++){
					if(flag[i]==true){
						correctAnswer[count]=(int) (1+Math.floor(Math.random()*4));//Setting the question and answers
						questions_final[count]=db.getQuestion(i+1).get_question();
						answers_final[count][0]=db.getQuestion(i+1).get_optiona();
						answers_final[count][1]=db.getQuestion(i+1).get_optionb();
						answers_final[count][2]=db.getQuestion(i+1).get_optionc();
						answers_final[count][3]=db.getQuestion(i+1).get_optiond();
						id_final[count]=db.getQuestion(i+1).get_id();
						
						count++;
						if(count==15)
							break;
					}
				}
				
				correct=wrong=unanswered=0;
				
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

	
}
