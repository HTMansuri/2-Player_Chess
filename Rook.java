package chess;

public class Rook extends Board
{
	//class variables
	private String color;

	//constructors
	public Rook()
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
		return "R";
	}
}
