package com.github.nadafigment.DataMapper;

import java.util.List;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class DataMapperActivity extends MapActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        MapView mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        
        List<Overlay> mapOverlays = mapView.getOverlays();
        
        int x = 0;
        int y = 0;
        int width = 100;
        int height = 100;
        
        //Drawable drawable = this.getResources().getDrawable(R.drawable.androidmarker);
        
        ShapeDrawable drawable = new ShapeDrawable(new OvalShape());
        drawable.getPaint().setColor(0xff74AC23);
        drawable.setBounds(x, y, x + width, y + height);
        //drawable.setAlpha(128);
        
        
        DataMapperOverlay overlay = new DataMapperOverlay(drawable, this);
        
        GeoPoint point = new GeoPoint(19240000,-99120000);
        OverlayItem item = new OverlayItem(point, "Hola, Mundo!", "I'm in Mexico City!");
        
        overlay.addOverlay(item);
        
        GeoPoint point2 = new GeoPoint(35410000, 139460000);
        item = new OverlayItem(point2, "Sekai, konichiwa!", "I'm in Japan!");
        overlay.addOverlay(item);
        
        mapOverlays.add(overlay);
    }

	/* isRouteDisplayed
	 * must implement this abstract method
	 */
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}