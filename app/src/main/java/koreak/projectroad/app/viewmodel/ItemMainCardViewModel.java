package koreak.projectroad.app.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import koreak.projectroad.app.model.Place;

/**
 * Created by eB-mobile on 9/21/2017.
 */

public class ItemMainCardViewModel extends BaseObservable {

    Place item;

    public ItemMainCardViewModel(Place item) {
        this.item = item;
    }

    public String getPlaceName() {
        return this.item.getPlaceName();
    }

    public String getPlaceImage() {
        return this.item.getPlaceImage();
    }

    @BindingAdapter("mainCardImageUrl")
    public static void setImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
    }
}
