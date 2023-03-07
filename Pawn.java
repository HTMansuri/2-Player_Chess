package chess;

public class Pawn extends Board
{
	//class variables
	private String color;

	//constructors
	public Pawn()
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
		return "p";
	}
}