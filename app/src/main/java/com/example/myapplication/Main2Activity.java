package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉导航栏
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);

        Button calculate =(Button) findViewById(R.id.button);
        final EditText heightEt =(EditText) findViewById(R.id.editText2);
        final TextView weightTv =(TextView) findViewById(R.id.textView8);
        final TextView tr=(TextView)findViewById(R.id.tr);
        final RadioGroup sexBtn=(RadioGroup) findViewById(R.id.sexJudge);
        final RadioButton maleBtn=(RadioButton)findViewById(R.id.radioButton);
        final RadioButton femaleBtn=(RadioButton)findViewById(R.id.radioButton2);

        sexBtn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.radioButton){
                    tr.setText("0");
                }else{
                    tr.setText("1");
                }
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float height = Float.parseFloat(heightEt.getText().toString());
                double maleBmi=0.00239;
                double femaleBmi=0.00185;
                double maleWeight=maleBmi*height*height;
                double femaleWeight=femaleBmi*height*height;
                if (tr.getText()=="0") {
                    weightTv.setText(String.format("%.1f", maleWeight));
                }else{
                    weightTv.setText(String.format("%.1f",femaleWeight));
                }
            }
        });
    }
}
