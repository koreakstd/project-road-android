package koreak.projectroad.app.viewmodel;

import android.databinding.BaseObservable;

import koreak.projectroad.app.view.MainActivity;

/**
 * Created by eB-mobile on 9/25/2017.
 */

public class MainActivityViewModel extends BaseObservable {

    private MainActivity mainActivity;

    public MainActivityViewModel(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

}
