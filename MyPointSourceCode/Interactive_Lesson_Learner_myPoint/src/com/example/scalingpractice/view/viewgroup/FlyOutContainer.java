package com.example.scalingpractice.view.viewgroup;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class FlyOutContainer extends LinearLayout {

	// References to groups contained in this view.
	private View lmenu;
	private View content;
		
	// Constants
	protected static final int menuMargin = 550;

	public enum MenuState {
		CLOSED, OPEN, CLOSING, OPENING
	};
	
	
	// Animation objects
	//	protected Scroller menuAnimationScroller = new Scroller(this.getContext(),	new LinearInterpolator());
		
		protected Scroller menuAnimationScroller = new Scroller(this.getContext(), new SmoothInterpolator());
		protected Runnable menuAnimationRunnable = new AnimationRunnable();
		protected Handler menuAnimationHandler = new Handler();

		// Animation constants
			private static final int menuAnimationDuration = 1000;
			private static final int menuAnimationPollingInterval = 16;
	
	
	

	// Position information attributes
	protected int currentContentOffset = 0;
	protected MenuState lmenuCurrentState = MenuState.CLOSED;
	

	public FlyOutContainer(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public FlyOutContainer(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public FlyOutContainer(Context context) {
		super(context);
	}

	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();

		this.lmenu = this.getChildAt(0);
		this.content = this.getChildAt(1);
		
		this.lmenu.setVisibility(View.GONE);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		if (changed)
			this.calculateChildDimensions();

		this.lmenu.layout(left, top, right - menuMargin, bottom);


		this.content.layout(left + this.currentContentOffset, top, right
				+ this.currentContentOffset, bottom);

	}

	public void ltoggleMenu() {
		switch (this.lmenuCurrentState) {
			case CLOSED:
				this.lmenuCurrentState = MenuState.OPENING;
				this.lmenu.setVisibility(View.VISIBLE);

				this.menuAnimationScroller.startScroll(0, 0, this.getMenuWidth(),
						0, menuAnimationDuration);
				break;
				
			case OPEN:
				this.lmenuCurrentState = MenuState.CLOSING;

				this.menuAnimationScroller.startScroll(this.currentContentOffset,
						0, -this.currentContentOffset, 0, menuAnimationDuration);
				break;
			default:
				return;
		}

		this.menuAnimationHandler.postDelayed(this.menuAnimationRunnable,
				menuAnimationPollingInterval);
		
		this.invalidate();
	}

	
	
	
	
	private int getMenuWidth() {
		return this.lmenu.getLayoutParams().width;
	}

	private void calculateChildDimensions() {
		this.content.getLayoutParams().height = this.getHeight();
		this.content.getLayoutParams().width = this.getWidth();

		this.lmenu.getLayoutParams().width = this.getWidth() - menuMargin;
		this.lmenu.getLayoutParams().height = this.getHeight();
		
	}





private void adjustContentPosition(boolean isAnimationOngoing) {
	
	

	int scrollerOffset = this.menuAnimationScroller.getCurrX();
	this.content.offsetLeftAndRight(scrollerOffset- this.currentContentOffset);
	this.currentContentOffset = scrollerOffset;

	this.invalidate();
	if (isAnimationOngoing)
		this.menuAnimationHandler.postDelayed(this.menuAnimationRunnable,menuAnimationPollingInterval);
	else
		this.onMenuTransitionComplete();
}


private void onMenuTransitionComplete() {
	
	switch (this.lmenuCurrentState) {
		case OPENING:
			this.lmenuCurrentState = MenuState.OPEN;
			break;
			
		case CLOSING:
			this.lmenuCurrentState = MenuState.CLOSED;
			this.lmenu.setVisibility(View.GONE);
			
			break;
			
		default:
			return;
	
	}
}

protected class SmoothInterpolator implements Interpolator{

	@Override
		public float getInterpolation(float t) {
			return (float)Math.pow(t-1, 5) + 1;
		}
}


protected class AnimationRunnable implements Runnable {

	@Override
	public void run() {
			FlyOutContainer.this
					.adjustContentPosition(FlyOutContainer.this.menuAnimationScroller
					.computeScrollOffset());
		}

}




}


