package chess;

public class Bishop extends Board
{
	//class variables
	private String color;

	//constructors
	public Bishop()
	{
		color="";
	}

	//set methods
	public void setColor(String c)
	{
		color=c;
	}

	//get methods
	public String getColor()
	{
		return color;
	}
	public String getName()
	{
		return "B";
	}
}