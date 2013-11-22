/* Description:- class for scaling practice 
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */

package com.example.scalingpractice;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.example.ill.R;
import com.example.scalingpractice.view.viewgroup.DrawView;
import com.example.scalingpractice.view.viewgroup.FlyOutContainer;

public class SampleActivity extends Activity implements OnSeekBarChangeListener {

	FlyOutContainer root;
	MediaPlayer mp;
	int help_flag=0;
	public static int x_value=1;
	public static int y_value=1;
	public static int x_break_value = 0, y_break_value = 0;
	public static float scale = (float)1.0;
	public static boolean plotting=false;
	public static boolean scaling=false;
	public static boolean resetting = false;
	public static boolean breaking = false;
	DrawView drawview;
	SeekBar sb;
	CheckBox cb;
	TextView tv, x_break_text, y_break_text;
	public EditText x_scale,y_scale, x_break, y_break;
	View content;
	String mImagePath;
	String instructions = "-> Touch anywhere on the graph to know the co-ordinates of that particular point.<br><br>->To move the graph, touch the origin and move it around.<br><br>->To change the scale, select the <i>Change Scale</i> option from the menu.<br><br>->Once you open the menu, enter X,Y scale and click on <i>Change Scale</i> button to change the scale.<br><br>->Use the SeekBar to zoom in and out of the graph.<br><br>->To introduce kinks in your graph, select the <i>Break</i> Checkbox, and enter the X,Y breaks.<br><br>-> Click on <i>Save Screenshot</i> to save the current screen.";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		this.root = (FlyOutContainer) this.getLayoutInflater().inflate(R.layout.activity_scaling_practice, null);
		this.setContentView(root);
		mp = MediaPlayer.create(SampleActivity.this, R.raw.scale_help);
		
//INITIALIZE WIDGETS FROM LAYOUT--------------------------------------		
		sb = (SeekBar) findViewById(R.id.zoom);
		tv = (TextView) findViewById(R.id.percent);
		drawview = new DrawView(this);
		sb.setMax(4);
		sb.setProgress(2);
		sb.setOnSeekBarChangeListener(this);
		x_scale = (EditText) findViewById(R.id.x_edit);
		y_scale = (EditText) findViewById(R.id.y_edit);
		cb = (CheckBox) findViewById(R.id.kink);
		x_break_text = (TextView) findViewById(R.id.x_break_text);
		y_break_text = (TextView) findViewById(R.id.y_break_text);
		x_break = (EditText) findViewById(R.id.x_break);
		y_break = (EditText) findViewById(R.id.y_break);
//----------------------------------------------------------------------		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.scaling_menu, menu);
		return true;
	}
	
	public void ltoggleMenu(View v){
//OPEN/CLOSE SIDE MENU		
		this.root.ltoggleMenu();
	}

	
	
//ON MENU BUTTON CLICKED-------------------------------------	
	@Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.homeee:
	    	finish();
	    	break;
	    case R.id.left:
	    	this.root.ltoggleMenu();
	    	break;
	    case R.id.text_scaling_help:
	    	final Dialog dialog = new Dialog(SampleActivity.this);
			dialog.setContentView(R.layout.instructions);
			dialog.setTitle("Instructions for Scaling Practice");
			dialog.show();
			TextView txt = (TextView)dialog.findViewById(R.id.instructions_text);
			txt.setText(Html.fromHtml(instructions));
			dialog.show();
			Button dialogButton = (Button) dialog.findViewById(R.id.close_instructions);
			// if button is clicked, close the custom dialog
			dialogButton.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					dialog.dismiss();
				}
			});
	    	break;
	    	
	    case R.id.audio_scaling:
	    	if(help_flag==0){
	    		mp = MediaPlayer.create(SampleActivity.this, R.raw.scale_help);
	    		mp.start();
	    		help_flag=1;
	    		
	    	}
	    	else{
	    		mp.stop();	 
	    		help_flag=0;
	    	}
	    	
	    	break;
	    	
	    	
	    	
	    case R.id.screenshot:
	    	content = findViewById(R.id.screenRoot3);
	    	View view = content;
	        View v = view.getRootView();
	        v.setDrawingCacheEnabled(true);
	        Bitmap b = v.getDrawingCache();             
	        
	        File direct = new File(Environment.getExternalStorageDirectory() + "/mypoint");

	        if(!direct.exists())
	         {
	             if(direct.mkdir());//directory is created;

	         }
	        mImagePath = Environment.getExternalStorageDirectory() + "/mypoint";

	        //String extr = Environment.getExternalStorageDirectory().toString();
	        Calendar currentDate = Calendar.getInstance();
			  SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMMddHmmss");
			  String dateNow = formatter.format(currentDate.getTime());
			  
	        File myPath = new File(mImagePath + "/" ,"Scaling_"+ dateNow + ".9.png");
	        FileOutputStream fos = null;
	        try {
	            fos = new FileOutputStream(myPath);
	            b.compress(Bitmap.CompressFormat.PNG, 100, fos);
	            fos.flush();
	            fos.close();
	            MediaStore.Images.Media.insertImage(getContentResolver(), b, "Screen", "screen");
	        }catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        Toast.makeText(this, "Screenshot saved", Toast.LENGTH_SHORT).show();
	    	break;
	  
	  
	  
	    default:
	      break;
	    }

	    return true;
	  }
	
//Zoom - SEEKBAR VALUE CHANGED
	@Override
	public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
		// TODO Auto-generated method stub
		tv.setText(Integer.toString(arg1-2)+"%");
		scale=arg1-2;
		scaling=true;
		if(scale<0)scale=-1/--scale;		
		else if(scale==0)scale=1;
		else if(scale>0)scale++;
		
		
	}

	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}
	
//ON PLOT BUTTON CLICK
	public void scale(View view){
		
		
		if(x_scale.getText().toString().equals("") && y_scale.getText().toString().equals("")){
			x_value=1;
			y_value=1;
		}
		
		
		else if(x_scale.getText().toString()!="" && y_scale.getText().toString().equals("")){
		
		x_value=Integer.parseInt(x_scale.getText().toString());
		y_value=1;
		
		}		

		else if(x_scale.getText().toString().equals("") && y_scale.getText().toString()!=""){
			
			x_value=1;
			y_value=Integer.parseInt(y_scale.getText().toString());
			
		
			}		
		else if(x_scale.getText().toString()!="" && y_scale.getText().toString()!=""){
			
			x_value=Integer.parseInt(x_scale.getText().toString());
			y_value=Integer.parseInt(y_scale.getText().toString());
			
		}
		
		
		//Set visible widgets
				if(cb.isChecked()==true){
					x_break_text.setVisibility(View.VISIBLE);
					y_break_text.setVisibility(View.VISIBLE);
					x_break.setVisibility(View.VISIBLE);
					y_break.setVisibility(View.VISIBLE);
				
				}
				
		//Set widgets invisible
				else{
					x_break_text.setVisibility(View.INVISIBLE);
					y_break_text.setVisibility(View.INVISIBLE);
					x_break.setVisibility(View.INVISIBLE);
					y_break.setVisibility(View.INVISIBLE);
					breaking=false;
					x_break_value=0;
					y_break_value=0;
					
				}
		
				if(x_break.getText().toString().equals("") && y_break.getText().toString().equals("")){
					x_break_value=0;
					y_break_value=0;
				}
				
				else if(x_break.getText().toString()!="" && y_break.getText().toString().equals("") && cb.isChecked()==true){
							
							x_break_value=Integer.parseInt(x_break.getText().toString());
							y_break_value=0;
							breaking=true;
						}
						else if(x_break.getText().toString().equals("") && y_break.getText().toString()!="" && cb.isChecked()==true){
												
								x_break_value=0;
								y_break_value=Integer.parseInt(y_break.getText().toString());
								breaking=true;
							
						}
						else if(x_break.getText().toString()!="" && y_break.getText().toString()!="" && cb.isChecked()==true){
							
							x_break_value=Integer.parseInt(x_break.getText().toString());
							y_break_value=Integer.parseInt(y_break.getText().toString());
						}
						
		
		
		
		this.root.ltoggleMenu();
	}
	
//RESET THE GRAPH---------------	
	public void reset(View view){
		resetting=true;
		sb.setProgress(2);
		tv.setText("0%");
		x_scale.setText("");
		y_scale.setText("");
		x_break.setText("");
		y_break.setText("");
		x_break_value=0;
		y_break_value=0;
		x_value=1;
		y_value=1;
		cb.setChecked(false);
		this.root.ltoggleMenu();
	}
	
	public static boolean getReset(){
		
		return resetting;
	}
	
	public static void setReset(boolean x){
		resetting = x;
	}
	
	
//Function for CheckBox clicked
	public void onBreak(View v){
		//Set visible widgets
		if(cb.isChecked()==true){
			x_break_text.setVisibility(View.VISIBLE);
			y_break_text.setVisibility(View.VISIBLE);
			x_break.setVisibility(View.VISIBLE);
			y_break.setVisibility(View.VISIBLE);
		
		}
		
//Set widgets invisible
		else{
			x_break_text.setVisibility(View.INVISIBLE);
			y_break_text.setVisibility(View.INVISIBLE);
			x_break.setVisibility(View.INVISIBLE);
			y_break.setVisibility(View.INVISIBLE);
			breaking=false;
			x_break_value=0;
			y_break_value=0;
			
		}
	}
	
	public void close(View v){
		//CHECK FOR BREAK
		
		
		
		if(x_break.getText().toString().equals("") && y_break.getText().toString().equals("")){
			x_break_value=0;
			y_break_value=0;
		}
		
		else if(x_break.getText().toString()!="" && y_break.getText().toString().equals("") && cb.isChecked()==true){
					
					x_break_value=Integer.parseInt(x_break.getText().toString());
					y_break_value=0;
					breaking=true;
				}
				else if(x_break.getText().toString().equals("") && y_break.getText().toString()!="" && cb.isChecked()==true){
										
						x_break_value=0;
						y_break_value=Integer.parseInt(y_break.getText().toString());
						breaking=true;
					
				}
				else if(x_break.getText().toString()!="" && y_break.getText().toString()!="" && cb.isChecked()==true){
					
					x_break_value=Integer.parseInt(x_break.getText().toString());
					y_break_value=Integer.parseInt(y_break.getText().toString());
				}
				
				this.root.ltoggleMenu();		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		resetting=true;
		sb.setProgress(2);
		tv.setText("0%");
		x_scale.setText("");
		y_scale.setText("");
		x_break.setText("");
		y_break.setText("");
		x_break_value=0;
		y_break_value=0;
		x_value=1;
		y_value=1;
		cb.setChecked(false);
		mp.release();
		finish();
	}
}
