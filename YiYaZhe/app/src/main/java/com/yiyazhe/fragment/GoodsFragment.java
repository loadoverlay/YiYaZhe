package com.yiyazhe.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yiyazhe.base.BaseFragment;

import org.w3c.dom.Text;

/**
 * Author：JiangChu
 * Date：2015/10/12
 */
public class GoodsFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText("fragment");
        return textView;
    }
}
