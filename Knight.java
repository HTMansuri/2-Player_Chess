package chess;

public class Knight extends Board
{
	//class variables
	private String color;
	private String name;
	
	//constructors
	public Knight()
	{
		color="";
	}
	
	public boolean isValid(Board[][] board, int initiali, int initialj, int finali, int finalj)
	{
		//TODO
		int iChange=finali-initiali;
		int jChange=finalj-initialj;
		if((Math.abs(iChange)==1 && Math.abs(jChange)==2) || (Math.abs(jChange)==1 && Math.abs(iChange)==2))
			return true;
		return false;
	}
	
	public Board move(Board obj)
	{
		obj = new Knight();
		obj.setColor(this.getColor());
		obj.setName(this.getName());
		return obj;
	}
	
	//set methods
	public void setColor(String c)
	{
		color=c;
		name="N";
	}
	public void setName (String n)
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