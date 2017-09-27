package koreak.projectroad.app.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.SwipeDirection;

import java.util.ArrayList;
import java.util.List;

import koreak.projectroad.app.adapter.MainPlaceAdapter;
import koreak.projectroad.app.model.Place;
import koreak.projectroad.app.view.MainFragment;

/**
 * Created by eB-mobile on 9/21/2017.
 */

public class MainViewModel extends BaseObservable {

    public ObservableField<String> placeKeyword = new ObservableField<>("");

    private MainFragment context;
    private List<Place> listPlace = new ArrayList<>();
    private MainPlaceAdapter mainPlaceAdapter;

    public MainViewModel(MainFragment context) {
        this.context = context;
        mainPlaceAdapter = new MainPlaceAdapter(context.getContext(), listPlace);
        DummyData();
    }

    public void DummyData() {
        listPlace.add(new Place(0, "Brazil", "http://www.nationsonline.org/gallery/Brazil/Caracol-Falls-Brazil.jpg"));
        listPlace.add(new Place(1, "Greenland", "http://www.nationsonline.org/gallery/Greenland/Tasiilaq-Greenland.jpg"));
        listPlace.add(new Place(2, "Iceland", "http://www.nationalgeographic.com/content/dam/travel/Guide-Pages/europe/Iceland/iceland_NationalGeographic_2168279.ngsversion.1501515063918.adapt.1900.1.jpg"));
        listPlace.add(new Place(3, "Hawaii", "https://www.ncl.com/sites/default/files/DestinationGalleries.Hawaii.SnorkelingBay900x400.jpg"));
        mainPlaceAdapter.notifyDataSetChanged();
    }

    public String getUserImageUrl() {
        return "https://scontent.fcgk3-1.fna.fbcdn.net/v/t31.0-8/13668940_1233767183324474_4314232993582709600_o.jpg?_nc_eui2=v1%3AAeEPMi4uuguptG4qczGZMhf7k-UXhGHpkrXvn_gsjVowAObFtTkDncwRdLcNTpOAQI7rQ1s1JGZJg4a2HMSulhqPZoVLYgf4wQVxtP_0AL4K0_mV1Rf3ous4L_u-qtwMcHw&oh=e84f5e7103d52afedd57344512710e83&oe=5A542523";
    }

    public MainPlaceAdapter getMainPlaceAdapter() {
        return mainPlaceAdapter;
    }

    public CardStackView.CardEventListener cardEventListener = new CardStackView.CardEventListener() {
        @Override
        public void onCardDragging(float percentX, float percentY) {

        }

        @Override
        public void onCardSwiped(SwipeDirection direction) {
            listPlace.remove(0);
            mainPlaceAdapter.notifyDataSetChanged();
            if (listPlace.size() == 3)
                DummyData();
        }

        @Override
        public void onCardReversed() {

        }

        @Override
        public void onCardMovedToOrigin() {

        }

        @Override
        public void onCardClicked(int index) {
            placeKeyword.set(listPlace.get(index).getPlaceName());
            context.searchPlace();
        }
    };

    @BindingAdapter("mainImageUrl")
    public static void setImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
    }

    @BindingAdapter("mainListPlaceAdapter")
    public static void setListPlaceAdapter(CardStackView view, ArrayAdapter adapter) {
        view.setAdapter(adapter);
    }

    @BindingAdapter("mainListPlaceFlingListener")
    public static void setListPlaceFlingListener(CardStackView view, CardStackView.CardEventListener cardEventListener) {
        view.setCardEventListener(cardEventListener);
    }
}
