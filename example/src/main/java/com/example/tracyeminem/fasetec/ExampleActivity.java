package com.example.tracyeminem.fasetec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.tracyeminem.latte_core.activities.ProxyActivity;
import com.example.tracyeminem.latte_core.app.Latte;
import com.example.tracyeminem.latte_core.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        Log.e("EEEEE","RRRRR");
        return new ExampleDelegate();
    }

}
