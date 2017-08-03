package com.example.administrator.androidanimation.activity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.androidanimation.R;

/**
 * 属性动画
 *
 * @author ZD
 *         created at 2017/7/13 14:42
 *         description：
 *         属性动画是Android3.0版本推出的动画框架，其功能和拓展性都很强
 *         包括：ValueAnimator使用
 *         ObjectAnimator使用
 *         CircularReveral
 */

public class AttributeAnimatonActivity extends AppCompatActivity {

    private ImageView iv;

    private View v;
    private ValueAnimator animator;
    private ObjectAnimator objectAnimator;
    private AnimatorSet animSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_attribute);
        TextView textView = (TextView) findViewById(R.id.tv_title);
        //设置标题
        textView.setText("属性动画实现Tween功能");
        iv = (ImageView) findViewById(R.id.iv);
        v = findViewById(R.id.iv);

    }

    /*
    View从透明到完全不透明，时间1s，先加速再减速：
     */
    public void java_alph(View view) {//透明效果
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv, "alpha", 0f, 1f);

        animator.setDuration(1000);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();
    }

    /*
x轴从自身50%缩放到自身200%，y轴从自身50%缩放到自身200%，中心点（10%，10%）时间1s，先加速再减速：
 */
    public void java_scale(View view) {//缩放效果
        PropertyValuesHolder valuesHolderX = PropertyValuesHolder.ofFloat("scaleX", 0.5f, 1f);
        PropertyValuesHolder valuesHolderY = PropertyValuesHolder.ofFloat("scaleY", 0.5f, 2f);
        //两个中心点其实可以用set方法直接设置，iv.setPivotX(pivotX)
        float pivotX = iv.getWidth() * 0.1f;
        float pivotY = iv.getHeight() * 0.1f;
        PropertyValuesHolder valuesHolderPvX = PropertyValuesHolder.ofFloat("pivotX", pivotX, pivotX);
        PropertyValuesHolder valuesHolderPvY = PropertyValuesHolder.ofFloat("pivotY", pivotY, pivotY);
//        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(iv, valuesHolderX, valuesHolderY, valuesHolderPvX, valuesHolderPvY);
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv, "scaleY", 1f, 3f, 1f);//在垂直方向上放大3倍再还原
        animator.setDuration(1000);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();
    }

    /*
x轴从自身位置50%向右平移相对于自己宽度100%的距离，y轴从自身位置50%向下平移相对于自己100%高度的距离，时间1s，先加速再减速：
 */
    public void java_translate(View view) {//平移效果
        PropertyValuesHolder valuesHolderX = PropertyValuesHolder.ofFloat("translationX", iv.getWidth() * 0.5f, iv.getWidth() * 1.5f);
        PropertyValuesHolder valuesHolderY = PropertyValuesHolder.ofFloat("translationY", iv.getHeight() * 0.5f, iv.getHeight() * 1.5f);
//        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(iv, valuesHolderX, valuesHolderY);
        float curTranslationX = iv.getTranslationX();//TextView先向左移出屏幕，然后再移动回来
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv, "translationX", curTranslationX, -500f, curTranslationX);
        animator.setDuration(1000);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();
    }

    /*
View绕自身中心点(10%,10%)位置，从-270旋转到180，时间1s，先加速再减速 ：
 */
    public void java_rotate(View view) {//旋转效果
        PropertyValuesHolder valuesHolderX = PropertyValuesHolder.ofFloat("rotation", -270f, 180f);
        //两个中心点其实可以用set方法直接设置，iv.setPivotX(pivotX)
        float pivotX = iv.getWidth() * 0.1f;
        float pivotY = iv.getHeight() * 0.1f;
        PropertyValuesHolder valuesHolderPvX = PropertyValuesHolder.ofFloat("pivotX", pivotX, pivotX);
        PropertyValuesHolder valuesHolderPvY = PropertyValuesHolder.ofFloat("pivotY", pivotY, pivotY);
//        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(iv, valuesHolderX, valuesHolderPvX, valuesHolderPvY);
        ObjectAnimator animator = ObjectAnimator.ofFloat(iv, "rotation", 0f, 360f);//一次360度的旋转
        animator.setDuration(1000);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();

    }

    public void xml_alph(View view) {
        Animator animator = AnimatorInflater.loadAnimator(AttributeAnimatonActivity.this, R.animator.alpha);
        animator.setTarget(v);
        animator.start();
    }

    public void xml_scale(View view) {
        Animator animator = AnimatorInflater.loadAnimator(AttributeAnimatonActivity.this, R.animator.scale);
        animator.setTarget(v);
        animator.start();
    }

    public void xml_translate(View view) {
        Animator animator = AnimatorInflater.loadAnimator(AttributeAnimatonActivity.this, R.animator.translate);
        animator.setTarget(v);
        animator.start();
    }

    public void xml_rotate(View view) {
        Animator animator = AnimatorInflater.loadAnimator(AttributeAnimatonActivity.this, R.animator.rotate);
        animator.setTarget(v);
        animator.start();
    }

    public void JAVASetAnimator(View view) {
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(iv, "translationX", -500f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(iv, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(iv, "alpha", 1f, 0f, 1f);
        animSet = new AnimatorSet();
        animSet.play(rotate).with(fadeInOut).after(moveIn);
        animSet.setDuration(5000);
        animSet.start();
    }

    public void XMLSetAnimator(View view) {//将图片先从屏幕外移动进屏幕，然后开始旋转360度，旋转的同时进行淡入淡出操作
        Animator animator = AnimatorInflater.loadAnimator(AttributeAnimatonActivity.this, R.animator.animatorset);
        animator.setTarget(v);
        animator.start();
    }


}
