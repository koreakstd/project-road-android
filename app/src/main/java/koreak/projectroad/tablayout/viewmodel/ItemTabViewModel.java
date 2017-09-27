package koreak.projectroad.tablayout.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableInt;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.util.Log;
import android.widget.ImageView;

import koreak.projectroad.tablayout.model.TabButton;
import koreak.projectroad.tablayout.util.OnTabClickListener;

/**
 * Created by eB-mobile on 9/26/2017.
 */

public class ItemTabViewModel extends BaseObservable {

    public ObservableInt tabColor = new ObservableInt(Color.WHITE);
    private TabButton tabButton;
    private int tabIndex;
    private OnTabClickListener onTabClickListener;

    public ItemTabViewModel(TabButton tabButton) {
        this.tabButton = tabButton;
    }

    public void setTabIndex(int tabIndex) {
        this.tabIndex = tabIndex;
    }

    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
        this.onTabClickListener = onTabClickListener;
    }

    public int getIcon() {
        return tabButton.getIcon();
    }

    public String getTitle() {
        return tabButton.getTitle();
    }

    public void onTabClick() {
        Log.d("travel_test", "onTabC");
        if (onTabClickListener != null)
            onTabClickListener.onTabClick(tabIndex);
    }

    @BindingAdapter("tabIcon")
    public static void setTabIcon(ImageView imageView, int res) {
        Drawable drawable;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            drawable = VectorDrawableCompat.create(imageView.getContext().getResources(), res, imageView.getContext().getTheme());
        } else {
            drawable = imageView.getContext().getResources().getDrawable(res, imageView.getContext().getTheme());
        }
        imageView.setImageDrawable(drawable);
    }
}
