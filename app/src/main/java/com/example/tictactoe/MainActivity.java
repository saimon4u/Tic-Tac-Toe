package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,newGame;
    private String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    private boolean flag = true;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
        newGame = findViewById(R.id.newGame);
        if(count == 0)newGame.setEnabled(false);
        newGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                newGame();
            }
        });
    }
    private void initialization(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }
    private void getButtonValue(){
        b1 = btn1.getText().toString();
        b2 = btn2.getText().toString();
        b3 = btn3.getText().toString();
        b4 = btn4.getText().toString();
        b5 = btn5.getText().toString();
        b6 = btn6.getText().toString();
        b7 = btn7.getText().toString();
        b8 = btn8.getText().toString();
        b9 = btn9.getText().toString();
    }
    private void showWinner(String s){
        Toast.makeText(this,"Winner is: " + s,Toast.LENGTH_SHORT).show();
    }
    private void setState(Button b1,Button b2, Button b3,Button b4,Button b5,Button b6,Boolean state){
        b1.setEnabled(state);
        b2.setEnabled(state);
        b3.setEnabled(state);
        b4.setEnabled(state);
        b5.setEnabled(state);
        b6.setEnabled(state);
        b1.setBackgroundColor(getColor(R.color.ash));
        b2.setBackgroundColor(getColor(R.color.ash));
        b3.setBackgroundColor(getColor(R.color.ash));
        b4.setBackgroundColor(getColor(R.color.ash));
        b5.setBackgroundColor(getColor(R.color.ash));
        b6.setBackgroundColor(getColor(R.color.ash));
    }
    private void resetGame(){
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                count = 0;
                flag = !flag;
                btn1.setEnabled(true);
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
                btn5.setEnabled(true);
                btn6.setEnabled(true);
                btn7.setEnabled(true);
                btn8.setEnabled(true);
                btn9.setEnabled(true);
                btn1.setBackgroundColor(getColor(R.color.btn_bg));
                btn2.setBackgroundColor(getColor(R.color.btn_bg));
                btn3.setBackgroundColor(getColor(R.color.btn_bg));
                btn4.setBackgroundColor(getColor(R.color.btn_bg));
                btn5.setBackgroundColor(getColor(R.color.btn_bg));
                btn6.setBackgroundColor(getColor(R.color.btn_bg));
                btn7.setBackgroundColor(getColor(R.color.btn_bg));
                btn8.setBackgroundColor(getColor(R.color.btn_bg));
                btn9.setBackgroundColor(getColor(R.color.btn_bg));
                newGame.setEnabled(false);
            }
        },2000);
    }
    private void newGame(){
        Toast.makeText(this,"Game Restarted",Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                count = 0;
                flag = !flag;
                btn1.setEnabled(true);
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
                btn5.setEnabled(true);
                btn6.setEnabled(true);
                btn7.setEnabled(true);
                btn8.setEnabled(true);
                btn9.setEnabled(true);
                newGame.setEnabled(false);
            }
        },1200);
    }
    public void check(View view) throws InterruptedException {
        Button btnCurrent = (Button) view;
        if(btnCurrent.getText().toString().equals("")){
            newGame.setEnabled(true);
            count++;
            if(flag){
                btnCurrent.setText("X");
                btnCurrent.setTextSize(25f);
            }
            else{
                btnCurrent.setText("O");
                btnCurrent.setTextSize(25f);
            }
            flag = !flag;
            if(count > 4){
                getButtonValue();
                if(b1.equals(b2) && b2.equals(b3) && !b1.equals("")){
                    showWinner(b1);
                    setState(btn4,btn5,btn6,btn7,btn8,btn9,false);
                    resetGame();
                }
                else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")){
                    showWinner(b4);
                    setState(btn1,btn2,btn3,btn7,btn8,btn9,false);
                    resetGame();
                }
                else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")){
                    showWinner(b7);
                    setState(btn4,btn5,btn6,btn1,btn2,btn3,false);
                    resetGame();
                }
                else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")){
                    showWinner(b1);
                    setState(btn2,btn3,btn5,btn6,btn8,btn9,false);
                    resetGame();
                }
                else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")){
                    showWinner(b2);
                    setState(btn1,btn3,btn4,btn6,btn7,btn9,false);
                    resetGame();
                }
                else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")){
                    showWinner(b3);
                    setState(btn1,btn2,btn4,btn5,btn7,btn8,false);
                    resetGame();
                }
                else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")){
                    showWinner(b1);
                    setState(btn2,btn3,btn4,btn6,btn7,btn8,false);
                    resetGame();
                }
                else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")){
                    showWinner(b3);
                    setState(btn1,btn2,btn4,btn6,btn8,btn9,false);
                    resetGame();
                }
                else if(count == 9){
                    Toast.makeText(this,"Game Drawn",Toast.LENGTH_SHORT).show();
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn1.setBackgroundColor(getColor(R.color.ash));
                    btn2.setBackgroundColor(getColor(R.color.ash));
                    btn3.setBackgroundColor(getColor(R.color.ash));
                    setState(btn4,btn5,btn6,btn7,btn8,btn9,false);
                    resetGame();
                }
            }
        }
        else{
            Toast.makeText(this,"Wrong Place!",Toast.LENGTH_SHORT).show();
        }
    }
}