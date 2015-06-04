
package com.example.reversigame;

import android.R.bool;

public class GameLogic extends Thread {
	int [][] board ; 
	int xCord , yCord , currentPlayer  ;
	/*void showme(){
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    System.out.print(board [i][j]+"  ");
                }
                System.out.println();
            }
        }*/
	public GameLogic (){
		board = new int[8][8];
		for (int  i = 0 ; i < 8 ; ++i){
			for (int y = 0 ; y < 8 ; ++y ){
				board [i][y]=0;
			}
		}
		board[3][3] = 2 ; 
		board[4][4] = 2 ; 
		board[3][4] = 1 ; 
		board[4][3] = 1 ;
	}
	
	public void setter (int[][] nboard ){
		board = nboard ;
	}

	public int[][] getNewBoard (){
		return board;
	}
	
	/* Function wrapper that that takes 5 parameters and call 8 other functions to explore surrounded cells 
	 * @param: int[][] board 
	 * @param: int xCord
	 * @param: int yCord 
	 * @param: int fPlayer
	 * @param: int sPlayer
	 */
	public boolean  wrapper ( int xCord , int yCord , int currentPlayer  ){
		this.xCord = xCord ;
		this.yCord = yCord ; 
		this.currentPlayer = currentPlayer ; 
		boolean ch1=false,ch2=false,ch3=false,ch4=false,ch5=false,ch6=false,ch7=false,ch8=false;
                if (board[xCord][yCord]==0){
                    ch1=up(currentPlayer);
                    ch2=down(currentPlayer);
                    ch3=right(currentPlayer);
                    ch4=left(currentPlayer);
                    ch5=upRight(currentPlayer);
                    ch6=upLeft(currentPlayer);
                    ch7=downRight(currentPlayer);
                    ch8=downLeft(currentPlayer);
                    if(ch1||ch2||ch3||ch4||ch5||ch6||ch7||ch8){
                            return true;
                    }
                    else
                            return false;

                }
                return false;
		
	}
	
	public boolean right (int p1 ){
		int  p2 , c = 0 , x = 0 , y = 0 ;
		boolean flp=false;
		
		if (p1==1)
			p2=2;
		else
			p2=1;
		 
		for (int i = yCord+1 ; i < 8 ; ++i ){
		    try {
		        if(i==yCord+1 && board[xCord][i]==p1) break;
				else if ( board[xCord][i] == p1 ){
					flp = true ;
					x=xCord;
					y=i;
					break;
				}else if (board[xCord][i] == p2){
					c++;
				} else if ( board[xCord][i] == 0 ){
					break;
				}
		    } catch (Exception e) {
		        break;
		    }
		}
		if ( flp ){
                        System.out.println("rigt");
                        board [xCord][yCord] = p1 ;
			for (int i = y-1 ; i >= 0 ; --i ){
				if ( board[x][i] == p1 ){
					break;
				}else {
					board[x][i] = p1;
				}
			}
		}else {
			flp = false ;
		}
		return flp;
	}
	
	
	public boolean left (int p1){
		int p2;
		if(p1==1)
			p2=2;
		else
			p2=1;
		int c = 0 ;
		int x=0,y=0;
		boolean flp=false;
		for (int i = yCord-1 ; i >= 0 ; --i ){
	        try {
	            if(i==yCord-1&&board[xCord][i]==p1)
	            	break;
				if ( board[xCord][i] == p1 ){
					flp = true ;
					x=xCord;
					y=i;
					break;
				}else if (board[xCord][i] == p2){
					c++;
				} else if (board[xCord][i] == 0 ){
					break;
				}
	        } catch (Exception e) {
	            break;
	        }
		}
		if (flp){
            
                    System.out.println("left");
                    board[xCord][yCord] = p1;
            
			for (int i = y+1 ; i < 8 ; ++i ){
				if ( board[xCord][i] == p1 ){
					break;
				}else {
					board[x][i] = p1 ;
				}
			}
		}else{
			flp = false ;
		} 
		return flp ;
	}
	
	public boolean down (int p1){
		int p2;
		if(p1==1)p2=2;
		else
			p2=1;
		int c = 0 ;
		int x=0,y=0;
		boolean flp=false;
		for (int i = xCord+1 ; i < 8 ; ++i ){
                    try {
                        if(i==xCord+1&&board[i][yCord]==p1)break;
			if ( board[i][yCord] == p1  ){
				flp=true;
				x=i;
				y=yCord;
				break;
			}else if (board[i][yCord] == p2){
				c++;
			}
			else if(board[i][yCord]==0)break;
                    } catch (Exception e) {
                        break;
                    }
			
		}
		if(flp){
                     board[xCord][yCord]=p1;
                     System.out.println("down ");
			for (int i = x-1 ; i >= 0 ; --i ){
				if ( board[i][y] == p1  ){
					break;
				}else if (board[i][y] == p2){
					board[i][y]=p1;
				}
			}
			
		}else{
			flp = false ;
		} 
		return flp;
	}
	
        public boolean up (int p1){
		int p2, c = 0 , x=0,y=0;
		boolean flp= false;
		
		if(p1==1)p2=2;
		else p2=1; 
		
		for (int i = xCord-1 ; i >= 0 ; --i ){
                    try {
                        if(i==xCord-1&&board[i][yCord]==p1)break;
			if ( board[i][yCord] == p1  ){
				flp=true;
				x=i;
				y=yCord;
			}else if (board[i][yCord] == p2){
				c++;
                        }
			else if(board[i][yCord]==0)break;
                    } catch (Exception e) {
                        break;
                    }
			
		}
		
		if(flp){
                        System.out.println("up");
			board[xCord][yCord]=p1;
			for (int i = x+1 ; i < 8 ; ++i ){
				if ( board[i][y] == p1  ){
					break;
				}else {
					board[i][y]=p1;
				}
			}
		
	}else{
		flp = false ;
	} 
	return flp;
}
public boolean upLeft(int p1){
		int p2 , c=0 , x=0,y=0 , n = yCord-1;
		boolean flp=false;
		
		if(p1==1)p2=2;
		else p2=1;
		try {
			for(int i= xCord-1 ; i >= 0 && n >=0 ; i--){
				if(i==xCord-1 && n == yCord - 1 && board[i][n] == p1)break;
					if(board[i][n]==p1){
						flp=true;
						x=i;
						y=n;
						break;
					}else if(board[i][n]==p2){
						c++;
					}else if(board[i][n]==0){
						break;
					}
				n--;
			}
		}catch (Exception e) {
			
		}
		int m=y+1;
		if(flp){
                    System.out.println("upleft");
			board[xCord][yCord]=p1;
			for(int i=x+1;i<8;i++){
				
					if(board[i][m]==p1){
						break;
					}else{
						board[i][m]=p1;
					}
					
					
				m++;
			}	
		}else{
			flp = false ;
		} 
		return flp;
	}
	public boolean upRight(int p1){
		int p2;
		if(p1==1)p2=2;
		else p2=1;
		int c=0;
		int x=0,y=0;
		int n=yCord+1;
		boolean flp=false;
		for(int i=xCord-1;i>=0;i--){
                    try {
                        if(i==xCord-1&&n==yCord+1&&board[i][n]==p1)break;
			if(board[i][n]==p1){
				flp=true;
				x=i;
				y=n;
				break;
			}else if(board[i][n]==p2){
				c++;
			}else if(board[i][n]==0){
				break;
			}
                        n++;
                    } catch (Exception e) {
                        break;
                    }
	}
                System.out.println("uprigt"+flp);
	int m=y-1;
	if(flp){
                board[xCord][yCord]=p1;
                System.out.println("uprigt");
		for(int i=x+1;i<8;i++){
			
				if(board[i][m]==p1){
					break;
				}else{
					board[i][m]=p1;
				}
			m--;
		}
	}else{
		flp = false ;
	} 
		return flp;
	}
	
	public boolean downLeft (int p1){
		int p2;
		if(p1==1)p2=2;
		else p2=1;
		int c=0;
		int x=0,y=0;
		int n=yCord-1;
                
		boolean flp=false;
		for(int i=xCord+1 ;i < 8 ;i++){
                    try {
                        if(i==xCord+1&&n==yCord-1&&board[i][n]==p1)break;
                        if(board[i][n]==p1){
                                flp=true;
                                x=i;
                                y=n;
                                break;
                        }else if(board[i][n]==p2){
                                c++;
                        }else if(board[i][n]==0){
                                break;
                        }
                        n--;
                    } catch (Exception e) {
                        break;
                    }
	}
	int m=y+1;
	if(flp){
                board[xCord][yCord]=p1;
                System.out.println("downlift");
		for(int i=x-1;i>=0;i--){
			
				if(board[i][m]==p1){
					break;
				}else{
					board[i][m]=p2;
				}
				
			m++;
		}

		}else{
			flp = false ;
		} 
	return flp;
	}
	
	public boolean downRight (int p1){
		int p2;
		if(p1==1)p2=2;
		else p2=1;
		int c=0;
		int x=0,y=0;
		int n=yCord+1;
		boolean flp=false;
		
		for(int i=xCord+1;i<8;i++){
                    try {
                        if(i==xCord+1&&n==yCord+1&&board[i][n]==p1)break;
			if(board[i][n]==p1){
				flp=true;
				x=i;
				y=n;
				break;
			}else if(board[i][n]==p2){
				c++;
			}else if(board[i][n]==0){
				break;
			}
                        n++;
                    } catch (Exception e) {
                        break;
                    }
		
                }
                int m=y-1;
                if(flp){
                        board[xCord][yCord]=p1;
                        System.out.println("downrigt");
                        for(int i=x-1;i>=0;i--){
                                //System.out.println("i= "+i+"m= "+m+"board[i][m]= "+board[i][m]);
                                if(board[i][m]==p1){
                                        break;
                                }else{
                                        board[i][m]=p1;
                                }
                                m--;
                        }
                }else{
        			flp = false ;
        		} 
                return flp;
	}

	
	public int[] easyLevel (){
		int[] result = new int [2] ;
		boolean notValid = true ;
		
		while (notValid){
			result[0] = 0 + (int)(Math.random() * ((7 - 0) + 1));
			result[1] = 0 + (int)(Math.random() * ((7 - 0) + 1));
			if (wrapper(result[0], result[1], 2)){
				notValid = false ;
			}
			/*if (board[result[0]][result[1]]!= currentPlayer && board[result[0]][result[1]] != currentPlayer ){
				notValid = false ;
			}*/
		}
		return result;
	}
	
	private boolean checkWinner (int sc1 , int sc2 ){
		return sc1 > sc2 ? true : false ;
	}
	
	public int[] calScores (){
		int[] result = new int [2];
		result[0] = 0 ;
		result[1] = 0 ;
		
		for (int i = 0 ; i < 8 ; ++i ){
			for (int y = 0 ; y < 8 ; ++y ){
				if ( board[i][y] == 1 ){
					result[0]++;
				}else if (board[i][y] == 2){
					result[1]++;
				}
			}
		}
		if (result[0] + result[1] == 64) {
			checkWinner (result[0] , result[1]);
		}
		return result ;
	}


}
