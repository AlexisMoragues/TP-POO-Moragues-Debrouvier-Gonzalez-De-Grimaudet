package backend.piece;

import backend.game.MatchModel;
import backend.weapons.warriorweapon.WarriorWeapon;


public class Warrior extends Piece {
	
	/**
	 * Crea una pieza con 100 de vida, 4 de movilidad y solo puede usar armas de guerrero
	 * @param team
	 * @param weapon
	 */
	public Warrior(int team, WarriorWeapon weapon, MatchModel match){
		super(WARRIOR_HEALTH, team, WARRIOR_MOVEMENT, weapon, "Warrior", match);
	}
	

	public static int getClassHealth(){
		return WARRIOR_HEALTH;
	}
	
	public static int getClassMovement(){
		return WARRIOR_MOVEMENT;
	}
	
	

}
