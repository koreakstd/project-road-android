package koreak.projectroad.tablayout.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.List;

import koreak.projectroad.tablayout.adapter.TabLayoutAdapter;
import koreak.projectroad.tablayout.model.FragmentBase;
import koreak.projectroad.tablayout.view.ItemTabView;

/**
 * Created by eB-mobile on 9/26/2017.
 */

public class MainTabViewModel extends BaseObservable {

    private TabLayoutAdapter tabLayoutAdapter;

    public MainTabViewModel() {
    }

    public TabLayoutAdapter getTabLayoutAdapter() {
        return tabLayoutAdapter;
    }

    public void setTabLayoutAdapter(TabLayoutAdapter tabLayoutAdapter) {
        this.tabLayoutAdapter = tabLayoutAdapter;
        notifyChange();
    }

    public List<ItemTabView> getTabButtons() {
        return tabLayoutAdapter != null ? tabLayoutAdapter.getTabButtons() : null;
    }

    @BindingAdapter("mainTabCurrentFragment")
    public static void setCurrentFragment(FrameLayout framelayout, FragmentBase fragment) {

    }

    @BindingAdapter("mainTabButtonList")
    public static void setButtonAdapter(LinearLayout linearLayout, List<ItemTabView> buttons) {
        if (buttons != null) {
            Log.d("travel_test", "buttonSize " + buttons.size());
            linearLayout.removeAllViews();
            for (ItemTabView v : buttons) {
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
                v.setLayoutParams(lp);
                linearLayout.addView(v);
            }
        }
    }
}
