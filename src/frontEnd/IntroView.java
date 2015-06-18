package frontEnd;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel con la imagen de inicio y los botones de seleccion board.
 */
public class IntroView extends JPanel{

	   private Image image;
	   private JButton match12x12;
	   private JButton match15x15;
	   private JButton match20x20;
	   private JLabel whoWon;	  

	    public IntroView(Dimension dimension) {
	    	Dimension size = dimension.getSize();
	    	this.setSize(dimension);	    	
	    	this.setLayout(null);
	    	match12x12 = new JButton("12x12");
	    	match15x15 = new JButton("15x15");
	    	match20x20 = new JButton("20x20");
	    
	    	match12x12.setBounds(size.width/2 - 280, 1, 180, 90);
	    	match15x15.setBounds(size.width/2 - 90, 1, 180, 90);
	     	match20x20.setBounds(size.width/2 + 100, 1, 180, 90);
	     	
	     	whoWon = new JLabel("");
			whoWon.setBounds((size.width/2)-150, 301, 200 , 90);
	    	
	    	try {                
		          image = ImageIO.read(new File("res/WaterInsignia.jpg"));
		          // Scale Down the original image fast
		          Image scaledImage = image.getScaledInstance(1280, 720, Image.SCALE_FAST);
		          image = scaledImage;
		          } catch (IOException e) {
		            System.out.println(e.getMessage());
		       }
    	
	    	this.add(match12x12);
	    	this.add(match15x15);
	    	this.add(match20x20);	
	    	this.add(whoWon);

	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	    	super.paintComponent(g);
	        g.drawImage(image, 0, 0, null);             
	    }
	    
	    void addmatch10x10(ActionListener match10x10listener){
			
			match12x12.addActionListener(match10x10listener);	
		}
	    
	    
	    void addmatch15x15(ActionListener match15x15listener){
			
			match15x15.addActionListener(match15x15listener);	
		}
	    
	    
		void addmatch20x20(ActionListener match20x20listener){
			
			match20x20.addActionListener(match20x20listener);	
		}

		public void printWhoWon(String text) {
			whoWon.setText("<HTML><h1><font color=BLUE>"+text+"</font></h1></HTML>");
		} 
	 
		
	    

	    
	    
}
