package com.example.lottieanimation;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.OnCompositionLoadedListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private LottieAnimationView animationView;
    private TextView tv_seek;
    private OkHttpClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // activity_main.xml中 lottie_fileName="data.json"
        // 所以只需要在 app/src/main/assets 中添加AE 生成的 json文件，重命名为data.json就可以显示动画
        animationView = (LottieAnimationView) findViewById(R.id.animation_view);//初始化LottieAnimationView
        tv_seek = (TextView) findViewById(R.id.tv_seek);
    }

    public void btBase(View view) {
        /*
        LottieAnimationView使用代码实现
         */
//        animationView.setAnimation("data.json");
//        animationView.loop(true);
//        animationView.playAnimation();//播放动画
//        animationView.pauseAnimation();//暂停动画
//        animationView.cancelAnimation();//取消动画播放
        /*
        使用LottieComposition
         */
        LottieComposition.Factory.fromAssetFileName(this, "data.json", new OnCompositionLoadedListener() {
            @Override
            public void onCompositionLoaded(@Nullable LottieComposition composition) {
                animationView.setComposition(composition);
                animationView.playAnimation();
            }
        });

    }

    public void btjava(View view) {
        LottieComposition.Factory.fromAssetFileName(this, "LottieLogo1.json", new OnCompositionLoadedListener() {
            @Override
            public void onCompositionLoaded(@Nullable LottieComposition composition) {
                animationView.setComposition(composition);
                animationView.setProgress(0.333f);
                animationView.playAnimation();
            }
        });
        animationView.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                tv_seek.setText(" 动画进度" +(int) (animation.getAnimatedFraction()*100) +"%");
            }
        });

    }

    public void btNetwork(View view) {
        loadUrl("http://www.chenailing.cn/EmptyState.json");
    }
    /*
        * 开始动画
        */
    public   void startAnima(View view){

        boolean inPlaying = animationView.isAnimating();
        if (!inPlaying) {
            animationView.setProgress(0f);
            animationView.playAnimation();
        }
    }
    /*
    * 停止动画
    */
    public   void stopAnima(View view){
        boolean inPlaying = animationView.isAnimating();
        if (inPlaying) {
            animationView.cancelAnimation();
        }
    }
    private void loadUrl(String url) {
        Request request;
        try {
            request = new Request.Builder()
                    .url(url)
                    .build();
        } catch (IllegalArgumentException e) {
            return;
        }


        if (client == null) {
            client = new OkHttpClient();
        }
        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {

            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                }

                try {
                    JSONObject json = new JSONObject(response.body().string());
                    LottieComposition.Factory.fromJson(getResources(), json, new OnCompositionLoadedListener() {
                        @Override
                        public void onCompositionLoaded(@Nullable LottieComposition composition) {
                            setComposition(composition);
                        }
                    });
                } catch (JSONException e) {
                }
            }
        });
    }

    private  void setComposition(LottieComposition composition){
        animationView.setProgress(0);
        animationView.loop(true);
        animationView.setComposition(composition);
        animationView.playAnimation();
    }

    @Override
    protected void onStop() {
        super.onStop();
        animationView.cancelAnimation();
    }
}
