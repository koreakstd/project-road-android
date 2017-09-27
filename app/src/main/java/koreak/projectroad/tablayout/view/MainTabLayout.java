package koreak.projectroad.tablayout.view;

import android.animation.LayoutTransition;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.ncapdevi.fragnav.FragNavController;
import com.ncapdevi.fragnav.FragNavTransactionOptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import koreak.projectroad.databinding.TablayoutLayoutMainBinding;
import koreak.projectroad.tablayout.adapter.TabLayoutAdapter;
import koreak.projectroad.tablayout.model.FragmentBase;
import koreak.projectroad.tablayout.util.OnTabChangeListener;
import koreak.projectroad.tablayout.util.OnTabClickListener;
import koreak.projectroad.tablayout.viewmodel.MainTabViewModel;

/**
 * Created by eB-mobile on 9/26/2017.
 */

public class MainTabLayout extends FrameLayout implements OnTabClickListener {

    TablayoutLayoutMainBinding binding;
    MainTabViewModel viewModel;
    TabLayoutAdapter adapter;
    OnTabChangeListener onTabChangeListener;
    FragNavController fragNavController;
    FragNavController.Builder fragNavBuilder;
    List<Integer> listTabStack = new ArrayList<>();
    Integer currentIndex = 0, previousIndex = 0;

    public MainTabLayout(Context context) {
        super(context);
        initView();
    }

    public MainTabLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MainTabLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public void initView() {
        Log.d("travel_test", "getRootV");
        binding = TablayoutLayoutMainBinding.inflate(LayoutInflater.from(getContext()));
        viewModel = new MainTabViewModel();
        binding.setViewModel(viewModel);
        addView(binding.getRoot());
    }

    public List<FragmentBase> getTabItems() {
        return viewModel.getTabLayoutAdapter().getItems();
    }

    public List<ItemTabView> getTabButtons() {
        return viewModel.getTabLayoutAdapter().getTabButtons();
    }

    public View getTabBorder() {
        if (binding != null)
            return binding.mainTabBorder;
        return null;
    }

    public boolean isRootFragment() {
        return currentIndex.equals(listTabStack.get(0));
    }

    public void setAdapter(TabLayoutAdapter adapter) {
        viewModel.setTabLayoutAdapter(adapter);
        int id = 0;
        for (FragmentBase f : adapter.getItems()) {
            f.setMainTabLayout(this);
            f.setTabIndex(id);
            id++;
        }
        int idd = 0;
        for (ItemTabView tab : adapter.getTabButtons()) {
            tab.setOnTabClickListener(this);
            tab.setTabIndex(idd);
            idd++;
        }
        fragNavBuilder = FragNavController.newBuilder(null, adapter.getFragmentManager(), binding.isiFrame.getId());
        List<Fragment> listFragments = new ArrayList<>();
        listFragments.addAll(adapter.getItems());
        listTabStack.add(0);
        fragNavBuilder.rootFragments(listFragments);
        fragNavController = fragNavBuilder.build();
        binding.executePendingBindings();
    }

    public void setOnTabChangeListener(OnTabChangeListener onTabChangeListener) {
        this.onTabChangeListener = onTabChangeListener;
    }

    public void popFragment() {
        listTabStack.remove(currentIndex);
        changeFragment(listTabStack.get(listTabStack.size() - 1));
    }

    public void changeFragment(int index) {
        changeFragment(index, null);
    }

    public void changeFragment(int index, View[] listSharedElement) {
        if (previousIndex == 0 || index == 0)
            binding.isiFrame.setLayoutTransition(new LayoutTransition());
        else
            binding.isiFrame.setLayoutTransition(null);
        if (listTabStack.contains(index) && listTabStack.indexOf(index) == 0)
            Collections.rotate(listTabStack, listTabStack.size() - 1);
        else if (!listTabStack.contains(index))
            listTabStack.add(index);
        Log.d("travel_test", listTabStack + "");
        currentIndex = index;
        if (listSharedElement == null)
            fragNavController.switchTab(index);
        else {
            FragNavTransactionOptions.Builder fragNavTransactionBuilder = FragNavTransactionOptions.newBuilder();
            for (View v : listSharedElement)
                fragNavTransactionBuilder.addSharedElement(new Pair<View, String>(v, ViewCompat.getTransitionName(v)));
            fragNavController.switchTab(index, fragNavTransactionBuilder.build());
        }
        if (onTabChangeListener != null)
            onTabChangeListener.onTabChange(currentIndex, previousIndex);
        previousIndex = index;
    }

    public void changeTab(FragmentBase fragmentBase) {
        int index = binding.getViewModel().getTabLayoutAdapter().getItems().indexOf(fragmentBase);
        for (ItemTabView tab : binding.getViewModel().getTabLayoutAdapter().getTabButtons())
            tab.setAlpha(0.25f);
        binding.getViewModel().getTabLayoutAdapter().getTabButton(index).setAlpha(1f);
    }

    @Override
    public void onTabClick(int index) {
        Log.d("travel_test", "onTabCCCC " + index);
        changeFragment(index);
    }
}
