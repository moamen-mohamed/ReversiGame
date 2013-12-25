package com.example.reversigame;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameForLocal extends Activity {
	EditText text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.name_for_local);
		Button button = (Button) findViewById(R.id.submit);
		
		text= (EditText) findViewById(R.id.nameText);
		
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(NameForLocal.this,LocalBoard.class);
				intent.putExtra("text", text.getText().toString());
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.name_for_local, menu);
		return true;
	}

}
