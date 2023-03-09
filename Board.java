package chess;

public abstract class Board
{
	//constructors
	public Board()
	{
		
	}
	
	public abstract Board move(Board obj);
	public abstract boolean isValid(Board[][] board, int initiali, int initialj, int finali, int finalj);
	
	//abstract sets
	public abstract void setColor(String c);
	public abstract void setName (String n);	
	
	//abstract gets
	public abstract String getColor();
	public abstract String getName();
}