package Boss_Final;

import Alien_Intruders.Main;

public class PigBoss 
{
	int xCoord = 200;
	int yCoord = 100;
	int xSpeed = 2;
	int ySpeed = 2;
	int size = 75;
	
	public PigBoss (int x, int y, int s, int m)
	{
		xCoord = x;
		yCoord = y;
		size = s;
		ySpeed *= m;
	}
	public int getX() {
		return xCoord;
	}
	public int getY() {
		return yCoord;
	}
	public int getSize()
	{
		return size;
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
	public void incrementY() 
	{
		yCoord += ySpeed;
	}
	public void inverseY() 
	{
		ySpeed *= -1;
	}
	public void fireBacon(int i) 
	{
		Main.baconFire[i] = new Bacon_Projectile(xCoord + 30, yCoord+60);
	}
}
