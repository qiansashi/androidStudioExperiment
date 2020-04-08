package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private EditText signInUserName;
    private EditText signInUserPwd;
    private EditText confirmUserPwd;
    private TextView pwdWarn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_layout);
        signInUserName=(EditText) findViewById(R.id.signInUserName);
        signInUserPwd=(EditText) findViewById(R.id.signInUserPwd);
        confirmUserPwd=(EditText) findViewById(R.id.confirmUserPwd);
        pwdWarn=(TextView)findViewById(R.id.pwdWarn);
        Button signInBtn = (Button) findViewById(R.id.signInBtn);
        LoginSql loginSql=new LoginSql(this);
        SQLiteDatabase db =null;
        loginSql.onCreate(db);

    }

    public String getUserNamePwd(){
        String et_userName = signInUserName.getText().toString().trim();
        String et_userPwd= confirmUserPwd.getText().toString().trim();
        return("'"+et_userName+"'"+","+"'"+et_userPwd+"'");
    }

    public boolean pwdCheck(){
        return(signInUserPwd.getText().toString().trim().equals(confirmUserPwd.getText().toString().trim()));
    }

    public void pwdWarning(boolean check){
        if(check){
            pwdWarn.setVisibility(View.INVISIBLE);
        }else{
            pwdWarn.setVisibility(View.VISIBLE);
        }
    }

    //获取数据库中是否有该用户
    public int getDataResult(){
        String et_userName = signInUserName.getText().toString().trim();
        LoginSql loginSql=new LoginSql(this);
        return (loginSql.signInCheck(et_userName));
    }

    public void signIn(View view){
        pwdWarning(pwdCheck());
        LoginSql loginSql=new LoginSql(this);
        if (getDataResult()==0 && pwdCheck()) {
            loginSql.insertData("INSERT INTO USERS VALUES(" + getUserNamePwd() + ")");
            Toast.makeText(this, "注册成功! ", Toast.LENGTH_LONG).show();
        }else if (! pwdCheck()){
            Toast.makeText(this, "密码不一致！ ", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "请求失败，失败原因:用户已注册！ ", Toast.LENGTH_LONG).show();
        }
    }
}
