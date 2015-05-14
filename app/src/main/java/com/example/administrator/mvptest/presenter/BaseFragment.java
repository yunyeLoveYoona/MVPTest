package com.example.administrator.mvptest.presenter;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.mvptest.view.BaseView;

/**
 * Created by Administrator on 15-5-14.
 */
public abstract class BaseFragment<V extends BaseView> extends Fragment{
    protected V v;

    /**
     * 获取需要展示的view
     * @return
     */
    protected abstract Class<V> getVClass();

    /**
     * 设置数据处理方法
     */
    protected abstract void setViewDataHelp();

    protected void onBindV() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = null;
        try {
            v = getVClass().newInstance();
            v.init(inflater,container);
            view = v.getView();
            onBindV();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        onDestroyV();
        v = null;
        super.onDestroyView();
    }

    protected void onDestroyV() {
    }


}
