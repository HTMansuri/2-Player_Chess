package chess;

public class Queen extends Board
{
	//class variables
	private String color;
	private String name;
	
	//constructors
	public Queen()
	{
		color="";
		name="Q";
	}
	
	public boolean isValid(Board[][] board, int initiali, int initialj, int finali, int finalj)
	{
		boolean status = false;
		
		Rook r = new Rook();
		Bishop b = new Bishop();
		
		status = r.isValid(board, initiali, initialj, finali, finalj);
		if(!status)
			status = b.isValid(board, initiali, initialj, finali, finalj);
		
		return status;
	}
	
	public Board move(Board obj)
	{
		obj = new Queen();
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