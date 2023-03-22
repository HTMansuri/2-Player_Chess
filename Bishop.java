package chess;

public class Bishop extends Board
{
	//class variables
	private String color;
	private String name;
	
	//constructors
	public Bishop()
	{
		color="";
		name="B";
	}
	
	public boolean isValid(Board[][] board, int initiali, int initialj, int finali, int finalj)
	{
		boolean status = false;
		
		if(Math.abs(initiali-finali) == Math.abs(initialj-finalj))
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
		obj = new Bishop();
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