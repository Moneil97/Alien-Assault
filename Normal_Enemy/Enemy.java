package Normal_Enemy;

import Alien_Intruders.Main;


public class Enemy 
{
	int xCoord = 200;
	int yCoord = 100;
	int xSpeed = 2;
	
	public Enemy (int x, int y)
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
		return 35;
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
	public void shootSlimeBall(int i) 
	{
		Main.SlimeBall[i] = new EnemySlimeBall(xCoord + 10, yCoord);
		Main.SlimeBallExist[i] = true;
	}

}
