package koreak.projectroad.app.view;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import koreak.projectroad.databinding.AppFragmentMainBinding;
import koreak.projectroad.tablayout.model.FragmentBase;
import koreak.projectroad.app.viewmodel.MainViewModel;

/**
 * Created by eB-mobile on 9/21/2017.
 */

public class MainFragment extends FragmentBase {

    MainFragment instance;
    AppFragmentMainBinding binding;
    MainViewModel viewModel;
    String previousKeyword = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (instance == null) {
            instance = this;
            binding = AppFragmentMainBinding.inflate(inflater, container, false);
            viewModel = new MainViewModel(this);
            binding.tPlaceKeyword.setOnEditorActionListener(placeKeywordEditorListener);
            binding.setViewModel(viewModel);
        } else {
            binding = instance.binding;
            viewModel = instance.viewModel;
        }
        return binding.getRoot();
    }

    TextView.OnEditorActionListener placeKeywordEditorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == EditorInfo.IME_ACTION_DONE) {
                searchPlace();
            }
            return false;
        }
    };

    public void searchPlace() {
        binding.tPlaceKeyword.postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity mainActivity = ((MainActivity) getActivity());
                ((ListTripFragment) mainActivity.binding.mainTabLayout.getTabItems().get(1)).setKeyword(viewModel.placeKeyword.get());
                mainActivity.binding.mainTabLayout.changeFragment(1, new View[] {binding.tPlaceKeywordWrapper});
            }
        }, 50);
    }

    @Override
    public void onTabClick() {

    }
}
