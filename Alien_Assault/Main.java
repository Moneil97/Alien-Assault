package Alien_Intruders;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Boss_1.BossFireBall;
import Boss_1.TheBoss1;
import Boss_2.TheBoss2;
import Boss_2.TheSuperLaser;
import Boss_Final.Bacon_Projectile;
import Boss_Final.PigBoss;
import Boss_Final.RHCP_Projectile;
import Boss_Final.SamBoss;
import Boss_Final.SlothBoss;
import Boss_Final.penguin_Projectiles;
import Normal_Enemy.Enemy;
import Normal_Enemy.EnemySlimeBall;
import Player.Laser;
import Player.Player;

@SuppressWarnings({ "serial" })
public class Main extends JFrame implements Runnable, ActionListener, KeyListener//, EventListener
{
	//Declarations
	public static int frameWidth = 600;
	static int frameHeight = 550;
	Dimension d;
	static int sleepCounter = 15;
	Image Background = new ImageIcon(this.getClass().getResource("/Images/BackGround.png")).getImage();
	Font calibri20 = new Font("Calibri", Font.BOLD, 20);
	int level = 1;
	Image dbi;
    Graphics dbg;
    boolean play = true;
    
		//You
		Image LaserPic = new ImageIcon(this.getClass().getResource("/Images/You/Laser.png")).getImage();
		Image redScreen = new ImageIcon(this.getClass().getResource("/Images/You/Red_Screen.png")).getImage();
		Image playerPics[] = {new ImageIcon(this.getClass().getResource("/Images/You/Player.png")).getImage(),
							  new ImageIcon(this.getClass().getResource("/Images/You/PlayerFlame1.5.png")).getImage(),
							  new ImageIcon(this.getClass().getResource("/Images/You/PlayerFrame2.png")).getImage(),
							  new ImageIcon(this.getClass().getResource("/Images/You/PlayerFlame2.5.png")).getImage(),
							  new ImageIcon(this.getClass().getResource("/Images/You/PlayerFrame3.png")).getImage(),
							  new ImageIcon(this.getClass().getResource("/Images/You/PlayerHit.png")).getImage()};
		int playerPicsSub = 0;
		int playerHitTimePassed = 0;
		int playerArrayTimePassed = 0;
		Player you;
		public static Laser laser;
		public static boolean laserExist = false;
		int lives = 3;
		int shipSpeed = 5;
		public static double shotsFired = 0;
		double hitCount = 0;
		int accuracy = 0;
		public static boolean spaceBarHeld = false;
		public static boolean playerCeaseFire = false;
		boolean laserSight = false;
	
		//Enemies
		Image SlimeBallPic = new ImageIcon(this.getClass().getResource("/Images/Normal Enemies/SlimeBall.png")).getImage();
		int EnemyPicsSub = 0;
		int EnemyPicsNum[];
		Image EnemyPics[] = {new ImageIcon(this.getClass().getResource("/Images/Normal Enemies/SlimeGrunt.png")).getImage(),
							 new ImageIcon(this.getClass().getResource("/Images/Normal Enemies/GruntDeath1.png")).getImage(),
							 new ImageIcon(this.getClass().getResource("/Images/Normal Enemies/GruntDeath2.png")).getImage()};
		Enemy enemys[];
		boolean enemyExists[];
		boolean enemyHit[];
		public static EnemySlimeBall SlimeBall[];
		public static boolean SlimeBallExist[];
		int enemiesLeft = 0;
		int ships = 48;
		int shipNum[] = {24, 36, 0, 48, 60, 0, 72, 84, 0};
		boolean enemiesRemain = true;
		int enemyHitTimePassed[];
		int MAXTIMEPASSED = 2;
	
		//Boss 1
		
		Image boss1Pics[] = {new ImageIcon(this.getClass().getResource("/Images/Boss 1/Boss2.png")).getImage(),
							 new ImageIcon(this.getClass().getResource("/Images/Boss 1/BossFiring.png")).getImage()};
		int boss1PicsSub = 0;
		TheBoss1 boss1;
		boolean boss1Exists = false;
		boolean boss1Summoned = false;
		int boss1Lives = 10;
		Image FireBallPic = new ImageIcon(this.getClass().getResource("/Images/Boss 1/FireBall.png")).getImage();
		public static BossFireBall FireBall[];
		public static boolean fireBallsExist = false;
		int boss1ArrayTimePassed = 0;
		boolean boss1EntranceAnimationDone = false;
		boolean boss1CeaseFire = true;
		Image bossHealthBarPics[] = {new ImageIcon(this.getClass().getResource("/Images/Health Bar/health100.png")).getImage(),
									 new ImageIcon(this.getClass().getResource("/Images/Health Bar/health90.png")).getImage(),
									 new ImageIcon(this.getClass().getResource("/Images/Health Bar/health80.png")).getImage(),
									 new ImageIcon(this.getClass().getResource("/Images/Health Bar/health70.png")).getImage(),
									 new ImageIcon(this.getClass().getResource("/Images/Health Bar/health60.png")).getImage(),
									 new ImageIcon(this.getClass().getResource("/Images/Health Bar/health50.png")).getImage(),
									 new ImageIcon(this.getClass().getResource("/Images/Health Bar/health40.png")).getImage(),
									 new ImageIcon(this.getClass().getResource("/Images/Health Bar/health30.png")).getImage(),
									 new ImageIcon(this.getClass().getResource("/Images/Health Bar/health20.png")).getImage(),
									 new ImageIcon(this.getClass().getResource("/Images/Health Bar/health10.png")).getImage(),
									 new ImageIcon(this.getClass().getResource("/Images/Health Bar/health0.png")).getImage()};
		//Boss 2
		Image boss2Pics[] = {new ImageIcon(this.getClass().getResource("/Images/Bear Boss/BearBossBase.png")).getImage(),
							 new ImageIcon(this.getClass().getResource("/Images/Bear Boss/BearBossPreparin.png")).getImage(),
							 new ImageIcon(this.getClass().getResource("/Images/Bear Boss/BearBossFirin.png")).getImage()};
		int boss2PicsSub = 0;
		TheBoss2 boss2;
		boolean boss2Exists = false;
		boolean boss2Summoned = false;
		int boss2Lives = 10;
		boolean win = false;
		public static boolean SuperLaserExists = false;
		public static TheSuperLaser SuperLaser;
		int boss2ArrayTimePassed = 0;
		Image SuperLaserPics[] = {new ImageIcon(this.getClass().getResource("/Images/Bear Boss/BearLaser1.png")).getImage(),
								  new ImageIcon(this.getClass().getResource("/Images/Bear Boss/BearLaser2.png")).getImage()};
		int SuperLaserPicsSub = 0;
		int SuperLaserArrayTimePassed = 0;
		int startingCountdown = 90;
		int quitCountdown = 130;
		int CNTDWN = 130;
		int STARTINGCNTDWN = 90;
		boolean boss2EntranceAnimationDone = false;
		boolean boss2CeaseFire = true;
		
	//Stats
	int levelAccuracy[] = {0,0,0,0,0,0,0,0,0};
	int levelLivesLost[] = {0,0,0,0,0,0,0,0,0};
	int levels = 9;
	boolean levelSkipped[];
	
	int showLevelTimer = 0;
	int LEVELTIMERMAX = 150;
	boolean DisplayLevel = false;
	boolean showLevelTimerDone = false;
	boolean Undecorated = true;
		
		//Final Boss
		boolean resized = false;	
		SamBoss sam;
		SlothBoss leftSloth;
		SlothBoss rightSloth;
		PigBoss pigs[];
		boolean FinalBossesSummoned = false;
		int leftSlothLives = 10;
		int samLives = 30;
		int rightSlothLives = 10;
		static int numberOfPigs = 8;
		int[] pigBossLives = new int[numberOfPigs];
		public static RHCP_Projectile samFire = null;
		public static penguin_Projectiles leftSlothFire = null;
		public static penguin_Projectiles rightSlothFire = null;
		boolean finalBossesCeaseFire = true;
		public static Bacon_Projectile baconFire[] = new Bacon_Projectile[numberOfPigs];
		
			//Pictures
			Image samPic = new ImageIcon(this.getClass().getResource("/Images/Final Bosses/Sam Boss/sam.png")).getImage();

			Image RHCP_Pic = new ImageIcon(this.getClass().getResource("/Images/Final Bosses/Sam Boss/RHCP.png")).getImage();	
			Image RHCP_Pics[] = {new ImageIcon(this.getClass().getResource("/Images/Final Bosses/Sam Boss/RHCP.png")).getImage()
//									,new ImageIcon(this.getClass().getResource("/Images/Final Bosses/Sam Boss/RHCP15.png")).getImage(),
//									 new ImageIcon(this.getClass().getResource("/Images/Final Bosses/Sam Boss/RHCP30.png")).getImage(),
									 };
				
			Image pigPic = new ImageIcon(this.getClass().getResource("/Images/Final Bosses/Pig Bosses/minecraft-pig.png")).getImage();
				Image baconPic = new ImageIcon(this.getClass().getResource("/Images/Final Bosses/Pig Bosses/bacon.png")).getImage();
			Image slothPic = new ImageIcon(this.getClass().getResource("/Images/Final Bosses/Sloth Bosses/Sloth.png")).getImage();
				Image penguinPic = new ImageIcon(this.getClass().getResource("/Images/Final Bosses/Sloth Bosses/Penguin1.png")).getImage();
			

	public Main ()
	{
		//Objects
		you = new Player();
		ships = shipNum[level-1]; //0

		//Set up all Arrays
		populateArrays();
		levelSkipped = new boolean[levels];

		//JFrame Edits
		setTitle("Alien Assualt");
		setSize(frameWidth, frameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		//Place JFrame on top of Control Panel
		Toolkit tk = Toolkit.getDefaultToolkit();
		d = tk.getScreenSize();
		setLocation((d.width - frameWidth)/2, (d.height - frameHeight)/2);  	//Center JFrame
		
		getContentPane();
		addKeyListener(this);
		
		setUndecorated(true);
		
		//Declare new thread
		Thread t = new Thread(this);
		t.start();
	}

	@SuppressWarnings("static-access")
	@Override
	public void run()
	{
		while (true) //true
		{ 
			if(play)
			{
				you.tick(); //Move the player (Smoothly)
				changePlayerPic();
	
				if (lives <= 0)
				{
					int MessageType = JOptionPane.ERROR_MESSAGE;
					Component parentComponent = null;
					String message = "            You Lose \nYou Made it to Level: " + level;
					JOptionPane.showMessageDialog(parentComponent, message, "Suck it!", MessageType);
					System.exit(0);
				}
				
				if ((!(level == 3)) && (!(level == 6)) && (!(level == 9)))
				{
					normalLevel();
				}
				else if (level == 3)
				{
					boss1Level();
				}
				else if (level == 6)
				{
					boss2Level();
				}
				else if (level == 9)
				{
					finalBossLevel();
				}
	
				repaint();	
			}
			try
			{
				//thread sleep
				Thread.currentThread().sleep(sleepCounter);
			}
			catch (Exception e)
			{
			}
		}
	}
	
	int finalBossCooldown = 200;
	
	private void finalBossLevel() 
		{
			if (levelSkipped[level-1] == true)
			{
				killAll();
				nextLevel();
				
				try
				{
					samRunAway2();
				}
				catch(NullPointerException e){}
				
				youWinMessage();
			}
			else
			{
				if (resized == false)
				{
					playerCeaseFire = true;
					Background = new ImageIcon(this.getClass().getResource("/Images/BackGroundExtended.png")).getImage();

					resizeWindowForBoss();
//					resizeWindowForBossInstant();
				}
				
				if (showLevelTimerDone == false && levelSkipped[level-1] == false)
				{
					displayLevelLarge();
				}
				else if (FinalBossesSummoned == false) //Summon boss and do not run again.
				{
					summonFinalBosses();
					FinalBossesSummoned = true;	
				}
				else if (finalBossCooldown > 0)
				{
					finalBossCooldown--;
					countdown(200, finalBossCooldown);
				}
				else if (finalBossesCeaseFire == true)
				{
					displayCountdown = -5;
					finalBossesCeaseFire = false;
					playerCeaseFire = false;
				}
				else
				{
					moveFinalBosses();

					if (laserExist == true)
					{
						laser.changeYby(-12);
						
						if (laser.getY() < 0)
						{
							laserExist = false;
							accuracy = CalcAccuracy(); //Update Accuracy
						}
						checkIfLaserHitsFinalBosses();
					}
					
					FinalBossesCheckLives();
					FinalBossesFireWeapons();
					FinalBossesMoveProjectiles();
					FinalBossesCheckIfHitPlayer();
				}
			}
		}

	int displayCountdown = -5;
	
	private void countdown(int original ,int countdown) 
	{
		if (countdown > original*4/5)
		{
			displayCountdown = 4;
		}
		else if (countdown > original*3/5)
		{
			displayCountdown = 3;
		}
		else if (countdown > original*2/5)
		{
			displayCountdown = 2;
		}
		else if (countdown > original/4)
		{
			displayCountdown = 1;
		}
		else
		{
			displayCountdown = 0;
		}
		
	}

	private void summonFinalBosses() 
		{
			clearEnemyFire();
			
			sam = new SamBoss(260,100,90);
			leftSloth = new SlothBoss(80, 210, 70);
			rightSloth = new SlothBoss(450, 210, 70);
	
			pigs = new PigBoss[numberOfPigs];
			for (int i=0; i<numberOfPigs; i++)
			{
	//			pigs[i] = new PigBoss(i==0 ? 0: (i*50), 300, 50); // You can multiply by Zero, stupid!
				pigs[i] = new PigBoss(i*75 +2, 325, 70, i % 2 == 0 ? 1:-1);
				
				pigBossLives[i] = 10;
			}
		}

	private void checkIfLaserHitsFinalBosses() 
	{
		try
		{
			if (laser.getX()+2 >= sam.getX()) //On right side
			{
				if ((laser.getX()+2) <= (sam.getX()+sam.getSize())) //On left
				{
					if (laser.getY() >= sam.getY()) //If below
					{
						if (laser.getY() <= sam.getY() + sam.getSize()) //If above
						{
							laserExist = false;
							samLives--;
							hitCount++;
							accuracy = CalcAccuracy(); //Update Accuracy
						}
					}
				}
			}
		}catch(NullPointerException e){}
		
		try
		{
			if (laser.getX()+2 >= leftSloth.getX()) //On right side
			{
				if ((laser.getX()+2) <= (leftSloth.getX()+leftSloth.getSize())) //On left
				{
					if (laser.getY() >= leftSloth.getY()) //If below
					{
						if (laser.getY() <= leftSloth.getY() + leftSloth.getSize()) //If above
						{
							laserExist = false;
							leftSlothLives--;
							hitCount++;
							accuracy = CalcAccuracy(); //Update Accuracy
						}
					}
				}
			}
		}catch(NullPointerException e){}
		
		try
		{
			if (laser.getX()+2 >= rightSloth.getX()) //On right side
			{
				if ((laser.getX()+2) <= (rightSloth.getX()+rightSloth.getSize())) //On left
				{
					if (laser.getY() >= rightSloth.getY()) //If below
					{
						if (laser.getY() <= rightSloth.getY() + rightSloth.getSize()) //If above
						{
							laserExist = false;
							rightSlothLives--;
							hitCount++;
							accuracy = CalcAccuracy(); //Update Accuracy
						}
					}
				}
			}
		}catch(NullPointerException e){}
		
		
		for (int i=0; i<numberOfPigs; i++)
		{
			try
			{
				if (laser.getX()+2 >= pigs[i].getX()) //On right side
				{
					if ((laser.getX()+2) <= (pigs[i].getX()+pigs[i].getSize())) //On left
					{
						if (laser.getY() >= pigs[i].getY()) //If below
						{
							if (laser.getY() <= pigs[i].getY() + pigs[i].getSize()) //If above
							{
								laserExist = false;
								pigBossLives[i]--;
								hitCount++;
								accuracy = CalcAccuracy(); //Update Accuracy
							}
						}
					}
				}
			}catch(NullPointerException e){}
		}
	}

	private void moveFinalBosses() 
	{
		try //If Sam exists
		{
			sam.incrementX();
			
			if (sam.getX() > (frameWidth -90) || sam.getX() < 0)
			{
				sam.inverseX();
			}
			else if (percentChance(.5) == true) //.5% chance to switch ways
			{
				sam.inverseX();
			}
			
		}catch(NullPointerException e){}
		
		try
		{
			leftSloth.incrementX();
			
			if (leftSloth.getX() > 230 || leftSloth.getX() < 0)
			{
				leftSloth.inverseX();
			}
			else if (percentChance(.3) == true) //.3% chance to switch ways
			{
				leftSloth.inverseX();
			}
			
		}catch(NullPointerException e){}
		
		try
		{
			rightSloth.incrementX();
			
			
			
			if (rightSloth.getX() > (frameWidth -70) || rightSloth.getX() < 300)
			{
				rightSloth.inverseX();
			}
			else if (percentChance(.3) == true) //.3% chance to switch ways
			{
				rightSloth.inverseX();
			}
			
		}catch(NullPointerException e){}
		
		for (int i=0; i<numberOfPigs; i++)
		{
			try
			{
				pigs[i].incrementY();  //375 max //275 min
				
				if (pigs[i].getY() >= 375 || pigs[i].getY() <= 275)
				{
					pigs[i].inverseY();
				}	
			}catch(NullPointerException e){}
		}
	}

	private void FinalBossesCheckLives() 
	{
		if (samLives <= 0)
		{	
			samRunAway2();
			
			nextLevel();
			youWinMessage();
		}
		if (leftSlothLives <= 0)
		{
			leftSloth = null;
		}
		if (rightSlothLives <= 0)
		{
			rightSloth = null;
		}
		for (int i=0; i<numberOfPigs; i++)
		{
			try
			{
				if (pigBossLives[i] <= 0)
				{
					pigs[i] = null;
				}
			}
			catch(NullPointerException e){}
		}
	}

	@SuppressWarnings("null")
	private void FinalBossesFireWeapons() 
	{
		try //Throw Exception if RHCP shot does not already exist
		{
			if((samFire == null))
			{ 	
				Exception NullPointerException = null;
				throw NullPointerException;
			}
		}
		catch (Exception e)
		{
			if (finalBossesCeaseFire ==false) //If one isn't active
			{
				sam.fireRHCP();
			}
		}
		
		for(int i=0; i<numberOfPigs; i++)
		{
			try //Throw Exception if bacon shot does not already exist
			{
				if((baconFire[i] == null))
				{ 	
					Exception NullPointerException = null;
					throw NullPointerException;
				}
			}
			catch (Exception e)
			{
				if (finalBossesCeaseFire == false && percentChance(.5)) //If one isn't active
				{
					try //Will throw exception if pig[i] does not exist
					{
						pigs[i].fireBacon(i);
					}
					catch(NullPointerException a){}
				}
			}
		}
		
		try //Throw Exception if Left Penguin shot does not already exist
		{
			if((leftSlothFire == null))
			{ 	
				Exception NullPointerException = null;
				throw NullPointerException;
			}
		}
		catch (Exception e)
		{
			try
			{
				if (finalBossesCeaseFire ==false) //If one isn't active
				{
					leftSloth.firePenguinLeft();
				}
			}
			catch(NullPointerException a){}
			
		}
		
		try //Throw Exception if right Penguin shot does not already exist
		{
			if((rightSlothFire == null))
			{ 	
				Exception NullPointerException = null;
				throw NullPointerException;
			}
		}
		catch (Exception e)
		{
			try
			{
				if (finalBossesCeaseFire ==false) //If one isn't active
				{
					rightSloth.firePenguinright();
				}
			}
			catch(NullPointerException a){}
			
		}
	}

	private void FinalBossesMoveProjectiles() 
	{
		try
		{
			samFire.changeYby(8);
			
			if (samFire.getY() > frameHeight)
			{
				samFire = null;
			}
		}
		catch(NullPointerException e){}
		
		for(int i=0; i<numberOfPigs; i++)
		{
			try
			{
				baconFire[i].changeYby(8);
				
				if (baconFire[i].getY() > frameHeight)
				{
					baconFire[i] = null;
				}
			}
			catch(NullPointerException e){}
		}
		
		try
		{
			leftSlothFire.changeYby(8);
			
			if (leftSlothFire.getY() > frameHeight)
			{
				leftSlothFire = null;
			}
		}
		catch(NullPointerException e){}
		
		try
		{
			rightSlothFire.changeYby(8);
			
			if (rightSlothFire.getY() > frameHeight)
			{
				rightSlothFire = null;
			}
		}
		catch(NullPointerException e){}
	}

	private void FinalBossesCheckIfHitPlayer() 
	{
		try
		{
			if ((samFire.getX()) <= (you.getX()+you.getSize())) //On left
			{
				if (samFire.getX()+28 >= you.getX()) //On right side
				{
					if (samFire.getY() >= you.getY()) //If below
					{
						if (samFire.getY() <= you.getY() + you.getSize()) //If above
						{
							loseALife();
							samFire = null;
						}
					}
				}
			}
		}
		catch(NullPointerException e){}
		
		for(int i=0; i<numberOfPigs; i++)
		{
			try
			{
				if (baconFire[i].getX()+2 >= you.getX()) //On right side
				{
					if ((baconFire[i].getX()+2) <= (you.getX()+you.getSize())) //On left
					{
						if (baconFire[i].getY() >= you.getY()) //If below
						{
							if (baconFire[i].getY() <= you.getY() + you.getSize()) //If above
							{
								loseALife();
								baconFire[i] = null;
							}
						}
					}
				}
			}catch(NullPointerException e){}
		}
		
		try
		{
			if (leftSlothFire.getX()+2 >= you.getX()) //On right side
			{
				if ((leftSlothFire.getX()+2) <= (you.getX()+you.getSize())) //On left
				{
					if (leftSlothFire.getY() >= you.getY()) //If below
					{
						if (leftSlothFire.getY() <= you.getY() + you.getSize()) //If above
						{
							loseALife();
							leftSlothFire = null;
						}
					}
				}
			}
		}catch(NullPointerException e){}
		
		try
		{
			if (rightSlothFire.getX()+2 >= you.getX()) //On right side
			{
				if ((rightSlothFire.getX()+2) <= (you.getX()+you.getSize())) //On left
				{
					if (rightSlothFire.getY() >= you.getY()) //If below
					{
						if (rightSlothFire.getY() <= you.getY() + you.getSize()) //If above
						{
							loseALife();
							rightSlothFire = null;
						}
					}
				}
			}
		}catch(NullPointerException e){}
	}

	int boss2Cooldown = 200;
	
	private void boss2Level() 
		{
			if (levelSkipped[level-1] == true)
			{
				killAll();
				nextLevel();
			}
			else
			{
				if (showLevelTimerDone == false && levelSkipped[level-1] == false)
				{
					displayLevelLarge();
				}
				else if (boss2Summoned == false) //Summon boss and do not run again.
				{
					summonBoss2();
				}
				else if (boss2EntranceAnimationDone == false)
				{
					playerCeaseFire = true;
					clearPlayerFire();
					boss2EntranceAnimation();
				}
				else if (boss2Cooldown > 0)
				{
					boss2Cooldown--;
					countdown(200, boss2Cooldown);
				}
				else
				{
					playerCeaseFire = false;
					displayCountdown = -5;
				
					if (startingCountdown > 0 && SuperLaserExists == false)
					{
						startingCountdown--;
					}
					
					if (quitCountdown > 0 && SuperLaserExists == true)
					{
						quitCountdown--;
					}
					
					moveBoss2AndFireLaser();
					
					if (laserExist == true)
					{
						laser.changeYby(-12);
						
						if (laser.getY() < 0)
						{
							laserExist = false;
							accuracy = CalcAccuracy(); //Update Accuracy
						}
						checkIfLaserHitsBoss2();
					}
					
					if (boss2Lives <= 0)
					{
						boss2Exists = false;	//Kill the boss
						boss2 = null;
	//					SuperLaserSound.stop();
	//					SuperLaserSound = null;
						SuperLaserExists = false;
						nextLevel();
	//					youWinMessage();
					}
	
					if (SuperLaserExists == true)
					{
						animateSuperLaser();
						checkIfSuperLaserHitsPlayer();
						
						if (quitCountdown < 1)
						{
	//						SuperLaserSound.stop();
	//						SuperLaserSound = null;
							SuperLaserExists = false;
							boss2PicsSub = 0;
							quitCountdown = (CNTDWN);
						}
					}
				}
			}
		}

	private void moveBoss1AndShootFireBall() 
	{
		if (boss1Exists == true)
		{
			boss1.incrementX();
			
			if (boss1.getX() > (frameWidth -50) || boss1.getX() < 0)
			{
				boss1.inverseX();
			}
			else if (percentChance(.5) == true) //.5% chance to switch ways
			{
				boss1.inverseX();
			}
			
			if (fireBallsExist == false && boss1CeaseFire == false) //If one isn't active
			{
				//Change picture
				boss1PicsSub = 1;
			}
			
			if (boss1PicsSub == 1) //cease fire stuff
			{
				boss1ArrayTimePassed++;
				if (boss1ArrayTimePassed > 10)
				{
					boss1.shootFireBall(); //Will wait till after picture updates to fire
					boss1PicsSub = 0;
					boss1ArrayTimePassed = 0;
				}
			}
		}
	}
	


	private void checkIfFireBallHitsPlayer(int i) 
	{
		//If FireBall hits Player
		if (FireBall[i].getX()+2 >= you.getX()) //On right side
		{
			if ((FireBall[i].getX()+2) <= (you.getX()+you.getSize())) //On left
			{
				if (FireBall[i].getY() >= you.getY()) //If below
				{
					if (FireBall[i].getY() <= you.getY() + you.getSize()) //If above
					{
						loseALife();
						fireBallsExist = false;
					}
				}
			}
		}
	}

	private void moveFireBalls(int i) 
	{
		FireBall[i].changeYby(8);
		
		if (i==2) //Make Fire Ball 3 Go Right
		{
			FireBall[i].changeXby(4);
		}
		if (i==0) //Make Fire Ball 1 Go Left
		{
			FireBall[i].changeXby(-4);
		}
		
		if (FireBall[i].getY() > frameHeight)
		{
			fireBallsExist = false;
		}
	}

	@SuppressWarnings({ "static-access", "unused" })
	private void samRunAway() 
	{
		int x = 0;
		int xLocation = (d.width - frameWidth)/2-(4*x);
		sam.makeXSpeedNegative();
		
//		for(int i=0;i<700;i++)
		while (xLocation > -frameWidth)
		{
			if (sam.getX() > 0)
			{
				sam.incrementX();
			}
			else
			{
				xLocation = (d.width - frameWidth)/2-(4*x);
				setLocation(xLocation, (d.height - frameHeight)/2); //Move JFrame Left
				x++;
			}
			
			try {
				Thread.currentThread().sleep(2);
			} catch (InterruptedException e) {}
		}
	}
	
	@SuppressWarnings("static-access")
	private void samRunAway2()
	{
		int y = 0;
		int yLocation = (d.height - frameHeight)/2-(4*y);
		sam.makeYSpeedPositve();
		
//		for(int i=0;i<700;i++)
		while (yLocation < (d.height + frameHeight))
		{
			if (sam.getY() < frameHeight-80)
			{
				sam.incrementY();
			}
			else
			{
				yLocation = (d.height - frameHeight)/2 +(4*y);
				setLocation((d.width - frameWidth)/2, yLocation); //Move JFrame Down
				y++;
			}
			
			try {
				Thread.currentThread().sleep(3);
			} catch (InterruptedException e) {}
		}
	}

	private void checkIfLaserHitsBoss1() 
	{
		if (laser.getX()+2 >= boss1.getX()) //On right side
		{
			if ((laser.getX()+2) <= (boss1.getX()+boss1.getSize())) //On left
			{
				if (laser.getY() >= boss1.getY()) //If below
				{
					if (laser.getY() <= boss1.getY() + boss1.getSize()) //If above
					{
						laserExist = false;
						boss1Lives--;
						hitCount++;
						accuracy = CalcAccuracy(); //Update Accuracy
					}
				}
			}
		}
		
		
	}

	@SuppressWarnings({ "static-access" })
	private void resizeWindowForBoss() 
	{
		playerPicsSub = 1;
		repaint();
		
		for (int i=0;i<200;i++)
		{
			frameHeight++;
			you.setY(you.getY() +1);
			you.tick();
			setSize(frameWidth, frameHeight);
			setLocation((d.width - frameWidth)/2, (d.height - frameHeight)/2);  	//Center JFrame
			
			try 
			{
				Thread.currentThread().sleep(15);
			} 
			catch (InterruptedException e) 
			{
			}
		}
		resized = true;
	}
	
//	private void resizeWindowForBossInstant() 
//	{
//		Background = new ImageIcon(this.getClass().getResource("/Images/BackGroundExtended.png")).getImage();
//		frameHeight += 200;
//		you.setY(you.getY() +200);
//		setSize(frameWidth, frameHeight);
//		setLocation((d.width - frameWidth)/2, (d.height - frameHeight)/2);  	//Center JFrame
//		resized = true;
//	}
	

	private void summonBoss1()
	{
		clearEnemyFire();
		//Summon Boss 1
		boss1 = new TheBoss1(300, -20);
		boss1Summoned = true;
		boss1Exists = true;
	}

	private void normalLevel() 
	{
		if (showLevelTimerDone == false && levelSkipped[level-1] == false)
		{
			displayLevelLarge();
		}
		else
		{
			for (int i = 0; i <= ships-1; i++) //Move Enemies
	        {
				if (enemyExists[i] == true)
				{
					enemys[i].incrementX();
					//Randomize
					if (SlimeBallExist[i] == false) //If one isn't active
					{
						shootSlime(i);
					}
					checkIfEnemyGetsPassedEnd(i);
				}
	        }
			
			for (int i = 0; i <= ships-1; i++) 
	        {
				moveSlimeBallAndCheckIfItHitsPlayer(i);
	        }
			
			if (laserExist == true)
			{
				laser.changeYby(-12);
				
				if (laser.getY() < 0)
				{
					laserExist = false;
					accuracy = CalcAccuracy(); //Update Accuracy
				}
				checkIfLaserHitsEnemy();
			}
			
			for (int i = 0; i <= ships-1; i++) 
		    {
				if (enemyHit[i] == true)
				{
					enemyDeathAnimationThenKill(i);
				}
		    }

			//Test for if all enemies killed
			enemiesRemain = calculateEnemiesLeft(); //If enemies are left, this will stay True
			
			if (enemiesRemain == false)
			{
				nextLevel();
			}
		}	
	}

	private void displayLevelLarge() 
	{
		if (showLevelTimer < LEVELTIMERMAX)
		{
			DisplayLevel = true;
			showLevelTimer++;
			playerCeaseFire = true;
			clearPlayerFire();
		}
		else
		{
			showLevelTimerDone = true;
			showLevelTimer = 0;
			DisplayLevel = false;
			if (!(level==9))
			{
				playerCeaseFire = false;
			}
			
		}
	}
	
	int boss1Cooldown = 200;

	private void boss1Level() 
	{
		if (levelSkipped[level-1] == true)
		{
			killAll();
			nextLevel();
		}
		else
		{
			if (showLevelTimerDone == false)
			{
				displayLevelLarge();
			}
			else if (boss1Summoned == false ) //Summon boss and do not run again.
			{
				summonBoss1();
			}
			else if (boss1EntranceAnimationDone == false)
			{
				playerCeaseFire = true;
				clearPlayerFire();
				boss1EntranceAnimation();
			}
			else if (boss1Cooldown > 0)
			{
				boss1Cooldown--;
				countdown(200, boss1Cooldown);
			}
			else
			{
				playerCeaseFire = false;
				displayCountdown = -5;
				
				moveBoss1AndShootFireBall();
				
				if (laserExist == true)
				{
					laser.changeYby(-12);
					
					if (laser.getY() < 0)
					{
						laserExist = false;
						accuracy = CalcAccuracy(); //Update Accuracy
					}
					checkIfLaserHitsBoss1();
				}
				
				if (boss1Lives <= 0)
				{
					boss1Exists = false;		//Kill the boss
					boss1 = null;
					fireBallsExist = false;
					nextLevel();
				}
				
				for (int i = 0; i <= 2; i++) 
		        {
					if (fireBallsExist == true)
					{
						try
						{
							moveFireBalls(i);
							
							checkIfFireBallHitsPlayer(i);
						}
						catch (Exception e)
						{
							//Throws error after you beat Boss 1 , only once
							//e.printStackTrace();
						}	
					}
		        }
			}
		}
		
		
	}

	private void boss1EntranceAnimation() 
		{
			boolean done = false;

			if (done == false)
			{
				boss1.changeYby(2);
			}
			if (boss1.getY() >= 100)
			{
				done = true;
				boss1EntranceAnimationDone = true;
				boss1CeaseFire = false;
			}
		}

	private void boss2EntranceAnimation() 
	{
		boolean done = false;

		if (done == false)
		{
			boss2.changeYby(2);
		}
		if (boss2.getY() >= 100)
		{
			done = true;
			boss2EntranceAnimationDone = true;
			boss2CeaseFire = false;
		}
	}

	private void clearPlayerFire() 
	{
		laserExist = false;
	}

	private void animateSuperLaser()
	{			
		SuperLaserArrayTimePassed++;
		
		if (SuperLaserPicsSub == 0)
		{
			if (SuperLaserArrayTimePassed > 5)
			{
				//Will wait till after picture updates to fire
				SuperLaserPicsSub = 1;
				SuperLaserArrayTimePassed = 0;
			}
		}
		else if (SuperLaserPicsSub == 1)
		{
			if (SuperLaserArrayTimePassed > 5)
			{
				//Will wait till after picture updates to fire
				SuperLaserPicsSub = 0;
				SuperLaserArrayTimePassed = 0;
			}
		}
	}

	private void checkIfSuperLaserHitsPlayer()
	{
		if (SuperLaser.getX()+2 >= you.getX()) //On right side
		{
			if ((SuperLaser.getX()+2) <= (you.getX()+you.getSize())) //On left
			{
				loseALife();
				SuperLaserExists = false;
//				SuperLaserSound.stop();
//				SuperLaserSound=null;
				boss2PicsSub = 0;
			}
		}
	}

	private void checkIfLaserHitsBoss2() 
	{
		if (laser.getX()+2 >= boss2.getX()) //On right side
		{
			if ((laser.getX()+2) <= (boss2.getX()+boss2.getSize())) //On left
			{
				if (laser.getY() >= boss2.getY()) //If below
				{
					if (laser.getY() <= boss2.getY() + boss2.getSize()-15) //If above
					{
						laserExist = false;
						boss2Lives--;
						hitCount++;
						accuracy = CalcAccuracy(); //Update Accuracy
					}
				}
			}
		}
	}
	
	private void moveBoss2AndFireLaser() 
	{
		if (boss2Exists == true)
		{
			boss2.incrementX();
			
			if (boss2.getX() > (frameWidth -50) || boss2.getX() < 0)
			{
				boss2.inverseX();
			}
			else if (percentChance(.5) == true) //.5% chance to switch ways
			{
				boss2.inverseX();
			}
			
			if (SuperLaserExists == false && startingCountdown < 1) //If one isn't active
			{
				//Change picture
				boss2PicsSub = 1;
				startingCountdown = (STARTINGCNTDWN);
				
//				if (Main.sounds && SuperLaserSound== null)
//				{
//					SuperLaserSound = new Play(Play.class.getResourceAsStream("Sounds/SuperLaser.wav"));
//				}
			}
			
			if (boss2PicsSub == 1)
			{
				boss2ArrayTimePassed++;
				if (boss2ArrayTimePassed > 20)
				{
					 //Will wait till after picture updates to fire
					boss2PicsSub = 2;
					boss2ArrayTimePassed = 0;
				}
			}
			if (boss2PicsSub == 2)
			{
				boss2.fireSuperLaser();
			}
		}
	}

	private void nextLevel() {
		//Reset Accuracy
		CalcAccuracy();
		levelAccuracy[level-1] = accuracy;
		showLevelTimerDone = false;
		clearPlayerFire();
		
		if (!(level==9)) //Set to Last Level
		{
			accuracy = 0;
			shotsFired = 0;
			hitCount = 0;
		
		
			level++;
			lives++;
			
			//Reset the arrays
			try
			{
				ships = shipNum[level-1];
				populateArrays();
//				say("arrays populated level" + level);
			}
			catch (ArrayIndexOutOfBoundsException e)
			{
//				youWinMessage();
			}
		}
	}

	private void youWinMessage() 
	{
		int MessageType = JOptionPane.INFORMATION_MESSAGE;
		Component parentComponent = null;
		accuracy = CalcAccuracy();
		String topBar = " \n                  Accuracy:      Lives Lost:";
		String levelStats[];
		levelStats = new String [levels];
		int totalAccuracy = 0;
		int totalLivesLost = 0;
		int levelsCompleted = levels;
		String totals;
		String cheats = "";
		
		
		for (int i=0; i<levels; i++)
		{
			if (levelSkipped[i] == false && !(levelAccuracy[i] == 0))
			{
				if (levelAccuracy[i] >= 10)
				{
					levelStats[i] = "\nLevel " + (i+1) + ":         " + levelAccuracy[i] + "%                     "+ levelLivesLost[i];
				}
				else
				{
					levelStats[i] = "\nLevel " + (i+1) + ":         " + levelAccuracy[i] + "%                      "+ levelLivesLost[i];
				}
				totalAccuracy += levelAccuracy[i];
				totalLivesLost += levelLivesLost[i];
			}
			else
			{
				levelStats[i] = "\nLevel " + (i+1) + ":                   Skipped";
				levelsCompleted--;
			}
		}
		try
		{
			totalAccuracy /= levelsCompleted;
		}
		catch (ArithmeticException e)
		{
			totalAccuracy = 0;
		}
		
		if (cheatsEnabled)
		{
			cheats = "\n\n       Cheats Were Enabled \n\n";
		}
		
		totals = "\nTotal:             " + totalAccuracy + "%                     "+ totalLivesLost;

		
		String message = "You Win!" + topBar + levelStats[0] + levelStats[1] + levelStats[2] + levelStats[3] + levelStats[4]
						 + levelStats[5] + levelStats[6] + levelStats[7] + levelStats[8] + totals + cheats;
		
		JOptionPane.showMessageDialog(parentComponent, message, "Winner!", MessageType);
		System.exit(0);
	}

	private void moveSlimeBallAndCheckIfItHitsPlayer(int i) 
	{
		if (SlimeBallExist[i] == true)
		{
			SlimeBall[i].changeYby(8);
			
			if (SlimeBall[i].getY() > frameHeight)
			{
				SlimeBallExist[i] = false;
			}
			//If SlimeBall hits Player
			if (SlimeBall[i].getX()+2 >= you.getX()) //On right side
			{
				if ((SlimeBall[i].getX()+2) <= (you.getX()+you.getSize())) //On left
				{
					if (SlimeBall[i].getY() >= you.getY()) //If below
					{
						if (SlimeBall[i].getY() <= you.getY() + you.getSize()) //If above
						{
							loseALife();
							SlimeBallExist[i] = false;
						}
					}
				}
			}
		}
	}

	private void summonBoss2() 
	{
		clearEnemyFire();
		//Summon Boss 2
		boss2 = new TheBoss2(200, -20);
		boss2Exists = true;
		boss2Summoned = true;
	}

	private void enemyDeathAnimationThenKill(int i) 
	{
		enemyHitTimePassed[i]++;
		if (EnemyPicsNum[i] == 1)
		{
			if (enemyHitTimePassed[i] > MAXTIMEPASSED)
			{
				EnemyPicsNum[i] = 2;
				enemyHitTimePassed[i] = 0;
			}
		}
		if (EnemyPicsNum[i] == 2)
		{
			if (enemyHitTimePassed[i] > MAXTIMEPASSED)
			{
				enemys[i] = null;
				enemyExists[i] = false;
			}
		}
	}

	private void checkIfEnemyGetsPassedEnd(int i) 
	{
		if (enemys[i].getX() > frameWidth -40 || enemys[i].getX() < 0)
		{
			enemys[i].inverseX();
			enemys[i].changeYby(50);
			
			if (enemys[i].getY() >= 500)
			{
				enemys[i] = null;
				enemyExists[i] = false;
				loseALife();
			}
		}
	}

	private void changePlayerPic() 
	{
		if (playerPicsSub == 5)
		{
			playerHitTimePassed++;
			if (playerHitTimePassed > MAXTIMEPASSED)
			{
				playerPicsSub = 0; //Restore sub to original
				playerHitTimePassed = 0;
			}
		}
		else //If you are not hit
		{
			playerArrayTimePassed++;
			if (playerArrayTimePassed > 5)
			{
				playerPicsSub++;
				playerArrayTimePassed = 0;
				
				if (playerPicsSub > 4)
				{
					playerPicsSub = 0;
				}
			}
		}
	}

	private void checkIfLaserHitsEnemy() 
	{
		for (int i = 0; i <= ships-1; i++) 
	    {
			if (enemyExists[i] == true)
			{
				if (laser.getX()+2 >= enemys[i].getX()) //On right side
				{
					if ((laser.getX()+2) <= (enemys[i].getX()+enemys[i].getSize())) //On left
					{
						if (laser.getY() >= enemys[i].getY()) //If below
						{
							if (laser.getY() <= enemys[i].getY() + enemys[i].getSize()) //If above
							{
								EnemyPicsNum[i] = 1;
								laserExist = false;
								enemyHit[i] = true;
								hitCount++;
								accuracy = CalcAccuracy(); //Update Accuracy
							}
						}
					}
				}
			}
	    }
	}

	private int CalcAccuracy() 
	{
		Double d = (double) Math.round(((hitCount/shotsFired)*100)*1/1);
		int i = d.intValue();
		
		return i;
	}

	private boolean calculateEnemiesLeft() //Return true if enemies remain
	{
		boolean sendReturn = false;
		
		enemiesLeft = 0;
		for (int i = 0; i <= ships-1; i++) 
        {
			if(enemyExists[i] == true)
			{
				sendReturn = true;
				enemiesLeft++;
			}
        }
		return sendReturn;
	}

	public void paint(Graphics g)
	{
        dbi = createImage(getWidth(), getHeight());
        dbg = dbi.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbi, 0, 0, this);
        repaint();
    }
		
	private void paintComponent(Graphics g)
	{
		//AA Text smoothing
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		//Draw Background
		g.drawImage(Background, 0 , 0 , frameWidth, frameHeight, this);
		
		g.drawImage(playerPics[playerPicsSub], you.getX(), you.getY(), you.getSize(), you.getSize() , this);
		
		if (playerPicsSub == 5) //If player is hit
		{
			g.drawImage(redScreen, 0 , 0 , frameWidth, frameHeight, this);
		}
			
		g.setColor(Color.yellow);
		g.setFont(calibri20);
		
		g.drawString("Level: " + level, 10 ,25);
		g.drawString("Lives: " + lives, 10 ,45);
		g.drawString("Accuracy: " + accuracy + "%", 10 ,65);
		
//		if (level ==9)
//		{
//			g.drawString("Idea to use Sam's Head: Jack Dahms", 110 , 25);
//		}
		
		if (cheatsEnabled)
		{
			g.drawString("Cheats Enabled", 450 ,25);
		}
		
		if (displayCountdown > -1)
		{
			g.setFont(new Font("Calibri", Font.BOLD, 100));
			
			if (level == 3 || level == 6)
			{
				g.drawString("" + displayCountdown, 280 ,400);
			}
			else
			{
				g.drawString("" + displayCountdown, 280 ,600);
			}
			
		}
		
		
		//Draw Laser
		if (laserExist == true)
		{
			g.drawImage(LaserPic, laser.getX(), laser.getY(), 12, 30, this);
		}
		
		if (laserSight)
		{
			g.setColor(Color.red);
			g.drawLine(you.getX()+25, 0, you.getX()+25, frameHeight-62);
		}
		
		//Draw enemy
		if (DisplayLevel == false)
		{
			for (int i = 0; i <= ships-1; i++) 
		    {
				if (enemyExists[i] == true)
				{
					g.drawImage(EnemyPics[EnemyPicsNum[i]], enemys[i].getX(), enemys[i].getY(), enemys[i].getSize(), enemys[i].getSize(), this);
		        }
				
				if (SlimeBallExist[i] == true)
				{
					g.drawImage(SlimeBallPic, SlimeBall[i].getX(), SlimeBall[i].getY(), 20, 30, this);
				}
		    }
		}
		else
		{
			g.setColor(Color.yellow);
			g.setFont(new Font("Calibri", Font.BOLD, 100));
			
			if (level == 3)
			{
				g.drawString("Level: " + level, 150 ,240);
				g.drawString("Boss 1 ", 180 ,340);
			}
			else if (level == 6)
			{
				g.drawString("Level: " + level, 150 ,240);
				g.drawString("Boss 2 ", 180 ,340);
			}
			else if (level == 9)
			{
				g.drawString("Level: " + level, 150 ,340);
				g.setFont(new Font("Calibri", Font.BOLD, 80));
				g.drawString("Boss 3 : Sam Ebe ", 20 ,440);
			}
			else
			{
				g.drawString("Level: " + level, 150 ,300);
			}
			
		}
			
		
		//Draw Boss
		if (boss1Exists == true)
		{
			g.drawImage(boss1Pics[boss1PicsSub], boss1.getX(), boss1.getY(), boss1.getSize(), boss1.getSize(), this);
			
			//Draw Boss Health Bar
			g.drawImage(bossHealthBarPics[10-boss1Lives], 470, 50, 100, 10, this);
			
			
			if (fireBallsExist == true)
			{
				for (int i = 0; i <= 2; i++ )
				{
					if (fireBallsExist == true)
					{
						g.drawImage(FireBallPic, FireBall[i].getX(), FireBall[i].getY(), 20, 30, this);
					}
				}
			}
        }
		else if (boss2Exists == true)
		{
			g.drawImage(boss2Pics[boss2PicsSub], boss2.getX(), boss2.getY(), boss2.getSize(), boss2.getSize(), this);
			
			//Draw Boss Health Bar
			g.drawImage(bossHealthBarPics[10-boss2Lives], 470, 50, 100, 10, this);
			
			if (SuperLaserExists == true)
			{
				g.drawImage(SuperLaserPics[SuperLaserPicsSub], SuperLaser.getX() +13, SuperLaser.getY() +50+10, 35, 550, this);
			}
		}
		else if (level == 9)
		{
			try //If Left Sloth Exists
			{
				g.drawImage(slothPic, leftSloth.getX(), leftSloth.getY(), leftSloth.getSize(), leftSloth.getSize(), this);
				
				//Draw Sloths's Health Bar
				g.drawImage(bossHealthBarPics[10- leftSlothLives], (leftSloth.getX()), (leftSloth.getY() -15), leftSloth.getSize(), 10, this);
			}catch (NullPointerException e){}
			
			
			try //If Right Sloth Exists
			{
				g.drawImage(slothPic, rightSloth.getX(), rightSloth.getY(), rightSloth.getSize(), rightSloth.getSize(), this);
				
				//Draw Sloths's Health Bar
				g.drawImage(bossHealthBarPics[10- rightSlothLives], (rightSloth.getX()), (rightSloth.getY() -15), rightSloth.getSize(), 10, this);
			}catch (NullPointerException e){}

			
			for (int i=0; i<numberOfPigs; i++)
			{
				try //If That Pig Exists
				{
					g.drawImage(pigPic, pigs[i].getX(), pigs[i].getY(), pigs[i].getSize(), pigs[i].getSize(), this);
					
					//Pig Health Bar
					g.drawImage(bossHealthBarPics[10- pigBossLives[i]], (pigs[i].getX()), (pigs[i].getY() -15), pigs[i].getSize(), 10, this);
				}
				catch (NullPointerException e){}
				
				try
				{
					g.drawImage(baconPic, baconFire[i].getX(), baconFire[i].getY(), 16, 50, this);
//					g.drawImage(baconPic, baconFire[i].getX(), baconFire[i].getY(), 20, 60, this);
				}
				catch (NullPointerException e){}
				
				
			}
			try //If Sam Exists
			{
				g.drawImage(samPic, sam.getX(), sam.getY(), sam.getSize(), sam.getSize(), this);
				
				//Draw Sam's Health Bar
				
				if (samLives > 20)
				{
					g.drawImage(bossHealthBarPics[30 -samLives], (sam.getX() -5), (sam.getY() -40), sam.getSize(), 10, this);
					g.drawImage(bossHealthBarPics[0], (sam.getX() -5), (sam.getY() -30), sam.getSize(), 10, this);
					g.drawImage(bossHealthBarPics[0], (sam.getX() -5), (sam.getY() -20), sam.getSize(), 10, this);
				}
				else if (samLives > 10)
				{
					g.drawImage(bossHealthBarPics[20 -samLives], (sam.getX() -5), (sam.getY() -30), sam.getSize(), 10, this);
					g.drawImage(bossHealthBarPics[0], (sam.getX() -5), (sam.getY() -20), sam.getSize(), 10, this);
				}
				else
				{
					g.drawImage(bossHealthBarPics[10 -samLives], (sam.getX() -5), (sam.getY() -20), sam.getSize(), 10, this);
				}
				
				try //If sam Projectile Exists
				{
					
//					g.drawImage(RHCP_Pics[RHCPsub], samFire.getX(), samFire.getY(), 40, 40, this);
					
					g.drawImage(RHCP_Pic, samFire.getX(), samFire.getY(), 40, 40, this);
					
					
					
//					RHCPcounter++;
//					
//					if (RHCPcounter > 5)
//					{
//						RHCPcounter = 0;
//						RHCPsub++;
//						
//						if (RHCPsub > RHCP_Pics.length-1)
//						{
//							RHCPsub = 0;
//						}
//					}
					
				}catch(NullPointerException e){}	
			}catch(NullPointerException e){}
			catch(ArrayIndexOutOfBoundsException e){}
			
			try
			{
				g.drawImage(penguinPic, leftSlothFire.getX(), leftSlothFire.getY(), 30, 60, this);
			}
			catch(NullPointerException e){}
			
			try
			{
				g.drawImage(penguinPic, rightSlothFire.getX(), rightSlothFire.getY(), 30, 60, this);
			}
			catch(NullPointerException e){}
			
		}
		
//			g.drawLine(300, 0, 300, 750); //Middle Line	
	}
	
	int RHCPsub = 0;
	int RHCPcounter = 0;
	
	private void populateArrays() 
	{
		SlimeBall = new EnemySlimeBall[ships];
		FireBall = new BossFireBall[3];
		SlimeBallExist = new boolean[ships];
		enemyHitTimePassed = new int[ships];
		enemys = new Enemy[ships];
		enemyExists = new boolean[ships];
		for (int i = 0; i <= ships-1; i++)
		{
			enemyExists[i] = true;
		}
		EnemyPicsNum = new int[ships];
		{
			for (int i = 0; i <= ships-1; i++)
			{
				EnemyPicsNum[i] = 0;
			}
		}
		enemyHit = new boolean[ships];
		
		int x=0;
		int y=50;
		int row = 1;
		
		for (int i = 0; i <= ships-1; i++) 
	    {
			enemys[i] = new Enemy(x,y);
			x += 50;
			if (x >= 560)
			{
				y += 50;
				x = 20;
				
				if (row % 2 == 0) //Even Rows
				{
					x=0;
				}
				else //Odd Rows
				{
					x=20;
				}
				row++;
			}
	    }
	}

	private void shootSlime(int i)
	{
		double x = 0;
		
		calculateEnemiesLeft();
		
		x = (1.000/enemiesLeft); //  /2
		
		if (percentChance(x) == true)
		{
			enemys[i].shootSlimeBall(i);
		}
	}
	

	private boolean percentChance(double x)
	{
		double randomNumber;
		double percentChanceofTrue = x;

			randomNumber = Math.random() *100;
			
			if (randomNumber < percentChanceofTrue) // % chance of firing
			{
				return true;
			}
			else
			{
				return false;
			}
	}
	private void loseALife() 
	{
		lives --;
		levelLivesLost[level-1] += 1; //Add 1 life lost to array
		playerPicsSub = 5;
	}

	private void clearEnemyFire() 
	{
		for (int i=0; i <= ships-1; i++ )
		{
			SlimeBallExist[i] = false;
		}	
	}

	private void killAll() 
	{
		if (calculateEnemiesLeft() == true)
		{
			for (int i = 0; i <= ships-1; i++)
			{
				enemyExists[i] = false;
			}
		}
		else if (boss1Exists == true)
		{
			boss1Exists = false;
		}
		else if (boss2Exists == true)
		{
			boss2Exists = false;
		}
		else if (level==9)
		{
			samRunAway2();
			nextLevel();
			youWinMessage();
		}
	}

	boolean cheatsEnabled = false;
	
	public void keyPressed(KeyEvent e) //Implement and add Listener
	{
		int keyCode = e.getKeyCode();
	    switch( keyCode )
	    { 
	    	//Arrow Keys
	    	case KeyEvent.VK_LEFT: //Left Arrow Key
	    		you.setVelX(-shipSpeed);
	            break;
	        case KeyEvent.VK_RIGHT :  //Right Arrow Key
	        	you.setVelX(shipSpeed);
	            break;
	        //WASD
	        case KeyEvent.VK_A: //A Key
	        	you.setVelX(-shipSpeed);
	            break;
	        case KeyEvent.VK_D : //D key
	        	you.setVelX(shipSpeed);
	            break;
	          //Space Bar
	        case KeyEvent.VK_SPACE:
	        	spaceBarHeld = true;
	        	break;
//	        case KeyEvent.VK_M:
//				sounds = (!sounds); //Toggle Sounds
//	            break;
	        case KeyEvent.VK_P:
				play = (!play); //Toggle Pause
	            break;
	        case KeyEvent.VK_R:
	        	laserSight = (!laserSight); //Toggle Laser Sight
	            break;
	        case KeyEvent.VK_ESCAPE:
	        	System.exit(0); //Exit
	            break;
	        case KeyEvent.VK_MINUS: 
	        	if (cheatsEnabled)
	        	{
	        		sleepCounter++;	//Slower
	        	}
	        	break;
	        case KeyEvent.VK_EQUALS:
	        	if (cheatsEnabled && sleepCounter > 2)
	        	{
	        		sleepCounter--;		//Faster
	        	}
	        	break;
	        case KeyEvent.VK_SUBTRACT: 
	        	if (cheatsEnabled)
	        	{
	        		sleepCounter++;		//Slower
	        	}
	        	break;
	        case KeyEvent.VK_ADD:
	        	if (cheatsEnabled && sleepCounter > 2)
	        	{
	        		sleepCounter--;		//Faster
	        	}
	        	break;
	        case KeyEvent.VK_L:
	        	if (cheatsEnabled)
	        	{
	        		lives++;
	        	}
	        	break;
	        case KeyEvent.VK_I:
	        	if (cheatsEnabled)
	        	{
	        		lives += 1000;
	        	}
	        	break;
	        case KeyEvent.VK_F:
	        	if (cheatsEnabled)
	        	{
	        		lives += 1000;
	        		sleepCounter =2;
	        	}
	        	break;
	        case KeyEvent.VK_NUMPAD0:
	        	if (cheatsEnabled)
	        	{
	        		levelSkipped[level-1] = true;
	        		killAll();
	        	}
	        	break;
	        case KeyEvent.VK_M:
	        	if (cheatsEnabled)
	        	{
	        		samLives--;
	        	}
	        	break;
	        case KeyEvent.VK_B:
	        	spaceBarHeld = !(spaceBarHeld);
	        	break;
	        case KeyEvent.VK_V:
	        	dispose();
	        	Undecorated = !Undecorated;
				setUndecorated(Undecorated);
				setVisible(true);
	        	break;
	        	
	     }
	    if(e.isControlDown() && e.isAltDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_C) 
    	{
	    	cheatsEnabled = true;
    	}
	}
	
	@Override
	public void keyReleased(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();
		switch( keyCode ) { 
        
    	//Arrow Keys
    	case KeyEvent.VK_LEFT: //Left Arrow Key
    		you.setVelX(0);
            break;
        case KeyEvent.VK_RIGHT :
        	you.setVelX(0);
            break;
        //WASD
        case KeyEvent.VK_A: //A Key
        	you.setVelX(0);
            break;
        case KeyEvent.VK_D : //D key
        	you.setVelX(0);
            break;
          //Space Bar
        case KeyEvent.VK_SPACE:
        	spaceBarHeld = false;
        	break;
		}
	}
	public void keyTyped(KeyEvent e) {}
	public void actionPerformed(ActionEvent arg0) {}

//	private void say(String talk)
//	{
//		System.out.println(talk);
//	}
//	private void say(int talk) 
//	{
//		System.out.println(talk);
//	}
//	private void say(double talk) 
//	{
//		System.out.println(talk);
//	}
//	private void say(boolean b) {
//		System.out.println(b);
//	}
	
	public static void main (String Args[])
	{
		Main MainScreen = new Main();
		MainScreen.setVisible(true);
	}
}