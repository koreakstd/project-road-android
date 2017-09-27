package koreak.projectroad.app.view;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import koreak.projectroad.R;
import koreak.projectroad.databinding.AppActivityMainBinding;
import koreak.projectroad.tablayout.adapter.TabLayoutAdapter;
import koreak.projectroad.tablayout.adapter.TabLayoutAdapterBuilder;
import koreak.projectroad.app.viewmodel.MainActivityViewModel;
import koreak.projectroad.tablayout.util.OnTabChangeListener;
import koreak.projectroad.tablayout.view.ItemTabView;

public class MainActivity extends AppCompatActivity {

    public AppActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.app_activity_main);
        binding.setViewModel(new MainActivityViewModel(this));
        TabLayoutAdapter tabLayoutAdapter = new TabLayoutAdapter(getSupportFragmentManager(),
                TabLayoutAdapterBuilder.with(this)
                        .add(R.drawable.ic_home, "Home", new MainFragment())
                        .add(R.drawable.ic_explore, "Explore", ListTripFragment.newInstance(""))
                        .add(R.drawable.ic_my_trip, "My Trip", new MyTripFragment())
                        .build());
        binding.mainTabLayout.setAdapter(tabLayoutAdapter);
        binding.mainTabLayout.setOnTabChangeListener(new OnTabChangeListener() {
            @Override
            public void onTabChange(int index, int previousIndex) {
                if (index == 0) {
                    binding.mainTabLayout.getTabBorder().setVisibility(View.INVISIBLE);
                    if (previousIndex != 0) {
                        Animation slideRight = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_slide_right);
                        binding.mainBackground.startAnimation(slideRight);
                    }
                    for (ItemTabView tab : binding.mainTabLayout.getTabButtons()) {
                        tab.setTintColor(Color.WHITE);
                        tab.getTitleView().setVisibility(View.VISIBLE);
                    }
                }
                else {
                    binding.mainTabLayout.getTabBorder().setVisibility(View.VISIBLE);
                    if (previousIndex == 0) {
                        Animation slideLeft = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_slide_left);
                        binding.mainBackground.startAnimation(slideLeft);
                    }
                    for (ItemTabView tab : binding.mainTabLayout.getTabButtons()) {
                        tab.setTintColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimaryDark));
                        tab.getTitleView().setVisibility(View.GONE);
                    }
                }
            }
        });
        if (binding.mainTabLayout.getTabBorder() != null) {
            binding.mainTabLayout.getTabBorder().setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
            binding.mainTabLayout.getTabBorder().setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        if (!binding.mainTabLayout.isRootFragment()) {
            binding.mainTabLayout.popFragment();
        }
        else
            super.onBackPressed();
    }

}
