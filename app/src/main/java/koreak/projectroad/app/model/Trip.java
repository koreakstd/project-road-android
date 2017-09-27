package koreak.projectroad.app.model;

/**
 * Created by eB-mobile on 9/25/2017.
 */

public class Trip {

    private long tripId;
    private String tripName;
    private String tripImage;
    private String tripUser;
    private double tripRating;
    private long tripPrice;
    private String tripFrom;
    private String tripTo;
    private int tripDays;

    public Trip(long id, String name, String image, String user, double rating, long price, String from, String to, int days) {
        tripId = id;
        tripName = name;
        tripImage = image;
        tripUser = user;
        tripRating = rating;
        tripPrice = price;
        tripFrom = from;
        tripTo = to;
        tripDays = days;
    }

    public long getTripId() {
        return tripId;
    }

    public String getTripName() {
        return tripName;
    }

    public String getTripImage() {
        return tripImage;
    }

    public String getTripUser() {
        return tripUser;
    }

    public double getTripRating() {
        return tripRating;
    }

    public long getTripPrice() {
        return tripPrice;
    }

    public String getTripFrom() {
        return tripFrom;
    }

    public String getTripTo() {
        return tripTo;
    }

    public int getTripDays() {
        return tripDays;
    }
}
