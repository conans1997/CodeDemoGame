import java.awt.*;
import java.awt.event.*;
//The actual game: BallWars
class BallwarsGame 
{
	public static void main(String args[])
	{
		int ts = 1;
		int es = 2;
		//Create a new BallWarsWindow
		BallWarsWindow windisp = new BallWarsWindow();
		//Create two balls
		Ball target = new Ball(1,1,640,480);
		Ball enemy = new Ball(2,2,640,480);
		//Put the balls into an array and put the colors into an array
		Ball fballs[]  = {target,enemy};
		Color fcolors[] = {Color.blue,Color.red};
		//Let our graphics engine know what balls and what colors to draw
		windisp.addballs(fballs,fcolors,1);
		//Brunning Determines weather or not to exit
		int brunning =  1;
		int lk;
		while (brunning == 1)
		{
			windisp.refreshview(); //Render the window
			target.Update(); //Update the targets position
			enemy.Update(); //Update the enemys position
			lk = windisp.getlastkey();
			//See what keys were pressed
			if (lk == 38)
			{
				windisp.movexyp(0,-10);
			}
			else if (lk == 40)
			{
				windisp.movexyp(0,10);
			}
			else if (lk ==37)
			{
				windisp.movexyp(-10,0);
			}
			else if (lk == 39)
			{
				windisp.movexyp(10,0);
			}
			else if(lk == 32)
			{
				//if the user decided to shoot, check wether it was a hit.
				System.out.println("Shoot");
				if (target.getballx() < windisp.getyx() + 40)
				{
					if (target.getballx() > windisp.getyx() - 40)
					{
						if (target.getbally() < windisp.getyy() + 40)
						{
							if (target.getbally() > windisp.getyy() - 40)
							{
								windisp.addkill();
								System.out.println("KILL");
								ts = ts + 1;
								es = es + 1;
								target.updatespeed(ts);
								enemy.updatespeed(es);
							}
						}
					}
				}
			}
			
			//See if the enemy hit the user
			if (enemy.getballx() < windisp.getyx() + 40)
			{
				if (enemy.getballx() > windisp.getyx() - 40)
				{
					if (enemy.getbally() < windisp.getyy() + 40)
					{
						if (enemy.getbally() > windisp.getyy() - 40)
						{
							windisp.takelife();
							System.out.println("DEATH");
							ts = ts - 1;
							es = es - 1;
							target.updatespeed(ts);
							enemy.updatespeed(es);
							enemy.setxy(5,80);
						}
					}
				}
			}
			sleep(50); //Give the computer 50 milliseconds to rest 
		}
	}
	public static void sleep(int slen)
	{
		try 
		{
			Thread.sleep (slen); //Give the cpu 50 milliseconds of rest.
		}
		catch (Exception e) { }
	}
	
}