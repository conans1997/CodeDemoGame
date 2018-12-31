//The includes
import java.awt.*; //AWT: Used to create windows and components.
import java.awt.event.*;  //AWT.Event: Allow events to be triggered by windows

//BallWarsWindow is part of BallWars
//It serves as the display and graphics engine for this game
//It extends frame so that it can easily create and manipulate a window
//It implements KeyListener so that it can detect pressed keys
public class BallWarsWindow extends Frame implements KeyListener
{
	Ball dballs[]; //The balls that should be rendered
	Color dcolors[]; //The color of the balls
	int ballnum; //The number of balls
	int yx; //Your X 
	int yy; //Your Y
	int lkey; //The last pressed key'
	int score; //Score
	int kills;
	int level;
	int lives;
	public BallWarsWindow()
	{
		super("Ball Wars"); //Create a window titled Ball Wars
		addKeyListener(this); //Detect keys that are being pressed
		resize(640,480); //Make our window 640x480 pixels so that it works on
		//most computers
		show(); //Display our window
		yx = 5; //Initialize our X
		yy = 80; //Initialize our Y
		score = 0;
		kills = 0;
		level = 1;
		lives = 3;
	}
	//Load the balls and there colros
	public void addballs(Ball allballs[],Color allcolors[],int bn)
	{
		dballs = allballs;
		dcolors = allcolors;
		ballnum = bn;
	}
	//ReRender the scene
	public void refreshview()
	{
		repaint();
	}	
	//This is called when the seen is rerendered.  The graphics are drawn here.
	public void update(Graphics g)
	{
		int bx1; //The X of the current ball
		int by1; //The Y of the current ball
		
		//Clear the screen to black
		g.setColor(Color.black); 
		g.fillRect(0,0,640,480);
		
		for (int i = 0; i <= ballnum; i++)
		{
			//Load and alter the coords of the current ball
			bx1 = dballs[i].getballx();
			bx1 = bx1 - 20;
			by1 = dballs[i].getbally();
			by1 = by1 - 20;
			//Draw the ball
			g.setColor(dcolors[i]);
			g.fillOval(bx1,by1,40,40);
		}
		//Draw the user controlled ball
		g.setColor(Color.green);
		g.drawOval(yx,yy,45,45);
		
		//Draw the scores and lives and other things
		g.setColor(Color.white);
		g.drawLine(0,65,640,65);
		String scoretext = Integer.toString(score);
		g.drawString("Score: " + scoretext,10,35);
		String lifetext = Integer.toString(lives);
		g.drawString("Lives: " + lifetext,10,45);
		String leveltext = Integer.toString(level);
		g.drawString("Level: " + leveltext,10,55);
	}			
	//Update user controlled ball position
	public void movexyp(int mx,int my)
	{
		yx = yx + mx;
		yy = yy + my;
	}
	//Retrieve the last pressed key
	public int getlastkey()
	{
		int lk2 = lkey;
		lkey = 0;
		return lk2;
	}
	//Retrieve the X of the player
	public int getyx()
	{
		return  yx;
	}
	//Retrieve the Y of the player
	public int getyy()
	{
		return yy;
	}
	//Add a kill into the users score, etc.
	public void addkill()
	{
		score = score + (100 * level );
		kills = kills + 1;
		if (kills == level)
		{
			level = level + 1;
			kills = 0;
		}
		if (score >= 10000)
		{
			lives = lives + 1;
			score = 0;
		}
	}
	//Take away a life from the user
	public void takelife()
	{
		lives = lives - 1;
		if (lives == 0) 
		{
			System.out.println("GAME OVER");
			hide();
			sleep(5000);
			System.exit(0);
		}
	}
	//Called when the user pressed a key
	//It stores it for other classes to use
	public void keyPressed(KeyEvent e)
 	{
		lkey = e.getKeyCode();
    }
    //Required by compiler
    public void keyTyped(KeyEvent e)
    {
    	
	}
	public void keyReleased(KeyEvent e)
	{
		
	}
	//Give the cpu (slen) of rest time
	public static void sleep(int slen)
	{
		try 
		{
			Thread.sleep (slen); //Giv the cpu (slen) milliseconds of rest.
		}
		catch (Exception e) { }
	}
	
}
