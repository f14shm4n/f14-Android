package f14.android.gps;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by f14shm4n on 14.11.2017.
 */

public final class GeocoderUtil {

    private static final String TAG = GeocoderUtil.class.getSimpleName();

    @NonNull
    public static LocationInfo geocodeCoordinates(@NonNull Context context, double lat, double lng) {
        if (Geocoder.isPresent()) {
            Geocoder geocoder = new Geocoder(context, Locale.getDefault());
            List<Address> addressList = null;
            try {
                addressList = geocoder.getFromLocation(lat, lng, 5);
            } catch (IOException ex) {
                Log.e(TAG, "Geocoder error", ex);
            }

            if (addressList != null && !addressList.isEmpty()) {
                Address address = addressList.get(0);
                String addressLine = "";
                for (int i = 0; i <= address.getMaxAddressLineIndex(); i++) {
                    addressLine += address.getAddressLine(i);
                }

                if (addressLine.isEmpty()) {
                    addressLine = address.toString();
                }
                return new LocationInfo(GeocoderResultStatus.OK, addressLine, lat, lng);
            } else {
                return new LocationInfo(GeocoderResultStatus.EMPTY_ADDRESS);
            }
        } else {
            return new LocationInfo(GeocoderResultStatus.NOT_AVAILABLE);
        }
    }


}
