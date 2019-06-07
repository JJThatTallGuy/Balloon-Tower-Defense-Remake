import java.awt.Color;

public class Balloon extends GameObject{
public Balloon(double x_, double y_, double a_, double s_, int radius_, Color color) {
		super(x_, y_, a_, s_, radius_, color);
		// TODO Auto-generated constructor stub
	}
int health;
int speed;
Color color;
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
			}
			else{
				counter++;
			}
		}
		this.setDestination(Const.array[counter].x, Const.array[counter].y);
		super.move(diffSeconds);

		}
	else {
		this.isLiving = false;
		
	}
}
protected double distance(double x1, double y1, double x2, double y2)
{
  double xd = x1-x2;
  double yd = y1-y2;
  return Math.sqrt(xd*xd+yd*yd);
}
}
