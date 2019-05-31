

public class Main 
	{
	  private World world = null;
	  
	  public Main()
	  { 
		Frame frame = new Frame();
	    frame.displayOnScreen();
	    
	    world = new World();
	    
	    world.setGraphicSystem(frame.getGraphicSystem());
	    world.setInputSystem(frame.getGraphicSystem());
	    
	    GameObject.setPhysicsSystem(world.getPhysicsSystem());
	    GameObject.setWorld(world);
	    TextObject.setWorld(world);
	    
	    world.init();
	    world.run();
	  }
		
	  public static void main(String[] args)
	  { new Main();
	  }
	}

