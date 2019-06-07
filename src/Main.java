

public class Main 
	{
	  private World world = null;
	  
	  public Main()
	  { 
		Frame frame = new Frame();
	    frame.displayOnScreen();
	    
	    world = new World();
	    
	    world.setGraphicSystem(frame.getGraphicSystem());
	    world.setInputSystem(frame.getInputSystem());
	    
	    GameObject.setWorld(world);
	    TextObject.setWorld(world);
	    frame.getGraphicSystem().setWorld(world);
	    frame.setWorld(world);
	    
	    world.init();
	    world.run();
	  }
		
	  public static void main(String[] args)
	  { new Main();
	  }
	}

