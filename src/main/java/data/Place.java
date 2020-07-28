package data;

public class Place {
    private String place;
    private String latitude;
    private String longitude;

    public Place(String place, String latitude, String longitude) {
        this.place = place;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getPlace() {
        return this.place;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    @Override
    public String toString() {
        return this.place + " " + this.latitude + " " + this.longitude;
    }
}
