import java.awt.Button;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Frame extends JFrame{

	  // ...ok...
	  private static final long serialVersionUID = 2L;
	  private Panel panel = null;
	  private World world = null;

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
		Button b = new Button("Tower");
		b.setBounds(1000, 50,50,30);
		Button start = new Button("Start");
		start.setBounds(1000, 20, 50, 30);
		Button spike = new Button("Spike");
		spike.setBounds(1000, 80, 50, 30);
		Button g = new Button("GlueTower");
		g.setBounds(980, 110, 70, 30);
		//Also do not remove
		b.setFocusable(false);
		start.setFocusable(false);
		spike.setFocusable(false);
		g.setFocusable(false);
		this.add(b);
		this.add(start);
		this.add(spike);
		this.add(g);
		b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					Const.drawTower = !Const.drawTower;		
				
			}
			
		});
		start.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//Const.canStart = true;
				if(world.balloons.isEmpty()){
				world.createNewObjects(world.millisDiff/1000.0);
				world.lvl++;
				for(int i =0 ; i < world.towers.size(); i++){
					world.towers.get(i).isShooting = false;
				}
				}
			}
		});
		spike.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					Const.drawSpike = !Const.drawSpike;	
				
			}
			
		});
		g.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					Const.drawGlue = !Const.drawGlue;	
				
			}
			
		});

	  }
	  
	  public void displayOnScreen() { validate(); setVisible(true); }
	  
	  public GraphicSystem getGraphicSystem() { return panel; }
	  public InputSystem   getInputSystem()   { return panel.getInputSystem(); }
	  public final void setWorld(World world_) {this.world = world_;}
}
