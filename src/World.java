import java.util.ArrayList;

import javafx.scene.shape.Line;

import java.awt.Color;

public class World {
	private int lvl = 1;
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

	
	
	
	protected void init(){
		Balloon b = new Balloon(20,20,0,5, 5, Color.BLACK);
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
			  for(int i=0; i<gameSize; i++)
			  { graphicSystem.draw(gameObjects.get(i));
			  }

			  
			  // draw all TextObjects
			  for(int i=0; i<textObjects.size(); i++)
			  { graphicSystem.draw(textObjects.get(i));
			  }
			  graphicSystem.drawLine(200, 200, 300, 225, 5);
				
			  // redraw everything
			  graphicSystem.redraw();
			  	  
			  // create new objects if needed
			  createNewObjects(millisDiff/1000.0);
		}
	}
	private void createNewObjects(double d) {
		// TODO Auto-generated method stub
		
	}
	  protected PhysicsSystem getPhysicsSystem()       { return physicsSystem; }

	  protected void setGraphicSystem(GraphicSystem p) { graphicSystem = p; }
	  protected void setInputSystem(InputSystem p)     { inputSystem   = p; }

	
}
