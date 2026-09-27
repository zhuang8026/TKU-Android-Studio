package com.example.n214410101_tku;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView r1;
    int s=12;

    EditText name, phone, mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        r1=(TextView) findViewById(R.id.result); // 用ID取得結果文字
        r1.setTextSize(s); // 設定 文字 大小

        name =(EditText) findViewById(R.id.ed_name);
        phone=(EditText) findViewById(R.id.ed_phone);
        mail =(EditText) findViewById(R.id.ed_mail);
    }

    // 結束
    public void end(View view) {
        finish();
    }

    // 放大
    public void large(View view) {
        if(s < 35) {
            s++;
            r1.setTextSize(s); // 設定 文字 大小
            r1.setText(getString(R.string.res)+ "" + s);
        }
    }

    // 縮小
    public void small(View view) {
        if(s > 12) {
            s--;
            r1.setTextSize(s); // 設定 文字 大小

            r1.setText(getString(R.string.res)+ "" + s);
        }
    }

    public void sure (View view) {

    }
}