package chess;

import java.util.Scanner;

public class Chess
{
	public static void main(String[] args)
	{
		//variables
		String input = "";
		int turn = 0;

		Scanner sc = new Scanner(System.in);

		//Initialize a default/initial chess board
		Board[][] board = new Board[8][8];
		initChessBoard(board);

		do
		{
			//Display current chess board
			displayChessBoard(board);
			System.out.println("\n");
			if(turn%2 != 0)
			{
				String color = "b";
				System.out.print("Black's move: ");
			}
			else
			{
				String color = "w";
				System.out.print("White's move: ");
			}
			turn++;
			input = sc.nextLine();

			int initiali = Character.getNumericValue(input.charAt(1));
			//System.out.println("initiali" + initiali);
			int finali = Character.getNumericValue(input.charAt(4));
			//System.out.println("finali" + finali);

			int initialj = input.charAt(0) - 97;
			//System.out.println("initialj" + initialj);
			int finalj = input.charAt(3) - 97;
			//System.out.println("finalj" + finalj);

			System.out.println();
		}
		while(turn<10);

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