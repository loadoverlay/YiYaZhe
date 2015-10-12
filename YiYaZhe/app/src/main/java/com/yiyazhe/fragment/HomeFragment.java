package com.yiyazhe.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.yiyazhe.R;
import com.yiyazhe.YiYaZheAppConst;
import com.yiyazhe.adapter.GoodsFragmentPagerAdapter;
import com.yiyazhe.model.ChannelItem;
import com.yiyazhe.utils.ScreenSizeUtil;
import com.yiyazhe.view.ColumnHorizontalScrollView;

import java.util.ArrayList;

/**
 * 商品页面
 *
 * Author：JiangChu
 * Date：2015/10/11
 */
public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    // 自定义HorizontalScrollView
    private ColumnHorizontalScrollView mColumnHorizontalScrollView;
    // 存放栏目
    private LinearLayout mRadioGroup_content;
    private ViewPager mViewPager;
    private RelativeLayout rl_column;
    // 用户选择的分类列表
    private ArrayList<ChannelItem> channelItems = new ArrayList<ChannelItem>();
    // 当前选中的栏目
    private int columnSelectIndex = 0;
    // 左阴影部分
    public ImageView shade_left;
    // 右阴影部分
    public ImageView shade_right;
    // 屏幕宽度
    private int mScreenWidth = 0;
    // Item宽度
    private int mItemWidth = 0;
    private ArrayList<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.goods_fragment, container, false);
        mScreenWidth = ScreenSizeUtil.getScreenWidth(getActivity());
        // 一个Item宽度为屏幕的1/4
        mItemWidth = mScreenWidth / 4;

        initView(view);


        return view;
    }

    /**
     * 初始化布局文件
     * @param view
     */
    private void initView(View view) {
        mColumnHorizontalScrollView =  (ColumnHorizontalScrollView)view.findViewById(R.id.mColumnHorizontalScrollView);
        mRadioGroup_content = (LinearLayout) view.findViewById(R.id.mRadioGroup_content);
        rl_column = (RelativeLayout) view.findViewById(R.id.rl_column);
        mViewPager = (ViewPager) view.findViewById(R.id.mViewPager);
        shade_left = (ImageView) view.findViewById(R.id.shade_left);
        shade_right = (ImageView) view.findViewById(R.id.shade_right);

        setChangelView();
    }

    private void setChangelView() {
        initColumnData();
        initTabColumn();
        initFragment();
    }

    /**
     * 获取Column栏目数据
     */
    private void initColumnData() {
        channelItems = YiYaZheAppConst.getData();
    }

    /**
     * 初始化 Column 项目栏
     */
    private void initTabColumn() {
        mRadioGroup_content.removeAllViews();
        int count = channelItems.size();

        Log.v(TAG, count + "");
        mColumnHorizontalScrollView.setParam(getActivity(), mScreenWidth, mRadioGroup_content, shade_left, shade_right, rl_column);
        for (int i = 0; i < count; i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(mItemWidth , LayoutParams.WRAP_CONTENT);
            params.leftMargin = 5;
            params.rightMargin = 5;
//			TextView localTextView = (TextView) mInflater.inflate(R.layout.column_radio_item, null);
            TextView columnTextView = new TextView(getActivity());
            columnTextView.setTextAppearance(getActivity(), R.style.top_category_scroll_view_item_text);
//			localTextView.setBackground(getResources().getDrawable(R.drawable.top_category_scroll_text_view_bg));
            columnTextView.setBackgroundResource(R.drawable.radio_buttong_bg);
            columnTextView.setGravity(Gravity.CENTER);
            columnTextView.setPadding(5, 5, 5, 5);
            columnTextView.setId(i);
            columnTextView.setText(channelItems.get(i).getTitle());
            columnTextView.setTextSize(14);
            columnTextView.setTextColor(getResources().getColorStateList(R.color.top_category_scroll_text_color_day));
            if(columnSelectIndex == i){
                columnTextView.setSelected(true);
            }
            columnTextView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    for(int i = 0;i < mRadioGroup_content.getChildCount();i++){
                        View localView = mRadioGroup_content.getChildAt(i);
                        if (localView != v)
                            localView.setSelected(false);
                        else{
                            localView.setSelected(true);
                            mViewPager.setCurrentItem(i);
                        }
                    }
                    Toast.makeText(getActivity(), channelItems.get(v.getId()).getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
            Log.v(TAG, i + "");
            mRadioGroup_content.addView(columnTextView, i ,params);
        }
    }

    /**
     *  选择的Column里面的Tab
     * */
    private void selectTab(int tab_postion) {
        columnSelectIndex = tab_postion;
        for (int i = 0; i < mRadioGroup_content.getChildCount(); i++) {
            View checkView = mRadioGroup_content.getChildAt(tab_postion);
            int k = checkView.getMeasuredWidth();
            int l = checkView.getLeft();
            int i2 = l + k / 2 - mScreenWidth / 2;
            // rg_nav_content.getParent()).smoothScrollTo(i2, 0);
            mColumnHorizontalScrollView.smoothScrollTo(i2, 0);
            // mColumnHorizontalScrollView.smoothScrollTo((position - 2) *
            // mItemWidth , 0);
        }
        //判断是否选中
        for (int j = 0; j <  mRadioGroup_content.getChildCount(); j++) {
            View checkView = mRadioGroup_content.getChildAt(j);
            boolean ischeck;
            if (j == tab_postion) {
                ischeck = true;
            } else {
                ischeck = false;
            }
            checkView.setSelected(ischeck);
        }
    }

    private void initFragment() {
        int count = channelItems.size();
        for (int i = 0; i < count; i++) {
            Bundle data = new Bundle();
            GoodsFragment goodsfragment = new GoodsFragment();
            goodsfragment.setArguments(data);
            fragments.add(goodsfragment);
        }
        GoodsFragmentPagerAdapter mAdapetr = new GoodsFragmentPagerAdapter(getActivity().getSupportFragmentManager(), fragments);
//      mViewPager.setOffscreenPageLimit(0);
        mViewPager.setAdapter(mAdapetr);
        mViewPager.setOnPageChangeListener(pageListener);
    }

    /**
     *  ViewPager切换监听方法
     * */
    public OnPageChangeListener pageListener= new OnPageChangeListener(){

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int position) {
            // TODO Auto-generated method stub
            mViewPager.setCurrentItem(position);
            selectTab(position);
        }
    };


}
