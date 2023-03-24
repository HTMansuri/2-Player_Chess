package chess;

import java.util.Scanner;

public class Chess
{
	public static void main(String[] args)
	{
		//variables
		String input = "";
		String color = "";
		int turn = 0;
		boolean status = true;
		
		//variables to identify check
		int bchecki = 7;
		int bcheckj = 4;
		int wchecki = 0;
		int wcheckj = 4;
		boolean check = false;
		
		Scanner sc = new Scanner(System.in);
		
		//Initialize a default/initial chess board
		Board[][] board = new Board[8][8];
		initChessBoard(board);
		
		do
		{
			//Display current chess board
			if(status)
			{
				displayChessBoard(board);
			}
			
			if(status)
				System.out.println("\n");
			if(turn%2 != 0)
			{
				color = "b";
				System.out.print("Black's move: ");
			}
			else
			{
				color = "w";
				System.out.print("White's move: ");
			}
			input = sc.nextLine().trim();
			
			
			if(input.equals("resign") || (input.length()>5 && input.substring(6).equals("draw?")))
			{
				break;
			}
			if(input.equals("") || input.charAt(2)!=' ' || input.charAt(0)<'a' || input.charAt(0)>'h' || input.charAt(3)<'a' || input.charAt(3)>'h' || input.charAt(1)<'0' || input.charAt(1)>'7' || input.charAt(4)<'0' || input.charAt(4)>'7')
			{
				status=false;
				System.out.println("Illegal move, try again");
				continue;
			}
			
			
			int initiali = Character.getNumericValue(input.charAt(1))-1;
			//System.out.println(initiali);
			int finali = Character.getNumericValue(input.charAt(4))-1;
			//System.out.println(finali);
			
			int initialj = input.charAt(0) - 97;
			//System.out.println(initialj);
			int finalj = input.charAt(3) - 97;
			//System.out.println(finalj);
			String promotionKey = null;
			
			if((finali==7 && board[initiali][initialj].getName()=="p") || (finali==0 && board[initiali][initialj].getName()=="p"))
			{
				if(input.length()>=7)
					promotionKey = String.valueOf(input.charAt(6));
				else
					promotionKey = "Q";
			}
			else if(input.length()>5)
			{
				status=false;
				System.out.println("Illegal move, try again");
				continue;
			}
			
			//checks for valid cases
//			if(initiali < 0 || initiali > 7 || initialj < 0 || initialj > 7 || finali < 0 || finali > 7 || finalj < 0 || finalj > 7)
//			{
//				status = false;
//			}
//			else if niche			
			if(board[initiali][initialj] == null)
			{
				status = false;
			}
			else if(!(board[initiali][initialj].getColor().equals(color)))
			{
				status = false;
			}
			else
			{
				if(board[finali][finalj] != null)
				{
					if(board[initiali][initialj].getColor().equals(board[finali][finalj].getColor()))
					{
						status = false;
					}
					else
					{
						if(Pawn.enPassant)
						{
							status = board[initiali][initialj].isValid(board, initiali, initialj, finali, finalj);
							if(status) {
								Pawn.enPassant = false;
								Pawn.enPassantPos=null;
							}
						}
						else
							status = board[initiali][initialj].isValid(board, initiali, initialj, finali, finalj);						
					}
				}
				else
				{
					if(Pawn.enPassant)
					{
						status = board[initiali][initialj].isValid(board, initiali, initialj, finali, finalj);
						if(status) {
							Pawn.enPassant = false;
							Pawn.enPassantPos=null;
						}
					}
					else
						status = board[initiali][initialj].isValid(board, initiali, initialj, finali, finalj);
				}
			}
			
			if(status)
			{
				//castling check for move
				if(((board[initiali][initialj].getColor().equals("w") && (King.wrcast || King.wlcast)) || (board[initiali][initialj].getColor().equals("b") && (King.blcast || King.brcast))) && board[initiali][initialj].getName().equals("K"))
				{
					if(King.wlcast && finali==0 && finalj==2)
					{
						//rook from 0,0 to 0,3
						board[0][0] = null;
						board[0][3] = new Rook();
						board[0][3].setColor("w");
						board[0][3].setName("R");
					}
					else if(King.blcast && finali==7 && finalj==2)
					{
						//rook from 7,0 to 7,3
						board[7][0] = null;
						board[7][3] = new Rook();
						board[7][3].setColor("b");
						board[7][3].setName("R");
					}
					else if(King.wrcast && finali==0 && finalj==6)
					{
						System.out.println("wrcast" + King.wrcast + "wlcast" + King.wlcast);
						//rook from 0,7 to 0,5
						board[0][7] = null;
						board[0][5] = new Rook();
						board[0][5].setColor("w");
						board[0][5].setName("R");
					}
					else if(King.brcast && finali==7 && finalj==6)
					{
						//rook from 7,7 to 7,5
						board[7][7] = null;
						board[7][5] = new Rook();
						board[7][5].setColor("b");
						board[7][5].setName("R");
					}
				}
				if((finali==7 && board[initiali][initialj].getName()=="p") || (finali==0 && board[initiali][initialj].getName()=="p"))
				{
					if(promotionKey==null)
						promotionKey="Q";
					String keyColor = board[initiali][initialj].getColor();
					switch(promotionKey)
					{
						case "Q":
							board[finali][finalj] = new Queen();
							board[finali][finalj].setColor(keyColor);
							board[initiali][initialj] = null;
							break;
							
						case "R":
							board[finali][finalj] = new Rook();
							board[finali][finalj].setColor(keyColor);
							board[initiali][initialj] = null;
							break;
							
						case "N":
							board[finali][finalj] = new Knight();
							board[finali][finalj].setColor(keyColor);
							board[initiali][initialj] = null;
							break;
							
						case "B":
							board[finali][finalj] = new Bishop();
							board[finali][finalj].setColor(keyColor);
							board[initiali][initialj] = null;
							break;
						
						case "K":
							promotionKey=null;
							status = false;
							break;
							
						case "p":
							promotionKey=null;
							status = false;
							break;
							
						default:
							promotionKey=null;
							status = false;
					}
				}
				if(status && promotionKey==null)
				{
					board[finali][finalj] = board[initiali][initialj].move(board[finali][finalj]);
					board[initiali][initialj] = null;
					//keeps track of i and j for check identification
					if(board[finali][finalj].getName().equals("K"))
					{
						if(board[finali][finalj].getColor().equals("w"))
						{
							wchecki = finali;
							wcheckj = finalj;
						}
						else
						{
							bchecki = finali;
							bcheckj = finalj;
						}
					}
				}
			}
			
			//region of check
			String c = "";
			if(board[finali][finalj]!=null)
				c = board[finali][finalj].getColor();
			if(c.equals("w"))
			{
				check = check(board, wchecki, wcheckj);
			}
			else
			{
				check = check(board, bchecki, bcheckj);
			}

			if(check)
			{
				status=false;
				board[initiali][initialj] = board[finali][finalj].move(board[initiali][initialj]);
				board[finali][finalj] = null;
			}
			
			
			
			
			if(!status)
			{
				System.out.println("Illegal move, try again");
				continue;
			}
			
			//opposite move check
			if(c.equals("b"))
			{
				check = check(board, wchecki, wcheckj);
			}
			else
			{
				check = check(board, bchecki, bcheckj);
			}
			
			if(check)
			{
				System.out.println("Check");
			}
			
			
			
			//if the rooks or kings move then castling is disabled
			if(board[finali][finalj] != null)
			{
				if((board[finali][finalj].getColor().equals("w") && status==true))
				{
					if(board[finali][finalj].getName().equals("K"))
					{
						King.wlcast = false;
						King.wrcast = false;
					}
					else if(board[finali][finalj].getName().equals("R"))
					{
						if(initialj==7)
						{
							King.wrcast = false;
						}
						else if(initialj==0)
						{
							King.wlcast = false;
						}
					}
				}
				else if((board[finali][finalj].getColor().equals("b") && status==true))
				{
					if(board[finali][finalj].getName().equals("K"))
					{
						King.blcast = false;
						King.brcast = false;
					}
					else if(board[finali][finalj].getName().equals("R"))
					{
						if(initialj==7)
						{
							King.brcast = false;
						}
						else if(initialj==0)
						{
							King.blcast = false;
						}
					}
				}
			}
			
			if(status)
				System.out.println();
			turn++;
		}
		while(turn<100);
		
		if(input.length()>5 && input.substring(6).equals("draw?"))
		{
			String draw = sc.nextLine();
			while(!draw.equals("draw"))
				draw = sc.nextLine();
		}
		else if(input.equals("resign"))
		{
			if(turn%2 != 0)
			{
				System.out.println("White wins");
			}
			else
			{
				System.out.println("Black wins");
			}
		}
		
		//close
		sc.close();
	}
	
	
	//methods
	
	//method that identifies check for given King - returns true if check is detected
	//i will need to keep track of where my king is after any move to make this method work
	public static boolean check(Board[][] board, int kingi, int kingj)
	{
		boolean check;
		for(int i=7; i>=0; i--)
		{
			for(int j=0; j<=7; j++)
			{
				String color="";
				if(board[i][j]!=null)
					color = board[i][j].getColor();
				if(board[i][j] != null && !board[kingi][kingj].getColor().equals(color))
				{
					check = board[i][j].isValid(board, i, j, kingi, kingj);
					if(check)
						return true;
				}
			}
		}
		return false;
	}
	
	//Initialize a default/initial chess board
	public static void initChessBoard(Board[][] board)
	{
		board[0][0] = new Rook();
		board[0][7] = new Rook();
		board[7][0] = new Rook();
		board[7][7] = new Rook();
		
		board[0][1] = new Knight();
		board[0][6] = new Knight();
		board[7][1] = new Knight();
		board[7][6] = new Knight();
		
		board[0][2] = new Bishop();
		board[0][5] = new Bishop();
		board[7][2] = new Bishop();
		board[7][5] = new Bishop();
		
		board[0][3] = new Queen();
		board[7][3] = new Queen();
		
		board[0][4] = new King();
		board[7][4] = new King();
		
		for(int i=0; i<1; i++)
		{
			for(int j=0; j<8; j++)
			{
				board[i][j].setColor("w");
			}
		}
		
		for(int i=7; i<8; i++)
		{
			for(int j=0; j<8; j++)
			{
				board[i][j].setColor("b");
			}
		}
		
		for(int i=1; i<2; i++)
		{
			for(int j=0; j<8; j++)
			{
				board[i][j] = new Pawn();
				board[i][j].setColor("w");
			}
		}
		
		for(int i=6; i<7; i++)
		{
			for(int j=0; j<8; j++)
			{
				board[i][j] = new Pawn();
				board[i][j].setColor("b");
			}
		}
	}
	
	
	//Display current chess board
	public static void displayChessBoard(Board[][] board)
	{
		int vertIndex = 9;
		char horiIndex = 'a';
		for(int i=7; i>=0; i--)
		{
			for(int j=0; j<8; j++)
			{
				if(board[i][j] != null)
				{
					StringBuilder name = new StringBuilder("");
					name.append(board[i][j].getColor());
					name.append(board[i][j].getName());
					System.out.print(name + " ");
				}
				else if((i%2 == 0 && j%2 != 0) || (i%2 != 0 && j%2 == 0))
				{
					System.out.print("## ");
				}
				else
				{
					System.out.print("   ");
				}
			}
			vertIndex--;
			System.out.println(vertIndex);
		}
		while(horiIndex != 'i')
		{
			if(horiIndex == 'a')
			{
				System.out.print(" " + horiIndex);
			}
			else
			{
				System.out.print("  " + horiIndex);
			}
			horiIndex++;
		}
	}
}