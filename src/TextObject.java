
// (c) Thorsten Hasbargen

import java.awt.Color;


public class TextObject
{
  protected static World world;
  
  // yes, public :(
  protected int     x,y;
  protected Color color;
  
  public TextObject(int x_, int y_, Color color_)
  { x=x_; y=y_; color=color_;
  }
  
  public String toString(){
	  String display = "Health: " + Const.health + "\n Money: " + Const.money;
	    return display;
  };
  
  protected static void setWorld(World w){world=w;}
}
