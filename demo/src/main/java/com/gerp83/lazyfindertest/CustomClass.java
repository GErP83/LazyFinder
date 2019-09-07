package com.gerp83.lazyfindertest;

import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gerp83.lazyfinder.LazyFinder;

/**
 * Created by GErP83 on 2017. 09. 24..
 *
 */

public class CustomClass extends RelativeLayout{

    private TextView text1 = null;
    private TextView text2 = null;
    private TextView text3 = null;
    private TextView text4 = null;

    public CustomClass(Context context) {
        super(context);
        init(context);
    }

    public CustomClass(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomClass(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.test_fragment, null);
        addView(view);
        LazyFinder.findAll(context, this, view);
    }

    public void setTexts(){

        text1.setText("text1 custom class finded");
        text2.setText("text2 custom class finded");
        text3.setText("text3 custom class finded");
        text4.setText("text4 custom class finded");
    }

}
