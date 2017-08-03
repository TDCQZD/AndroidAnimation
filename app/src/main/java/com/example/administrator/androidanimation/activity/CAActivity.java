package com.example.administrator.androidanimation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.Window;

import com.example.administrator.androidanimation.R;

public class CAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int flag = getIntent().getExtras().getInt("flag");
        switch (flag) {
            case 0:
                getWindow().setEnterTransition(new Explode());
                getWindow().setExitTransition(new Explode());
                break;
            case 1:
                getWindow().setEnterTransition(new Slide());
                getWindow().setExitTransition(new Slide());
                break;
            case 2:
                getWindow().setEnterTransition(new Fade());
                getWindow().setExitTransition(new Fade());
                break;
            case 3:
                getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
                break;
            default:
                break;
        }
        setContentView(R.layout.activity_ca);

    }
    public void backToActivity(View view) {
        this.finish();
        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
    }
}
