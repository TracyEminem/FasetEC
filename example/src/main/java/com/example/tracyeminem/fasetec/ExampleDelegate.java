package com.example.tracyeminem.fasetec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.tracyeminem.latte_core.delegates.LatteDelegate;

/**
 * Created by tracyeminem on 2018/7/16.
 */

public class ExampleDelegate extends LatteDelegate{


    @Override
    public Object setLayout() {
        Log.e("EEEEEE","eeeee");
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle saveInstanceState, View rootView) {

    }
}
