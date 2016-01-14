package com.transition.demon.activity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.transition.demon.R;

import demon.example.com.mylibrary.anim.ViewAnimationListenerAdapter;
import demon.example.com.mylibrary.transition.TransitionCompat;
import demon.example.com.mylibrary.transition.TransitionListenerAdapter;


public class SharedTransitionsInActionbarActivity extends AppCompatActivity {

    private TextView closeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_transitions_in_actionbar);

        if (Build.VERSION.SDK_INT < 21){
            TransitionCompat.startTransition(this, R.layout.activity_shared_transitions_in_actionbar);
        }

        final float fraction = 0.9f;
        TransitionCompat.addViewAnimListener(new ViewAnimationListenerAdapter() {
            boolean isShowed = false;

            @Override
            public void onViewAnimationStart(View view, Animator animator) {
                // TODO 自动生成的方法存根
                super.onViewAnimationStart(view, animator);
            }

            public void onViewAnimationUpdate(View view, ValueAnimator valueAnimator, float progress) {
                super.onViewAnimationUpdate(view, valueAnimator, progress);
            }

            @Override
            public void onViewAnimationEnd(View view, Animator animator) {
                // TODO 自动生成的方法存根
                super.onViewAnimationEnd(view, animator);
            }
        });

        /**
         * 屏幕（场景）动画的监听器，这里用了适配器模式。可以传入完整的接口实现类
         */
        TransitionCompat.addListener(new TransitionListenerAdapter() {
            @Override
            public void onTransitionEnd(Animator animator, Animation animation,
                                        boolean isEnter) {
                super.onTransitionEnd(animator, animation, isEnter);
                // TODO:onEnd
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (Build.VERSION.SDK_INT < 21){
            TransitionCompat.finishAfterTransition(this);
        }
    }
}
