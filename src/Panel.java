
// (c) Thorsten Hasbargen


import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;



class Panel extends JPanel implements GraphicSystem
{
  // constants
  private static final long serialVersionUID = 1L;
  private static final Font font = new Font("Arial",Font.PLAIN,24);

  
  // InputSystem is an external instance
  private InputSystem inputSystem = new InputSystem();
  private World       world       = null;

	
  // GraphicsSystem variables
  //
  private GraphicsConfiguration graphicsConf = 
    GraphicsEnvironment.getLocalGraphicsEnvironment().
    getDefaultScreenDevice().getDefaultConfiguration();
  private BufferedImage imageBuffer;
  private Graphics      graphics;

  
	
  public Panel()
  { 
	this.setSize(Const.WORLD_WIDTH,Const.WORLD_HEIGHT);  
	imageBuffer = graphicsConf.createCompatibleImage(
			        this.getWidth(), this.getHeight());	 
	graphics = imageBuffer.getGraphics();
	
	// initialize Listeners
	this.addMouseListener(inputSystem);
	this.addMouseMotionListener(inputSystem);
	this.addKeyListener(inputSystem);
  }
  
  public void clear()
  { graphics.setColor(Color.LIGHT_GRAY);
    graphics.fillRect(
               0, 0,Const.WORLD_WIDTH,Const.WORLD_HEIGHT);
  }
  
  public final void drawLine(int x1, int y1, int x2, int y2){
	  graphics.setColor(Color.ORANGE);
	  graphics.fillRect(x1, y1, x2-x1, y2-y1);
	  //graphics.drawLine(x1, y1, x2, y2);

  }

  public final void draw(GameObject dot)
  {	  
	int x = (int)(dot.x-dot.radius-world.worldPartX);
	int y = (int)(dot.y-dot.radius-world.worldPartY);
	int d = (int)(dot.radius*2);
	
	graphics.setColor(dot.color);
	graphics.fillOval(x, y, d, d);
	graphics.setColor(Color.DARK_GRAY);
	graphics.drawOval(x,y,d,d);
	
  }
  public final void drawTower(GameObject dot){
	  int x = (int)(dot.x-dot.radius-world.worldPartX);
	  int y = (int)(dot.y-dot.radius-world.worldPartY);
	  int d = (int)(dot.radius*2);
	  File classPathInput = null;
	  if(dot.type() == 2){
		  classPathInput = new File(Panel.class.getResource("/image.png").getFile());
	  }
	  else if(dot.type() ==5){
		  classPathInput = new File(Panel.class.getResource("/image2.png").getFile());
	  }
	  else{
		  classPathInput = new File(Panel.class.getResource("/spike.png").getFile());
	  }
      BufferedImage classpathImage = null;
	try {
		classpathImage = ImageIO.read(classPathInput);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		graphics.drawImage(classpathImage, x, y, d, d*2, null);
  }
  public final void draw(TextObject text)
  {	  
    graphics.setFont(font);
    graphics.setColor(Color.DARK_GRAY);
    graphics.drawString(text.toString(), (int)text.x+1, (int)text.y+1);    
    graphics.setColor(text.color);
    graphics.drawString(text.toString(), (int)text.x, (int)text.y);
  }
  
  
  public void redraw()
  { this.getGraphics().drawImage(imageBuffer, 0, 0, this);
  }
  
  public final InputSystem getInputSystem() { return inputSystem; }
  public final void setWorld(World world_)  {this.world = world_;}
}

