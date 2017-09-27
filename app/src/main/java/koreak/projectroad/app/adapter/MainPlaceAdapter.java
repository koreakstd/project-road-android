package koreak.projectroad.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import koreak.projectroad.databinding.AppItemMainCardBinding;
import koreak.projectroad.app.model.Place;
import koreak.projectroad.app.viewmodel.ItemMainCardViewModel;

/**
 * Created by eB-mobile on 9/21/2017.
 */

public class MainPlaceAdapter extends ArrayAdapter<Place> {

    private List<Place> listPlace = new ArrayList<>();

    public MainPlaceAdapter(Context context, List<Place> listPlace) {
        super(context, 0);
        this.listPlace = listPlace;
    }

    @Override
    public int getCount() {
        return listPlace.size();
    }

    @Override
    public Place getItem(int i) {
        return listPlace.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listPlace.get(i).getPlaceId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MainPlaceViewHolder viewHolder;
        View v = view;
        if (v == null) {
            viewHolder = new MainPlaceViewHolder();
            viewHolder.binding = AppItemMainCardBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            v = viewHolder.binding.getRoot();
            v.setTag(viewHolder);
        } else {
            viewHolder = (MainPlaceViewHolder) v.getTag();
        }
        viewHolder.binding.setViewModel(new ItemMainCardViewModel(listPlace.get(i)));
        viewHolder.binding.executePendingBindings();
        return v;
    }

    private class MainPlaceViewHolder {
        AppItemMainCardBinding binding;
    }
}
