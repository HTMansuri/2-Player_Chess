package chess;

public class Queen extends Board
{
	//class variables
	private String color;
	private String name;
	
	//constructors
	public Queen()
	{
		color="";
		name="Q";
	}
	
	public boolean isValid(Board[][] board, int initiali, int initialj, int finali, int finalj)
	{
		boolean status = false;
		
		if(initiali == finali) //checks for Rook
		{
			status = true;
			if(initialj < finalj) // example moving from (0,0) to (0,7)
			{
				initialj++; //don't want to check the initial position for any object present or not
				//returns false if there is any other object between initial and final move of the Rook
				while(initialj < finalj)
				{
					if(board[initiali][initialj] != null)
					{
						return false;
					}
					initialj++;
				}
			}
			else if(initialj > finalj) // example moving from (0,7) to (0,0)
			{
				initialj--; //don't want to check the initial position for any object present or not
				//returns false if there is any other object between initial and final move of the Rook
				while(initialj > finalj)
				{
					if(board[initiali][initialj] != null)
					{
						return false;
					}
					initialj--;
				}
			}
		}
		else if(initialj == finalj)
		{
			status = true;
			if(initiali < finali)
			{	
				initiali++;
				while(initiali < finali)
				{
					if(board[initiali][initialj] != null)
					{
						return false;
					}
					initiali++;
				}
			}
			else if(initiali > finali)
			{
				initiali--;
				while(initiali > finali)
				{
					if(board[initiali][initialj] != null)
					{
						return false;
					}
					initiali--;
				}
			}
		}
		else if(Math.abs(initiali-finali) == Math.abs(initialj-finalj)) //checks for Bishop
		{
			status = true;
			if(initiali > finali && initialj > finalj)
			{
				initiali--;
				initialj--;
				while(initiali > finali && initialj > finalj)
				{
					if(board[initiali][initialj] != null)
					{
						return false;
					}
					initiali--;
					initialj--;
				}
			}
			else if(initiali < finali && initialj < finalj)
			{
				initiali++;
				initialj++;
				while(initiali < finali && initialj < finalj)
				{
					if(board[initiali][initialj] != null)
					{
						return false;
					}
					initiali++;
					initialj++;
				}
			}
			else if(initiali < finali && initialj > finalj)
			{
				initiali++;
				initialj--;
				while(initiali < finali && initialj > finalj)
				{
					if(board[initiali][initialj] != null)
					{
						return false;
					}
					initiali++;
					initialj--;
				}
			}
			else if(initiali > finali && initialj < finalj)
			{
				initiali--;
				initialj++;
				while(initiali > finali && initialj < finalj)
				{
					if(board[initiali][initialj] != null)
					{
						return false;
					}
					initiali--;
					initialj++;
				}
			}
			else
			{
				status = false;
			}
		}
		
		return status;
	}
	
	public Board move(Board obj)
	{
		obj = new Queen();
		obj.setColor(this.getColor());
		obj.setName(this.getName());
		return obj;
	}
	
	//set methods
	public void setColor(String c)
	{
		color=c;
	}
	
	public void setName(String n)
	{
		name=n;
	}
	
	//get methods
	public String getColor()
	{
		return color;
	}
	public String getName()
	{
		return name;
	}
}