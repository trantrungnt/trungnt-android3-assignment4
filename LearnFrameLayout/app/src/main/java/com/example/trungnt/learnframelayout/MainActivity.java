package com.example.trungnt.learnframelayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnShowMain, btnHideMain, btnCloseMain, btnFullScreenMain, btnMiniatureMain;
    private Button btnCloseMainAuthor;
    private RelativeLayout relativeLayoutMain, relativeLayoutAuthor;

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

        if (id == R.id.btnShowMain)
                            showAllFrameLayout();

        if (id == R.id.btnHideMain)
                            hideAllFreamLayout();

        if (id ==R.id.btnCloseAuthor)
                            relativeLayoutAuthor.setVisibility(View.GONE);
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

        btnCloseMainAuthor = (Button) this.findViewById(R.id.btnCloseAuthor);
    }

    private void initListener()
    {
        btnShowMain.setOnClickListener(this);
        btnHideMain.setOnClickListener(this);
        btnCloseMain.setOnClickListener(this);
        btnFullScreenMain.setOnClickListener(this);
        btnMiniatureMain.setOnClickListener(this);

        btnCloseMainAuthor.setOnClickListener(this);
    }

    private void showAllFrameLayout()
    {
        relativeLayoutMain.setVisibility(View.VISIBLE);
        relativeLayoutAuthor.setVisibility(View.VISIBLE);
    }

    private void hideAllFreamLayout()
    {
        relativeLayoutMain.setVisibility(View.GONE);
        relativeLayoutAuthor.setVisibility(View.GONE);
    }
}
