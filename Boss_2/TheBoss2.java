package Boss_2;

import Alien_Intruders.Main;


public class TheBoss2 {
	int xCoord = 200;
	int yCoord = 100;
	int xSpeed = 2;
	
	public TheBoss2 (int x, int y)
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
	public int getSize()
	{
		return 75;
	}
	public void setX(int x)
	{
		xCoord = x;
	}
	public void setY(int y)
	{
		yCoord = y;
	}
	public void changeXby(int x)
	{
		xCoord += x;
	}
	public void changeYby(int y)
	{
		yCoord += y;
	}
	public void inverseX()
	{
		xSpeed *= -1;
	}
	public void incrementX()
	{
		xCoord += xSpeed;
	}
	
	public void fireSuperLaser() 
	{	
			Main.SuperLaser = new TheSuperLaser(xCoord + 10, yCoord);
			
			//Add grace period and move this to main:
			Main.SuperLaserExists = true;
	}

}
