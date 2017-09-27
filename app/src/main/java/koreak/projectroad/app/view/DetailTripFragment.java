package koreak.projectroad.app.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import koreak.projectroad.app.viewmodel.DetailTripViewModel;
import koreak.projectroad.databinding.AppFragmentDetailTripBinding;

/**
 * Created by eB-mobile on 9/26/2017.
 */

public class DetailTripFragment extends Fragment {

    AppFragmentDetailTripBinding binding;
    DetailTripViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = AppFragmentDetailTripBinding.inflate(inflater, container, false);
        viewModel = new DetailTripViewModel();
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }
}
