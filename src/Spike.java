import java.awt.Color;

public class Spike extends GameObject{
	int health = 100;
	public Spike(double x_, double y_, int radius_, Color color_) {
		super(x_, y_, 0, 0, radius_, color_);
		// TODO Auto-generated constructor stub
	}

	@Override
	int type() {
		// TODO Auto-generated method stub
		return 4;
	}
	public void hasHit(){
		
	}
	
	
	


}
