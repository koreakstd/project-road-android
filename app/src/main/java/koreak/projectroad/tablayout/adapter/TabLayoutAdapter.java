package koreak.projectroad.tablayout.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import koreak.projectroad.tablayout.model.FragmentBase;
import koreak.projectroad.tablayout.view.ItemTabView;

/**
 * Created by eB-mobile on 9/26/2017.
 */

public class TabLayoutAdapter extends FragmentPagerAdapter {

    LinkedHashMap<ItemTabView, FragmentBase> listFragments = new LinkedHashMap<>();
    FragmentManager fragmentManager;

    public TabLayoutAdapter(FragmentManager fm, LinkedHashMap<ItemTabView, FragmentBase> listFragments) {
        super(fm);
        this.fragmentManager = fm;
        this.listFragments = listFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return (FragmentBase) listFragments.values().toArray()[position];
    }

    public ItemTabView getTabButton(int position) {
        return (ItemTabView) listFragments.keySet().toArray()[position];
    }

    public List<FragmentBase> getItems() {
        return new ArrayList<FragmentBase>(listFragments.values());
    }

    public List<ItemTabView> getTabButtons() {
        return new ArrayList<ItemTabView>(listFragments.keySet());
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }

    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }
}
