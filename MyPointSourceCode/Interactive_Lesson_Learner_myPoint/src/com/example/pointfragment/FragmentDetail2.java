/* Description:-Display text and images for Basics of any module   
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */


package com.example.pointfragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ill.R;

public class FragmentDetail2 extends Fragment {
	
	Button B2,B3;
	ImageView iv;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);		
	}

		
	

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fragment_detail2, (ViewGroup) menu);
		return true;
	}
	
	private LayoutInflater getMenuInflater() {
		// TODO Auto-generated method stub
		return null;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.activity_fragment_detail2,
				container, false);
		setHasOptionsMenu(true);
		iv = (ImageView) rootView.findViewById(R.id.imageView1);
		MainActivity.cnt=0;
		B2= (Button) rootView.findViewById(R.id.button2);
		B3=(Button) rootView.findViewById(R.id.button1);
		FragmentDetail1.B1.setVisibility(View.INVISIBLE);
		B3.setVisibility(View.INVISIBLE);
		//Assigning the images to their respective content
		switch (MainActivity.seletion) {
		case 0:	iv.setVisibility(View.VISIBLE);
				iv.setImageResource(R.drawable.introex1);
		//		B3.setText("Go to X-Y axis");
				break;
			//Assigning the images to their respective content
		case 1:	iv.setVisibility(View.VISIBLE);
				iv.setImageResource(R.drawable.xandy1);
	//			B3.setText("Go to Properties");
				break;
			//Assigning the images to their respective content
		case 2:iv.setVisibility(View.VISIBLE);
				iv.setImageResource(R.drawable.quad1);
				//			B3.setText("Go to Recap");
			break;
			//Assigning the images to their respective content
		case 3:	iv.setVisibility(View.VISIBLE);
				iv.setImageResource(R.drawable.pointex0);
		//				B3.setText("Go to Solved Eg.");
					//iv.setImageResource(R.drawable.pointex1);
			break;
		case 4:iv.setVisibility(View.GONE);
				break;
			//Assigning the images to their respective content
		case 5:	iv.setVisibility(View.VISIBLE);
				iv.setImageResource(R.drawable.lingenex1);
				//				B3.setText("Go to Explanation");			
				break;
		case 6:	iv.setVisibility(View.VISIBLE);
				iv.setImageResource(R.drawable.lineex1);
				//B3.setText("Go to Solved Eg");
				break;

		default:iv.setVisibility(View.GONE);
			break;
		}

		FragmentDetail1.B1.setOnClickListener(new View.OnClickListener() {
			//Assigning image and contents when button is pressed
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(MainActivity.mp.isPlaying())
					MainActivity.mp.stop();
				
				
				if(MainActivity.cnt!=0)
				{
					B2.setVisibility(View.VISIBLE);
					B3.setVisibility(View.INVISIBLE);
				 	MainActivity.cnt--;
				 	if(MainActivity.cnt==0){
				 		FragmentDetail1.B1.setVisibility(View.INVISIBLE);
				 	}
				 	else{
				 		FragmentDetail1.B1.setVisibility(View.VISIBLE);
						B3.setVisibility(View.INVISIBLE);
				 	}
	//			t1 = (TextView) rootView.findViewById(R.id.textView2);
				 //	FragmentDetail1.t1.setText(MainActivity.st[MainActivity.seletion][MainActivity.cnt]);
				 	//TextViewJustify.justifyText(((TextView)findViewById(R.id.textview)), 305f); 
				 	FragmentDetail1.t1.setText(Html.fromHtml(MainActivity.heading[MainActivity.seletion][MainActivity.cnt] + "<p align=\"justify\"><b><font color=black >" + MainActivity.st[MainActivity.seletion][MainActivity.cnt]+"</font></b></p>"));
				 	//TextViewJustify.justifyText(FragmentDetail1.t1, 150f);
				 	switch (MainActivity.seletion) {
					case 0:if(MainActivity.img[0][MainActivity.cnt]==1){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.introex1);
							}
					
							else if(MainActivity.img[0][MainActivity.cnt]==2){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.introex2);
							}
							else if(MainActivity.img[0][MainActivity.cnt]==3){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.introex3);
							}
							else if(MainActivity.img[0][MainActivity.cnt]==4){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.introex4);
							}
							else
							{
								iv.setVisibility(View.INVISIBLE);
								//iv.setImageResource(R.drawable.introex1);
						
							}
						break;
					case 1:if(MainActivity.img[1][MainActivity.cnt]==1){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.xandy1);
							}
							else if(MainActivity.img[1][MainActivity.cnt]==2){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.xandy2);
							}
							else if(MainActivity.img[1][MainActivity.cnt]==3){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.xandy3);
							}
							else if(MainActivity.img[1][MainActivity.cnt]==4){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.descartesrene);
							}
							else
							{
								iv.setVisibility(View.INVISIBLE);
								//iv.setImageResource(R.drawable.introex1);
							}
						break;
					case 2:if(MainActivity.img[2][MainActivity.cnt]==1){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.quad1);
							}
							else
							{
								iv.setVisibility(View.INVISIBLE);
								//iv.setImageResource(R.drawable.introex1);
							}
						break;
					case 3:if(MainActivity.img[3][MainActivity.cnt]==1){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.pointex1);
							}
							else if(MainActivity.img[3][MainActivity.cnt]==2){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.pointex2);
							}
							else if(MainActivity.img[3][MainActivity.cnt]==3){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.pointex3);
							}
							else if(MainActivity.img[3][MainActivity.cnt]==4){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.pointex4);
							}
							else if(MainActivity.img[3][MainActivity.cnt]==5){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.pointex0);
							}
							else if(MainActivity.img[3][MainActivity.cnt]==6){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.miniop);
							}
							else	
							{
								iv.setVisibility(View.INVISIBLE);
								//iv.setImageResource(R.drawable.introex1);		
							}
						break;
					case 4:if(MainActivity.img[4][MainActivity.cnt]==1){
						iv.setVisibility(View.VISIBLE);
						iv.setImageResource(R.drawable.scaling1);
						}
						else if(MainActivity.img[4][MainActivity.cnt]==2){
						iv.setVisibility(View.VISIBLE);
						iv.setImageResource(R.drawable.scaling2);
						}
						else if(MainActivity.img[4][MainActivity.cnt]==3){
						iv.setVisibility(View.VISIBLE);
						iv.setImageResource(R.drawable.scaling3);
						}
						else
						{
							iv.setVisibility(View.INVISIBLE);
							//iv.setImageResource(R.drawable.introex1);
						}
					break;
					case 5:if(MainActivity.img[5][MainActivity.cnt]==1){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.lingenex1);
							}
							else if(MainActivity.img[5][MainActivity.cnt]==2){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.lingenex2);
							}
							else if(MainActivity.img[5][MainActivity.cnt]==3){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.lingenex3);
							}
							else if(MainActivity.img[5][MainActivity.cnt]==4){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.lingenex4);
							}
							else if(MainActivity.img[5][MainActivity.cnt]==5){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.lingenex5);
							}
							else	
							{
								iv.setVisibility(View.INVISIBLE);
								//iv.setImageResource(R.drawable.introex1);		
							}
						break;
					case 6:if(MainActivity.img[6][MainActivity.cnt]==1){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.lineex1);
							}
							else if(MainActivity.img[6][MainActivity.cnt]==2){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.lineex2);
							}
							else if(MainActivity.img[6][MainActivity.cnt]==3){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.lineex3);
							}
							else if(MainActivity.img[6][MainActivity.cnt]==4){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.lineex4);
							}
							else if(MainActivity.img[6][MainActivity.cnt]==5){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.lineex5);
							}else if(MainActivity.img[6][MainActivity.cnt]==6){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.lineex6);
							}else if(MainActivity.img[6][MainActivity.cnt]==7){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.lineex7);
							}else if(MainActivity.img[6][MainActivity.cnt]==8){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.lineex8);
							}else if(MainActivity.img[6][MainActivity.cnt]==9){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.lineex9);
							}else if(MainActivity.img[6][MainActivity.cnt]==10){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.lineex10);
							}
							else if(MainActivity.img[6][MainActivity.cnt]==11){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.lineex11);
							}
							else if(MainActivity.img[6][MainActivity.cnt]==12){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.lineex12);
							}
							else if(MainActivity.img[6][MainActivity.cnt]==13){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.lineex13);
							}
							else if(MainActivity.img[6][MainActivity.cnt]==14){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.lineex1_1);
							}
							else if(MainActivity.img[6][MainActivity.cnt]==15){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.lineex14);
							}
							else if(MainActivity.img[6][MainActivity.cnt]==16){
								iv.setVisibility(View.VISIBLE);
								iv.setImageResource(R.drawable.line123);
							}
							else
							{
								iv.setVisibility(View.GONE);
								//iv.setImageResource(R.drawable.introex1);
							}
						break;
	
					default:iv.setVisibility(View.INVISIBLE);
						break;
					}
				 	
				}	
				else
				{
					FragmentDetail1.B1.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View v) {
					}});
				}}
		});
		
		
		
		B2.setOnClickListener(new View.OnClickListener() {
			//Assigning image and contents when button is pressed
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(MainActivity.mp.isPlaying())
					MainActivity.mp.stop();
				B3.setVisibility(View.INVISIBLE);
				if((MainActivity.seletion==0 && MainActivity.cnt<4)||(MainActivity.seletion==1 && MainActivity.cnt<3)||
						(MainActivity.seletion==2 && MainActivity.cnt<1)||(MainActivity.seletion==3 && MainActivity.cnt<13)||
						(MainActivity.seletion==4 && MainActivity.cnt<5)||(MainActivity.seletion==5 && MainActivity.cnt<4)||
						(MainActivity.seletion==6 && MainActivity.cnt<22))
				{
				MainActivity.cnt++;
				FragmentDetail1.B1.setVisibility(View.VISIBLE);
		//		t2 = (TextView) rootView.findViewById(R.id.textView2);
				//FragmentDetail1.t1.setText(MainActivity.st[MainActivity.seletion][MainActivity.cnt]); 
			 	//TextViewJustify.justifyText(FragmentDetail1.t1, 150f);
				if((MainActivity.seletion==0 && MainActivity.cnt==4)||(MainActivity.seletion==1 && MainActivity.cnt==3)||
						(MainActivity.seletion==2 && MainActivity.cnt==1)||(MainActivity.seletion==4 && MainActivity.cnt==5)||
						(MainActivity.seletion==5 && MainActivity.cnt==4))
				{
					B2.setVisibility(View.INVISIBLE);
					B3.setVisibility(View.INVISIBLE);
				}
				else if((MainActivity.seletion==3 && MainActivity.cnt==13)||(MainActivity.seletion==6 && MainActivity.cnt==22))
				{
					B2.setVisibility(View.INVISIBLE);
					B3.setVisibility(View.VISIBLE);
				}
				else{
					B2.setVisibility(View.VISIBLE);
					B3.setVisibility(View.INVISIBLE);
				}
				FragmentDetail1.t1.setText(Html.fromHtml(MainActivity.heading[MainActivity.seletion][MainActivity.cnt] + "<p align=\"justify\"><b><font color=black >" + MainActivity.st[MainActivity.seletion][MainActivity.cnt]+"</font></b></p>"));
				switch (MainActivity.seletion) {
				case 0:if(MainActivity.img[0][MainActivity.cnt]==1){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.introex1);
						}
				
						else if(MainActivity.img[0][MainActivity.cnt]==2){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.introex2);
						}
						else if(MainActivity.img[0][MainActivity.cnt]==3){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.introex3);
						}
						else if(MainActivity.img[0][MainActivity.cnt]==4){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.introex4);
						}
						else if(MainActivity.img[0][MainActivity.cnt]==5){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.introex5);
						}
						else
						{
							iv.setVisibility(View.INVISIBLE);
							//iv.setImageResource(R.drawable.introex1);
						}
					break;
				case 1:if(MainActivity.img[1][MainActivity.cnt]==1){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.xandy1);
						}
						else if(MainActivity.img[1][MainActivity.cnt]==2){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.xandy2);
						}
						else if(MainActivity.img[1][MainActivity.cnt]==3){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.xandy3);
						}
						else if(MainActivity.img[1][MainActivity.cnt]==4){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.descartesrene);
						} 
						else
						{
							iv.setVisibility(View.INVISIBLE);
							//iv.setImageResource(R.drawable.introex1);
						}
					break;
				case 2:if(MainActivity.img[2][MainActivity.cnt]==1){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.quad1);
						}
						
						else
						{
							iv.setVisibility(View.INVISIBLE);
							//iv.setImageResource(R.drawable.introex1);
						}
					break;
				case 3:if(MainActivity.img[3][MainActivity.cnt]==1){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.pointex1);
						}
						else if(MainActivity.img[3][MainActivity.cnt]==2){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.pointex2);
						}
						else if(MainActivity.img[3][MainActivity.cnt]==3){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.pointex3);
						}
						else if(MainActivity.img[3][MainActivity.cnt]==4){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.pointex4);
						}
						else if(MainActivity.img[3][MainActivity.cnt]==5){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.pointex0);
						}
						else if(MainActivity.img[3][MainActivity.cnt]==6){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.miniop);
						}
						else	
						{
							iv.setVisibility(View.INVISIBLE);
							//iv.setImageResource(R.drawable.introex1);		
						}
					break;
				case 4:if(MainActivity.img[4][MainActivity.cnt]==1){
					iv.setVisibility(View.VISIBLE);
					iv.setImageResource(R.drawable.scaling1);
					}
					else if(MainActivity.img[4][MainActivity.cnt]==2){
					iv.setVisibility(View.VISIBLE);
					iv.setImageResource(R.drawable.scaling2);
					}
					else if(MainActivity.img[4][MainActivity.cnt]==3){
					iv.setVisibility(View.VISIBLE);
					iv.setImageResource(R.drawable.scaling3);
					}
					else
					{
						iv.setVisibility(View.INVISIBLE);
						//iv.setImageResource(R.drawable.introex1);
					}
				break;
				case 5:if(MainActivity.img[5][MainActivity.cnt]==1){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.lingenex1);
						}
						else if(MainActivity.img[5][MainActivity.cnt]==2){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.lingenex2);
						}
						else if(MainActivity.img[5][MainActivity.cnt]==3){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.lingenex3);
						}
						else if(MainActivity.img[5][MainActivity.cnt]==4){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.lingenex4);
						}
						else if(MainActivity.img[5][MainActivity.cnt]==5){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.lingenex5);
						}
						else	
						{
							iv.setVisibility(View.INVISIBLE);
							//iv.setImageResource(R.drawable.introex1);		
						}
					break;
		
				case 6:if(MainActivity.img[6][MainActivity.cnt]==0){
							iv.setVisibility(View.GONE);
							//iv.setImageResource(R.drawable.lineex1);
						}
						else if(MainActivity.img[6][MainActivity.cnt]==1){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.lineex1);
						}
						else if(MainActivity.img[6][MainActivity.cnt]==2){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.lineex2);
						}
						else if(MainActivity.img[6][MainActivity.cnt]==3){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.lineex3);
						}
						else if(MainActivity.img[6][MainActivity.cnt]==4){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.lineex4);
						}
						else if(MainActivity.img[6][MainActivity.cnt]==5){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.lineex5);
						}else if(MainActivity.img[6][MainActivity.cnt]==6){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.lineex6);
						}else if(MainActivity.img[6][MainActivity.cnt]==7){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.lineex7);
						}else if(MainActivity.img[6][MainActivity.cnt]==8){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.lineex8);
						}else if(MainActivity.img[6][MainActivity.cnt]==9){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.lineex9);
						}else if(MainActivity.img[6][MainActivity.cnt]==10){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.lineex10);
						}
						else if(MainActivity.img[6][MainActivity.cnt]==11){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.lineex11);
						}
						else if(MainActivity.img[6][MainActivity.cnt]==12){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.lineex12);
						}
						else if(MainActivity.img[6][MainActivity.cnt]==13){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.lineex13);
						}
						else if(MainActivity.img[6][MainActivity.cnt]==14){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.lineex1_1);
						}
						else if(MainActivity.img[6][MainActivity.cnt]==15){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.lineex14);
						}
						else if(MainActivity.img[6][MainActivity.cnt]==16){
							iv.setVisibility(View.VISIBLE);
							iv.setImageResource(R.drawable.line123);
						}
						else
						{
							iv.setVisibility(View.INVISIBLE);
							//iv.setImageResource(R.drawable.introex1);
						}
					break;

				default:iv.setVisibility(View.INVISIBLE);
					break;
				}
				}
				else
				{	
					B2.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View v) {
					}});
				}
				/*if((MainActivity.seletion==3 && MainActivity.cnt==14)||(MainActivity.seletion==6 && MainActivity.cnt==5)){
					Intent in=new Intent(getActivity(),com.example.ill.PointFDMainActivity.class);
					startActivity(in);
				}*/
			}
		});
	
		B3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent in=new Intent(getActivity(),com.example.ill.PointFDMainActivity.class);
				startActivity(in);
			}
		});
				
		// Show the dummy content as text in a TextView.
		return rootView;
	}



	private ImageView findViewById(int imageview1) {
		// TODO Auto-generated method stub
		return null;
	}

	 
}
