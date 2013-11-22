/* Description:- Formatting text in textview in fragmentdetail1
 *  Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */


package com.example.pointfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ill.R;

public class FragmentDetail1 extends Fragment {
	static Button B1;
	static TextView t1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		
	}
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
	    // TODO Add your menu entries here
	    super.onCreateOptionsMenu(menu, inflater);
	    inflater.inflate(R.menu.fragment_detail1, menu);
	    
	}
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {						//assigning ids in xml code to objects in java 
		final View rootView = inflater.inflate(R.layout.activity_fragment_detail1,
				container, false);
		MainActivity.cnt=0;
		t1 = (TextView) rootView.findViewById(R.id.textView2);
		t1.setText(Html.fromHtml(MainActivity.heading[MainActivity.seletion][MainActivity.cnt]+ "<p align=\"justify\"><b><font color=black>" + MainActivity.st[MainActivity.seletion][MainActivity.cnt]+"</font></b></p>"));
		B1= (Button) rootView.findViewById(R.id.button1);
		
		// Show the dummy content as text in a TextView.
    	return rootView;
	}
	
	
	
	}
