/* Description:-Setting functionality to switch between different modules through swiping and selecting the tabs.
 * Author:Mradu Bansal              Email-id:mradu_bansal786@yahoo.com
 * Author:Rindu John                Email-id:rindu.john92@gmail.com
 * Author:Nikhilesh Ganesan         Email-id:nikhileshg92@gmail.com
 * Author:Upendra Ghintala          Email-id:upendrajat77@gmail.com 
 */


package com.example.ill;

import java.util.Locale;

import android.app.ActionBar;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements
		ActionBar.TabListener {
	SectionsPagerAdapter mSectionsPagerAdapter;
	static int var = 0;
	static int webvar = 0;
	ViewPager mViewPager;
	public static int pointSelect = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about_us, menu);
		return true;
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		
			mViewPager.setCurrentItem(tab.getPosition());
		
		if(tab.getPosition() == 0) {
		}
		else if(tab.getPosition() == 1) {
		}
		else if(tab.getPosition() == 2) {
		}
		else if(tab.getPosition() == 3) {
		}
		else if(tab.getPosition() == 4) {

		}
	}


	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = new DummySectionFragment();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			// Show 5 total pages.
			return 5;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			case 3:
				return getString(R.string.title_section4).toUpperCase(l);
			case 4:
				return getString(R.string.title_section5).toUpperCase(l);
			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main_dummy,
					container, false);
			
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);
			dummyTextView.setText(Integer.toString(getArguments().getInt(
					ARG_SECTION_NUMBER)));
			if(getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
				rootView = inflater.inflate(R.layout.fragment_main_dummy, container, false);	
				webvar = 1;
			}
			else if(getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
				rootView = inflater.inflate(R.layout.fragment_main_dummy_point, container, false);
				webvar = 2;
			}
			else if(getArguments().getInt(ARG_SECTION_NUMBER) == 3) {
				rootView = inflater.inflate(R.layout.fragment_main_dummy_scaling, container, false);
				webvar = 3;
			}
			else if(getArguments().getInt(ARG_SECTION_NUMBER) == 4) {
				rootView = inflater.inflate(R.layout.fragment_main_dummy_line, container, false);
				webvar = 4;
			}
			else if(getArguments().getInt(ARG_SECTION_NUMBER) == 5) {
				rootView = inflater.inflate(R.layout.fragment_main_dummy_test, container, false);
				webvar = 5;
			}
			return rootView;
		}
	}
	
	public void introexample1(View v) {
		com.example.pointfragment.MainActivity.seletion=0;
		Intent in = new Intent(MainActivity.this, com.example.pointfragment.MainActivity.class);
		startActivity(in);

	}
	public void introxyaxis(View v) {
		com.example.pointfragment.MainActivity.seletion=1;
		Intent in = new Intent(MainActivity.this, com.example.pointfragment.MainActivity.class);
		startActivity(in);

	}
	public void introquad(View v) {
		com.example.pointfragment.MainActivity.seletion=2;
		Intent in = new Intent(MainActivity.this, com.example.pointfragment.MainActivity.class);
		startActivity(in);

	}
	public void animation(View v) {
		Intent in = new Intent(MainActivity.this, AnimationActivity.class);
		startActivity(in);
	}
	
	
	public void pointgen1(View v) {
		pointSelect = 1;
		Intent in = new Intent(MainActivity.this, PointActivity.class);
		startActivity(in);
	}
	public void pointexplanation(View v) {
		com.example.pointfragment.MainActivity.seletion=3;
		Intent in = new Intent(MainActivity.this, com.example.pointfragment.MainActivity.class);
		startActivity(in);

	}
	public void pointsolved(View v) {
		pointSelect = 2;
		Intent in = new Intent(MainActivity.this, PointActivity.class);
		startActivity(in);
	}
	public void pointpractice(View v) {
		
		Intent in = new Intent(MainActivity.this, com.example.pointpractice.SampleActivity.class);
		startActivity(in);
		
	}
	public void pointtest(View v) {
		final Dialog dialog = new Dialog(MainActivity.this);
		dialog.setContentView(R.layout.pointtest);
		dialog.setTitle(Html.fromHtml("<font color=#085D04><strong>Point Quiz</strong></font>"));
		// set the custom dialog components - text, image and button
		dialog.show();
		Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
		// if button is clicked, close the custom dialog
		dialogButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
		Button b1 = (Button) dialog.findViewById(R.id.button_point_test1);
		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				var  = 1;
				Intent in = new Intent(MainActivity.this , QuizActivity.class);
				startActivity(in);
			}
		});
		Button b2 = (Button) dialog.findViewById(R.id.button_point_test2);
		b2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				var = 2;
				Intent in = new Intent(MainActivity.this , QuizActivity.class);
				startActivity(in);
			}
		});
		Button b3 = (Button) dialog.findViewById(R.id.button_point_test3);
		b3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				var = 3;
				Intent in = new Intent(MainActivity.this , com.example.pointtest.LaunchScreen.class);
				startActivity(in);
			}
		});
		
		
	}
	
	public void scalinggen1(View v) {
		pointSelect = 3;
		Intent in  = new Intent(MainActivity.this,PointActivity.class);
		startActivity(in);
	}

	public void scalingexplanation(View v) {
		com.example.pointfragment.MainActivity.seletion=4;
		Intent in = new Intent(MainActivity.this, com.example.pointfragment.MainActivity.class);
		startActivity(in);

	}
	public void scalingsolved(View v) {
		pointSelect = 4;
		Intent in  = new Intent(MainActivity.this,PointActivity.class);
		startActivity(in);
	}
	public void scalingpractice(View v) {
	
		Intent in = new Intent(MainActivity.this, com.example.scalingpractice.SampleActivity.class);
		startActivity(in);
		
	}
	public void scalingtest(View v) {
		var = 3;
		Intent in = new Intent(MainActivity.this , QuizActivity.class);
		startActivity(in);
	}
	
	public void linegen1(View v) {
		com.example.pointfragment.MainActivity.seletion=5;
		Intent in = new Intent(MainActivity.this, com.example.pointfragment.MainActivity.class);
		startActivity(in);
}
	public void linesolved(View v) {
		pointSelect = 6;
		Intent in  = new Intent(MainActivity.this,PointActivity.class);
		startActivity(in);
	}
	public void lineexplanation(View v) {
		com.example.pointfragment.MainActivity.seletion=6;
		Intent in = new Intent(MainActivity.this, com.example.pointfragment.MainActivity.class);
		startActivity(in);

	}
	public void linepractice(View v) {
		
		Intent in = new Intent(MainActivity.this, com.example.linepractice.MainActivity.class);
		startActivity(in);

		
	}
	public void linetest(View v) {
		final Dialog dialog = new Dialog(MainActivity.this);
		dialog.setContentView(R.layout.linetest);
		dialog.setTitle(Html.fromHtml("<font color=#085D04><strong>Line Quiz</strong></font>"));
		// set the custom dialog components - text, image and button
		dialog.show();
		Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
		// if button is clicked, close the custom dialog
		dialogButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
		Button b1 = (Button) dialog.findViewById(R.id.button_lines_test1);
		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				var  = 4;
				Intent in = new Intent(MainActivity.this , QuizActivity.class);
				startActivity(in);
			}
		});
		Button b2 = (Button) dialog.findViewById(R.id.button_lines_test2);
		b2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				var = 5;
				Intent in = new Intent(MainActivity.this , QuizActivity.class);
				startActivity(in);
			}
		});
		
		Button b3 = (Button) dialog.findViewById(R.id.button_lines_test3);
		b3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				Intent in = new Intent(MainActivity.this , com.example.linetest.LaunchScreen.class);
				startActivity(in);
			}
		});
		
		
	}
	
	
	public void finaltest(View v) {
		
		Spinner spin =(Spinner) v.getRootView().findViewById(R.id.spinner1);
		
		if(spin.getSelectedItemPosition()==0){
		Intent in = new Intent(MainActivity.this , com.example.finaleasy.MainActivity.class);
		startActivity(in);
		}
		else{
		Intent in = new Intent(MainActivity.this , com.example.finaltough.MainActivity.class);
		startActivity(in);
		}
	}	
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.aboutus:
			Intent in  = new Intent(this, AboutUs.class);
			startActivity(in);
			break;
			case R.id.cpsubmenu1:
				Intent in1  = new Intent(Intent.ACTION_VIEW, Uri.parse("http://en.wikipedia.org/wiki/Cartesian_coordinate_system"));
				startActivity(in1);
				break;
				
			case R.id.plsubmenu1:
				Intent in2  = new Intent(Intent.ACTION_VIEW, Uri.parse("http://en.wikipedia.org/wiki/Point_plotting"));
				startActivity(in2);
				break;
			case R.id.google:
				Intent in3  = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/"));
				startActivity(in3);
				break;
			case R.id.lisubmenu1:
				Intent in4  = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Line_chart"));
				startActivity(in4);
				break;
			case R.id.qusubmenu1:
				Intent in5  = new Intent(Intent.ACTION_VIEW, Uri.parse("http://en.wikipedia.org/wiki/Quiz"));
				startActivity(in5);
			break;
			case R.id.cpsubmenu2:
				Intent in6  = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.khanacademy.org/math/algebra/introduction-to-algebra/overview_hist_alg/v/descartes-and-cartesian-coordinates"));
				startActivity(in6);
				break;
			case R.id.plsubmenu2:
				Intent in7  = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.khanacademy.org/math/algebra/linear-equations-and-inequalitie/coordinate-plane/v/plot-ordered-pairs"));
				startActivity(in7);
				break;
			case R.id.lisubmenu2:
				Intent in9  = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.khanacademy.org/math/algebra/linear-equations-and-inequalitie/equation-of-a-line/v/graphing-a-line-in-slope-intercept-form"));
				startActivity(in9);
				break;
			case R.id.qusubmenu2:
				Intent in10  = new Intent(Intent.ACTION_VIEW, Uri.parse("http://en.wikipedia.org/wiki/Quiz"));
				startActivity(in10);
				break;
			default:
				break;
		}
		return true;
	}
	
	
}
