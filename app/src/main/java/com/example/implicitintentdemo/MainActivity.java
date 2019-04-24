package com.example.implicitintentdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_referto;
    private EditText editText_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        btn_referto=(Button) findViewById(R.id.btn_referto);
        editText_url=(EditText) findViewById(R.id.editText_url);
        btn_referto.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_referto:
                Intent intent=new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(editText_url.getText().toString()));
                startActivity(Intent.createChooser(intent, "请选择浏览器"));
                break;
        }
    }

}
