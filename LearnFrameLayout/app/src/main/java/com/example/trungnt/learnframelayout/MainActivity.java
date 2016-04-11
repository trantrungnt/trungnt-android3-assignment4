package com.example.trungnt.learnframelayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnShowMain, btnHideMain, btnCloseMain, btnFullScreenMain, btnMiniatureMain;
    private Button btnCloseAuthor, btnCloseWork, btnShowWork, btnHideWork, btnShowAuthor, btnHideAuthor;
    private RelativeLayout relativeLayoutMain, relativeLayoutAuthor, relativeLayoutWork;

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

        if (id == R.id.btnCloseMain)
                            relativeLayoutMain.setVisibility(View.GONE);

        if (id == R.id.btnShowMain ||
            id == R.id.btnShowAuthor ||
            id == R.id.btnShowWork
           )
                            showAllFrameLayout();

        if (id == R.id.btnHideMain ||
            id == R.id.btnHideAuthor ||
            id == R.id.btnHideWork
           )
                            hideAllFreamLayout();

        if (id == R.id.btnCloseAuthor)
                            relativeLayoutAuthor.setVisibility(View.GONE);

        if (id == R.id.btnCloseWork)
                            relativeLayoutWork.setVisibility(View.GONE);
    }

    //dinh nghia phuong thuc khoi tao ViewMainActivity
    private void initViewMainActivity()
    {
        btnShowMain = (Button) this.findViewById(R.id.btnShowMain);
        btnHideMain = (Button) this.findViewById(R.id.btnHideMain);
        btnCloseMain = (Button) this.findViewById(R.id.btnCloseMain);
        btnFullScreenMain = (Button) this.findViewById(R.id.btnFullscreenMain);
        btnMiniatureMain = (Button) this.findViewById(R.id.btnMiniatureMain);

        relativeLayoutMain = (RelativeLayout) this.findViewById(R.id.relativeLayoutMain);
        relativeLayoutAuthor = (RelativeLayout) this.findViewById(R.id.relativeLayoutAuthor);
        relativeLayoutWork = (RelativeLayout) this.findViewById(R.id.relativeLayoutWork);

        btnCloseAuthor = (Button) this.findViewById(R.id.btnCloseAuthor);
        btnShowAuthor = (Button) this.findViewById(R.id.btnShowAuthor);
        btnHideAuthor = (Button) this.findViewById(R.id.btnHideAuthor);

        btnCloseWork = (Button) this.findViewById(R.id.btnCloseWork);
        btnShowWork = (Button) this.findViewById(R.id.btnShowWork);
        btnHideWork = (Button) this.findViewById(R.id.btnHideWork);
    }

    private void initListener()
    {
        btnShowMain.setOnClickListener(this);
        btnHideMain.setOnClickListener(this);
        btnCloseMain.setOnClickListener(this);
        btnFullScreenMain.setOnClickListener(this);
        btnMiniatureMain.setOnClickListener(this);

        btnCloseAuthor.setOnClickListener(this);
        btnShowAuthor.setOnClickListener(this);
        btnHideAuthor.setOnClickListener(this);

        btnCloseWork.setOnClickListener(this);
        btnShowWork.setOnClickListener(this);
        btnHideWork.setOnClickListener(this);
    }

    private void showAllFrameLayout()
    {
        relativeLayoutMain.setVisibility(View.VISIBLE);
        relativeLayoutAuthor.setVisibility(View.VISIBLE);
        relativeLayoutWork.setVisibility(View.VISIBLE);
    }

    private void hideAllFreamLayout()
    {
        relativeLayoutMain.setVisibility(View.GONE);
        relativeLayoutAuthor.setVisibility(View.GONE);
        relativeLayoutWork.setVisibility(View.GONE);
    }
}
