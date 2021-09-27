package com.snmgroup.justlaw;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    ImageView image_logo;
    TextView justLaw;

    //Logo Animation:

    ScaleAnimation scaleInAnimation,scaleOutAnimation;
    TranslateAnimation translateLogo;
    AnimationSet setLogo;

    //Text Animation:

    AnimationSet animationSetText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        image_logo = findViewById(R.id.image_logo);
        justLaw = findViewById(R.id.justLaw);


        //LogoAnimation:

        scaleInAnimation = new ScaleAnimation(1,1.5f,1,1.5f,
                            Animation.RELATIVE_TO_SELF,0.5f,
                            Animation.RELATIVE_TO_SELF,0.5f);
        scaleInAnimation.setDuration(800);
        scaleInAnimation.setFillAfter(true);


        scaleOutAnimation = new ScaleAnimation(1.5f,1,1.5f,1,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        scaleOutAnimation.setDuration(800);

        translateLogo = new TranslateAnimation(0,0,0,-700);
        translateLogo.setDuration(800);
        setLogo = new AnimationSet(true);
        setLogo.addAnimation(scaleOutAnimation);
        setLogo.addAnimation(translateLogo);
        setLogo.setFillAfter(true);

        //TextAnimation:

       AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
        alphaAnimation.setDuration(800);

        TranslateAnimation transl = new TranslateAnimation(0,0,500,0);
        transl.setDuration(800);

        animationSetText = new AnimationSet(true);
        animationSetText.addAnimation(alphaAnimation);
        animationSetText.addAnimation(transl);
        alphaAnimation.setFillAfter(true);

        scaleInAnimation = new ScaleAnimation(1,1.5f,1,1.5f,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        scaleInAnimation.setDuration(800);
        scaleInAnimation.setFillAfter(true);


        scaleOutAnimation = new ScaleAnimation(1.5f,1,1.5f,1,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        scaleOutAnimation.setDuration(800);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                image_logo.startAnimation(scaleInAnimation);
            }
        },2000);

        scaleInAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                image_logo.startAnimation(setLogo);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        setLogo.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                justLaw.startAnimation(animationSetText);
                justLaw.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {



            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

            }

    }
