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
			turn++;
			input = sc.nextLine();
			
			int initiali = Character.getNumericValue(input.charAt(1))-1;
			//System.out.println(initiali);
			int finali = Character.getNumericValue(input.charAt(4))-1;
			//System.out.println(finali);
			
			int initialj = input.charAt(0) - 97;
			//System.out.println(initialj);
			int finalj = input.charAt(3) - 97;
			//System.out.println(finalj);
			
			//checks for valid cases
			if(initiali < 0 && initiali > 7 && initialj < 0 && initialj > 7 && finali < 0 && finali > 7 && finalj < 0 && finalj > 7)
			{
				status = false;
			}
			else if(board[initiali][initialj] == null)
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
						status = board[initiali][initialj].isValid(board, initiali, initialj, finali, finalj);
					}
				}
				else
				{
					status = board[initiali][initialj].isValid(board, initiali, initialj, finali, finalj);
				}
			}
			
			if(status)
			{
				board[finali][finalj] = board[initiali][initialj].move(board[finali][finalj]);
				board[initiali][initialj] = null;
			}
			else
			{
				System.out.println("Illegal move, try again");
				turn--;
			}
			System.out.println();
		}
		while(turn<100);
		
		//close
		sc.close();
	}
	
	
	//methods
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