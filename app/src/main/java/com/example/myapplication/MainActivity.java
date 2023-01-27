package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ast.Scope;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnClean,btn9aws,btnRest,btnDivi,btn7,btn8,btn9,btnmulti,btn4,btn5,btn6,btnSub,btn1,btn2,btn3,btnAdd,btn0,btnPoint,btnEqual;
    TextView txtInput,txtOutput;
    String process;
    boolean qawss = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);

        btnClean=findViewById(R.id.btnClean);
        btn9aws=findViewById(R.id.btn9aws);
        btnPoint=findViewById(R.id.btnPoint);

        btnDivi=findViewById(R.id.btnDivi);
        btnAdd=findViewById(R.id.btnAdd);
        btnRest=findViewById(R.id.btnRest);
        btnmulti=findViewById(R.id.btnmulti);
        btnSub=findViewById(R.id.btnSub);

        btnEqual=findViewById(R.id.btnEqual);

        txtInput=findViewById(R.id.txtInput);
        txtOutput=findViewById(R.id.txtOutput);

        btnDivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txtInput.getText().toString();
                txtInput.setText(process + "/");
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txtInput.getText().toString();
                txtInput.setText(process + "+");
            }
        });
        btnRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txtInput.getText().toString();
                txtInput.setText(process + "%");
            }
        });
        btnmulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txtInput.getText().toString();
                    txtInput.setText(process + "*");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txtInput.getText().toString();
                txtInput.setText(process + "- ");
            }
        });

        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtInput.setText("");
                txtOutput.setText("");
            }
        });
        btn9aws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qawss){
                    process = txtInput.getText().toString();
                    txtInput.setText(process + ")");
                    qawss=false;
                }else {
                    process = txtInput.getText().toString();
                    txtInput.setText(process + "(");
                    qawss=true;
                }
            }
        });
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txtInput.getText().toString();
                txtInput.setText(process + ".");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txtInput.getText().toString();
                txtInput.setText(process + "0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txtInput.getText().toString();
                txtInput.setText(process + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txtInput.getText().toString();
                txtInput.setText(process + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txtInput.getText().toString();
                txtInput.setText(process + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txtInput.getText().toString();
                txtInput.setText(process + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txtInput.getText().toString();
                txtInput.setText(process + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txtInput.getText().toString();
                txtInput.setText(process + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txtInput.getText().toString();
                txtInput.setText(process + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txtInput.getText().toString();
                txtInput.setText(process + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txtInput.getText().toString();
                txtInput.setText(process + "9");
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txtInput.getText().toString();

                process = process.replaceAll("×","*");
                process = process.replaceAll("%","/100");
                process = process.replaceAll("÷","/");

                Context rhino = Context.enter();

                rhino.setOptimizationLevel(-1);

                String finalResult = "";

                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
                }catch (Exception e){
                    finalResult="0";
                }

                txtOutput.setText(finalResult);

            }
        });
    }
}