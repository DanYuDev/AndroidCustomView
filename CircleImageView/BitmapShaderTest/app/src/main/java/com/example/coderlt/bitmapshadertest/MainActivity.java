package com.example.coderlt.bitmapshadertest;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;

import com.example.coderlt.bitmapshadertest.view.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private CircleImageView cImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 属性动画默认时间 300 ms
         */
        cImageView = findViewById(R.id.c_iv);
        ObjectAnimator animator = ObjectAnimator.ofFloat(cImageView,"radius",300,500);
        animator.setDuration(800);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();
//        radiusAnim.setDuration(1000);
//        radiusAnim.setRepeatCount(ValueAnimator.INFINITE);
//        radiusAnim.setRepeatMode(ValueAnimator.REVERSE);
//        radiusAnim.start();
    }
}
