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
		//TODO
		return true;
	}
	
	public Board move(Board obj) 
	{
		// TODO Auto-generated method stub
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