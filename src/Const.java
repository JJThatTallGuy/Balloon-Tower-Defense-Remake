import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;


public class Const {
	 // size of the world
	  static final int WORLD_WIDTH      = 960;
	  static final int WORLD_HEIGHT     = 720;
	  static int health = 50;
	  static int money = 10;
	  // size of the displayed part of the world
	  static boolean drawTower = false;
	  static boolean canStart = false;
	  static boolean drawSpike = false;
	  static boolean drawGlue = false;
	  static boolean gameOver = false;
	  static Point[] array = {new Point(490,0), new Point(490, 150), new Point(340, 150), new Point(340, 300)
			  , new Point(640, 300), new Point(640, 500), new Point(505, 500), new Point(505, 720)};
	  	  
	  static final double SPAWN_INTERVAL = 110;
	  static final double SHOT_INTERVAL = 100;
	  
	  static final int TYPE_BALLOON  = 1;
	  static final int TYPE_TOWER    = 2;
	  static final int TYPE_SHOT    = 3;
	  static final int TYPE_SPIKE  = 4;
	  static final int TYPE_GLUETOWER = 5;
	  static final int TYPE_GLUESHOT = 6;

	  
	  static final Map<Integer,Balloon[]> levels = new HashMap<Integer,Balloon[]>(){{
		  put(0,new Balloon[]{new Balloon(490,0,10,100,5, 300)});
		  put(1,new Balloon[]{new Balloon(490,0,10,100,5,300),new Balloon(490,0,10,100,5,300)});
		  put(2,new Balloon[]{new Balloon(490,0,10,100,5,300),new Balloon(490,0,10,100,5,300), new Balloon(490,0,10,100,5,300),new Balloon(490,0,10,100,5,300)});
		  put(3,new Balloon[]{new Balloon(490,0,10,100,5,500),new Balloon(490,0,10,100,5,500), new Balloon(490,0,10,100,5,500),new Balloon(490,0,10,100,5,500)});
		  put(4,new Balloon[]{new Balloon(490,0,10,100,5,500),new Balloon(490,0,10,100,5,500), new Balloon(490,0,10,100,5,500),new Balloon(490,0,10,100,5,500), 
				  new Balloon(490,0,10,100,5,500),new Balloon(490,0,10,100,5,500), new Balloon(490,0,10,100,5,500),new Balloon(490,0,10,100,5,500)});
		  put(5,new Balloon[]{new Balloon(490,0,10,100,5,700),new Balloon(490,0,10,100,5,700), new Balloon(490,0,10,100,5,700),new Balloon(490,0,10,100,5,700), 
				  new Balloon(490,0,10,100,5,700),new Balloon(490,0,10,100,5,700), new Balloon(490,0,10,100,5,700),new Balloon(490,0,10,100,5,700)});
		  put(6,new Balloon[]{new Balloon(490,0,10,100,5,700),new Balloon(490,0,10,100,5,700), new Balloon(490,0,10,100,5,700),new Balloon(490,0,10,100,5,700), 
				  new Balloon(490,0,10,100,5,700),new Balloon(490,0,10,100,5,700), new Balloon(490,0,10,100,5,700),new Balloon(490,0,10,100,5,700), 
				  new Balloon(490,0,10,100,5,700),new Balloon(490,0,10,100,5,700), new Balloon(490,0,10,100,5,700),new Balloon(490,0,10,100,5,700), 
				  new Balloon(490,0,10,100,5,700),new Balloon(490,0,10,100,5,700), new Balloon(490,0,10,100,5,700),new Balloon(490,0,10,100,5,700)});
		  put(7,new Balloon[]{new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), 
				  new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), 
				  new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), 
				  new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900)});
		  put(8,new Balloon[]{new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), 
				  new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), 
				  new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), 
				  new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), 
				  new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), 
				  new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), 
				  new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), 
				 new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900), new Balloon(490,0,10,100,5,900),new Balloon(490,0,10,100,5,900)});
		  put(9,new Balloon[]{new Balloon(490,0,10,100,5,1100),new Balloon(490,0,10,100,5,1100), new Balloon(490,0,10,100,5,1100),new Balloon(490,0,10,100,5,1100), 
				  new Balloon(490,0,10,100,5,1100),new Balloon(490,0,10,100,5,1100), new Balloon(490,0,10,100,5, 1100),new Balloon(490,0,10,100,5,1100), 
				  new Balloon(490,0,10,100,5,1100),new Balloon(490,0,10,100,5,1100), new Balloon(490,0,10,100,5,1100),new Balloon(490,0,10,100,5,1100), 
				  new Balloon(490,0,10,100,5,1100),new Balloon(490,0,10,100,5,1100), new Balloon(490,0,10,100,5,1100),new Balloon(490,0,10,100,5,1100), 
				  new Balloon(490,0,10,100,5,1100),new Balloon(490,0,10,100,5,1100), new Balloon(490,0,10,100,5,1100),new Balloon(490,0,10,100,5,1100), 
				  new Balloon(490,0,10,100,5,1100),new Balloon(490,0,10,100,5,1100), new Balloon(490,0,10,100,5,1100),new Balloon(490,0,10,100,5,1100), 
				  new Balloon(490,0,10,100,5,1100),new Balloon(490,0,10,100,5,1100), new Balloon(490,0,10,100,5,1100),new Balloon(490,0,10,100,5,1100), 
				 new Balloon(490,0,10,100,5,1100),new Balloon(490,0,10,100,5,1100), new Balloon(490,0,10,100,5,1100),new Balloon(490,0,10,100,5,1100)});

	  };
	  };  
}
