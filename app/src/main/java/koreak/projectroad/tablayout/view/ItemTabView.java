package koreak.projectroad.tablayout.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import koreak.projectroad.databinding.TablayoutItemTabBinding;
import koreak.projectroad.tablayout.model.TabButton;
import koreak.projectroad.tablayout.util.OnTabClickListener;
import koreak.projectroad.tablayout.viewmodel.ItemTabViewModel;

/**
 * Created by eB-mobile on 9/26/2017.
 */

public class ItemTabView extends FrameLayout {

    TablayoutItemTabBinding binding;
    ItemTabViewModel viewModel;
    TabButton tabButton;

    public ItemTabView(Context context) {
        super(context);
        initView();
    }

    public ItemTabView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ItemTabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public ItemTabView(Context context, int icon) {
        super(context);
        this.tabButton = new TabButton(icon);
        initView();
    }

    public ItemTabView(Context context, String title) {
        super(context);
        this.tabButton = new TabButton(title);
        initView();
    }

    public ItemTabView(Context context, int icon, String title) {
        super(context);
        this.tabButton = new TabButton(icon, title);
        initView();
    }

    public ItemTabView(Context context, TabButton tabButton) {
        super(context);
        this.tabButton = tabButton;
        initView();
    }

    private void initView() {
        Log.d("travel_test", "InitV");
        binding = TablayoutItemTabBinding.inflate(LayoutInflater.from(getContext()));
        viewModel = new ItemTabViewModel(tabButton);
        binding.setViewModel(viewModel);
        addView(binding.getRoot());
        setTintColor(viewModel.tabColor.get());
    }

    public ImageView getIconView() {
        return binding.tabIcon;
    }

    public TextView getTitleView() {
        return binding.tabTitle;
    }

    public void setIcon(int icon) {
        tabButton.setIcon(icon);
        viewModel.notifyChange();
    }

    public void setTitle(String title) {
        tabButton.setTitle(title);
        viewModel.notifyChange();
    }

    public void setTintColor(int color) {
        viewModel.tabColor.set(color);
        binding.tabIcon.setColorFilter(color);
    }

    public void setTabIndex(int index) {
        viewModel.setTabIndex(index);
    }

    public void setTintColor(String color) {
        viewModel.tabColor.set(Color.parseColor(color));
        binding.tabIcon.setColorFilter(Color.parseColor(color));
    }

    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
        viewModel.setOnTabClickListener(onTabClickListener);
    }
}
