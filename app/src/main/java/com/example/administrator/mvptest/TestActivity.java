package com.example.administrator.mvptest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.administrator.mvptest.presenter.BaseActivity;


public class TestActivity extends BaseActivity{

    @Override
    protected Class<TestV> getVClass() {
        return TestV.class;
    }

    @Override
    protected void setViewDataHelp() {
        view.setDataHelp(new DataHelp() {
            @Override
            public void dataProcessing(int tag, Object data) {
                switch (tag){
                    case TestV.TEST_TAG:
                        view.onDataChange(TestV.TEST_TAG,"success");
                }
            }
        });

    }
}
