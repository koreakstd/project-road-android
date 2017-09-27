package koreak.projectroad.app.view;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import koreak.projectroad.databinding.AppFragmentListTripBinding;
import koreak.projectroad.tablayout.model.FragmentBase;
import koreak.projectroad.app.viewmodel.ListTripViewModel;

/**
 * Created by eB-mobile on 9/21/2017.
 */

public class ListTripFragment extends FragmentBase {

    AppFragmentListTripBinding binding;
    ListTripViewModel viewModel;
    String keyword;
    ListTripFragment instance;
    boolean forceChange = false;

    public static ListTripFragment newInstance(String keyword) {
        ListTripFragment fragment = new ListTripFragment();
        fragment.setKeyword(keyword);
        return fragment;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
        forceChange = true;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (instance == null) {
            instance = this;
            binding = AppFragmentListTripBinding.inflate(inflater, container, false);
            viewModel = new ListTripViewModel(getContext(), keyword);
            binding.setViewModel(viewModel);
        } else {
            binding = instance.binding;
            viewModel = instance.viewModel;
        }
        if (forceChange) {
            viewModel.setKeywordFinal(keyword);
            viewModel.notifyChange();
        }
        forceChange = false;
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onTabClick() {
        binding.listTrip.smoothScrollToPosition(0);
    }
}
