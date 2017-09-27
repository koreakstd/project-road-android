package koreak.projectroad.app.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import koreak.projectroad.R;
import koreak.projectroad.tablayout.model.FragmentBase;

/**
 * Created by eB-mobile on 9/25/2017.
 */

public class MyTripFragment extends FragmentBase {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.app_fragment_my_trip, container, false);
        return v;
    }

    @Override
    public void onTabClick() {

    }
}
