package koreak.projectroad.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import koreak.projectroad.app.model.Trip;
import koreak.projectroad.app.viewmodel.ItemTripViewModel;
import koreak.projectroad.databinding.AppItemTripBinding;

/**
 * Created by eB-mobile on 9/21/2017.
 */

public class ListTripAdapter extends RecyclerView.Adapter<ListTripAdapter.TripViewHolder> {

    private List<Trip> listTrip = new ArrayList<>();
    private Context context;

    public ListTripAdapter(Context context, List<Trip> listTrip) {
        this.context = context;
        this.listTrip = listTrip;
    }

    @Override
    public TripViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TripViewHolder(AppItemTripBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(TripViewHolder holder, int position) {
        holder.bind(listTrip.get(position));
    }

    @Override
    public int getItemCount() {
        return listTrip.size();
    }

    public class TripViewHolder extends RecyclerView.ViewHolder {

        AppItemTripBinding binding;

        public TripViewHolder(AppItemTripBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Trip item) {
            binding.setViewModel(new ItemTripViewModel(context, item));
            binding.executePendingBindings();
        }
    }

}
