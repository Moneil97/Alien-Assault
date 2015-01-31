package Boss_Final;

import Alien_Intruders.Main;

public class SlothBoss 
{
	int xCoord = 200;
	int yCoord = 100;
	int xSpeed = 2;
	int size = 75;
	
	public SlothBoss (int x, int y, int s)
	{
		xCoord = x;
		yCoord = y;
		size = s;
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
	public void firePenguinLeft() 
	{
		Main.leftSlothFire = new penguin_Projectiles(xCoord + 30, yCoord+60);
	}
	public void firePenguinright() 
	{
		Main.rightSlothFire = new penguin_Projectiles(xCoord + 30, yCoord+60);
	}
}
