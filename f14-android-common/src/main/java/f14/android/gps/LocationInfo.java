package f14.android.gps;

/**
 * Created by f14shm4n on 14.11.2017.
 */

public final class LocationInfo {
    private GeocoderResultStatus status;
    private String address;
    private double lat;
    private double lng;

    public LocationInfo(GeocoderResultStatus status) {
        this(status, null, 0, 0);
    }

    public LocationInfo(GeocoderResultStatus status, String address, double lat, double lng) {
        this.status = status;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
    }

    public GeocoderResultStatus getStatus() {
        return status;
    }

    public String getAddress() {
        return address;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
