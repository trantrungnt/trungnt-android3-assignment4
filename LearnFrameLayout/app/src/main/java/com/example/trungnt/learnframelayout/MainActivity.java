package com.example.trungnt.learnframelayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnShow, btnHide, btnClose, btnFullScreen, btnMiniature;
    private Intent intentOpenAuthor, intentOpenWork;

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

        if (id == R.id.btnClose)
                            this.finish();

        if (id == R.id.btnShow)
                            showAllFrameLayout();
    }

    //dinh nghia phuong thuc khoi tao ViewMainActivity
    private void initViewMainActivity()
    {
        btnShow = (Button) this.findViewById(R.id.btnShow);
        btnHide = (Button) this.findViewById(R.id.btnHide);
        btnClose = (Button) this.findViewById(R.id.btnClose);
        btnFullScreen = (Button) this.findViewById(R.id.btnFullscreen);
        btnMiniature = (Button) this.findViewById(R.id.btnMiniature);
    }

    private void initListener()
    {
        btnShow.setOnClickListener(this);
        btnHide.setOnClickListener(this);
        btnClose.setOnClickListener(this);
        btnFullScreen.setOnClickListener(this);
        btnMiniature.setOnClickListener(this);
    }

    private void showAllFrameLayout()
    {
        //intentOpenAuthor = new Intent(MainActivity.this, AuthorActivity.class);
        //startActivity(intentOpenAuthor);

        intentOpenWork = new Intent(this, WorkActivity.class);
        startActivity(intentOpenWork);
    }
}
