package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    private EditText alertUserName;
    private EditText alertUserPwd;
    private EditText newUserPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        alertUserName=(EditText) findViewById(R.id.alertUserName);
        alertUserPwd=(EditText) findViewById(R.id.alertUserPwd);
        newUserPwd=(EditText) findViewById(R.id.newUserPwd);
        Button alertBtn = (Button) findViewById(R.id.alertBtn);
    }

    public boolean originPwdCheck(){
        String et_userName = alertUserName.getText().toString().trim();
        String et_userPwd = alertUserPwd.getText().toString().trim();
        LoginSql loginSql=new LoginSql(this);
        return (loginSql.loginInCheck(et_userName,et_userPwd)==0);
    }
    public void alertPassword(View view){
        LoginSql loginSql=new LoginSql(this);
        if (! originPwdCheck() && ! alertUserName.getText().toString().trim().isEmpty()
                &&! alertUserPwd.getText().toString().trim().isEmpty()
                &&! newUserPwd.getText().toString().trim().isEmpty()
                &&! (newUserPwd.getText().toString().trim().equals(alertUserPwd.getText().toString().trim()))){
            loginSql.alertPwd(alertUserName.getText().toString().trim(),newUserPwd.getText().toString().trim());
            Toast.makeText(this,"修改成功!",Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this,"错误!",Toast.LENGTH_LONG).show();
        }
    }
}
