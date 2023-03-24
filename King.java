package chess;

public class King extends Board
{
	//class variables
	private String color;
	private String name;
	
	//for castling
	public static boolean wlcast=true;
	public static boolean wrcast=true;
	public static boolean blcast=true;
	public static boolean brcast=true;
	
	//constructors
	public King()
	{
		color="";
		name="K";
	}
	
	public boolean isValid(Board[][] board, int initiali, int initialj, int finali, int finalj)
	{
		//checks if there are any pieces between Rook and King before castling
		if(((this.getColor().equals("w") && (wrcast || wlcast)) || (this.getColor().equals("b") && (blcast || brcast))) && Math.abs(initiali-finali) == 0 && Math.abs(initialj-finalj) == 2)
		{
			boolean status = false;
			if(finalj==2 && ((wlcast && finali==0) || (blcast && finali==7)))
			{
				status = true;
				int i=0;
				if(finali==7)
					i=7;
				for(int j=1; j<4; j++)
				{
					if(board[i][j] != null)
						return false;
				}
			}
			else if(finalj==6 && ((wrcast && finali==0) || (brcast && finali==7)))
			{
				status = true;
				int i=0;
				if(finali==7)
					i=7;
				for(int j=5; j<7; j++)
				{
					if(board[i][j] != null)
						return false;
				}
			}
			return status;
		}
		
		
		
		
		
		int iChange = finali-initiali;
		int jChange = finalj-initialj;
		if(iChange*jChange==0 && Math.abs(iChange+jChange)==1) {
				return true;
		}
		else if(Math.abs(iChange)+Math.abs(jChange)==2 && iChange*jChange!=0){
			return true;
		}
		return false;
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