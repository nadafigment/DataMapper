package com.github.nadafigment.DataMapper;

import java.util.List;

import android.graphics.drawable.Drawable;
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
        
        Drawable drawable = this.getResources().getDrawable(R.drawable.androidmarker);
        
        DataMapperOverlay overlay = new DataMapperOverlay(drawable, this);
        
        GeoPoint point = new GeoPoint(19240000,-99120000);
        DataMapperOverlayItem item = new DataMapperOverlayItem(point, "Hola, Mundo!", "I'm in Mexico City!");
        
        overlay.addOverlay(item);
        
        GeoPoint point2 = new GeoPoint(35410000, 139460000);
        item = new DataMapperOverlayItem(point2, "Sekai, konichiwa!", "I'm in Japan!");
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