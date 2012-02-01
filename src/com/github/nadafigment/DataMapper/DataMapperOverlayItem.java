package com.github.nadafigment.DataMapper;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;

public class DataMapperOverlayItem extends OverlayItem {

	protected ShapeDrawable mDrawable;
	
	public DataMapperOverlayItem(GeoPoint arg0, String arg1, String arg2) {
		super(arg0, arg1, arg2);
		
		int x = 0;
        int y = 0;
        int width = 10;
        int height = 10;
        
		mDrawable = new ShapeDrawable(new OvalShape());
        mDrawable.getPaint().setColor(0xff74AC23);
        mDrawable.setBounds(x, y, x + width, y + height);
        //mDrawable.setAlpha(128);
	}

	/* (non-Javadoc)
	 * @see com.google.android.maps.OverlayItem#getMarker(int)
	 */
	@Override
	public Drawable getMarker(int arg0) {		
		return mDrawable;
		//return super.getMarker(arg0);
	}

}
