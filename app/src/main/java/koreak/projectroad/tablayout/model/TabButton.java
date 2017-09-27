package koreak.projectroad.tablayout.model;

/**
 * Created by eB-mobile on 9/26/2017.
 */

public class TabButton {

    private int icon = -1;
    private String title;

    public TabButton(int res) {
        this.icon = res;
    }

    public TabButton(String title) {
        this.title = title;
    }

    public TabButton(int res, String title) {
        this.icon = res;
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
