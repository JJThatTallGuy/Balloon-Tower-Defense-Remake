import java.awt.Color;


public class Tower extends GameObject{

public Tower(double x_, double y_, int radius_, Color color_) {
		super(x_, y_, 0, 0, radius_, color_);
		
		
	}
int price = 5;
int shootingSpeed;
int lvl;
double Shootradius = 100;
boolean isShooting = false;
@Override
int type() {
	// TODO Auto-generated method stub
	return 2;
}
public Shot shoot(double x, double y){
	Shot s = new Shot(this.x, this.y, 10, 100);
	s.setDestination(x, y);
	return s;
}

}
