package com.example.calculator;

import static androidx.fragment.app.FragmentManager.TAG;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.calculator.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
     Button one,two,three,four,five,six,seven,eigth,nine,zero;
     Button addition,divide,multiply,subtract,modulus,clear;

     one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eigth = findViewById(R.id.eigth);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        addition = findViewById(R.id.addition);
        divide = findViewById(R.id.divide);
        multiply = findViewById(R.id.multiply);
        subtract = findViewById(R.id.subtract);
        Button equal = findViewById(R.id.equal);
        modulus = findViewById(R.id.modulus);
        clear = findViewById(R.id.clear);

        ImageButton back = findViewById(R.id.backspace);


        StringBuffer txt = new StringBuffer();

        TextView number = findViewById(R.id.textView);
        TextView total = findViewById(R.id.total);

        one.setOnClickListener((View v) ->{
                txt.append("1");
                number.setText(txt.toString());
        });


        two.setOnClickListener((View v) -> {
                txt.append("2");
                number.setText(txt.toString());
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.append("3");
                number.setText(txt.toString());
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.append("4");
                number.setText(txt.toString());
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.append("5");
                number.setText(txt.toString());
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.append("6");
                number.setText(txt.toString());
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.append("7");
                number.setText(txt.toString());
            }
        });

        eigth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.append("8");
                number.setText(txt.toString());
            }
        });


        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.append("9");
                number.setText(txt.toString());
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.append("0");
                number.setText(txt.toString());
            }
        });
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.append("+");
                number.setText(txt.toString());
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.append("-");
                number.setText(txt.toString());
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.append("/");
                number.setText(txt.toString());
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.append("X");
                number.setText(txt.toString());
            }
        });

        modulus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.append("%");
                number.setText(txt.toString());
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.delete(0,number.length());
                number.setText(txt.toString());
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txt.length() > 0) {
                    txt.deleteCharAt(txt.length() - 1);
                    number.setText(txt.toString());
                }
            }
        });


        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                //Toast.makeText(context, number.getText().toString(), Toast.LENGTH_LONG).show();
                for(int i = 0; i < number.getText().length(); i++)
                {
                    //Log.d("TAG", "onClick: "+txt.charAt(i));
                    //Toast.makeText(context, number.getText().toString(), Toast.LENGTH_LONG).show();
                    if(txt.charAt(i) == "+".charAt(0))
                    {
                        Toast.makeText(context, number.getText().toString(), Toast.LENGTH_LONG).show();

                        String[] n = txt.toString().split("\\+");
                        Log.d("TAG", "onClick: "+n);
                        Integer num1 = Integer.parseInt(String.valueOf(n[0]));
                        Integer num2 = Integer.parseInt(String.valueOf(n[1]));

                        int tot = num1 + num2;
                        total.setText(String.valueOf(tot));
                        Log.d("TAG", "onClick: "+ tot);
                    }
                    if(txt.charAt(i) == "-".charAt(0))
                    {
                        String[] n = txt.toString().split("-");
                        int num1 = Integer.parseInt(String.valueOf(n[0]));
                        int num2 = Integer.parseInt(String.valueOf(n[1]));
                        int tot = num1 - num2;
                        total.setText(String.valueOf(tot));

                    }

                    if(txt.charAt(i) == "/".charAt(0))
                    {
                        String[] n = txt.toString().split("/");
                        int num1 = Integer.parseInt(String.valueOf(n[0]));
                        int num2 = Integer.parseInt(String.valueOf(n[1]));
                        int tot = num1 / num2;
                        total.setText(String.valueOf(tot));

                    }

                    if(txt.charAt(i) == "X".charAt(0))
                    {
                        String[] n = txt.toString().split("X");
                        int num1 = Integer.parseInt(String.valueOf(n[0]));
                        int num2 = Integer.parseInt(String.valueOf(n[1]));
                        int tot = num1 * num2;
                        total.setText(String.valueOf(tot));

                    }

                    if(txt.charAt(i) == "%".charAt(0))
                    {
                        String[] n = txt.toString().split("%");
                        int num1 = Integer.parseInt(String.valueOf(n[0]));
                        int num2 = Integer.parseInt(String.valueOf(n[1]));
                        int tot = num1 % num2;
                        total.setText(String.valueOf(tot));
                    }
                }
            }
        });

    }
    
}