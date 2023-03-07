package chess;

public class King extends Board
{
	//class variables
	private String color;

	//constructors
	public King()
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
		return "K";
	}
}