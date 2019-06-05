import java.util.ArrayList;

import javafx.scene.shape.Line;

import java.awt.Color;

public class World {
	private int lvl = 0;
	private int health = 100;
	private int money = 0;
	 GameObjectList        gameObjects = new GameObjectList();
	private ArrayList<TextObject> textObjects = new ArrayList<TextObject>();
	private static final int FRAME_MINIMUM_MILLIS = 10;
	private  GraphicSystem graphicSystem;
	 private  PhysicsSystem physicsSystem;
	 private  InputSystem   inputSystem;  
	 private  UserInput     userInput;
	  double worldPartX = 0;
	  double worldPartY = 0;
	  private double timePassed = 0;


	
	
	
	protected void init(){
		Balloon b = new Balloon(490, 0,10,100, 5, Color.BLACK);
		gameObjects.add(b);
		
		
	}
	private void LoadLevel(){
		
	}
	
	private void processUserInput(UserInput userInput, double diffseconds){
	
		 
		  if(userInput.keyPressed==(char)27)
		  { System.exit(0);
		  }
		  else if(userInput.isMousePressed && Const.drawTower){
			  Balloon b2 = new Balloon(userInput.mousePressedX,userInput.mousePressedY,0,5, 5, Color.BLACK);
			  
			  gameObjects.add(b2);
		  }
		
	}
	final void run(){
		long lastTick = System.currentTimeMillis();
		while(true){
		
			long currentTick = System.currentTimeMillis();
			  long millisDiff  = currentTick-lastTick;
			  
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
			  	  
			  // create new objects if needed
			  createNewObjects(millisDiff/1000.0);
		}
	}
	private void createNewObjects(double diffSeconds) {
		 final double INTERVAL = Const.SPAWN_INTERVAL;
		  
			timePassed += diffSeconds;
			if(timePassed>INTERVAL)
			{
			  timePassed -= INTERVAL;
			      
			  
			
			      
			  
			  Balloon b = new Balloon(490, 0,10,100, 5, Color.BLACK);
			 
			      
			  // else add zombie to world
			  this.gameObjects.add(b);
			}
		
	}
	  protected PhysicsSystem getPhysicsSystem()       { return physicsSystem; }

	  protected void setGraphicSystem(GraphicSystem p) { graphicSystem = p; }
	  protected void setInputSystem(InputSystem p)     { inputSystem   = p; }

	
}
