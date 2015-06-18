package frontEnd;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import backend.piece.Mage;
import backend.piece.Piece;
import backend.piece.Ranger;
import backend.piece.Warrior;
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


public class SelectScreenView extends JPanel{
	
	private JPanel buttonPanel = new JPanel();

	private JLabel currentPlayer;
	private JLabel resources;
	private JButton doneButton;
	
	/*
	 * Warrior Buttons
	 */
	private JButton shortSwordButton;
	private JLabel shortSwordDescription = new JLabel();
	private JButton halberdButton;
	private JLabel halberdDescription= new JLabel();
	private JButton zweihanderButton;
	private JLabel zweihanderDescription = new JLabel();

	
	/*
	 * Mage Buttons
	 */
	private JButton fireStaffButton;
	private JLabel fireStaffDescription= new JLabel();
	private JButton iceStaffButton;
	private JLabel iceStaffDescription= new JLabel();
	private JButton arcaneStaffButton;
	private JLabel arcaneStaffDescription= new JLabel();

	
	/*
	 * Ranger Buttons
	 */
	private JButton shortBowButton;
	private JLabel shortBowDescription= new JLabel();
	private JButton crossbowButton;
	private JLabel crossbowDescription= new JLabel();
	private JButton javelinButton;
	private JLabel javelinDescription= new JLabel();

	
	public SelectScreenView(){
						
		setLayout(new FlowLayout());
		setSize(1280, 720);
		Dimension size = getSize();
		
		shortSwordButton = new JButton("ShortSword Warrior");
		shortSwordButton.setBounds(size.width/2 - 290, 1, 180, 90);
		halberdButton = new JButton("Halberd Warrior");
		halberdButton.setBounds(size.width/2 - 290, 101, 180, 90);
		zweihanderButton = new JButton("Zweihander Warrior");
		zweihanderButton.setBounds(size.width/2 - 290, 201, 180, 90);
		
		fireStaffButton = new JButton("Fire Staff Mage");
		fireStaffButton.setBounds(size.width/2 - 90, 1, 180, 90);
		iceStaffButton = new JButton("Ice Staff Mage");
		iceStaffButton.setBounds(size.width/2 - 90, 101, 180, 90);
		arcaneStaffButton = new JButton("Arcane Staff Mage");
		arcaneStaffButton.setBounds(size.width/2 - 90, 201, 180, 90);
		
		shortBowButton = new JButton("ShortBow Ranger");
		shortBowButton.setBounds(size.width/2 + 110, 1, 180, 90);
		crossbowButton = new JButton("Crossbow Ranger");
		crossbowButton.setBounds(size.width/2 + 110, 101, 180, 90);
		javelinButton = new JButton("Javelin Ranger");
		javelinButton.setBounds(size.width/2 + 110, 201, 180, 90);
		
		doneButton = new JButton("Next Player");
		doneButton.setBounds(size.width/2 - 90, 600, 180, 90);
		
		
		currentPlayer = new JLabel("");
		currentPlayer.setBounds(size.width/2 - 450, 100, 180, 90);
		resources = new JLabel("");
		resources.setBounds(size.width/2 - 450, 1, 180, 900);
		
		shortSwordDescription.setText(getData(Warrior.class,ShortSword.class));
		zweihanderDescription.setText(getData(Warrior.class,Zweihander.class));
		halberdDescription.setText(getData(Warrior.class,Halberd.class));
		
		fireStaffDescription.setText(getData(Mage.class,FireStaff.class));
		iceStaffDescription.setText(getData(Mage.class,IceStaff.class));
		arcaneStaffDescription.setText(getData(Mage.class,ArcaneStaff.class));
		
		shortBowDescription.setText(getData(Ranger.class,ShortBow.class));
		crossbowDescription.setText(getData(Ranger.class,Crossbow.class));
		javelinDescription.setText(getData(Ranger.class,Javelin.class));
		
		this.add(buttonPanel);

		GridLayout layout = new  GridLayout(7,3);
		buttonPanel.setLayout(layout);
		layout.setHgap(25);
		layout.setVgap(10);
		
		
		buttonPanel.add(shortSwordButton);
		buttonPanel.add(fireStaffButton);
		buttonPanel.add(shortBowButton);
		buttonPanel.add(shortSwordDescription);
		buttonPanel.add(fireStaffDescription);
		buttonPanel.add(shortBowDescription);


		buttonPanel.add(halberdButton);
		buttonPanel.add(iceStaffButton);
		buttonPanel.add(crossbowButton);
		buttonPanel.add(halberdDescription);
		buttonPanel.add(iceStaffDescription);
		buttonPanel.add(crossbowDescription);

		buttonPanel.add(zweihanderButton);
		buttonPanel.add(arcaneStaffButton);
		buttonPanel.add(javelinButton);
		buttonPanel.add(zweihanderDescription);
		buttonPanel.add(arcaneStaffDescription);
		buttonPanel.add(javelinDescription);
	
		buttonPanel.add(currentPlayer);

		buttonPanel.add(doneButton);
	
		buttonPanel.add(resources);

		

					
	}
	
	private String getData(Class<? extends Piece> piece, Class<? extends Weapon> weapon) {
		int health=0;
		int movement=0;
		int damage=0;
		int range=0;
		int cost=1;
		
		if (piece == Warrior.class){
			health=Warrior.getClassHealth();
			movement=Warrior.getClassMovement();
		}
		if (piece == Ranger.class)
			{
				health=Ranger.getClassHealth();
				movement=Ranger.getClassMovement();	
			}	
		if (piece == Mage.class){
				health=Mage.getClassHealth();
				movement=Mage.getClassMovement();
			}
		
		if (weapon == ShortSword.class){
		damage=ShortSword.getClassDamage();
		range=ShortSword.getClassRange();
		cost=ShortSword.getClassCost();
		}
		
		if (weapon == Zweihander.class){
			damage=Zweihander.getClassDamage();
			range=Zweihander.getClassRange();
			cost=Zweihander.getClassCost();
		}
		
		if (weapon == Halberd.class){
			damage=Halberd.getClassDamage();
			range=Halberd.getClassRange();
			cost=Halberd.getClassCost();
		}
		
		if (weapon == FireStaff.class){
			damage=FireStaff.getClassDamage();
			range=FireStaff.getClassRange();
			cost=FireStaff.getClassCost();
		}
		
		if (weapon == IceStaff.class){
			damage=IceStaff.getClassDamage();
			range=IceStaff.getClassRange();
			cost=IceStaff.getClassCost();
		}
		
		if (weapon == ArcaneStaff.class){
			damage = ArcaneStaff.getClassDamage();
			range=ArcaneStaff.getClassRange();
			cost=ArcaneStaff.getClassCost();
		}
		
		if (weapon == ShortBow.class){
		damage = ShortBow.getClassDamage();
		range=ShortBow.getClassRange();
		cost=ShortBow.getClassCost();
		}
		
		if (weapon == Crossbow.class){
			damage=Crossbow.getClassDamage();
			range=Crossbow.getClassRange();
			cost=Crossbow.getClassCost();
		}
		
		if (weapon == Javelin.class){
			damage=Javelin.getClassDamage();
			range=Javelin.getClassRange();
			cost=Javelin.getClassCost();
		}
		
		String description;
			
		description= "<html>";
		description += "Health " + health;
		description += "<br>";	
		description += "Attack: " + damage + " Range: " + range;
		description += "<br>";
		description += "Movement: " + movement;
		description += "<br>";
		description += "Cost: " + cost;
		description += "<br>";	
		description += "</html>";
			
		return description;	
	}

	void addShortSwordListener(ActionListener shortSwordListener){
		
		shortSwordButton.addActionListener(shortSwordListener);	
	}
	
	void addHalberdListener(ActionListener halberdListener){
		
		halberdButton.addActionListener(halberdListener);	
	}
	
	void addZweihanderListener(ActionListener zweihanderListener){
		
		zweihanderButton.addActionListener(zweihanderListener);	
	}
	
	void addShortBowListener(ActionListener shortBowListener){
		
		shortBowButton.addActionListener(shortBowListener);	
	}
	
	void addCrossbowListener(ActionListener crossbowListener){
		
		crossbowButton.addActionListener(crossbowListener);	
	}
	
	void addJavelinListener(ActionListener javelinListener){
		
		javelinButton.addActionListener(javelinListener);	
	}
	
	void addFireStaffListener(ActionListener fireStaffListener){
		
		fireStaffButton.addActionListener(fireStaffListener);	
	}
	void addIceStaffListener(ActionListener iceStaffListener){
		iceStaffButton.addActionListener(iceStaffListener);
	}
	void addArcaneStaffListener(ActionListener arcaneStaffListener){
		arcaneStaffButton.addActionListener(arcaneStaffListener);
	}
	
	void addDoneListener(ActionListener doneListener){
		
		doneButton.addActionListener(doneListener);	
	}
	
	public void printCurrentPlayer(String text){
		currentPlayer.setText(text);
	}
	
	public void printResources(String text){
		resources.setText(text);
	}
	
}
