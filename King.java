package chess;

public class King extends Board
{
	//class variables
	private String color;
	private String name;
	
	//constructors
	public King()
	{
		color="";
		name="K";
	}
	
	public boolean isValid(Board[][] board, int initiali, int initialj, int finali, int finalj)
	{
		//TODO
		return true;
	}
	
	public Board move(Board obj)
	{
		obj = new King();
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