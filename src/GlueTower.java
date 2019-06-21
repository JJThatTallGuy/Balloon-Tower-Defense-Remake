import java.awt.Color;

public class GlueTower extends GameObject{

	public GlueTower(double x_, double y_, int radius_, Color color_) {
		super(x_, y_, 0, 0, radius_, color_);
		
		
	}
	int price = 10;
	int shootingSpeed;
	int lvl;
	double Shootradius = 50;
	boolean hasShot = false;
	@Override
	int type() {
		// TODO Auto-generated method stub
		return 5;
	}
	public GlueShot shoot(double x, double y){
		GlueShot s = new GlueShot(this.x, this.y, 10, 100);
		s.setDestination(x, y);
		return s;
	}

	
}
