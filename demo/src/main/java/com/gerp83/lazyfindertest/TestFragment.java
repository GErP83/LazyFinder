package com.gerp83.lazyfindertest;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gerp83.lazyfinder.LazyFinder;

/**
 * Created by GErP83 on 2017. 09. 24..
 *
 */

public class TestFragment extends Fragment{

    private TextView text1 = null;
    private TextView text2 = null;
    private TextView text3 = null;
    private TextView text4 = null;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.test_fragment, null);
        LazyFinder.findAll(getActivity(), this, view);

        text1.setText("text1 fragment finded");
        text2.setText("text2 fragment finded");
        text3.setText("text3 fragment finded");
        text4.setText("text4 fragment finded");

        return view;
    }
}
