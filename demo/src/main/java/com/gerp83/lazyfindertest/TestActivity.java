package com.gerp83.lazyfindertest;

import android.os.Bundle;
import android.widget.TextView;

import com.gerp83.lazyfinder.LazyFinder;

/**
 * Created by GErP83 on 2017. 09. 23..
 *
 */

public class TestActivity extends TestSuperActivity{

    private TextView text1 = null;
    private TextView text2 = null;
    private TextView text3 = null;
    private TextView text5 = null;
    private CustomClass customClass = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        LazyFinder.findAll(this, 2);

        text1.setText("text1 finded");
        text2.setText("text2 finded");
        text3.setText("text3 finded");
        text4.setText("text4 finded");
        text5.setText("text5 finded");

        customClass.setTexts();

    }


}