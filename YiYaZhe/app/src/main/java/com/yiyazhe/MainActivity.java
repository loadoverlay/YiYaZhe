package com.yiyazhe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.yiyazhe.R;
import com.yiyazhe.fragment.HomeFragment;
import com.yiyazhe.view.DrawerView;

/**
 * Author：JiangChu
 * Date：2015/10/11
 */
public class MainActivity extends FragmentActivity {


    private ImageView btn_category;
    private SlidingMenu side_drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initSlidingMenu();
    }

    /**
     * 初始化布局
     */
    private void initView() {
        btn_category = (ImageView) findViewById(R.id.btn_category);
        btn_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (side_drawer.isMenuShowing()) {
                    side_drawer.showContent();
                } else {
                    side_drawer.showMenu();
                }
            }
        });

        replaceFragment(R.id.frame_container, new HomeFragment());
    }

    private void initSlidingMenu() {
        side_drawer = new DrawerView(this).initSlidingMenu();
    }


    /**
     * 替换 Fragment
     * @param id_content
     * @param fragment
     */
    public void replaceFragment(int id_content, Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(id_content, fragment);
        transaction.commit();
    }

}
