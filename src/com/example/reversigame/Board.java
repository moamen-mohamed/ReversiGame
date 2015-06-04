package com.example.reversigame;


import java.io.PrintWriter;
import java.net.Socket;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class Board extends Activity {
	final ImageButton btnImage [][] = new ImageButton[8][8];
	int playerTurn = 0 ;
	int played = 0 ;
	int[][] currentState = new int[8][8];
	FilesOperations filesHandler;
	TextView sc1 , sc2;
	GameLogic logic = new GameLogic();
	int [] result = new int[2];
	Socket client;
	PrintWriter printwriter;
	EditText textField;
	Button button;
	String messsage;
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.local_board);
			
			sc1 = (TextView) findViewById(R.id.textView2); 
			sc2 = (TextView) findViewById(R.id.textView6); 
			TextView textview=(TextView)findViewById(R.id.textView1);
			textview.setText(getIntent().getStringExtra("text"));
			Button button=(Button) findViewById(R.id.button1);
			Button saveBtn = (Button) findViewById(R.id.button2);

			//this function is to reset the game to the begining
			button.setOnClickListener(new View.OnClickListener() { 	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Board.this,NameForLocal.class);
				startActivity(intent);			
				}
			});
			
			initialize ();
			
			for (int i = 0 ; i < 8 ; ++i ){
				for (int y = 0 ; y < 8 ; ++y ){
					final ImageButton touchedBtn = btnImage[i][y];
					final int z = i ; 
					final int q = y ;
					touchedBtn.setOnClickListener(new OnClickListener() {
						int[] scores;
						@SuppressWarnings("static-access")
						@Override
						public void onClick(View arg0) {
							if (playerTurn % 2 == 0 && logic.wrapper(z,q,1) ){
								touchedBtn.setImageResource(R.drawable.p1);
								touchedBtn.setEnabled(false);
								currentState[z][q] = 1 ;
								currentState = logic.getNewBoard(); 
								update (); 
								scores = logic.calScores();
								sc1.setText((CharSequence) String.valueOf(scores[0]));
								sc2.setText((CharSequence) String.valueOf(scores[1]));
							}
								result = logic.easyLevel();
								btnImage[result[0]][result[1]].setImageResource(R.drawable.p2);
								btnImage[result[0]][result[1]].setEnabled(false);
								currentState[result[0]][result[1]] = 2 ;
								currentState = logic.getNewBoard();  
								update ();
								scores = logic.calScores();
								sc1.setText((CharSequence) String.valueOf(scores[0]));
								sc2.setText((CharSequence) String.valueOf(scores[1]));
								playerTurn+=2;
						}
					});
				}
			}
			
			saveBtn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					save();
				}
			});
		
		}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.local_board, menu);
			return true;
		}
		
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * initialize void function that initilaize the btnButtons with the corresponding ImageButton
		 */
		private void initialize (){
			btnImage[0][0] = (ImageButton) findViewById(R.id.imageButton1);
			btnImage[0][1] = (ImageButton) findViewById(R.id.imageButton2);
			btnImage[0][2] = (ImageButton) findViewById(R.id.imageButton3);
			btnImage[0][3] = (ImageButton) findViewById(R.id.imageButton4);
			btnImage[0][4] = (ImageButton) findViewById(R.id.imageButton5);
			btnImage[0][5] = (ImageButton) findViewById(R.id.imageButton6);
			btnImage[0][6] = (ImageButton) findViewById(R.id.imageButton7);
			btnImage[0][7] = (ImageButton) findViewById(R.id.imageButton8);

			btnImage[1][0] = (ImageButton) findViewById(R.id.imageButton9);
			btnImage[1][1] = (ImageButton) findViewById(R.id.imageButton10);
			btnImage[1][2] = (ImageButton) findViewById(R.id.imageButton11);
			btnImage[1][3] = (ImageButton) findViewById(R.id.imageButton12);
			btnImage[1][4] = (ImageButton) findViewById(R.id.imageButton13);
			btnImage[1][5] = (ImageButton) findViewById(R.id.imageButton14);
			btnImage[1][6] = (ImageButton) findViewById(R.id.imageButton15);
			btnImage[1][7] = (ImageButton) findViewById(R.id.imageButton16);
			
			btnImage[2][0] = (ImageButton) findViewById(R.id.imageButton17);
			btnImage[2][1] = (ImageButton) findViewById(R.id.imageButton18);
			btnImage[2][2] = (ImageButton) findViewById(R.id.imageButton19);
			btnImage[2][3] = (ImageButton) findViewById(R.id.imageButton20);
			btnImage[2][4] = (ImageButton) findViewById(R.id.imageButton21);
			btnImage[2][5] = (ImageButton) findViewById(R.id.imageButton22);
			btnImage[2][6] = (ImageButton) findViewById(R.id.imageButton23);
			btnImage[2][7] = (ImageButton) findViewById(R.id.imageButton24);
			
			btnImage[3][0] = (ImageButton) findViewById(R.id.imageButton25);
			btnImage[3][1] = (ImageButton) findViewById(R.id.imageButton26);
			btnImage[3][2] = (ImageButton) findViewById(R.id.imageButton27);
			btnImage[3][3] = (ImageButton) findViewById(R.id.imageButton28);
			btnImage[3][4] = (ImageButton) findViewById(R.id.imageButton29);
			btnImage[3][5] = (ImageButton) findViewById(R.id.imageButton30);
			btnImage[3][6] = (ImageButton) findViewById(R.id.imageButton31);
			btnImage[3][7] = (ImageButton) findViewById(R.id.imageButton32);
			
			btnImage[4][0] = (ImageButton) findViewById(R.id.imageButton33);
			btnImage[4][1] = (ImageButton) findViewById(R.id.imageButton34);
			btnImage[4][2] = (ImageButton) findViewById(R.id.imageButton35);
			btnImage[4][3] = (ImageButton) findViewById(R.id.imageButton36);
			btnImage[4][4] = (ImageButton) findViewById(R.id.imageButton37);
			btnImage[4][5] = (ImageButton) findViewById(R.id.imageButton38);
			btnImage[4][6] = (ImageButton) findViewById(R.id.imageButton39);
			btnImage[4][7] = (ImageButton) findViewById(R.id.imageButton40);
			
			btnImage[5][0] = (ImageButton) findViewById(R.id.imageButton41);
			btnImage[5][1] = (ImageButton) findViewById(R.id.imageButton42);
			btnImage[5][2] = (ImageButton) findViewById(R.id.imageButton43);
			btnImage[5][3] = (ImageButton) findViewById(R.id.imageButton44);
			btnImage[5][4] = (ImageButton) findViewById(R.id.imageButton45);
			btnImage[5][5] = (ImageButton) findViewById(R.id.imageButton46);
			btnImage[5][6] = (ImageButton) findViewById(R.id.imageButton47);
			btnImage[5][7] = (ImageButton) findViewById(R.id.imageButton48);
			
			btnImage[6][0] = (ImageButton) findViewById(R.id.imageButton49);
			btnImage[6][1] = (ImageButton) findViewById(R.id.imageButton50);
			btnImage[6][2] = (ImageButton) findViewById(R.id.imageButton51);
			btnImage[6][3] = (ImageButton) findViewById(R.id.imageButton52);
			btnImage[6][4] = (ImageButton) findViewById(R.id.imageButton53);
			btnImage[6][5] = (ImageButton) findViewById(R.id.imageButton54);
			btnImage[6][6] = (ImageButton) findViewById(R.id.imageButton55);
			btnImage[6][7] = (ImageButton) findViewById(R.id.imageButton56);
			
			btnImage[7][0] = (ImageButton) findViewById(R.id.imageButton57);
			btnImage[7][1] = (ImageButton) findViewById(R.id.imageButton58);
			btnImage[7][2] = (ImageButton) findViewById(R.id.imageButton59);
			btnImage[7][3] = (ImageButton) findViewById(R.id.imageButton60);
			btnImage[7][4] = (ImageButton) findViewById(R.id.imageButton61);
			btnImage[7][5] = (ImageButton) findViewById(R.id.imageButton62);
			btnImage[7][6] = (ImageButton) findViewById(R.id.imageButton63);
			btnImage[7][7] = (ImageButton) findViewById(R.id.imageButton64);
			
			for (int i = 0 ; i < 8 ; i++ ){
				for (int y = 0 ; y < 8 ; ++y ){
					currentState[i][y] = 0 ;
				}
			}
			
			currentState[3][3] = 2 ; 
			currentState[4][4] = 2 ; 
			currentState[3][4] = 1 ; 
			currentState[4][3] = 1 ;
			logic.setter(currentState);
			update();
		}
		
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * Save () function is to save the board state
		 */
		private void save (){
			filesHandler = new FilesOperations();
			filesHandler.saveAGame(currentState);
		}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		/**
		 * update () function is to update the board after each player with the fliping  
		 */
		private void update (){
			for (int i = 0 ; i < 8 ; ++i ){
				for (int y = 0 ; y < 8 ; ++y ){
					if (currentState[i][y]==1){
						btnImage[i][y].setImageResource(R.drawable.p1);
					}else if (currentState[i][y]==2){
						btnImage[i][y].setImageResource(R.drawable.p2);	
					}else {
						
					}
				}			
			}
		}	
}
