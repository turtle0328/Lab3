package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
EditText editText;
TextView textView9;
RadioButton radioButton;
RadioButton radioButton2;
RadioButton radioButton3;
RadioGroup radioGroup;
Button button;
TextView name;
TextView winner;
TextView myMora;
TextView computerMora;

int mora_gamer =-1;
String[] MoraString ={"剪刀","石頭","布"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText =(EditText) findViewById(R.id.editText);
        textView9 =(TextView) findViewById(R.id.textView9);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 =(RadioButton) findViewById(R.id.radioButton2);
        radioButton3=(RadioButton) findViewById(R.id.radioButton3);
        radioGroup =(RadioGroup) findViewById(R.id.radioGroup);
        button =(Button)findViewById(R.id.button);
        name = (TextView)findViewById(R.id.name);
        winner  =(TextView)findViewById(R.id.winner);
        myMora = (TextView)findViewById(R.id.myMora);
        computerMora = (TextView)findViewById(R.id.computerMora);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioButton :
                        mora_gamer=0;
                        break;
                    case R.id.radioButton2:
                        mora_gamer=1;
                        break;
                    case R.id.radioButton3:
                        mora_gamer=2;
                        break;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().equals(""))
                    textView9.setText("請選擇玩家名稱");
                else if (mora_gamer ==-1)
                    textView9.setText("請選擇出拳的種類");
                else{
                    name.setText(editText.getText());
                    myMora.setText((MoraString[mora_gamer]));
                    int mora_computer=(int)(Math.random()*3);
                    computerMora.setText(MoraString[mora_computer]);
                    if((mora_gamer==0&&mora_computer==1)||(mora_gamer==1&&mora_computer==2)||(mora_gamer==2&&mora_computer==0)) {
                        winner.setText("電腦");
                        textView9.setText("可惜，電腦獲勝了");
                    }else if (mora_computer==mora_gamer) {
                        winner.setText("平局");
                        textView9.setText("平局!再試一場看看");
                    } else{
                        winner.setText(editText.getText());
                        textView9.setText("恭喜你獲勝了");
                    }
                }
            }
        });
    }
}