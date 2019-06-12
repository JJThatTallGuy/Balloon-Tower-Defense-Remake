import java.util.ArrayList;

import javafx.scene.shape.Line;

import java.awt.Color;

public class World {
	public int lvl = 0;
	GameObjectList gameObjects = new GameObjectList();
	private ArrayList<TextObject> textObjects = new ArrayList<TextObject>();
	public ArrayList<Balloon> balloons = new ArrayList<Balloon>();
	public  ArrayList<Tower> towers = new ArrayList<Tower>();
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
		//Balloon b = new Balloon(490, 0,10,100, 5, Color.BLACK);
		//gameObjects.add(b);
	    TextObject to = new TextObject(20,40, Color.BLACK);
	    textObjects.add(to);

	}
	private void LoadLevel(){
		
	}
	
	private void processUserInput(UserInput userInput, double diffseconds){
	
		 
		  if(userInput.keyPressed==(char)27)
		  { System.exit(0);
		  }
		  else if(userInput.isMousePressed && Const.drawTower && Const.money >= 5){
			  Tower t = new Tower(userInput.mousePressedX,userInput.mousePressedY, 20, Color.BLACK);
			  gameObjects.add(t);
			  towers.add(t);
			  Const.drawTower = false;
			  Const.money -= t.price;
		  }
		
		
	}
	final void run(){
		long lastTick = System.currentTimeMillis();
		while(true){
		
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
		      //System.out.println(balloonSize);

		      
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
			  { graphicSystem.draw(gameObjects.get(i));
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
			  if(Const.canStart && balloons.isEmpty()){
				  
				  //createNewObjects(millisDiff/1000.0);
				  //lvl++;
				  Const.canStart = false;
			  }
			  for(int i =0; i< towers.size(); i++){
				  Tower t = towers.get(i);
				  double TowerX = towers.get(i).x;
				  double TowerY = towers.get(i).y;
				  double TowerRadius = towers.get(i).Shootradius;
				  for(int j=0; j<balloons.size(); j++){
					  if(distance(TowerX, TowerY, balloons.get(j).x, balloons.get(j).y) < TowerRadius){
						  	if(t.hasShot == false){
						  		createShots(t, TowerX, TowerY, TowerRadius, balloons.get(j).x, balloons.get(j).y, millisDiff/1000.0);
						  		t.hasShot = true;
						  	}
						  	
					  }
				  }
			  }
		}
	}
	private void createShots(Tower t, double towerX, double towerY, double towerRadius, double x, double y, double d) {
		int i =0;
		while(i<10){
			timePassed2 += millisDiff/1000.0;
			if(timePassed2>= Const.SHOT_INTERVAL){
				Shot s = t.shoot(x, y);
				gameObjects.add(s);
				timePassed2=0;
				i++;
				System.out.println(i);
			}
		}
		
	}
	public void createNewObjects(double diffSeconds) {
		 final double INTERVAL = Const.SPAWN_INTERVAL;
		 Balloon[] b = Const.levels.get(lvl);
		 gameObjects.add(b[0]);
		 balloons.add(b[0]);
		 int i = 1;
		 while(i < b.length){
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
