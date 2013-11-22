/* Description:- class for point practice 
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */

package com.example.pointpractice;


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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ill.HomeActivity;
import com.example.ill.R;
import com.example.pointpractice.view.viewgroup.DrawView;
import com.example.pointpractice.view.viewgroup.FlyOutContainer;

public class SampleActivity extends Activity implements OnSeekBarChangeListener {

	FlyOutContainer root;
	MediaPlayer mp;
	int help_flag=0;
	public static float x_value;
	public static float y_value;
	public static float scale = (float)1.0;
	public static boolean plotting=false;
	public static boolean scaling=false;
	public static boolean resetting = false;
	DrawView drawview;
	SeekBar sb;
	TextView tv;
	public EditText x_input,y_input;
	View content;
	static String mImagePath; 
	String instructions = "-> Touch anywhere on the graph to know the co-ordinates of that particular point.<br><br>->To move the graph, touch the origin and move it around.<br><br>->To plot a point, select the <i>Plot Point</i> option from the menu.<br><br>->Once you open the menu, enter X,Y co-ordinates and click on <i>Plot</i> to plot the point.<br><br>->Use the SeekBar to zoom in and out of the graph.<br><br>-> Click on <i>Save Screenshot</i> to save the current screen.";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.root = (FlyOutContainer) this.getLayoutInflater().inflate(R.layout.activity_point_practice, null);
		this.setContentView(root);
		mp = MediaPlayer.create(SampleActivity.this, R.raw.point_help_final);
		sb = (SeekBar) findViewById(R.id.zoom);
		tv = (TextView) findViewById(R.id.percent);
		drawview = new DrawView(this);
		sb.setMax(4);
		sb.setProgress(2);
		sb.setOnSeekBarChangeListener(this);
		x_input = (EditText) findViewById(R.id.x_edit);
		y_input = (EditText) findViewById(R.id.y_edit);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.point_practice_menu, menu);
		return true;
	}
	
	public void ltoggleMenu(View v){
	
		this.root.ltoggleMenu();
	}
	
	
	@Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	    
		switch (item.getItemId()) {
		case R.id.homeee:
			finish();
			break;
	    case R.id.left:
	    	this.root.ltoggleMenu();
	    	Log.d("info","in left");
	    	break;
	    case R.id.text_point_help:
	    	final Dialog dialog = new Dialog(SampleActivity.this);
			dialog.setContentView(R.layout.instructions);
			dialog.setTitle("Instructions for Point Practice");
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
	    	
	    case R.id.audio_point:
	    	if(help_flag==0){
	    		mp = MediaPlayer.create(SampleActivity.this, R.raw.point_help_final);
	    		mp.start();
	    		help_flag=1;
	    		
	    	}
	    	else{
	    		mp.stop();	 
	    		help_flag=0;
	    	}
	    	
	    	break;
	    	
	    	
	    case R.id.screenshot:
	    	content = findViewById(R.id.screenRoot2);
	    	View view = content;
	    	Log.d("info","in screenshot");
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
			  
	        File myPath = new File(mImagePath + "/" ,"Point_"+ dateNow + ".9.PNG");
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
	
	public void plot(View view){
		
		
		if(x_input.getText().toString().equals("") || y_input.getText().toString().equals("")){
			Toast.makeText(this, "Enter both values", Toast.LENGTH_SHORT).show();
		}
		
		else{
		
			x_value=Float.parseFloat(x_input.getText().toString());
			y_value=Float.parseFloat(y_input.getText().toString());
		if(x_value>22.0 || x_value<-22.0 || y_value>10.0 || y_value<-10.0){
		
			Toast.makeText(this, "Enter values within limits", Toast.LENGTH_SHORT).show();
			x_input.setText("");
			y_input.setText("");
		}
		
		else{
		plotting=true;
		this.root.ltoggleMenu();
		}
	
		}		
	}
	
	public void reset(View view){
		resetting=true;
		sb.setProgress(2);
		tv.setText("0%");
		x_input.setText("");
		y_input.setText("");
		this.root.ltoggleMenu();
	}
	
	public void close(View v){
		this.root.ltoggleMenu();
	}
	
	public static boolean getReset(){
		
		return resetting;
	}
	
	public static void setReset(boolean x){
		resetting = x;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		resetting=true;
		sb.setProgress(2);
		tv.setText("0%");
		x_input.setText("");
		y_input.setText("");
		x_value=0;
		y_value=0;
		x_value=1;
		y_value=1;
		mp.release();
		finish();
	}
	
}
