
// (c) Thorsten Hasbargen


final class UserInput 
{
  // everything a user can press on keyboard or mouse	
  int mousePressedX, mousePressedY, 
      mouseMovedX,   mouseMovedY, mouseButton;
  
  char keyPressed;
  
  // if Mouse was clicked, Key was pressed or Mouse is still hold down
  boolean isMouseEvent, isKeyEvent, isMousePressed; 
  
  // ... is returned as a data set
  UserInput()
  { this.clear();
  }
  
  final void clear()
  { isMouseEvent=false; isKeyEvent=false;
  }
}
