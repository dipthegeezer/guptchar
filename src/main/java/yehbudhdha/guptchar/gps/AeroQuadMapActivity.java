package yehbudhdha.guptchar.gps;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import yehbudhdha.guptchar.R;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: dpatel
 * Date: 02/12/11
 * Time: 11:48
 * To change this template use File | Settings | File Templates.
 */
public class AeroQuadMapActivity extends MapActivity {

    private LocationManager lm;
    private LocationListener locationListener;

    private MapView mapView;
    private MapController mc;

    private Context context;

    @Override
    protected boolean isRouteDisplayed() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        context = getBaseContext();

        mapView = (MapView) findViewById(R.id.mapview1);
        mapView.setBuiltInZoomControls(true);
        mc = mapView.getController();

        //set map overlays
        List overlays = mapView.getOverlays();
		MyLocationOverlay lo;
        lo = new MyLocationOverlay(context, mapView);
        overlays.add(lo);
		lo.enableMyLocation();
        lo.enableCompass();

        lm = (LocationManager)
            getSystemService(context.LOCATION_SERVICE);

        locationListener = new MeLocationListener( mapView, mc, context);

        lm.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            0,
            0,
            locationListener);
    }
}
