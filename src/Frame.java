import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Frame extends JFrame{

	  // ...ok...
	  private static final long serialVersionUID = 2L;
	  private Panel panel = null;	

	  public Frame()
	  { this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(Const.WORLD_WIDTH+100,Const.WORLD_HEIGHT+100);
		
		this.setAlwaysOnTop(true);
		this.setUndecorated(true);
		
		this.setResizable(false);
		
		panel = new Panel();
		
		// needed for Keyboard input !!!
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		
		this.setContentPane(panel);
		//Do not remove
		this.setLayout(null);
		Button b = new Button("Button");
		b.setBounds(1000, 50,50,30);
		//Also do not remove
		b.setFocusable(false);
		this.add(b);
		b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					Const.drawTower = !Const.drawTower;		
				
			}
			
		});
	  }
	  
	  public void displayOnScreen() { validate(); setVisible(true); }
	  
	  public GraphicSystem getGraphicSystem() { return panel; }
	  public InputSystem   getInputSystem()   { return panel.getInputSystem(); }
}
