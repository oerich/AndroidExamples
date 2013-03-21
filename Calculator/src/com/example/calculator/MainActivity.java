package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void doCalc(View view) {
    	double v1 = Double.parseDouble(((EditText)findViewById(R.id.val01)).getText().toString());
    	double v2 = Double.parseDouble(((EditText)findViewById(R.id.val02)).getText().toString());
    	TextView res = (TextView)findViewById(R.id.result);

    	switch(view.getId()) {
    		case R.id.opPlus:
    			res.setText(String.format("%.2f", v1+v2));
    			break;
    		case R.id.opMinus:
    			res.setText(Double.toString(v1-v2));
    			break;
    		case R.id.opMult:
    			res.setText(Double.toString(v1*v2));
    			break;
    		case R.id.opDiv:
    			res.setText(Double.toString(v1/v2));
    	}
    }

}
