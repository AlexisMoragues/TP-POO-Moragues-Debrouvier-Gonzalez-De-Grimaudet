package frontEnd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import backend.game.Tile;
import backend.piece.Piece;
import backend.weapons.Weapon;
import backend.weapons.mageweapon.ArcaneStaff;
import backend.weapons.mageweapon.FireStaff;
import backend.weapons.mageweapon.IceStaff;
import backend.weapons.rangerweapon.Crossbow;
import backend.weapons.rangerweapon.Javelin;
import backend.weapons.rangerweapon.ShortBow;
import backend.weapons.warriorweapon.Halberd;
import backend.weapons.warriorweapon.ShortSword;
import backend.weapons.warriorweapon.Zweihander;
 
public class VisualBoard extends JPanel  {
	
  JLayeredPane layeredPane;
  
  JPanel board;
   Map<Class<? extends Weapon>,ImageIcon> Player1images=new HashMap<Class<? extends Weapon>,ImageIcon>();
  Map<Class<? extends Weapon>,ImageIcon> Player2images=new HashMap<Class<? extends Weapon>,ImageIcon>();
  
  ImageIcon player1ShortBow = new ImageIcon("res/Archer.png");
  ImageIcon player1CrossBow = new ImageIcon("res/Crossbowman.png");
  ImageIcon player1Javelin = new ImageIcon("res/Javelin.png");
  ImageIcon player1FireMage = new ImageIcon("res/Fire Mage.png");
  ImageIcon player1IceMage = new ImageIcon("res/Ice Mage.png");
  ImageIcon player1ArcaneMage = new ImageIcon("res/Arcane Mage.png");
  ImageIcon player1SwordWarrior = new ImageIcon("res/Warrior wSword.png");
  ImageIcon player1HalberdWarrior = new ImageIcon("res/Warrior wHalberd.png");
  ImageIcon player1LongSwordWarrior = new ImageIcon("res/Warrior wLong Sword.png");
  

  private Color backgroundColor;
  private int width;
  private int height;
  
  public VisualBoard(int width, int height) {
	  Dimension boardSize = new Dimension(500, 500);
	 
	  this.width = width;
	  this.height = height;
	  layeredPane = new JLayeredPane();
	  this.add(layeredPane);
	  layeredPane.setPreferredSize(boardSize);

	  
	
	 
	  board = new JPanel();
	  layeredPane.add(board, JLayeredPane.DEFAULT_LAYER);
	  board.setLayout( new GridLayout(height, width) );
	  board.setPreferredSize( boardSize );
	  board.setBounds(0, 0, boardSize.width, boardSize.height);
	 
	  for (int i = 0; i < width*height; i++) {
		  
	  		  JPanel square = new JPanel( new BorderLayout() );
			  board.add( square );
			  square.setBorder(BorderFactory.createLineBorder(Color.black));
	  		
	  	}
	  backgroundColor=null;
	  
	  Player1images.put(ShortSword.class, player1SwordWarrior);
	  Player1images.put(Halberd.class, player1HalberdWarrior);
	  Player1images.put(Zweihander.class, player1LongSwordWarrior);
	  Player1images.put(FireStaff.class, player1FireMage);
	  Player1images.put(IceStaff.class, player1IceMage);
	  Player1images.put(ArcaneStaff.class, player1ArcaneMage);
	  Player1images.put(ShortBow.class, player1ShortBow);
	  Player1images.put(Crossbow.class, player1CrossBow);
	  Player1images.put(Javelin.class, player1Javelin);
	  
	 
	   
  }
  
  
  public void removePiece(int position){
	  
	  
	  JPanel panel = (JPanel)board.getComponent(position);
	  panel.removeAll();
	  
	  
  }

  public void updatePiece(Piece piece) {
	  if(piece.getHealth()>0){
		  addPiece(piece, piece.getPosition());
	  }
}

private void addPiece(Piece piece, Tile position) {

	if(piece.getTeam() == 1){
		ImageIcon imagePiece = Player1images.get(piece.getWeapon().getClass());
		JLabel pieceImage = new JLabel(imagePiece);
		JPanel panel = (JPanel)board.getComponent(coordinatesToInt(position));
		panel.add(pieceImage);
	}
	else if(piece.getTeam() == 2){
		ImageIcon imagePiece = Player1images.get(piece.getWeapon().getClass());
		JLabel pieceImage = new JLabel(imagePiece);
		JPanel panel = (JPanel)board.getComponent(coordinatesToInt(position));
		panel.add(pieceImage);
		}
}

public int coordinatesToInt(Tile position) {
	return position.getPositionX()*width+position.getPositionY();
	
}

public void updateBackground(int position, Color color){
	 JPanel panel = (JPanel)board.getComponent(position);
	 panel.setBackground(color);
}

public void updateCursor(int position) { 
	 updateBackground(position, Color.green);
}

public void removeColor(int position) {
	updateBackground(position, backgroundColor);
}

public JPanel getBoard(){
	return this.board;
}

  
}