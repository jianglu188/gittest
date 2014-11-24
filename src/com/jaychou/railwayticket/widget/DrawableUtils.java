package com.jaychou.railwayticket.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;

public class DrawableUtils {
	private static DrawableUtils mUtils;

	private SparseArray<Bitmap> mArray = new SparseArray<Bitmap>();

	public static DrawableUtils getInstance() {
		if (mUtils == null)
			mUtils = new DrawableUtils();
		return mUtils;
	}

	private Drawable getDrawable(int key, Bitmap bitmap, boolean paramBoolean) {
		if ((bitmap.getWidth() <= 0) || (bitmap.getHeight() <= 0)) {
			this.mArray.put(key, bitmap);
			return new BitmapDrawable(bitmap);
		}
		Bitmap.Config config = Bitmap.Config.ARGB_8888;
		Paint paint = new Paint();
		ColorMatrix colorMatrix = new ColorMatrix();
		if (paramBoolean)
			colorMatrix.setScale(2.5F, 2.5F, 2.5F, 1.0F);
		else
			colorMatrix.setScale(0.8F, 0.8F, 0.8F, 1.0F);
		paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
		Bitmap result = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), config);
		new Canvas(result).drawBitmap(bitmap, 0.0F, 0.0F, paint);
		this.mArray.put(key, result);
		return new BitmapDrawable(result);
	}

	protected Drawable getDrawable(Bitmap bitmap, boolean paramBoolean) {
		int key = bitmap.hashCode();
		if (this.mArray.get(key) != null)
			return new BitmapDrawable((Bitmap) this.mArray.get(key));
		return getDrawable(key, bitmap, paramBoolean);
	}
}
