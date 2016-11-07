package com.beiing.toolbar_menu;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by chenliu on 2016/11/7.<br/>
 * 描述：
 * </br>
 */
public class MainActionProvider extends ActionProvider {

    LinearLayout customMenu;

    TextView tvTitle;

    View.OnClickListener clickListener;

    /**
     * Creates a new instance.
     *
     * @param context Context for accessing resources.
     */
    public MainActionProvider(Context context) {
        super(context);
    }

    @Override
    public View onCreateActionView() {
        Log.e("toolbar-menu", "onCreateActionView");
        customMenu = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_menu, null);
        tvTitle = (TextView) customMenu.findViewById(R.id.tv_custom_menu);
        customMenu.setOnClickListener(clickListener);

        //return null 时才会调用onPrepareSubMenu方法
//        return null;

        return customMenu;
    }


    @Override
    public void onPrepareSubMenu(SubMenu subMenu) {

        subMenu.clear();
        subMenu.add("子菜单1").setIcon(R.mipmap.ic_launcher)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return true;
                    }
                });
        subMenu.add("子菜单2").setIcon(R.mipmap.ic_launcher)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return true;
                    }
                });

    }

    @Override
    public boolean hasSubMenu() {
        return true;
    }

    public void setonClickListener(View.OnClickListener listener){
        clickListener = listener;
    }

    public void setTvTitle(String title){
        tvTitle.setText(title);
    }

}
