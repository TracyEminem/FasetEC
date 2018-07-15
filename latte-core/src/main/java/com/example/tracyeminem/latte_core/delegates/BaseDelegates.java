package com.example.tracyeminem.latte_core.delegates;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Created by tracyeminem on 2018/7/15.
 */

public abstract class BaseDelegates extends SwipeBackFragment{

    public abstract Object setLayout();

    @SuppressWarnings("SpellCheckingInspection")
    private Unbinder mUbinder = null;

    public abstract void onBindView(@Nullable Bundle saveInstanceState,View rootView);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = null;
        if(setLayout() instanceof Integer){
            rootView = inflater.inflate((Integer) setLayout(),container,false);
        }else if(setLayout() instanceof View){
            rootView = (View) setLayout();
        }

        if(rootView != null){
            mUbinder = ButterKnife.bind(this,rootView);
            onBindView(savedInstanceState,rootView);
            Log.e("EEEEEEE","NOT NULL");
        }

        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mUbinder != null)
            mUbinder.unbind();
    }
}
