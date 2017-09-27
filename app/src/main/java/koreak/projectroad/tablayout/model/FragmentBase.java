package koreak.projectroad.tablayout.model;

import android.support.v4.app.Fragment;

import koreak.projectroad.tablayout.view.MainTabLayout;

/**
 * Created by eB-mobile on 9/25/2017.
 */

public abstract class FragmentBase extends Fragment {

    MainTabLayout mainTabLayout;
    int tabIndex;

    @Override
    public void onStart() {
        super.onStart();
        if (mainTabLayout != null)
            mainTabLayout.changeTab(this);
    }

    public int getTabIndex() {
        return tabIndex;
    }

    public void setTabIndex(int tabIndex) {
        this.tabIndex = tabIndex;
    }

    public void setMainTabLayout(MainTabLayout mainTabLayout) {
        this.mainTabLayout = mainTabLayout;
    }

    public abstract void onTabClick();

}
