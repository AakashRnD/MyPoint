/* Description:-Storing the contents for the given module in array 
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */


package com.example.pointfragment;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.ill.AnimationActivity;
import com.example.ill.R;

public class MainActivity extends FragmentActivity {
	static int cnt=0;
	static MediaPlayer mp;
	static int clwh = 0;
	public static int seletion;
	static String heading[][]={{"Introduction","","","",""},
		{"X and Y Axis","","","Discovery of Cartesian Coordinate System"},
		{"Quadrants of a Graph",""},
		{"Coordinates of Points","","Identifying the x-coordinate","","","Identifying the y-coordinate","","","Notation for Identifying Points","","","Points On The Axes","",""},
		{"Scaling","","How to Scale ?","","Axis Break",""},
		{"Introduction","","","",""},
		{"Lines","","Points on Axis","Lines Parallel to Axis","Intercept","","Understanding Slope","","","","","Types of Slopes","","Slope of Horizontal Lines","","Slope of Parallel Lines","Slope of Perpendicular Lines","The Point-Slope Form","","The Slope-Intercept Form","","Graph of equation ax + by + c = 0",""}
	};
	static String st[][]={{							//Storing the contents of each module
		"The diagram at the right is that of a Classroom",
		"In this class room, the benches are lined up in four rows, with three benches in each row. The teacher asks the students from third row with reference to the entrance of a classroom to stand up. Then all the three students stand up.",
		"But if the teacher wants only a particular boy to stand up, then he refers to him as \"The boy sitting on second bench in the third row\". Then Aman (denoted by \"A\") stands up.",
		"Aman's location with respect to the entrance of the classroom is stated by pair of numbers third row, second bench enclosed in parenthesis as (3,2). Similarly, the position of all the benches in the classroom can be indicated by assigning a pair of numbers.",
		"The position 'H' is indicated by the pair of numbers (3,1). The position of a number in parenthesis is always fixed. Hence, (3, 1) and (1, 3) denotes two different location which are called as Ordered Pairs. In the given diagram, (1, 3) denotes location 'B'."
	},
	{
		"The left-right (horizontal) direction is called X axis.<br><br>The up-down (vertical) direction is called Y axis.",
		"Draw X and Y axis perpendicular to each other. The intersection of these two lines is called origin and denoted by letter \"O\". Origin is the reference point from where the distances are measured.",
		"Thus when we put two Number Lines together, one going left-right, and the other going up-down, they intersect at point \"O\" the origin. ",
		"A French mathematician Rene Descartes also known Cartesian found the two axis system to find the position of an object.<br>This system is called 'Cartesian Coordinates System'.<br>The graph plotted using Cartesian System in the visual representation between the two coordinates."
	},
	{	
		"On a graph paper, intersection of X and Y axis at the origin form four areas known as Quadrants. They are named in anti-clockwise direction as first, second, third and fourth quadrant.",
		"Quadrant I: positive x coordinates and positive y coordinates (+x, +y)<br>Quadrant II: negative x coordinates and positive y coordinates.(-x,+y)<br>Quadrant III: negative x coordinates and negative y coordinates.(-x,-y)<br>Quadrants IV: positive x coordinates and negative y coordinates (+x,-y).",
	},
	{
		"A location of a point on a graph is always represented by the ‘ordered pairs’ which are called Coordinates. Thus coordinates is one set of numbers defined to identify the location of a point on a graph.",
		" The first position in the parenthesis is called x coordinate and second position is called y coordinate. So each point is identified by its both x and y (x,y) coordinates.",
		"The x-coordinate of a point is the value that tells you how far the point is on the horizontal, or x-axis from the origin.",
		"To find the x-coordinate of a point on a graph:<br>-	Draw a straight line from the point directly to the x-axis.<br>- 	The number where the line hits the x-axis is the value of the x-coordinate or abscissa. The graph displayed on the right shows two points, B and D.",
		"In the figure:<br>-	The x-coordinate of point B is 100.<br>-	The x-coordinate of point D is 400.<br>",
		"Each point is defined by two coordinates, the x and the y coordinate. The y-coordinate of a point is the value that tells you how far from the origin the point is on the vertical, or y-axis.",
		"To find the y-coordinate of a point on a graph:<br>\t-	Draw a straight line from the point directly to the y-axis.<br>\t-	The number where the line hits the axis is the value of the y-coordinate.",
		"Looking back at the graph with our points B and D, we now identify the y-coordinate for each.<br>In the figure:<br>-	The y-coordinate of point B is 400.<br>\t-	The y-coordinate of point D is 100.",
		"Once we find the coordinates of a point then we can use the ordered pair notation for labeling this point. The notation is simple. Points are identified by stating their coordinates in the form of (x, y). Note that the x-coordinate always comes first.",
		"For example, in the figure we have identified both the x and y coordinate for each of the points B and D.<br>-	The x-coordinate of point B is 100.<br>-	The y-coordinate of point B is 400.<br>Similarly,<br>-	The x-coordinate of point D is 400.<br>-	The y-coordinate of point D is 100.",
		"Thus<br>-	Coordinates of point B are (100, 400)<br>-	Coordinates of point D are (400, 100)",
		"If a point is lying on any one of the axes, there is no need to draw lines to determine the coordinates of the point. In this figure, point A lies on y-axis so its x coordinate is zero and point C lies on the x-axis hence its y coordinate is zero. Therefore points lying on any one of the axes always have one coordinate zero. ",
		"-	Point A - If you look at how far the point is from the origin along the x-axis, the answer is zero. Therefore, the x-coordinate is zero. Any point that lies on the y-axis has an x-coordinate of zero. If you move along the y-axis to find the y-coordinate, the point is 400 from the origin. The coordinates of point A are (0, 400).",
		"-	Point C - If you look at how far the point is from the origin along the y-axis, the answer is zero. Therefore, the y-coordinate is zero. Any point that lies on the x-axis has a y-coordinate of zero. If you move along the x-axis to find the x-coordinate, the point is 200 from the origin. The coordinates of point C are (200, 0)."
	},
	{
		"Graphs is generally used to model many types of relations and process dynamics in physical, biological, social and information systems. Many practical problems can be represented by graphs.",
		"It may be possible that we need to represent large values in a given graph. To solve this problem we use \"Scaling\". Scaling refers to the act of linear transformation of the original data which enables the enlarging or shrinking of a given object.",
		"\t(i) First Count the number of squares available to draw the graph. Let it be n.<br>\t(ii) Find the lowest value (x1) in the data given.<br>\t(iii) Find the highest value (x2) in the data given.",
		"\t(iv) Now find the difference of highest and lowest value (x2 - x1).<br>\t(v) Now divide it by number of squares ( (x2-x1)/n ).<br><br>\t\tScale=(x2 - x1) / n",
		"At times it may be possible that we require to plot high values on the graph but having small scale. So it becomes impossible to plot graph for such data. So it requires use of another concept that is \"Axis Break\".",
		"\"Axis Break\" feature insures that we do not have to start plotting the graph from 0. Instead break the axis and begin plotting the graph from the required values."
	},
	{
		"The diagram at the right is that of a class room. In this class room, the benches are lined up in four rows which indicates X axis, with three benches in each row which represents Y axis.",
		"The teacher asked A, B and C to stand up. Then all the three students who stood up are of the same row.",
		"If we join them, it will create an imaginary line which is parallel to Y axis.<br> Note that all the points on the line parallel to Y axis has constant value for X and is perpendicular to X axis.<br>We can denote such lines in the form of 'x = a' (where \'a\' is constant). In this example since constant is 3, we can denote this line as 'x = 3'.",
		"But if the teacher asks D, B and E to stand then line which joins them is parallel to X axis.<br>Points of the line parallel to X axis has constant value for Y and is perpendicular to Y axis.<br>We can denote such line in the form of 'y = b' (where \'b\' is constant). In this example since constant is 3, we can denote this line as 'y = 3'.",
		"The teacher asked A, D and E to stand then line which joins them is not parallel to either of the axis.<br>Such lines make either some angle with both the axis which is neither 0 nor 90 degree i.e. such lines are neither parallel nor perpendicular with either axis."
	},
	{
		"A line is a series of points that extents without end in opposite directions. A line is formed by any 2 points on that line.<br><br>When two lines move in exactly the same direction so that they will never touch, they are parallel. ",
		"When two lines cross paths, they are referred to as intersecting one another.<br><br>A special term is used for cases where the lines intersect like the letter T. The lines are said to be perpendicular to each other.",
		"y coordinate of every point on the X-axis is 0. So, the equation of x axis is y=0.<br><br>x coordinate of every point on the Y-axis is 0. So, the equation of y axis is x=0.",
		"The equation of the line parallel to Y-axis is in the form of 'x = a' and the equation of a line parallel to X-axis is in the form of 'y = b' where 'a' and 'b' are real numbers",
		"The y-intercept is the y value where x = 0. It represents the place where line crosses the y-axis.<br><br>Here,  the first number (x) is always 0. Similarily, X intercept is the x value where y = 0.",
		"The y-intercept of a line is an ordered pair in which x value must be zero.<br>Such as :(0,5) (0,3) (0,-4) (0,18)",
		"To understand slope one needs to understand two things:  steepness and direction. If you remember these two points, you will be able to conquer this math concept in no time. To help, imagine that you are a skateboarder about to go down a ramp.",
		"Notice how the first skateboarder is going down a steeper ramp.  In math, steeper means bigger so the slope of that line is bigger than the slope of the second skater's line. You may also notice that the skaters are going down the ramp from the left to the right.  This makes the slope decreasing, or negative.",
		"Now, if they were going up the ramp like in the picture then it would mean that it would be an increasing or positive slope.<br>Slope measures the direction of the line - whether our skater is going up the ramp (positive) or going down the ramp (negative).",
		"It also measures the steepness of a line - the steeper the ramp the larger will be the value of the slope. We will use our trusty skater to demonstrate few other slope scenarios.",
		"For instance, a skater could also skate on flat ground, which would mean that there is no steepness to the line and therefore it would defined as zero slope. Or, if our skater was a true daredevil and wanted to go straight down the side of a building or ramp, that would be known as an undefined slope.",
		"- Positive Slope<br>- Negative Slope<br>- Zero Slope<br>- Undefined Slope",//table is there
		"The slope of a line characterizes the general direction in which a line points. To find the slope, you divide the difference of the y coordinates of a point on a line by the difference of the x coordinates.",
		"Horizontal lines have slope zero, because 'y2 - y1 = 0' for all y. From the definition of slope<br>m =(y2 - y1)/(x2 - x1) = 0/(x2 - x1)<br>\t = 0.",
		"\tVertical Lines have infinity Slope.<br>\tVertical lines have no slope, because x2 - x1 = 0 for all x. From<br>m = (y2 - y1)/(x2 - x1) = (y2 - y1)/ 0 <br>\t-> infinity ",
		"Two non-vertical lines are parallel if they have the same slope.<br>Look at the figure, m1 is the slope of line AB and m2 is the slope of line CD. If m1 = m2, then lines AB is parallel to CD.",
		"Two non-vertical lines are perpendicular if their slopes are negative reciprocals of each other. That is, if one line has slope m1, then other line must have slope m2 = -1/m2 or m1 * m2 = -1.<br>In the figure, m1 is the slope of line AB and m2 is the slope of line CD.",
		"If L is a line with slope m, and P1(x1, y1) is a point on line L, then  equation of line L is: y - y1 = m ( x - x1 ).<br>This equation comes from the definition of line AB. ",
		"Suppose point A has coordinate (x1, y1) and point B has a coordinate (x, y), then the slope of line AB is :<br>\t\t m = (y - y1)/(x - x1)<br>By multiplying x - x1 both side, we obtained y - y1 = m (x - x1). This is the point-slope form of an equation for the line L that passes point (x1, y1) and has a slope m.",
		"If L is a straight line with slope m and b is a constant which represent the y-intercept, then the line equation is :<br>\t\ty = mx + b.<br><br>This equation comes from point-slope form of line equation.",
		"Suppose that line L with slope m pass through point P1(0, b), another point is P(x, y), then its line equation is :<br>\t\ty - b = m(x - 0)<br><br>By simplifying we will obtain y = mx + b. ",
		"An equation of the form ax + by + c = 0, where a, b and c are real numbers and a, b not equal to 0 is called linear equation in two variables x and y.",
		"To draw the graph of line ax + by +c = 0. We start with Cartesian co-ordinate axes in a plane.<br>Then we find coordinates of the point which satisfy the given equation.<br>The conventional method to draw the line graph is given in the flow chart."
	}
	};
static int img[][]={{1,2,3,4,5},{1,2,3,4},{1,1},{5,6,1,1,1,2,2,2,3,3,3,4,4,4},{0,1,0,0,2,3},{1,2,3,4,5},{1,14,2,3,4,4,5,5,6,6,6,7,8,9,9,10,11,12,12,13,13,16,15}};	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_point);
		mp = MediaPlayer.create(MainActivity.this, R.raw.cl1);
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    
	    case R.id.home:
	    	finish();
	    	break;
	    	
	    case R.id.audio_fragment:	    	
	    	
	    	switch (MainActivity.seletion) {
			case 0:if(MainActivity.img[0][MainActivity.cnt]==1){
					if(mp.isPlaying())	
						mp.stop();
					mp = MediaPlayer.create(MainActivity.this, R.raw.cl1);
					mp.start();
					}
			
					else if(MainActivity.img[0][MainActivity.cnt]==2){
						if(mp.isPlaying())	
							mp.stop();
						mp = MediaPlayer.create(MainActivity.this, R.raw.cl2);
						mp.start();
					}
					else if(MainActivity.img[0][MainActivity.cnt]==3){
						if(mp.isPlaying())	
							mp.stop();
						mp = MediaPlayer.create(MainActivity.this, R.raw.cl3);
						mp.start();
					}
					else if(MainActivity.img[0][MainActivity.cnt]==4){
						if(mp.isPlaying())	
							mp.stop();
						mp = MediaPlayer.create(MainActivity.this, R.raw.cl4);
						mp.start();
					}
					else if(MainActivity.img[0][MainActivity.cnt]==5){
						if(mp.isPlaying())	
							mp.stop();
						mp = MediaPlayer.create(MainActivity.this, R.raw.cl5);
						mp.start();
					}
					else
					{
						if(mp.isPlaying())
							mp.stop();
						//iv.setImageResource(R.drawable.introex1);
				
					}
				break;
			case 1:if(MainActivity.img[1][MainActivity.cnt]==1){
				if(mp.isPlaying())	
					mp.stop();
						mp = MediaPlayer.create(MainActivity.this, R.raw.cxy1_final);
						mp.start();
					}
					else if(MainActivity.img[1][MainActivity.cnt]==2){
						if(mp.isPlaying())	
							mp.stop();
								mp = MediaPlayer.create(MainActivity.this, R.raw.cxy2_final);
								mp.start();
					}
					else if(MainActivity.img[1][MainActivity.cnt]==3){
						if(mp.isPlaying())	
							mp.stop();
								mp = MediaPlayer.create(MainActivity.this, R.raw.cxy3_final);
								mp.start();
					}
					else if(MainActivity.img[1][MainActivity.cnt]==4){
						if(mp.isPlaying())	
							mp.stop();
								mp = MediaPlayer.create(MainActivity.this, R.raw.cxy4_final);
								mp.start();
					}
					else
					{
						if(mp.isPlaying())
							mp.stop();
					}
				break;
				
				default:
					mp.stop();
					break;
			
	    	}
	    	break;
	    
	    }
	    return true;
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		 mp.release();
		finish();
	}

}
