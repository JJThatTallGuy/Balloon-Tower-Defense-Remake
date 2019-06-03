
public class PhysicsSystem {
	protected World world;
	  
	  public PhysicsSystem(World w)
	  { world = w;
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
	  
	  protected double distance(double x1, double y1, double x2, double y2)
	  {
	    double xd = x1-x2;
	    double yd = y1-y2;
	    return Math.sqrt(xd*xd+yd*yd);
	  }
	  
	  
	  //
	  // move object "back" reverse alfa until it just does not collide
	  //
	  public void moveBackToUncollide(GameObject object)
	  {
	    double dx = Math.cos(object.alfa);
	    double dy = Math.sin(object.alfa);
	    
	    while(true)
	    {
	      object.x -= dx;
	      object.y -= dy;
	      
	      GameObjectList collisions = getCollisions(object);
	      if(collisions.size()==0) break;
	    }
	  }
}
