package koreak.projectroad.app.view;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.bumptech.glide.Glide;

import koreak.projectroad.R;
import koreak.projectroad.databinding.AppActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    AppActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        binding = DataBindingUtil.setContentView(this, R.layout.app_activity_detail);
        setSupportActionBar(binding.detailToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Glide.with(this).load("https://scontent.fcgk3-1.fna.fbcdn.net/v/t31.0-8/13668940_1233767183324474_4314232993582709600_o.jpg?_nc_eui2=v1%3AAeEPMi4uuguptG4qczGZMhf7k-UXhGHpkrXvn_gsjVowAObFtTkDncwRdLcNTpOAQI7rQ1s1JGZJg4a2HMSulhqPZoVLYgf4wQVxtP_0AL4K0_mV1Rf3ous4L_u-qtwMcHw&oh=e84f5e7103d52afedd57344512710e83&oe=5A542523").into(binding.userImage);

        binding.detailAppBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    Log.d("travel_test", "Show");
                    binding.detailCollapsingToolbar.setTitle(getSupportActionBar().getTitle());
                    binding.detailCollapsingToolbar.setCollapsedTitleTextColor(Color.WHITE);
                    binding.detailCollapsingToolbar.setExpandedTitleColor(Color.WHITE);
                    isShow = true;
                } else if (isShow) {
                    Log.d("travel_test", "Not show");
                    binding.detailCollapsingToolbar.setTitle("");
                    binding.detailCollapsingToolbar.setCollapsedTitleTextColor(Color.TRANSPARENT);
                    binding.detailCollapsingToolbar.setExpandedTitleColor(Color.TRANSPARENT);
                    isShow = false;
                }
            }
        });
//        getSupportFragmentManager().beginTransaction().replace(R.id.isiFrame, new DetailTripFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
