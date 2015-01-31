package Boss_Final;

public class Bacon_Projectile 
{
	int xCoord = 0;
	int yCoord = 0;
	
	public Bacon_Projectile (int x, int y)
	{
		xCoord = x;
		yCoord = y;
	}
	public int getX() {
		return xCoord;
	}
	public int getY() {
		return yCoord;
	}
	public void changeXby(int x)
	{
		xCoord += x;
	}
	public void changeYby(int y)
	{
		yCoord += y;
	}
	public void setX(int x)
	{
		xCoord = x;
	}
	public void setY(int y)
	{
		yCoord = y;
	}

}
