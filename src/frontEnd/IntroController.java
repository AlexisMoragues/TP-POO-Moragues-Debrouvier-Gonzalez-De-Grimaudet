package frontEnd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import backend.SelectScreen;

/**
 * Controlador del inicio que tiene a la view y al panel introPanel con la imagen de fondo.
 */
public class IntroController {

	private GameView gameView;
	
	public IntroController (String winningText){
		this.gameView=new GameView();
		gameView.getIntroPanel().addmatch10x10(new Board10x10Listener());
		gameView.getIntroPanel().addmatch15x15(new Board15x15Listener());
		gameView.getIntroPanel().addmatch20x20(new Board20x20Listener());
		gameView.getIntroPanel().printWhoWon(winningText);
		gameView.repaint();
		}

	class Board15x15Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			createNewMatch(15,15,15);
		}
	}
	
	class Board10x10Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			createNewMatch(10,12,12);
		}
	}
	
	
	class Board20x20Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			createNewMatch(20,20,20);
		}
	}
 
	
	private void createNewMatch(int gold, int width, int height) {
		gameView.getIntroPanel().setVisible(false);
		gameView.getSelectScreenPanel().setVisible(true);
		SelectScreen screenModel = new SelectScreen(gold);
		new SelectScreenController(screenModel, gameView, width, height);
	}

}