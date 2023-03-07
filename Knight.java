package chess;

public class Knight extends Board
{
	//class variables
	private String color;

	//constructors
	public Knight()
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
		return "N";
	}
}