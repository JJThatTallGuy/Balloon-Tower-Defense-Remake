import java.awt.Point;

public class Const {
	 // size of the world
	  static final int WORLD_WIDTH      = 960;
	  static final int WORLD_HEIGHT     = 720;
	  // size of the displayed part of the world
	  static boolean drawTower = false;
	  static Point[] array = {new Point(490,0), new Point(490, 150), new Point(340, 150), new Point(340, 300)
			  , new Point(640, 300), new Point(640, 500), new Point(505, 500), new Point(505, 720)};
	  	  
	  static final double SPAWN_INTERVAL = 0.2;
	  
	  static final int TYPE_BALLOON  = 1;
	  static final int TYPE_TEXT    = 2;
	  static final int TYPE_TREE    = 3;
	  static final int TYPE_ZOMBIE  = 4;
	  static final int TYPE_SHOT    = 5;
	  static final int TYPE_GRENADE = 6;
	  
}
