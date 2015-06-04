package com.example.reversigame;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Name extends Activity {
	EditText text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.name);
		
		Button button = (Button) findViewById(R.id.submit);
		text= (EditText) findViewById(R.id.nameText);
		   ConnectivityManager connMgr = (ConnectivityManager) 
		        getSystemService(Context.CONNECTIVITY_SERVICE);
			    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
			    if (networkInfo != null && networkInfo.isConnected()) {
			button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Name.this , Board.class);
				intent.putExtra("text", text.getText().toString());
				startActivity(intent);
			}
		});
	}else {
		
	}
}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.name, menu);
		return true;
	}
	
}
