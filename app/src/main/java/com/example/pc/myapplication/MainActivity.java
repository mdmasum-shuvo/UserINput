package com.example.pc.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private TextView textView;
    private Switch aSwitch;
    private CheckBox checkBox;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar=findViewById(R.id.seekbar);
        textView=findViewById(R.id.textView);
        aSwitch=findViewById(R.id.switch_one);
        checkBox=findViewById(R.id.simpleCheckBox);
        radioGroup=findViewById(R.id.radio_group);
        btnClick=findViewById(R.id.btn_click);
        aSwitch.setChecked(true);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int changeValue=0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                changeValue=progress;
                textView.setText(""+changeValue);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivity.this, "switch is on", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "switch is off", Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()){
                    Toast.makeText(MainActivity.this, "checked", Toast.LENGTH_SHORT).show();

                }

                else {
                    Toast.makeText(MainActivity.this, "un checked", Toast.LENGTH_SHORT).show();

                }
            }
        });


        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int buttonId=radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(buttonId);
                Toast.makeText(MainActivity.this, ""+radioButton.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });





    }
}
