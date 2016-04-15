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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button btnZoomOut, btnZoomIn, btnCloseMain, btnFullScreenMain, btnMiniatureMain;
    private Button btnCloseAuthor, btnCloseWork, btnShowWork, btnHideWork, btnShowAuthor, btnHideAuthor;
    private Button btnShowGlobal, btnHideGlobal;
    private RelativeLayout relLayoutAbout, reLayoutAuthor, reLayoutWork;
    private FrameLayout.LayoutParams paraReLayoutAbout, paraReLayoutAuthor, paraReLayoutWork;
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
            relLayoutAbout.setVisibility(View.GONE);
            changeLocationLayout(relLayoutAbout);
        }

        if (id == R.id.btnZoomOut)
        {
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
            reLayoutAuthor.setVisibility(View.GONE);
            changeLocationLayout(reLayoutAuthor);
        }

        if (id == R.id.btnCloseWork) {
            reLayoutWork.setVisibility(View.GONE);
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

        btnCloseAuthor = (Button) this.findViewById(R.id.btnCloseAuthor);
        btnShowAuthor = (Button) this.findViewById(R.id.btnShowAuthor);
        btnHideAuthor = (Button) this.findViewById(R.id.btnHideAuthor);

        btnCloseWork = (Button) this.findViewById(R.id.btnCloseWork);
        btnShowWork = (Button) this.findViewById(R.id.btnShowWork);
        btnHideWork = (Button) this.findViewById(R.id.btnHideWork);

        btnShowGlobal = (Button) this.findViewById(R.id.btnShowGlobal);
        btnHideGlobal = (Button) this.findViewById(R.id.btnHideGlobal);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        bound = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bound);
        slideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        slideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        //zoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
        //zoomIn = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0);
//        zoomIn = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f);
//        zoomIn.setDuration(1000);
//        zoomIn.setFillAfter(true);

        zoomIn = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        zoomIn.setDuration(1000);
        zoomIn.setFillAfter(true);

        //zoomIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);

        zoomOut = new ScaleAnimation(0.0f, 1.0f, 0.5f, 1.0f);
        zoomOut.setDuration(1000);
        zoomOut.setFillAfter(true);

        imgViewMain = (ImageView) this.findViewById(R.id.imgViewMain);
        ////////////////////////////////////////////////////////////////////////////
        //lay id cua layout tern giao dien Main
        relLayoutAbout = (RelativeLayout) this.findViewById(R.id.layoutAbout);
        reLayoutAuthor = (RelativeLayout) this.findViewById(R.id.layoutAuthor);
        reLayoutWork = (RelativeLayout) this.findViewById(R.id.layoutWork);

        //lay Layout Param cua tung giao dien About, Author, Work do FrameLayout quan ly
        paraReLayoutAbout = (FrameLayout.LayoutParams) relLayoutAbout.getLayoutParams();
        paraReLayoutAuthor = (FrameLayout.LayoutParams) reLayoutAuthor.getLayoutParams();
        paraReLayoutWork = (FrameLayout.LayoutParams) reLayoutWork.getLayoutParams();
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
        relLayoutAbout.setVisibility(View.VISIBLE);
        reLayoutAuthor.setVisibility(View.VISIBLE);
        reLayoutWork.setVisibility(View.VISIBLE);
    }

    private void hideAllFrameLayout()
    {
        relLayoutAbout.setVisibility(View.GONE);
        reLayoutAuthor.setVisibility(View.GONE);
        reLayoutWork.setVisibility(View.GONE);
    }

    //dinh nghia viec thay doi margin cua 3 Layout Author, About, Work
    private void changeLocationLayout(RelativeLayout layout)
    {
        if (layout == reLayoutAuthor)
        {
            //khi vung mau Vang bi dong thi vung mau Do se chua vung mau Vang => reLayoutWork se chinh theo tham so cua LayoutAuthor
            reLayoutWork.setLayoutParams(paraReLayoutAuthor);
        }

        if (layout == relLayoutAbout)
        {
            //thay doi gia tri tham so margin cua Author theo LayoutAbout
            reLayoutAuthor.setLayoutParams(paraReLayoutAbout);

            //thay doi gia tri tham so margin cua Work theo LayoutAuthor
            reLayoutWork.setLayoutParams(paraReLayoutAuthor);
        }

    }

}

