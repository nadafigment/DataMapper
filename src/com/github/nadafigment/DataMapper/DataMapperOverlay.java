package com.github.nadafigment.DataMapper;

import java.util.ArrayList;
import java.util.ListIterator;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

/**
 * 
 */

/**
 * @author dpeacock
 *
 */
public class DataMapperOverlay extends ItemizedOverlay<OverlayItem> {

	private ArrayList<DataMapperOverlayItem> mOverlays = new ArrayList<DataMapperOverlayItem>();
	private Context mContext;
	
	public DataMapperOverlay(Drawable defaultMarker) {
		super(boundCenterBottom(defaultMarker));
	}
	
	public DataMapperOverlay(Drawable defaultMarker, Context context) {
		super(boundCenterBottom(defaultMarker));
		mContext = context;
	}

	/* (non-Javadoc)
	 * @see com.google.android.maps.ItemizedOverlay#createItem(int)
	 */
	@Override
	protected OverlayItem createItem(int arg0) {
		return mOverlays.get(arg0);
	}

	/* (non-Javadoc)
	 * @see com.google.android.maps.ItemizedOverlay#size()
	 */
	@Override
	public int size() {
		return mOverlays.size();
	}

	public void addOverlay(DataMapperOverlayItem overlay) {
	    mOverlays.add(overlay);
	    populate();
	}
	
	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		
		ListIterator<DataMapperOverlayItem> litr = mOverlays.listIterator();
        while (litr.hasNext()) {
        	Drawable drawable = litr.next().getMarker(0);
        	drawable.draw(canvas);
        }
        
		super.draw(canvas, mapView, shadow);
	}
	
	@Override
	protected boolean onTap(int index) {
	  OverlayItem item = mOverlays.get(index);
	  AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
	  dialog.setTitle(item.getTitle());
	  dialog.setMessage(item.getSnippet());
	  dialog.show();
	  return true;
	}
	
}
