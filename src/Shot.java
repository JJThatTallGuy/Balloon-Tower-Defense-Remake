import java.awt.Color;

public class Shot extends GameObject{

	public Shot(double x_, double y_, double a_, double s_) {
		super(x_, y_, a_, s_, 4, Color.BLACK);
	
		// TODO Auto-generated constructor stub
	}

	@Override
	int type() {
		// TODO Auto-generated method stub
		return 3;
	}
	public void move(double diffSeconds){
//		GameObjectList collisions = getCollisions(this);
//		for(int i=0; i<collisions.size(); i++)
//		{
//		  GameObject obj = collisions.get(i);
//		  
//		  int type = obj.type();
//		  
//		 
//		  if(type==Const.TYPE_BALLOON && obj.isLiving)
//		  { 
//		    Balloon b = (Balloon) obj;
//		    b.hasBeenShot();
//	        this.isLiving=false;
//		  }
//		} 
		super.move(diffSeconds);
	}
	public GameObjectList getCollisions(GameObject object)
	  {
	    GameObjectList result = new GameObjectList();
	    
	    int len = world.gameObjects.size();
	    for(int i=0; i<len; i++)
	    {
	      GameObject obj2 = world.gameObjects.get(i);
	      
	      // an object doesn't collide with itself
	      if(obj2==object) continue;
	      
	      // check if they touch each other
	      double dist = object.radius+obj2.radius;
	      double dx   = object.x-obj2.x;
	      double dy   = object.y-obj2.y;
	      
	      if(dx*dx+dy*dy < dist*dist)
	      { result.add(obj2);
	      }
	    }
	    
	    return result;
	  }
}
