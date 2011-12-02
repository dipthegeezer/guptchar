package yehbudhdha.guptchar.gps;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

/**
 * Created by IntelliJ IDEA.
 * User: dpatel
 * Date: 02/12/11
 * Time: 16:14
 * To change this template use File | Settings | File Templates.
 */
public class MeLocationListener implements LocationListener{
    private MapView mapView;
    private MapController mapController;

    public MeLocationListener(MapView mv, MapController mc){
        mapView = mv;
        mapController = mc;
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
            Toast.makeText(getBaseContext(),
               "Location changed : Lat: " + location.getLatitude() +
                " Lng: " + loc.getLongitude(),
                    Toast.LENGTH_SHORT).show();

                GeoPoint p = new GeoPoint(
                        (int) (location.getLatitude() * 1E6),
                        (int) (location.getLongitude() * 1E6));
                mapController.animateTo(p);
                mapController.setZoom(16);
                mapView.invalidate();
            }
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onProviderEnabled(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onProviderDisabled(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}
