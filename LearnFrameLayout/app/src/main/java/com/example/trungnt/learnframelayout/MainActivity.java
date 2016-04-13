package com.example.trungnt.learnframelayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button btnZoomOut, btnZoomIn, btnCloseMain, btnFullScreenMain, btnMiniatureMain;
    private Button btnCloseAuthor, btnCloseWork, btnShowWork, btnHideWork, btnShowAuthor, btnHideAuthor;
    private Button btnShowGlobal, btnHideGlobal;
    private RelativeLayout relativeLayoutMain, relativeLayoutAuthor, relativeLayoutWork, retMain;
    private Animation bound, slideUp, slideDown, zoomOut, zoomIn;
    private ImageView imgViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewMainActivity();
        initListener();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btnCloseMain) {
            relativeLayoutMain.setVisibility(View.GONE);
            //relativeLayoutAuthor.getLayoutParams();
            //RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams)relativeLayoutAuthor.getLayoutParams();
            //relativeParams.topMargin=0;
            //relativeParams.setMargins(0, 0, 0, 0);
//            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(relativeLayoutAuthor.getLayoutParams().MATCH_PARENT,
//                    relativeLayoutAuthor.getLayoutParams().MATCH_PARENT);
//            params.topMargin = 0;
//            retMain.setLayoutParams(params);
//            retMain.requestLayout();

        }

        if (id == R.id.btnZoomOut)
        {
            //imgViewMain.animate().translationY(v.getHeight()).alpha(0.0f).setDuration(10000);

            /*zoomOut.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {


                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    imgViewMain.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });*/
            imgViewMain.startAnimation(zoomOut);
        }

        if (id == R.id.btnZoomIn)
        {
            //imgViewMain.animate().translationY(v.getHeight()).alpha(0.0f);
            imgViewMain.startAnimation(zoomIn);

        }

        if (
            id == R.id.btnShowGlobal
           )
                            showAllFrameLayout(v);

        if (
            id == R.id.btnHideGlobal
           )
                            hideAllFrameLayout();

        if (id == R.id.btnCloseAuthor) {
            relativeLayoutAuthor.setVisibility(View.GONE);
            //relativeLayoutAuthor.animate().translationY(v.getHeight()).alpha(0.0f).setDuration(300);
            //relativeLayoutAuthor.startAnimation(slideUp);
        }

        if (id == R.id.btnCloseWork) {
            relativeLayoutWork.setVisibility(View.GONE);
            //relativeLayoutWork.animate().translationY(v.getHeight()).alpha(0.0f).setDuration(300);
            //relativeLayoutWork.startAnimation(slideUp);
        }
    }

    //dinh nghia phuong thuc khoi tao ViewMainActivity
    private void initViewMainActivity()
    {
        btnZoomOut = (Button) this.findViewById(R.id.btnZoomOut);
        btnZoomIn = (Button) this.findViewById(R.id.btnZoomIn);
        btnCloseMain = (Button) this.findViewById(R.id.btnCloseMain);
        btnFullScreenMain = (Button) this.findViewById(R.id.btnFullscreenMain);
        btnMiniatureMain = (Button) this.findViewById(R.id.btnMiniatureMain);

        relativeLayoutMain = (RelativeLayout) this.findViewById(R.id.relativeLayoutMain);
        relativeLayoutAuthor = (RelativeLayout) this.findViewById(R.id.relativeLayoutAuthor);
        relativeLayoutWork = (RelativeLayout) this.findViewById(R.id.relativeLayoutWork);
        retMain = (RelativeLayout) this.findViewById(R.id.retMain);

        btnCloseAuthor = (Button) this.findViewById(R.id.btnCloseAuthor);
        btnShowAuthor = (Button) this.findViewById(R.id.btnShowAuthor);
        btnHideAuthor = (Button) this.findViewById(R.id.btnHideAuthor);

        btnCloseWork = (Button) this.findViewById(R.id.btnCloseWork);
        btnShowWork = (Button) this.findViewById(R.id.btnShowWork);
        btnHideWork = (Button) this.findViewById(R.id.btnHideWork);

        btnShowGlobal = (Button) this.findViewById(R.id.btnShowGlobal);
        btnHideGlobal = (Button) this.findViewById(R.id.btnHideGlobal);
        bound = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bound);
        slideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        slideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        //zoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
        //zoomIn = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0);
        zoomIn = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f);
        zoomIn.setDuration(1000);
        zoomIn.setFillAfter(true);
        //zoomIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);

        zoomOut = new ScaleAnimation(0.0f, 1.0f, 0.5f, 1.0f);
        zoomOut.setDuration(1000);
        zoomOut.setFillAfter(true);

        imgViewMain = (ImageView) this.findViewById(R.id.imgViewMain);
    }

    private void initListener()
    {
        btnZoomOut.setOnClickListener(this);
        btnZoomIn.setOnClickListener(this);
        btnCloseMain.setOnClickListener(this);
        btnFullScreenMain.setOnClickListener(this);
        btnMiniatureMain.setOnClickListener(this);

        btnCloseAuthor.setOnClickListener(this);
        btnShowAuthor.setOnClickListener(this);
        btnHideAuthor.setOnClickListener(this);

        btnCloseWork.setOnClickListener(this);
        btnShowWork.setOnClickListener(this);
        btnHideWork.setOnClickListener(this);

        btnShowGlobal.setOnClickListener(this);
        btnHideGlobal.setOnClickListener(this);
        imgViewMain.setOnClickListener(this);

    }

    private void showAllFrameLayout(View v)
    {
        relativeLayoutMain.setVisibility(View.VISIBLE);
        relativeLayoutAuthor.setVisibility(View.VISIBLE);
        relativeLayoutWork.setVisibility(View.VISIBLE);

        /*relativeLayoutMain.animate().translationY(v.getHeight()).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                relativeLayoutMain.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });
        relativeLayoutMain.startAnimation(slideDown);*/

        /*relativeLayoutAuthor.animate().translationY(v.getHeight()).alpha(0.0f).setDuration(30000).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                relativeLayoutAuthor.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });
        relativeLayoutAuthor.startAnimation(slideDown);

        relativeLayoutWork.animate().translationY(v.getHeight()).alpha(0.0f).setDuration(30000).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                relativeLayoutWork.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });
        relativeLayoutWork.startAnimation(slideDown);*/
    }

    private void hideAllFrameLayout()
    {
        relativeLayoutMain.setVisibility(View.GONE);
        relativeLayoutAuthor.setVisibility(View.GONE);
        relativeLayoutWork.setVisibility(View.GONE);
    }



}
