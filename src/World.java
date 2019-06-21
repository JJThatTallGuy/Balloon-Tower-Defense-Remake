import java.util.ArrayList;

import javafx.scene.shape.Line;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Area;

public class World {
	public int lvl = 0;
	GameObjectList gameObjects = new GameObjectList();
	private ArrayList<TextObject> textObjects = new ArrayList<TextObject>();
	public ArrayList<Balloon> balloons = new ArrayList<Balloon>();
	public  ArrayList<Tower> towers = new ArrayList<Tower>();
	public ArrayList<GlueTower> gluetowers = new ArrayList<GlueTower>();
	public  ArrayList<Spike> spikes = new ArrayList<Spike>();

	private static final int FRAME_MINIMUM_MILLIS = 10;
	private  GraphicSystem graphicSystem;
	private  PhysicsSystem physicsSystem;
	private  InputSystem   inputSystem;  
	private  UserInput     userInput;
	double worldPartX = 0;
	double worldPartY = 0;
	private double timePassed = 0;
	private double timePassed2 = 0;
	public long millisDiff;
	
	protected void init(){
	    TextObject to = new TextObject(20,40, Color.BLACK);
	    textObjects.add(to);

	}

	//method checks if the tower will intersect any of the rectangles that make up the road
	private boolean intersection(Tower t){
		Rectangle2D[] rArray = {new Rectangle2D.Double(480, 0, 20, 150),
		  new Rectangle2D.Double(330, 140, 130, 20),
		  new Rectangle2D.Double(330, 140, 20, 150),
		  new Rectangle2D.Double(330, 290, 300, 20),
		  new Rectangle2D.Double(630, 290, 20, 220),
		  new Rectangle2D.Double(500, 490 , 150, 20),
		  new Rectangle2D.Double(500, 490, 20, 130)};
		//Ellipse2D e = new Ellipse2D.Double(t.x, t.y, t.radius, t.radius);
		Point p = new Point((int)t.x, (int)t.y);
		for(int i =0; i< rArray.length; i++){
			if(rArray[i].contains(p) == true){
				return true;
			}
		}
		return false;
	}
	private boolean intersection(GlueTower t){
		Rectangle2D[] rArray = {new Rectangle2D.Double(480, 0, 20, 150),
		  new Rectangle2D.Double(330, 140, 130, 20),
		  new Rectangle2D.Double(330, 140, 20, 150),
		  new Rectangle2D.Double(330, 290, 300, 20),
		  new Rectangle2D.Double(630, 290, 20, 220),
		  new Rectangle2D.Double(500, 490 , 150, 20),
		  new Rectangle2D.Double(500, 490, 20, 130)};
		//Ellipse2D e = new Ellipse2D.Double(t.x, t.y, t.radius, t.radius);
		Point p = new Point((int)t.x, (int)t.y);
		for(int i =0; i< rArray.length; i++){
			if(rArray[i].contains(p) == true){
				return true;
			}
		}
		return false;
	}
	
	private void processUserInput(UserInput userInput, double diffseconds){
	
		 
		  if(userInput.keyPressed==(char)27)
		  { System.exit(0);
		  }
		  else if(userInput.isMousePressed && Const.drawTower && Const.money >= 5){
			  Tower t = new Tower(userInput.mousePressedX,userInput.mousePressedY, 20, Color.BLACK);
			  if(intersection(t)==false){
				  //only adds tower to gameObjects if it's not intersecting
				  gameObjects.add(t);
				  towers.add(t);
				  Const.drawTower = false;
				  Const.money -= t.price;
			  }
		  }
		  else if(userInput.isMousePressed && Const.drawSpike && Const.money >=3){
			  Spike s = new Spike(userInput.mousePressedX,userInput.mousePressedY, 5, Color.BLACK);
			  gameObjects.add(s);
			  spikes.add(s);
			  Const.drawSpike = false;
			  
			  Const.money -= 3;
		  }
		  else if(userInput.isMousePressed && Const.drawGlue && Const.money >=10){
			  GlueTower gt = new GlueTower(userInput.mousePressedX,userInput.mousePressedY, 20, Color.CYAN);
			  if(intersection(gt)==false){
				  //only adds tower to gameObjects if it's not intersecting
				  gameObjects.add(gt);
				  gluetowers.add(gt);
				  Const.drawGlue = false;
				  Const.money -= gt.price;
			  }
		  }
		
	}
	final void run(){
		long lastTick = System.currentTimeMillis();
		while(true){
			if((Const.health <= 0) || (lvl == Const.levels.size() && balloons.isEmpty())){
				Const.gameOver = true;
			}
			 if(Const.gameOver) { continue;}
			long currentTick = System.currentTimeMillis();
			  this.millisDiff  = currentTick-lastTick;
			  
			  if(millisDiff<FRAME_MINIMUM_MILLIS)
			  {
			    try{ Thread.sleep(FRAME_MINIMUM_MILLIS-millisDiff);} catch(Exception ex){}
				currentTick = System.currentTimeMillis();
				millisDiff  = currentTick-lastTick;
			  }
			  
			  lastTick = currentTick;
			  
			// process User Input
			  userInput = inputSystem.getUserInput();
			  processUserInput(userInput,millisDiff/1000.0);
			  userInput.clear();

			  
			  // move all Objects, maybe collide them etc...
			  int gameSize = gameObjects.size();
			  for(int i=0; i<gameSize; i++)
			  { 
		        GameObject obj = gameObjects.get(i);
		        if(obj.isLiving)  obj.move(millisDiff/1000.0);
			  }
			  
			  
		      // delete all Objects which are not living anymore
		      int num=0;
		      while(num<gameSize)
		      {
		        if(gameObjects.get(num).isLiving==false)
		        { gameObjects.remove(num);
		          gameSize--;
		        }
		        else
		        { num++;
		        }
		      }	  
		      int num2=0;
		      int balloonSize = balloons.size();
		      //System.out.println(balloonSize);
		      while(num2<balloonSize)
		      {
		        if(balloons.get(num2).isLiving==false)
		        { balloons.remove(num2);
		          balloonSize--;
		        }
		        else
		        { num2++;
		        }
		      }	 
		        
			  // draw all Objects
			  graphicSystem.clear();
			  graphicSystem.drawLine(480, 0, 500, 150);
			  graphicSystem.drawLine(330, 140, 500, 160);
			  graphicSystem.drawLine(330, 140, 350, 290);
			  graphicSystem.drawLine(330, 290, 630, 310);
			  graphicSystem.drawLine(630, 290, 650, 510);
			  graphicSystem.drawLine(500, 490 , 650, 510);
			  graphicSystem.drawLine(500, 490, 520, 720);
			  for(int i=0; i<gameSize; i++)
			  {  
				graphicSystem.draw(gameObjects.get(i));
			  }

			  
			  // draw all TextObjects
			  for(int i=0; i<textObjects.size(); i++)
			  { graphicSystem.draw(textObjects.get(i));
			  }
			
			  // redraw everything
			  graphicSystem.redraw();
			  //if(Const.levels.get(lvl).length == balloons.size()){
				  //Const.canStart = false;
			  //}
			  
			  // create new objects if needed
			  //if(Const.canStart && balloons.isEmpty()){
				  
				  //createNewObjects(millisDiff/1000.0);
				  //lvl++;
				  //Const.canStart = false;
			  //}
			  for(int i =0; i< towers.size(); i++){
				  Tower t = towers.get(i);
				  double TowerX = towers.get(i).x;
				  double TowerY = towers.get(i).y;
				  double TowerRadius = towers.get(i).Shootradius;
				  for(int j=0; j<balloons.size(); j++){
					  if(distance(TowerX, TowerY, balloons.get(j).x, balloons.get(j).y) < TowerRadius){
						  	if(t.isShooting == false){
						  		createShots(t, TowerX, TowerY, balloons.get(j).x, balloons.get(j).y);
						  	}
					  }
				  }
			  }
			  for(int i =0; i< gluetowers.size(); i++){

				  GlueTower t = gluetowers.get(i);
				  double TowerX = gluetowers.get(i).x;
				  double TowerY = gluetowers.get(i).y;
				  double TowerRadius = gluetowers.get(i).Shootradius;
				  for(int j=0; j<balloons.size(); j++){
					  if(distance(TowerX, TowerY, balloons.get(j).x, balloons.get(j).y) < TowerRadius){
						  	if(t.hasShot == false){
						  		createShots(t, TowerX, TowerY, balloons.get(j).x, balloons.get(j).y);
						  		//t.hasShot = true;
						  	}
					  }
				  }
			  }
		}
	}
	private void createShots(Tower t, double towerX, double towerY, double x, double y) {
  		t.isShooting = true;
		final double INTERVAL = Const.SHOT_INTERVAL;
		int i = 0;
		while(i<6){
			 System.out.println("");
			timePassed2 += millisDiff/1000.0;
			if(timePassed2 >= INTERVAL){
				Shot s = t.shoot(x, y);
				gameObjects.add(s);
				timePassed2=0;
				i++;
			}
		}
  		t.isShooting = false;


	}
	private void createShots(GlueTower t, double towerX, double towerY, double x, double y) {
		final double INTERVAL = Const.SHOT_INTERVAL;
		int i = 0;
		while(i<6){
			 System.out.println("");
			timePassed2 += millisDiff/1000.0;
			if(timePassed2 >= INTERVAL){
				GlueShot s = t.shoot(x, y);
				gameObjects.add(s);
				timePassed2=0;
				i++;
			}
		}

	}
	public void createNewObjects(double diffSeconds) {
		 final double INTERVAL = Const.SPAWN_INTERVAL;
		 Balloon[] b = Const.levels.get(lvl);
		 int i = 0;
		 while(i < b.length){
			 System.out.println("");
			 timePassed += millisDiff/1000.0;
			 if(timePassed >= INTERVAL){
				 gameObjects.add(b[i]);
				 balloons.add(b[i]);
				 timePassed=0;
				 i++;
			 }
		 }
		
	}
	  protected PhysicsSystem getPhysicsSystem()       { return physicsSystem; }

	  protected void setGraphicSystem(GraphicSystem p) { graphicSystem = p; }
	  protected void setInputSystem(InputSystem p)     { inputSystem   = p; }
	  protected double distance(double x1, double y1, double x2, double y2)
	  {
	    double xd = x1-x2;
	    double yd = y1-y2;
	    return Math.sqrt(xd*xd+yd*yd);
	  }
	
}
