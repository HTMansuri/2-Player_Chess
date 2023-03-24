package chess;

public class Rook extends Board
{
	//class variables
	private String color;
	private String name;
	
	//constructors
	public Rook()
	{
		color="";
		name = "R";
	}
	
	//other methods
	//method to check whether the move is valid or not
	public boolean isValid(Board[][] board, int initiali, int initialj, int finali, int finalj)
	{
		boolean status = false;
		
		if(initiali == finali)	
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
		
		return status;
	}
	
	public Board move(Board obj)
	{
		obj = new Rook();
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
		name = n;
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