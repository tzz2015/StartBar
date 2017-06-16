package com.rongke.mifan.starbarapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoUtils.setSize(this, false, 720, 1280);
        AutoUtils.auto(this);
        StartBar sb_no_score = (StartBar) findViewById(R.id.sb_no_score);
        sb_no_score.setCore(2);
        StartBar sb_have_score = (StartBar) findViewById(R.id.sb_have_score);
        sb_have_score.setCore(3);
        StartBar sb_touch_score = (StartBar) findViewById(R.id.sb_touch_score);
        sb_touch_score.setCore(4);
    }
}
