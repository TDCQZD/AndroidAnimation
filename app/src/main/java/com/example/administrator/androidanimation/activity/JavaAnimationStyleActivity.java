package com.example.administrator.androidanimation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.androidanimation.R;

/**
 * 在Java代码中定义动画类型
 *
 * @author ZD
 *         created at 2017/7/13 11:34
 *         description：
 */

public class JavaAnimationStyleActivity extends AppCompatActivity {
    private ImageView iv;
    //在代码中定义 动画实例对象
    private Animation animation_Alpha;
    private Animation animation_Scale;
    private Animation animation_Translate;
    private Animation animation_Rotate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_xmlstyle);
        iv = (ImageView) findViewById(R.id.iv);
      TextView  textView = (TextView) findViewById(R.id.tv_title);
        //设置标题
        textView.setText("JAVA实现补间动画");
    }

    public void alph(View view) {
        /*
           AlphaAnimation(float fromAlpha, float toAlpha)
          第一个参数fromAlpha为 动画开始时候透明度
         第二个参数toAlpha为 动画结束时候透明度
         */
        animation_Alpha = new AlphaAnimation(0.1f, 1.0f);//说明:0.0表示完全透明,1.0表示完全不透明
        animation_Alpha.setDuration(5000);
        //设置线性变化
        animation_Alpha.setInterpolator(new LinearInterpolator());
        //设置动画重复次数
        animation_Alpha.setRepeatCount(1);//重复3次Animation.INFINITE
        //设置动画监听
        animation_Alpha.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                Log.e("TAG", "动画开始");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.e("TAG", "动画重复");

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.e("TAG", "动画结束");
            }
        });

        iv.startAnimation(animation_Alpha);
    }

    public void scale(View view) {

//      ScaleAnimation(float fromX, float toX, float fromY, float toY,
//      int pivotXType, float pivotXValue, int pivotYType, float pivotYValue)
        /*
      第一个参数fromX为动画起始时 X坐标上的伸缩尺寸
      第二个参数toX为动画结束时 X坐标上的伸缩尺寸
      第三个参数fromY为动画起始时Y坐标上的伸缩尺寸
      第四个参数toY为动画结束时Y坐标上的伸缩尺寸
      说明:
            以上四种属性值
            0.0表示收缩到没有
            1.0表示正常无伸缩
            值小于1.0表示收缩
            值大于1.0表示放大
     第五个参数pivotXType为动画在X轴相对于物件位置类型
     第六个参数pivotXValue为动画相对于物件的X坐标的开始位置
     第七个参数pivotXType为动画在Y轴相对于物件位置类型
     第八个参数pivotYValue为动画相对于物件的Y坐标的开始位置
         */
        animation_Scale = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation_Scale.setDuration(2000);

        iv.startAnimation(animation_Scale);
        animation_Scale.reset();
    }

    public void translate(View view) {
        /*
         TranslateAnimation(float fromXDelta, float toXDelta,float fromYDelta, float toYDelta)
         第一个参数fromXDelta为动画起始时 X坐标上的移动位置
         第二个参数toXDelta为动画结束时 X坐标上的移动位置
         第三个参数fromYDelta为动画起始时Y坐标上的移动位置
         第四个参数toYDelta为动画结束时Y坐标上的移动位置
         */

        animation_Translate = new TranslateAnimation(30, 30, -80, 300);
        animation_Translate.setDuration(2000);
        iv.startAnimation(animation_Translate);

    }

    public void rotate(View view) {
/*
RotateAnimation(float fromDegrees, float toDegrees,int pivotXType, float pivotXValue, int pivotYType, float pivotYValue)
第一个参数fromDegrees为动画起始时的旋转角度
第二个参数toDegrees为动画旋转到的角度
第三个参数pivotXType为动画在X轴相对于物件位置类型
第四个参数pivotXValue为动画相对于物件的X坐标的开始位置
第五个参数pivotXType为动画在Y轴相对于物件位置类型
第六个参数pivotYValue为动画相对于物件的Y坐标的开始位置
 */
        animation_Rotate = new RotateAnimation(0.0f, +350.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation_Rotate.setDuration(2000);
        iv.startAnimation(animation_Rotate);
    }

    public void setGroupAnimation(View v) {
        animation_Alpha = new AlphaAnimation(0.1f, 1.0f);
        animation_Scale = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation_Translate = new TranslateAnimation(30, 30, -80, 300);
        animation_Rotate = new RotateAnimation(0.0f, +350.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        AnimationSet animationset = new AnimationSet(true);
        animationset.addAnimation(animation_Alpha);
        animationset.addAnimation(animation_Rotate);
        animationset.addAnimation(animation_Scale);
        animationset.addAnimation(animation_Translate);
        animationset.setInterpolator(new LinearInterpolator());
        animationset.setRepeatCount(Animation.INFINITE);//重复3次
        animationset.setDuration(10000);
        iv.startAnimation(animationset);
    }


}
