package chess;

public class King extends Board
{
	//class variables
	private String color;
	private String name;
	
	//constructors
	public King()
	{
		color="";
		name="K";
	}
	
	public boolean isValid(Board[][] board, int initiali, int initialj, int finali, int finalj)
	{
<<<<<<< HEAD
=======
		//TODO
>>>>>>> 10dfd4bcfd1a96646e8390adfd2607eb4587bffe
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