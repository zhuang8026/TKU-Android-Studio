package com.example.n214410101_tku;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView r1;
    int s=12;

    EditText name, phone, mail, eu, en, eg;
    Button bu, bn, bc, bx;
    Button bs, be, bl, bm;

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

        bu=(Button) findViewById(R.id.b_u2n); // 美轉台 按鈕dom
        bn=(Button) findViewById(R.id.b_n2u); // 台轉美 按鈕dom
        bc=(Button) findViewById(R.id.b_cls); // 清除 按鈕dom
        bx=(Button) findViewById(R.id.b_ex);  // 離開 按鈕dom

        bu.setOnClickListener(this); // this是指向MainActivity這個類別
        bn.setOnClickListener(this);
        bc.setOnClickListener(this);
        bx.setOnClickListener(this);

        en=(EditText) findViewById(R.id.ed_nt); // 取得 台幣dom
        eu=(EditText) findViewById(R.id.ed_us); // 取得 美金dom
        eg=(EditText) findViewById(R.id.ed_exg); // 取得 匯率dom

        bs=(Button) findViewById(R.id.b_su); // 確定 按鈕dom
        be=(Button) findViewById(R.id.b_exit); // 離開 按鈕dom
        bl=(Button) findViewById(R.id.b_la); // 放大 按鈕dom
        bm=(Button) findViewById(R.id.b_sm); // 縮小 按鈕dom

        bs.setOnClickListener(this); // this是指向MainActivity這個類別
        be.setOnClickListener(this);
        bl.setOnClickListener(this);
        bm.setOnClickListener(this);
    }

//    // 結束
//    public void end(View view) {
//        finish();
//    }
//
//    // 放大
//    public void large(View view) {
//        if(s < 35) {
//            s++;
//            r1.setTextSize(s); // 設定 文字 大小
//            r1.setText(getString(R.string.res)+ "" + s);
//        }
//    }
//
//    // 縮小
//    public void small(View view) {
//        if(s > 12) {
//            s--;
//            r1.setTextSize(s); // 設定 文字 大小
//
//            r1.setText(getString(R.string.res)+ "" + s);
//        }
//    }
//
//    // 確定
//    public void sure (View view) {
//        String name_1 = name.getText().toString();
//         String phone_1 = phone.getText().toString();
//        String mail_1 = mail.getText().toString();
//
//        r1.setText(getString(R.string.res) +name_1 +phone_1+phone_1);
//
//    }

    // 匯率按鈕 功能
    @Override
    public void onClick(View v) {
    // View v：是那一個 dom
        if(v==bx) { // 結束
            finish();
        }
        if(v==bc) { // 清除
            en.setText("");
            eu.setText("");
            eg.setText("");
        };

        // 美金轉台幣
        if(v==bu) {
            String us = eu.getText().toString();
            String exg = eg.getText().toString();

            if(us.length() > 0 && exg.length() > 0) {
                double usd = Double.parseDouble(us), exg1=Double.parseDouble(exg);
                double ntd = usd*exg1; // 美金轉台幣
//                en.setText("" + ntd); // 重點：轉string
                en.setText(String.format("%.2f", ntd)); // 重點：轉string, 小數點第二位(%.2f)
            } else  {
                // 提示窗
                // 第一個參數是 Context，第二個是訊息，第三個是時長
                Toast.makeText(MainActivity.this, getString(R.string.err), Toast.LENGTH_SHORT).show();
            }
        };

        // 台幣轉美金
        if(v==bn) {
            String nt = en.getText().toString();
            String exg = eg.getText().toString();

            if(nt.length() > 0 && exg.length() > 0) {
                double ntd = Double.parseDouble(nt), exg1=Double.parseDouble(exg);
                double usd = ntd / exg1; // 美金轉台幣
                eu.setText(String.format("%.2f", usd)); // 重點：轉string, 小數點第二位(%.2f)
            } else  {
                // 提示窗
                // 第一個參數是 Context，第二個是訊息，第三個是時長
                Toast.makeText(MainActivity.this, getString(R.string.err), Toast.LENGTH_SHORT).show();
            }
        };

        if(v==bx || v==be) finish();
        if(v==bs){
            String name_1 = name.getText().toString();
            String phone_1 = phone.getText().toString();
            String mail_1 = mail.getText().toString();

            r1.setText(getString(R.string.res) +name_1 +phone_1+phone_1);
        }
        if(v==bl){
            if(s < 35) {
                s++;
                r1.setTextSize(s); // 設定 文字 大小
                r1.setText(getString(R.string.res)+ "" + s);
            }
        }
        if(v==bm){
            if(s > 12) {
                s--;
                r1.setTextSize(s); // 設定 文字 大小

                r1.setText(getString(R.string.res)+ "" + s);
            }
        }
    }
}