package com.example.administrator.mvptest.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.example.administrator.mvptest.view.BaseView;

/**
 * Created by Administrator on 15-5-13.
 */
public abstract class BaseActivity<V extends BaseView> extends Activity {
    protected V view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            view = getVClass().newInstance();
            view.init(getLayoutInflater(), null);
            setContentView(view.getView());
            onBindV();
            setViewDataHelp();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        onDestroyV();
        view = null;
        super.onDestroy();
    }

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



    protected void onDestroyV() {
    }



    public interface DataHelp {
        public void dataProcessing(int tag, Object data);
    }
}
