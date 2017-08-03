package com.example.administrator.androidanimation.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.androidanimation.R;

public class TimeInterpolatorActivity extends AppCompatActivity {
    private ImageView iv;
    private ObjectAnimator objectAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_time_interpolaator);
        TextView textView = (TextView) findViewById(R.id.tv_title);
        //设置标题
        textView.setText("自定义Interpolator");

        iv = (ImageView) findViewById(R.id.imageView2);
    }

    public void start(View view) {
        float curTranslationY = iv.getTranslationY();//获取到当前控件的translationX的位置
        objectAnimator = ObjectAnimator.ofFloat(iv, "translationY", curTranslationY, -500f, curTranslationY);

        objectAnimator.setDuration(3000);
        objectAnimator.setRepeatCount(1);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        objectAnimator.addPauseListener(new Animator.AnimatorPauseListener() {
            @Override
            public void onAnimationPause(Animator animation) {//通知动画暂停。

            }

            @Override
            public void onAnimationResume(Animator animation) {//通知动画得到恢复，之前被暂停后。

            }
        });

        objectAnimator.start();
    }

    public void cancle(View view) {
        objectAnimator.cancel();
    }

    /**
     * 自定义插值器
     */
    public class MyDecelerateAccelerateInterpolator implements TimeInterpolator {
        @Override
        public float getInterpolation(float input) {
            if (input <= 0.5) {
                return (float) (Math.sin(Math.PI * input)) / 2;
            } else {
                return (float) (2 - Math.sin(Math.PI * input)) / 2;
            }
        }
    }
}
