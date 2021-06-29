package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;
import android.widget.Toast;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import android.media.MediaPlayer;
import java.lang.reflect.GenericArrayType;

import javax.xml.transform.sax.TemplatesHandler;

public class MainActivity extends AppCompatActivity {
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnback,btnclear,btndot,btnadd,
            btnsub,btnmul,btndiv,btnmod,btnequal;
    TextView edttxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = (Button)findViewById(R.id.btn0);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btnback = (Button)findViewById(R.id.btnback);
        btnclear = (Button)findViewById(R.id.btnallc);
        btndot = (Button)findViewById(R.id.btndot);
        btnadd = (Button)findViewById(R.id.btnadd);
        btnsub = (Button)findViewById(R.id.btnminus);
        btnmul = (Button)findViewById(R.id.btnmul);
        btndiv = (Button)findViewById(R.id.btndiv);
        btnmod = (Button)findViewById(R.id.btnmod);
        btnequal = (Button)findViewById(R.id.btnequal);
        edttxt = (TextView) findViewById(R.id.edtxt);
        btn0.setOnClickListener(v -> edttxt.setText(edttxt.getText()+"0"));
        btn1.setOnClickListener(v -> edttxt.setText(edttxt.getText()+"1"));
        btn2.setOnClickListener(v -> edttxt.setText(edttxt.getText()+"2"));
        btn3.setOnClickListener(v -> edttxt.setText(edttxt.getText()+"3"));
        btn4.setOnClickListener(v -> edttxt.setText(edttxt.getText()+"4"));
        btn5.setOnClickListener(v -> edttxt.setText(edttxt.getText()+"5"));
        btn6.setOnClickListener(v -> edttxt.setText(edttxt.getText()+"6"));
        btn7.setOnClickListener(v -> edttxt.setText(edttxt.getText()+"7"));
        btn8.setOnClickListener(v -> edttxt.setText(edttxt.getText()+"8"));
        btn9.setOnClickListener(v -> edttxt.setText(edttxt.getText()+"9"));
        btnadd.setOnClickListener(v -> edttxt.setText(edttxt.getText()+"+"));
        btnsub.setOnClickListener(v -> edttxt.setText(edttxt.getText()+"-"));
        btnmul.setOnClickListener(v -> edttxt.setText(edttxt.getText()+"*"));
        btndiv.setOnClickListener(v -> edttxt.setText(edttxt.getText()+"/"));
        btnmod.setOnClickListener(v -> edttxt.setText(edttxt.getText()+"%"));
        btndot.setOnClickListener(v -> edttxt.setText(edttxt.getText()+"."));
        btnclear.setOnClickListener(v -> edttxt.setText(""));
        btnback.setOnClickListener(v -> { String txt=edttxt.getText().toString();if(txt.length() > 0){ String newtxt=txt.substring(0,txt.length()-1);edttxt.setText(newtxt); } else if (txt.length() <=0){ edttxt.setText(""); } });
        btnequal.setOnClickListener(v -> equal());
    }
    private void equal(){
        if(edttxt.getText()==""){
            Toast.makeText(getApplicationContext(),"Empty Field",Toast.LENGTH_SHORT).show();
        }
        else {
            String exp = edttxt.getText().toString();
            Expression expr = new ExpressionBuilder(exp).build();
            try {
                double result = expr.evaluate();
                edttxt.setText(Double.toString(result));
            } catch (Exception ex) {
                Toast.makeText(getApplicationContext(),"Invalid input expression!",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}