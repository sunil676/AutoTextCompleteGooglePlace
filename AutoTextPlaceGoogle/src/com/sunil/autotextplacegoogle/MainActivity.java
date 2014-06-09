package com.sunil.autotextplacegoogle;

import com.sunil.autotextplacegoogle.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity implements OnItemClickListener{

	AutoCompleteTextView autotextview=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
    
		autotextview=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView_test);
		autotextview.setThreshold(1);
		autotextview.setAdapter(new PlacesAutoCompleteAdapter(this, R.layout.list_item));

		autotextview.setOnItemClickListener(this);

		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		String str = (String) arg0.getItemAtPosition(arg2);
		autotextview.setText(str);
	}

	

}
