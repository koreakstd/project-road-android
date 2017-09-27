package koreak.projectroad.tablayout.adapter;

import android.content.Context;

import java.util.LinkedHashMap;

import koreak.projectroad.tablayout.model.FragmentBase;
import koreak.projectroad.tablayout.model.TabButton;
import koreak.projectroad.tablayout.view.ItemTabView;

/**
 * Created by eB-mobile on 9/26/2017.
 */

public class TabLayoutAdapterBuilder {

    public static TabLayoutAdapterBuilder with(Context context) {
        return new TabLayoutAdapterBuilder(context);
    }

    private LinkedHashMap<ItemTabView, FragmentBase> listFragments = new LinkedHashMap<>();
    private Context context;

    private TabLayoutAdapterBuilder(Context context) {
        this.context = context;
    }

    public TabLayoutAdapterBuilder add(int tabIcon, FragmentBase fragmentBase) {
        listFragments.put(new ItemTabView(context, tabIcon), fragmentBase);
        return this;
    }

    public TabLayoutAdapterBuilder add(String tabTitle, FragmentBase fragmentBase) {
        listFragments.put(new ItemTabView(context, tabTitle), fragmentBase);
        return this;
    }

    public TabLayoutAdapterBuilder add(int tabIcon, String tabTitle, FragmentBase fragmentBase) {
        listFragments.put(new ItemTabView(context, tabIcon, tabTitle), fragmentBase);
        return this;
    }

    public TabLayoutAdapterBuilder add(TabButton tabButton, FragmentBase fragmentBase) {
        listFragments.put(new ItemTabView(context, tabButton), fragmentBase);
        return this;
    }

    public LinkedHashMap<ItemTabView, FragmentBase> build() {
        return listFragments;
    }

}
