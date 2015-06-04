package com.example.reversigame;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class Menu extends Activity {
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.options_menu);
		
		//All Button for options menu that will call another functions to be implemented 
		
		Button playOnline  = (Button) findViewById(R.id.submit);
		Button localPlay   = (Button) findViewById(R.id.button2);
		Button settings    = (Button) findViewById(R.id.button3);
		Button howToPlay   = (Button) findViewById(R.id.button6);
		Button load        = (Button) findViewById(R.id.button4);
		Button exit        = (Button) findViewById(R.id.button5);

		
		//Play online button when clicked 
		playOnline.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(Menu.this , Name.class  ) ;
				startActivity(intent);
				
			}
		});
		
		//play vs computer button when clicked
		localPlay.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Menu.this , NameForLocal.class);
				startActivity(intent);
			}
		});
		
		//Settings that the user will choose 
		settings.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent= new Intent (Menu.this , Settings.class);
				startActivity(intent);
			}
		});
		
		//How to play
		howToPlay.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent= new Intent (Menu.this , HowToPlay.class);
				startActivity(intent);
			}
		});
		
		//load a new game
		load.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				FilesOperations newOb =  new FilesOperations(); 
//				newOb.loadAGame();
			}
		});

		//Exit the game 
		exit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, (android.view.Menu) menu);
		return true;
	}

}
