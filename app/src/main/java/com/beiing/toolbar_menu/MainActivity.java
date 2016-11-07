package com.beiing.toolbar_menu;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    String TAG = "toolbar-menu";

    boolean isSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.e(TAG, "onCreateOptionsMenu");
        getMenuInflater().inflate(R.menu.share_and_save, menu);

        MenuItem customItem = menu.findItem(R.id.menu_custom);
        MainActionProvider actionProvider = (MainActionProvider) MenuItemCompat.getActionProvider(customItem);
        actionProvider.setonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "自定义菜单", Toast.LENGTH_SHORT).show();
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.e(TAG, "onOptionsItemSelected");
        switch (item.getItemId()){
            case R.id.menu_save:
                Toast.makeText(MainActivity.this, "保存", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_share:
                Toast.makeText(MainActivity.this, "分享", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.e(TAG, "onPrepareOptionsMenu");
        if(isSave){
            MenuItem save = menu.findItem(R.id.menu_save);
            save.setVisible(true);
            String title = count == 0 ? "保存" : String.format("保存(%d)", count);
            save.setTitle(title);
            menu.findItem(R.id.menu_share).setVisible(false);
        } else {
            menu.findItem(R.id.menu_save).setVisible(false);
            MenuItem share = menu.findItem(R.id.menu_share);
            share.setVisible(true);
            String title = count == 0 ? "分享" : String.format("分享(%d)", count);
            share.setTitle(title);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        Log.e(TAG, "onPrepareOptionsPanel");
        return super.onPrepareOptionsPanel(view, menu);
    }

    public void taggle(View view) {
        isSave = ! isSave;
        count = 0;
        supportInvalidateOptionsMenu();
    }

    private int count;

    public void increase(View view) {
        count++;
        supportInvalidateOptionsMenu();
        invalidateOptionsMenu();
    }
}
