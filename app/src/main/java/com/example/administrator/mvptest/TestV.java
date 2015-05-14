package com.example.administrator.mvptest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.mvptest.presenter.BaseActivity;
import com.example.administrator.mvptest.view.BaseView;

/**
 * Created by Administrator on 15-5-14.
 */
public class TestV implements BaseView{
    private View view;
    private BaseActivity.DataHelp dataHelp;
    private Button test;
    public final static int TEST_TAG=1001;
    @Override
    public View getView() {
        return view;
    }

    @Override
    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.activity_main,viewGroup,false);
        test= (Button) view.findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHelp.dataProcessing(TEST_TAG,null);
            }
        });
    }

    @Override
    public void setDataHelp(BaseActivity.DataHelp dataHelp) {
        this.dataHelp=dataHelp;
    }

    @Override
    public void onDataChange(int tag, Object data) {
        switch (tag){
            case TEST_TAG:
                test.setText(data.toString());
        }

    }
}
