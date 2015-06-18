package frontEnd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import backend.SelectScreen;
import backend.piece.Mage;
import backend.piece.Ranger;
import backend.piece.Warrior;
import backend.weapons.mageweapon.ArcaneStaff;
import backend.weapons.mageweapon.FireStaff;
import backend.weapons.mageweapon.IceStaff;
import backend.weapons.rangerweapon.Crossbow;
import backend.weapons.rangerweapon.Javelin;
import backend.weapons.rangerweapon.ShortBow;
import backend.weapons.warriorweapon.Halberd;
import backend.weapons.warriorweapon.ShortSword;
import backend.weapons.warriorweapon.Zweihander;

public class SelectScreenController {

	private SelectScreen screenModel;
	private GameView view;
	private int width;
	private int height;
	
	public SelectScreenController(SelectScreen screenModel, GameView view, int width, int height){
		this.screenModel=screenModel;
		this.view=view;
		this.view.getSelectScreenPanel().addFireStaffListener(new FireStaffListener());
		this.view.getSelectScreenPanel().addIceStaffListener(new IceStaffListener());
		this.view.getSelectScreenPanel().addArcaneStaffListener(new ArcaneStaffListener());
		
		this.view.getSelectScreenPanel().addShortSwordListener(new ShortSwordListener());
		this.view.getSelectScreenPanel().addHalberdListener(new HalberdListener());
		this.view.getSelectScreenPanel().addZweihanderListener(new ZweihanderListener());
		
		this.view.getSelectScreenPanel().addShortBowListener(new ShortBowListener());
		this.view.getSelectScreenPanel().addCrossbowListener(new CrossbowListener());
		this.view.getSelectScreenPanel().addJavelinListener(new JavelinListener());
		
		
		this.view.getSelectScreenPanel().addDoneListener(new DoneListener());
		
		updateSelectScreen();
		
		this.height=height;
		this.width=width;
	}
	
	class ShortSwordListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
			screenModel.buyPiece(new Warrior(screenModel.getPlayerTurn(), new ShortSword(), null));
			view.requestFocusInWindow();
			updateSelectScreen();
		}

	}
	
	class FireStaffListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
			screenModel.buyPiece(new Mage(screenModel.getPlayerTurn(), new FireStaff(), null));
			view.requestFocusInWindow();
			updateSelectScreen();
		}
		
	}
	
	class IceStaffListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			screenModel.buyPiece(new Mage(screenModel.getPlayerTurn(), new IceStaff(), null));
			view.requestFocusInWindow();
			updateSelectScreen();
		}
		
	}
	
	class ShortBowListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
			screenModel.buyPiece(new Ranger(screenModel.getPlayerTurn(), new ShortBow(), null));
			view.requestFocusInWindow();
			updateSelectScreen();
		}
		
	}
	
	class CrossbowListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
			screenModel.buyPiece(new Ranger(screenModel.getPlayerTurn(), new Crossbow(), null));
			view.requestFocusInWindow();
			updateSelectScreen();
		}
		
	}
	
	
	class ArcaneStaffListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
			screenModel.buyPiece(new Mage(screenModel.getPlayerTurn(), new ArcaneStaff(), null));
			view.requestFocusInWindow();
			updateSelectScreen();
		}
		
	}
	
	
	class JavelinListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
			screenModel.buyPiece(new Ranger(screenModel.getPlayerTurn(), new Javelin(), null));
			view.requestFocusInWindow();
			updateSelectScreen();
		}
		
	}
	
	class ZweihanderListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
			screenModel.buyPiece(new Warrior(screenModel.getPlayerTurn(), new Zweihander(), null));
			view.requestFocusInWindow();
			updateSelectScreen();
		}
		
	}
	
	class HalberdListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
			screenModel.buyPiece(new Warrior(screenModel.getPlayerTurn(), new Halberd(), null));
			view.requestFocusInWindow();
			updateSelectScreen();
		}
		
	}
	
		
	class DoneListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if(screenModel.done()){
				view.getSelectScreenPanel().setVisible(false);
				new MatchController(screenModel.getPlayerPieces(), view, width, height);
			}
			updateSelectScreen();
			view.requestFocusInWindow();
		}
	}
	
	private void updateSelectScreen() {
		view.getSelectScreenPanel().printCurrentPlayer("Current Player: "+screenModel.getPlayerTurn());
		view.getSelectScreenPanel().printResources("Resources: "+screenModel.getPlayerPlaying().getResources());
	}
	
	
}
