package koreak.projectroad.app.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import koreak.projectroad.app.model.Trip;
import koreak.projectroad.app.view.DetailActivity;

/**
 * Created by eB-mobile on 9/21/2017.
 */

public class ItemTripViewModel extends BaseObservable {

    private Trip item;
    private Context context;

    public ItemTripViewModel(Context context, Trip item) {
        this.context = context;
        this.item = item;
    }

    public String getTripUser() {
        return this.item.getTripUser();
    }

    public String getTripName() {
        return this.item.getTripFrom() + " - " + this.item.getTripTo();
    }

    public String getTripImage() {
        return this.item.getTripImage();
    }

    public String getTripPrice() {
        return "$" + this.item.getTripPrice();
    }

    public String getTripRating() {
        return String.valueOf(this.item.getTripRating());
    }

    public String getTripDays() {
        return this.item.getTripDays() + " days";
    }

    @BindingAdapter("listCardImageUrl")
    public static void setImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
    }

    public void tripItemClick() {
        Intent i = new Intent(context, DetailActivity.class);
        context.startActivity(i);
    }
}
