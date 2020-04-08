package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText userName;
    private EditText userPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);
        userName = (EditText) findViewById(R.id.userName);
        userPwd = (EditText) findViewById(R.id.userPwd);
        Button loginBtn = (Button) findViewById(R.id.SigninBtn);
        LoginSql loginSql=new LoginSql(this);
        loginSql.createDataTable();

    }

    public int getDataResult(){
        String et_userName = userName.getText().toString().trim();
        String et_userPwd = userPwd.getText().toString().trim();
        LoginSql loginSql=new LoginSql(this);
        return (loginSql.loginInCheck(et_userName,et_userPwd));
    }

    public void login(View view){
        LoginSql loginSql=new LoginSql(this);
//        loginSql.insertData("INSERT INTO USERS VALUES("+getUserNamePwd()+")");
        if (getDataResult()!=0){
            Toast.makeText(this,"登录成功!",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(this,Main5Activity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"该用户名尚未注册或密码错误!",Toast.LENGTH_LONG).show();
        }
        loginSql.close();
//        String name = userName.getText().toString().trim();
//        String pwd = userPwd.getText().toString().trim();
//
//        if (name.isEmpty() || pwd.isEmpty()) {
//            Toast.makeText(this, "用户名密码不能为空", Toast.LENGTH_LONG).show();
//        } else {
//            // 模拟http请求，提交数据到服务器
//            String path = "http://localhost:8080/2ndhandMall_war/admin/login.do?userName="
//                    + name + "&password=" + pwd;
//            try {
//                URL url = new URL(path);
//                // 2.建立一个http连接
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                // 3.设置一些请求方式
//                System.out.println(conn);
//                conn.setRequestMethod("POST");
//                conn.setRequestProperty(
//                        "User-Agent",
//                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
//                conn.setRequestProperty("Content-Type",
//                        "application/x-www-form-urlencoded");
//                String data = "username=" + name + "&password=" + pwd;
//                conn.setRequestProperty("Content-Length", data.length() + "");
//                conn.setConnectTimeout(5000);//设置连接超时时间
//                conn.setReadTimeout(5000); //设置读取的超时时间
//
//
//                int code = conn.getResponseCode();
//                if (code == 200) {
//                    InputStream is = conn.getInputStream();
//                    // 把is的内容转换为字符串
//                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
//                    byte[] buffer = new byte[1024];
//                    int len = -1;
//                    while ((len = is.read(buffer)) != -1) {
//                        bos.write(buffer, 0, len);
//                    }
//                    String result = new String(bos.toByteArray());
//                    is.close();
//                    Toast.makeText(this, result, Toast.LENGTH_LONG).show();
//
//                } else {
//                    Toast.makeText(this, "请求失败，失败原因: " + code, Toast.LENGTH_LONG).show();
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                Toast.makeText(this, "请求成功，正在登入", Toast.LENGTH_LONG).show();
//                TimerTask task = new TimerTask() {
//                    @Override
//                    public void run() {
//                        setContentView(R.layout.layout2);
//                    }
//                };
//                Timer timer = new Timer();
//                timer.schedule(task, 3000);//3秒后执行TimeTask的run方法
//            }
//
//        }
    }
    public void signInRouter(View view){
        Intent intent = new Intent(this,Main3Activity.class);
        startActivity(intent);
        //不进行跳转
//        setContentView(R.layout.signin_layout);
    }

    public  void alertPwd(View view){
        Intent intent = new Intent(this,Main4Activity.class);
        startActivity(intent);
    }

}
