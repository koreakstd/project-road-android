package koreak.projectroad.app.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import koreak.projectroad.app.adapter.ListTripAdapter;
import koreak.projectroad.app.model.Trip;

/**
 * Created by eB-mobile on 9/21/2017.
 */

public class ListTripViewModel extends BaseObservable {

    private Context context;
    private List<Trip> listTrip = new ArrayList<>();
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String keyword, keywordFinal;

    public ListTripViewModel(Context context, String keyword) {
        this.context = context;
        this.keyword = keyword;
        layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        adapter = new ListTripAdapter(context, listTrip);
        DummyData();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keywordFinal = keyword;
    }

    public void setKeywordFinal(String keyword) {
        this.keyword = keyword;
    }

    public void DummyData() {
        listTrip.add(new Trip(0, "Brazil", "http://www.nationsonline.org/gallery/Brazil/Caracol-Falls-Brazil.jpg", "cukil69", 4.5, 20000, "Bandung", "Brazil", 10));
        listTrip.add(new Trip(1, "Greenland", "http://www.nationsonline.org/gallery/Greenland/Tasiilaq-Greenland.jpg", "cukil69", 4.5, 20000, "Bandung", "Greenland", 10));
        listTrip.add(new Trip(2, "Iceland", "http://www.nationalgeographic.com/content/dam/travel/Guide-Pages/europe/Iceland/iceland_NationalGeographic_2168279.ngsversion.1501515063918.adapt.1900.1.jpg", "cukil69", 4.5, 20000, "Bandung", "Iceland", 10));
        listTrip.add(new Trip(3, "Hawaii", "https://www.ncl.com/sites/default/files/DestinationGalleries.Hawaii.SnorkelingBay900x400.jpg", "cukil69", 4.5, 20000, "Bandung", "Hawaii", 10));

        listTrip.add(new Trip(4, "Brazil", "http://www.nationsonline.org/gallery/Brazil/Caracol-Falls-Brazil.jpg", "cukil69", 4.5, 20000, "Bandung", "Brazil", 10));
        listTrip.add(new Trip(5, "Greenland", "http://www.nationsonline.org/gallery/Greenland/Tasiilaq-Greenland.jpg", "cukil69", 4.5, 20000, "Bandung", "Greenland", 10));
        listTrip.add(new Trip(6, "Iceland", "http://www.nationalgeographic.com/content/dam/travel/Guide-Pages/europe/Iceland/iceland_NationalGeographic_2168279.ngsversion.1501515063918.adapt.1900.1.jpg", "cukil69", 4.5, 20000, "Bandung", "Iceland", 10));
        listTrip.add(new Trip(7, "Hawaii", "https://www.ncl.com/sites/default/files/DestinationGalleries.Hawaii.SnorkelingBay900x400.jpg", "cukil69", 4.5, 20000, "Bandung", "Hawaii", 10));
        adapter.notifyDataSetChanged();
    }

    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return layoutManager;
    }

    @BindingAdapter("listTripAdapter")
    public static void setAdapter(final RecyclerView recyclerView, final RecyclerView.Adapter adapter) {
        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                recyclerView.setAdapter(adapter);
            }
        }, 500);
    }
}
