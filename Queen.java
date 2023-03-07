package chess;

public class Queen extends Board
{
	//class variables
	private String color;

	//constructors
	public Queen()
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
		return "Q";
	}
}