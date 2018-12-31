
public class Ball 
{
	int bx; //Ball X
	int by; //Ball Y
	int bxd; //Ball X Direction
	int byd; //Ball Y Direction
	int mxs; //Maximum X Speed
	int mys; //Maximum Y Speed
	int sxs; //Screen Size X
	int sys; //Screen Size Y
	
	//What happens when a ball is created
	public Ball(int mx, int my, int sx, int sy)
	{ 
		//Initialize everything
		sxs = sx;
		sys = sy;
		mxs = mx;
		mys = my;
		bx = 320;
		by = 240;
		bxd = mxs;
		byd = mys;
	}
	//Set the XY Position of the current ball
	public void setxy(int blx, int bly)
	{
		bx = blx;
		by = bly;
	}
	//Update the balls position, etc.
	public void Update()
	{
		bx = bx + bxd;
		by = by + byd;
		if (bx > sxs)
		{
			bxd = -mxs;
		}
		if (bx < 0)
		{
			bxd = mxs;
		}
		if (by > sys)
		{
			byd = -mys;
		}
		if (by < 80)
		{
			byd = mys;
		}
	}
	//Change the speed of the current ball
	public void updatespeed(int nspeed)
	{
		mxs = nspeed;
		mys = nspeed;
	}
	//Get the ball's X
	public int getballx()
	{
		return bx;
	}
	public int getbally()
	//Get the ball's Y
	{
		return by;
	}
}
