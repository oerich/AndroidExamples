package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity
{
	StringBuilder val = null;
	Double res = null;
	int op;
	boolean lastop = false;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    private double calc(double v1, double v2, int op) {
    	switch(op) {
	    case R.id.opPlus:
	    	return v1 + v2;
	    case R.id.opMinus:
	    	return v1 - v2;
	    case R.id.opMult:
	    	return v1 * v2;
	    case R.id.opDiv:
	    	return v1 / v2;
	    }
	    return 0.0; // should never happen
    }

    public void enterDigit(View view) {
    	TextView tv = (TextView)findViewById(R.id.val);

    	if(val == null || view.getId() == R.id.clear || lastop == true) {
    		lastop = false;
    		val = new StringBuilder("");
    	}

    	switch(view.getId()) {
    		case R.id.val1:
    			val.append("1");
    			break;
    		case R.id.val2:
    			val.append("2");
    			break;
    		case R.id.val3:
    			val.append("3");
    			break;
    		case R.id.val4:
    			val.append("4");
    			break;
    		case R.id.val5:
    			val.append("5");
    			break;
    		case R.id.val6:
    			val.append("6");
    			break;
    		case R.id.val7:
    			val.append("7");
    			break;
    		case R.id.val8:
    			val.append("8");
    			break;
    		case R.id.val9:
    			val.append("9");
    			break;
    		case R.id.val0:
    			val.append("0");
    			break;
    		case R.id.dot:
    			val.append(".");
    	}
    	tv.setText(val.toString());
    }

    public void doCalc(View view) {
    	lastop = true;
    	if(res == null) {
    		res = Double.parseDouble(val.toString());
    		op = view.getId();
    	} else {
    		if(view.getId() == R.id.opEq && val != null) {
				res = calc(res, Double.parseDouble(val.toString()), op);
				op = -1;
				val = new StringBuilder(Double.toString(res));
				res = null;
			} else if(op!=-1 && val != null){
				res = calc(res, Double.parseDouble(val.toString()), view.getId());
				op = view.getId();
				val = new StringBuilder(Double.toString(res));
			}
			if(val!=null)
				((TextView)findViewById(R.id.val)).setText(val.toString());
		}
    }
}
