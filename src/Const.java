import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;


public class Const {
	 // size of the world
	  static final int WORLD_WIDTH      = 960;
	  static final int WORLD_HEIGHT     = 720;
	  static int health = 100;
	  static int money = 10;
	  // size of the displayed part of the world
	  static boolean drawTower = false;
	  static boolean canStart = false;
	  static Point[] array = {new Point(490,0), new Point(490, 150), new Point(340, 150), new Point(340, 300)
			  , new Point(640, 300), new Point(640, 500), new Point(505, 500), new Point(505, 720)};
	  	  
	  static final double SPAWN_INTERVAL = 110;
	  static final double SHOT_INTERVAL = 150;
	  
	  static final int TYPE_BALLOON  = 1;
	  static final int TYPE_TOWER    = 2;
	  static final int TYPE_SHOT    = 3;
	  static final int TYPE_ZOMBIE  = 4;
	  static final int TYPE_GRENADE = 6;
	  
	  static final Map<Integer,Balloon[]> levels = new HashMap<Integer,Balloon[]>(){{
		  put(0,new Balloon[]{new Balloon(490,0,10,100,5,Color.BLACK), new Balloon(490,0,10,100,5,Color.BLACK)});
		  put(1,new Balloon[]{new Balloon(490,0,10,100,5,Color.BLACK),new Balloon(490,0,10,100,5,Color.BLACK)});
	  };
	  };  
}
