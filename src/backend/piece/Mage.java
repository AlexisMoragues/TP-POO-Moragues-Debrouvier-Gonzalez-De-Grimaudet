package backend.piece;

import backend.game.MatchModel;
import backend.weapons.mageweapon.MageWeapon;

public class Mage extends Piece {
	
	/**
	 * Crea un mago, una pieza que tiene 45 de vida y 2 de movilidad
	 * y solo puede usar armas de mago
	 * 
	 * @param team
	 * @param weapon
	 */
	public Mage(int team, MageWeapon weapon, MatchModel match){
		super(MAGE_HEALTH, team, MAGE_MOVEMENT, weapon, "Mage", match);
	}
	
	public static int getClassHealth(){
		return MAGE_HEALTH;
	}
	
	public static int getClassMovement(){
		return MAGE_MOVEMENT;
	}
	
	
}
