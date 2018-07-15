package com.example.tracyeminem.fasetec;

import android.app.Application;

import com.example.tracyeminem.latte_core.app.Latte;
import com.example.tracyeminem.latte_ec.icon.FontModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;



/**
 * Created by tracyeminem on 2018/7/15.
 */

public class ExampleApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontModule())
                .withApiHost("http://127.0.0.1")
                .configure();

    }
}
