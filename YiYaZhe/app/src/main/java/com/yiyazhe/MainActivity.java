package com.yiyazhe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.yiyazhe.view.ColumnHorizontalScrollView;
import com.yiyazhe.view.DrawerView;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    // 自定义HorizontalScrollView
    private HorizontalScrollView mColumnHorizontalScrollView;
    private ViewPager mViewPager;
    /** 用户选择的新闻分类列表*/
//    private ArrayList<ChannelItem> userChannelList=new ArrayList<ChannelItem>();
    // 当前选中的栏目
    private int columnSelectIndex = 0;
    // 左阴影部分
    public ImageView shade_left;
    // 右阴影部分
    public ImageView shade_right;
    // 屏幕宽度
    private int mScreenWidth = 0;
    /** Item宽度 */
    private int mItemWidth = 0;

    private ArrayList<Fragment> fragments = new ArrayList<Fragment>();


    protected SlidingMenu side_drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSlidingMenu();
    }


    protected void initSlidingMenu() {
        side_drawer = new DrawerView(this).initSlidingMenu();
    }


}
