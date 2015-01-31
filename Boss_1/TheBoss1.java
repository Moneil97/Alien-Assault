package Boss_1;

import Alien_Intruders.Main;


public class TheBoss1 {
	int xCoord = 200;
	int yCoord = 100;
	int xSpeed = 2;
	
	public TheBoss1 (int x, int y)
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
	
	public void shootFireBall() 
	{	
		for (int f = 0; f <= 2; f++ ) //Instantiate 3 Fire Balls
		{
			Main.FireBall[f] = new BossFireBall(xCoord + 10, yCoord);
		}
			Main.fireBallsExist = true;
		
	}

}
