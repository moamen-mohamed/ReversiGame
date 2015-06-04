package com.example.reversigame;



import java.io.File;
import java.io.FileOutputStream;

import android.content.Context;


public class FilesOperations {
	

	public void saveAGame (int [][] currentState ){
		File saveGame = new File("outfile.txt");
		String string = "";
		FileOutputStream outputStream;
		try {
			outputStream = openFileOutput(saveGame,Context.MODE_PRIVATE);		
			for (int i = 0 ; i < 8 ; ++i ){
				for (int y = 0 ; y < 8 ; ++y ){
					  outputStream.write(string.getBytes());
					  
				}}
			outputStream.flush();
			outputStream.close();
		}catch (Exception e ){
			e.printStackTrace();
		} 
		
	}
	
	private FileOutputStream openFileOutput(File saveGame2, int modePrivate) {
		// TODO Auto-generated method stub
		return null;
	}

	/*public String [][] loadAGame (){
		String[][] result = new String [8][8];
		int row = 0 , col = 0 ;
		String data ="";
		try {
			readData = new BufferedReader( new FileReader("savedgame.txt"));
			while (readData.ready()){
				data = readData.readLine();
				StringTokenizer tokens = new StringTokenizer(data);
				while (tokens.hasMoreTokens() ){
					result[row][col] = tokens.nextToken();
					col++;
				}
				col=0;
				row++;
			}
		}catch (Exception e ){
			
		}
		return result ;
	}*/

	
};
 
