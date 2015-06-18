package frontEnd;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * Frame Principal del juego 
 */
public  class GameView extends JFrame{
	
	private IntroView introPanel;
	private MatchView matchPanel;
	private SelectScreenView selectScreen;
	
	public GameView(){		
		requestFocusInWindow();
		setTitle("Water Insignia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		setSize((int)width,(int)height);
		setResizable(false);
		
		setVisible(true);

	    introPanel= new IntroView(this.getContentPane().getSize());
		this.add(introPanel);
	    introPanel.setVisible(true);
		introPanel.repaint();
		
		selectScreen= new SelectScreenView();
		selectScreen.setVisible(false);
		this.add(selectScreen);
		selectScreen.repaint();
		
		matchPanel = new MatchView(15,15);
		matchPanel.setVisible(false);
		add(matchPanel);
		matchPanel.repaint();
			
	    repaint();
	}
	
	public void newMatchPanel(int width, int height){
		remove(matchPanel);
		matchPanel = new MatchView(width,height);
		add(matchPanel);
		matchPanel.revalidate();		
	}
	
	public IntroView getIntroPanel() {
		return this.introPanel;
	}

	public MatchView getMatchPanel() {
		return this.matchPanel;
	}
	
	public SelectScreenView getSelectScreenPanel() {
		return this.selectScreen;
	}
	
	 
	
}