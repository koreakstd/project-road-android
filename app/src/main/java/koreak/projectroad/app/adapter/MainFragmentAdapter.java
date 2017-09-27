package koreak.projectroad.app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

import koreak.projectroad.tablayout.model.FragmentBase;

/**
 * Created by eB-mobile on 9/26/2017.
 */

public class MainFragmentAdapter extends FragmentPagerAdapter {

    Map<View, FragmentBase> listFragment = new HashMap<>();

    public MainFragmentAdapter(FragmentManager fm, Map<View, FragmentBase> listFragment) {
        super(fm);
        this.listFragment = listFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }
}
