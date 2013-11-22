/* Description:-Assigning Questions, Options and Explanation for Quiz-it Advanced Level
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */


package com.example.finaltough;


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
	
	boolean[] flag = new boolean[15];
	
	static int number=1;
	int count=0;
	DataBaseHandler db = new DataBaseHandler(this);
	
//Array consisting of questions	
	String questions[]  ={  "In a Cartesian coordinate system, axes x, y and z are at __________ to each other.",
							"Find the slope of a line perpendicular to the line whose equation is 2y + 6x = 24.",
							"Find the value of y for x = 2 in equation 2y + 6x = 24",
							"What is the range of Y in the equation y + 2x = 4 , if the range of X is (-1, 2]  ?",
							"When a is not equal to 0 , b=0 and c=0 then the equation ax + by + c = 0 is :-",
							"What is the Equation of Y-Axis ? " ,
							"Given two distinct point in a plane , the number of lines that passes through both of them is/are ",
							"What is the angle between two parallel lines ?" ,
							"If a point is in 2nd Quadrants ,  then the point will be of the form.",
							"If x = 1 and y = 3 is a solution of 3x + 5y = k, then k = ?",
							"Pencils cost Rs 2 each; pens cost Rs 7 each. John spends Rs 20 on these items. Then the linear 		equation for the given data is:",
							"In the third quadrant, the nature of the x and y coordinates is ____.",
							"If both the abscissa and ordinate of a point are negatives, then the point lies in the ____ quadrant.",
							"Line x - 2y = 3 will intersect ",
							"If x = 2 and y = 2 is a solution of 6x + 2ay = 5a, then the value of a is ____.",
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
									{"90°" , "45°" , "120" , "180"},
									{"1/3" , "-3" ,  "6" ,  "-1/6"},
									{"6", "4", "8", "12"},
									{"[0 , 6)" , "[6 , 0)" , "(0 , 6]" , "(6 , 0]" },
									{"Parallel to Y axis" , "Parallel to X axis", "Perpendicular to Y axis", "None"}, 
									{"x = 0"  ,  " y  = 0"  ,  "x = k"  ,  "y = k" }, 
									{"2", "1" , "0" , "infinite"},
									{"0°" , "90°" , "45°" , "180°"},
									{"(-, +)", "(+, +)", "(+, -)" , "(-, -)"},
									{"18" , "16" , "15" , "12"}, 
									{"2x + 7y = 20" , "x + 7y = 20" , "2x + y = 20" , "2x – 7y = 20" }, 
									{ "x > 0 and y > 0" , "x < 0 and y < 0" , "x < 0 and y > 0", "x > 0 and y < 0 "}, 
									{ "Third" , "Second" , "First" , "Fourth"},
									{"+X axis , -Y axis" , "+X axis , +Y axis" , "-X axis , -Y axis" , "-X axis , +Y axis"}, 
									{"12" , "10" , "14" , "8"}
				};


		String explanation[] = {"Answer is 90° because all the x , y and z axes are perpendicular to each other. ",
								"Write the equation in the form of Y = mX + c. So the equation will be Y = -3X + 12. The product of slopes of two perpendicular lines is -1. Slope of this equation is  -3. The slope of line perpendicular to this will be  (-1)/(-3). The answer is 1/3.",
								"To find the value of Y , if value of X (X = 2) is given for an equation , we need to put the value of X into equation and calculate the value of Y. So 2Y + 6*(2) = 24 , so the value of Y is 6.",
								"For the minimum value of y use the given minimum value of x=-1 and find the value of y. Similarily find y for x=2. For x=-1, y=6 and for x=2, y=0. In the question, x=-1 is not included (Because of ‘(‘ braces), so 6 is not included and for x = 2 the braces is ‘]’, so 0 is included. The answer is [0, 6).",
								"Given that a is not equal to zero , b=0 and c=0. So the equation will be ax = 0. Where a is any non-zero value. We know that  ax = 0 is the equation of Y axis and a line itself is always parallel to itself , so the answer will be ‘line is parallel to Y axis’.",
								"Equation of Y axis is X = 0.",
								"Only one line can pass through two points in a plane.",
								"Angle between two parallel lines is 0° because if the lines are parallel than the slope of both lines will be same",
								"In the 2nd quadrant the X axis is ‘–‘ and Y axis is ‘+’ so if a point is in 2nd quadrants than its coordinate form will be (-, +).",
								"Put the value of x = 1 and y = 3 in the given equation and calculate the value of k .3*1 + 5*3 = k , so k will be 18.",
								"Say John buy X pencils and Y pens than the cost of X pencil will be 2*X and cost of Y pens will be 7*Y , and given that he spends Rs 20 so the total spent money is equal to total cost. So the answer is  2*X + 7*Y = 20",
								"In the 3rd  quadrant the X axis is ‘–‘ and Y axis is ‘-’ so the answer is (-, -).",
								"If both the abscissa and ordinate of a point are negatives, this means x is –ve and y is also –ve so the point lies in 3rd quadrants.",
								"If we put x = 0 in the equation than the value of y will be +ve so it will intersect –Y axis and if we put y = 0 in the equation than the value of x  will be +ve so it will intersect +X axis , so the answer is that this line will intersect ‘+X axis and –Y axis.",
								"Put the value of x = 2 and y = 2 in the given equation and calculate the value of a. 6*2 + 2*a*2 = 5a =>12 + 4a = 5a =>a = 12. "
		};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.finaltough_activity_main);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		//ADD QUESTIONS TO THE TABLE---------------------------------
		db.remove();
				for(int j=0; j<15 ;j++){
					
					db.addQuestion(new Question(j+1, questions[j], options[j][0], options[j][1], options[j][2], options[j][3], explanation[j]));
				}
				
				for(int i=0 ; i<15 ; i++){
					answerState[i]=0;
					ansSelected[i]=-1;					
				}
				do{
					
					int qnumber =(int) Math.floor(Math.random()*15);//Random number to select question
				
					if(flag[qnumber]==false)
					{
					 flag[qnumber]=true;			 	 
					 count++;
					}
				}while(count<15);
				
				count=0;
				for(int i=0 ; i<15;i++){
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
