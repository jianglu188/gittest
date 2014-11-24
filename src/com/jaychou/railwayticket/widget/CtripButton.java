package com.jaychou.railwayticket.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.Button;

public class CtripButton extends Button {

	public CtripButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public CtripButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public CtripButton(Context context) {
		super(context);
		init();
	}

	private StateListDrawable getStateListDrawable(Drawable drawable, Drawable pressedDrawable) {
		StateListDrawable stateListDrawable = new StateListDrawable();
		stateListDrawable.addState(new int[] { android.R.attr.state_pressed }, pressedDrawable);
		stateListDrawable.addState(new int[0], drawable);
		return stateListDrawable;
	}

	@SuppressWarnings("deprecation")
	public void init() {
		Drawable drawable = getBackground();
		if ((drawable != null) && ((drawable instanceof BitmapDrawable))) {
			Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
			setBackgroundDrawable(getStateListDrawable(drawable, DrawableUtils.getInstance().getDrawable(bitmap, false)));
		}
	}
}
