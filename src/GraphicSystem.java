

interface GraphicSystem 
{
   void drawLine(int x1, int x2, int y1, int y2);
  // prepare to draw a new Screen
  void clear();
  
  // draw ONE GameObject on the Screen
  void draw(GameObject dot);
 
  // draw ONE TextObject on the Screen
  void draw(TextObject obj);
  
  // display the completed Screen
  void redraw();
  
  // set world
  void setWorld(World world);  
  
  void drawTower(GameObject dot);
}
