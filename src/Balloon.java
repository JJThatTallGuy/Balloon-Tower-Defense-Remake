import java.awt.Color;

public class Balloon extends GameObject{
	
public Balloon(double x_, double y_, double a_, double s_, int radius_, int h) {
		super(x_, y_, a_, s_, radius_, Color.GREEN);
		health = h;
		// TODO Auto-generated constructor stub
	}
int health;
int speed;
Color color = Color.GREEN;
int layers;
int value;
int counter = 0;
@Override
int type() {
	// TODO Auto-generated method stub
	return 1;
}
public void move(double diffSeconds){
	if(counter !=8){
		double dist = distance(x,y,Const.array[counter].x,Const.array[counter].y);
		if(dist <= 5){
			if(counter==7){
				this.isLiving = false;
				Const.health--;

			}
			else{
				counter++;
			}
		}
		GameObjectList collisions = getCollisions(this);
		for(int i=0; i<collisions.size(); i++)
		{
		  GameObject obj = collisions.get(i);
		  
		  int type = obj.type();
		  
		 
		  if(type==Const.TYPE_SPIKE && obj.isLiving)
		  { 
		    hasBeenShot();
		    obj.isLiving = false;
		  }
		  else if(type==Const.TYPE_SHOT && obj.isLiving){
			  hasBeenShot();
			  obj.isLiving = false;
		  }
		  else if(type==Const.TYPE_GLUESHOT && obj.isLiving){
			  super.speed = 50;
			  obj.isLiving = false;
		  }
		}
		this.setDestination(Const.array[counter].x, Const.array[counter].y);
		super.move(diffSeconds);
		
		}
	else {
		this.isLiving = false;
		Const.health-= this.health/100;
		
	}
}
protected double distance(double x1, double y1, double x2, double y2)
{
  double xd = x1-x2;
  double yd = y1-y2;
  return Math.sqrt(xd*xd+yd*yd);
}
public void hasBeenShot() {
	this.health -= 100;
	switch(health){
	case 200: super.color = Color.YELLOW; Const.money += 1; return;
	case 100: super.color = Color.RED; Const.money += 2; return;
	case 0: this.isLiving = false; Const.money +=3; return;
	}
//	if(health<=0)
//	{
//	  this.isLiving=false;
//	  Const.money +=1;
//	  return;
//	}
//	
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
