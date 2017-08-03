package com.example.administrator.androidanimation.activity;

import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import com.example.administrator.androidanimation.R;
import com.example.administrator.androidanimation.practice.DiditalJumpActivity;
import com.example.administrator.androidanimation.practice.InputETShakeActivity;
import com.example.administrator.androidanimation.practice.RadarSkannaActivity;
import com.example.administrator.androidanimation.practice.WelcomeActivity;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            SVG svg = SVG.getFromResource(this, R.raw.android);
            RectF rectf = svg.getDocumentViewBox(); //viewport的宽高
            Log.e("TAG", "## rectf=" + rectf);
            Set<String> viewList = svg.getViewList();
            Log.e("TAG", "## viewList=" + viewList);
            float documentWidth = svg.getDocumentWidth(); //显示的宽
            float documentHeight = svg.getDocumentHeight(); //显示的高
            Log.e("TAG", "## documentWidth=" + documentWidth + ", documentHeight=" + documentHeight);
            float documentAspectRatio = svg.getDocumentAspectRatio();
            Log.e("TAG", "## documentAspectRatio=" + documentAspectRatio); //宽高比
            float renderDPI = svg.getRenderDPI();
            Log.e("TAG", "## renderDPI=" + renderDPI); //手机屏幕的PPI

            svg.setDocumentWidth(100.f); //设置显示的宽高，具体为ImageView的宽高
            svg.setDocumentHeight(100.f);
        } catch (SVGParseException e) {
            e.printStackTrace();
        }
    }


    public void JavaAnimationStyle(View view) {
        startActivity(new Intent(MainActivity.this, JavaAnimationStyleActivity.class));
    }

    public void XmlAnimationStyle(View view) {
        startActivity(new Intent(MainActivity.this, XmlAnimationStyleActivity.class));
    }


    public void Frame(View view) {
        startActivity(new Intent(MainActivity.this, FrameAnimatonActivity.class));
    }

    public void input(View view) {
        startActivity(new Intent(MainActivity.this, InputETShakeActivity.class));
    }

    public void weclome(View view) {
        startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
    }

    public void pader(View view) {
        startActivity(new Intent(MainActivity.this, RadarSkannaActivity.class));
    }

    public void Attribute(View view) {
        startActivity(new Intent(MainActivity.this, AttributeAnimatonActivity.class));
    }

    public void Animator(View view) {
        startActivity(new Intent(MainActivity.this, AnimatorAnimatonActivity.class));
    }

    public void DiditalJump(View view) {
        startActivity(new Intent(MainActivity.this, DiditalJumpActivity.class));
    }


    public void activitySpecial(View view) {
        startActivity(new Intent(MainActivity.this, ActivitySpecial.class));
    }

    public void CircularReveral(View view) {//>=5.0
        startActivity(new Intent(MainActivity.this, CircularReveralActivity.class));
    }

    public void SurfaceView(View view) {
        startActivity(new Intent(MainActivity.this, SurfaceViewActivity.class));
    }

    public void vector(View view) {
        startActivity(new Intent(MainActivity.this, VectorActivity.class));
    }

    public void drawPath(View view) {
        startActivity(new Intent(MainActivity.this, DrawPathActivity.class));
    }

    public void customSVG(View view) {
        startActivity(new Intent(MainActivity.this, CustomSVGActivity.class));
    }

    public void customSVG2(View view) {
        startActivity(new Intent(MainActivity.this, CustomSVGActivity2.class));
    }
}
