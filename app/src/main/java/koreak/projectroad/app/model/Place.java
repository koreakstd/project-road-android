package koreak.projectroad.app.model;

/**
 * Created by eB-mobile on 9/21/2017.
 */

public class Place {

    private long placeId;
    private String placeName;
    private String placeImage;

    public Place(long id, String name, String image) {
        this.placeId = id;
        this.placeName = name;
        this.placeImage = image;
    }

    public long getPlaceId() {
        return placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceImage() {
        return placeImage;
    }
}
