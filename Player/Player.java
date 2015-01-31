package Player;

import Alien_Intruders.Main;


public class Player
{
	int xCoord = 300;
	int yCoord = 550-60;
	
	double velX = 0;
	
	public Player()
	{
	}
	
	public void tick()
	{
//		xCoord += velX;
		
		if (velX < 0)
		{
			if (getX() > 0)
			{
				xCoord += velX;
			}
		}
		
		if (velX > 0)
		{
			if (!(getX() > Main.frameWidth -60))
			{
				xCoord += velX;
			}
		}
		
		
		
		if (Main.spaceBarHeld == true && Main.playerCeaseFire==false)
		{
			if (Main.laserExist == false)
			{
				fireLaser();
//				if (Main.sounds)
//				{
//					Play x = new Play(Play.class.getResourceAsStream("Sounds/PlayerLaser.wav"));
//				}
			}
		}
	}
	
	public int getSize()
	{
		return 50;
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
	
	public void setVelX (double velX)
	{
		this.velX = velX;
	}

	public void fireLaser()
	{
		Main.shotsFired++;
		Main.laser = new Laser(xCoord + 19, yCoord);
		Main.laserExist = true;
	}

}
