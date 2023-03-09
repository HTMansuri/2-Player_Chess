package chess;

public class Pawn extends Board
{
	//class variables
	private String color;
	private String name;
	
	//constructors
	public Pawn()
	{
		color="";
		name="p";
	}
	
	public boolean isValid(Board[][] board, int initiali, int initialj, int finali, int finalj)
	{
		//Add Code to check out-of-board - TODO
		if(this.getColor().equals("w")) {
			int iChange = finali-initiali;
			int jChange = finalj-initialj;
			if(iChange==1 || iChange==2) {
				if((iChange==1 && jChange == 0)) {
					if((board[finali][finalj] == null)) {
						return true;
					}
				}
				else if((iChange==2 && jChange == 0) && initiali==1) {
					if((board[initiali+1][initialj] == null) && (board[finali][finalj] == null))
						return true;
				}
				else if((iChange==1 && jChange == 1) || (iChange==1 && jChange == -1)) {
					if((board[finali][finalj] != null) && (board[finali][finalj].getColor()=="b"))
						return true;
				}
			}
			return false;
		}
		else {
			int iChange = finali-initiali;
			int jChange = finalj-initialj;
			if(iChange==-1 || iChange==-2) {
				if((iChange==-1 && jChange == 0)) {
					if((board[finali][finalj] == null)) {
						return true;
					}
				}
				else if((iChange==-2 && jChange == 0) && initiali==6) {
					if((board[initiali-1][initialj] == null) && (board[finali][finalj] == null))
						return true;
				}
				else if((iChange==-1 && jChange == -1) || (iChange==-1 && jChange == 1)) {
					if((board[finali][finalj] != null) && (board[finali][finalj].getColor()=="w"))
						return true;
				}
			}
			return false;
			}
	}
	
	public Board move(Board obj) {
		// TODO Auto-generated method stub
		obj = new Pawn();
		obj.setColor(this.getColor());
		obj.setName(this.getName());
		return obj;
	}
	
	//set methods
	public void setColor(String c)
	{
		color=c;
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