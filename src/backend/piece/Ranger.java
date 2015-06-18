package backend.piece;

import backend.game.MatchModel;
import backend.weapons.rangerweapon.RangerWeapon;

public class Ranger extends Piece{
	
	public Ranger(int team, RangerWeapon weapon, MatchModel match) {
		super(RANGER_HEALTH, team, RANGER_MOVEMENT, weapon, "Ranger", match);
	}
	

	public static int getClassHealth(){
		return RANGER_HEALTH;
	}
	
	public static int getClassMovement(){
		return RANGER_MOVEMENT;
	}
	
}
