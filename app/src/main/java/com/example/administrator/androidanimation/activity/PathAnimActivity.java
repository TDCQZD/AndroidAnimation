package com.example.administrator.androidanimation.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.administrator.androidanimation.R;

/**
 * Path路径运动
 *
 * @author ZD
 *         created at 2017/7/14 16:31
 *         description：
 */
public class PathAnimActivity extends AppCompatActivity {
    private ImageView iv;

    private int screenWidth;

    private int screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_path_anim);
        iv = (ImageView) findViewById(R.id.iv);
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
    }


    public void startAnim(View view) {
        Path path = new Path();
        path.moveTo(100, 100);
        path.quadTo(screenWidth - 300, 200, screenWidth - 100, screenHeight - 600);

        ObjectAnimator animator = ObjectAnimator.ofFloat(iv, View.X, View.Y, path);
        animator.setDuration(2000);
        animator.setRepeatCount(1);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();

    }
}
