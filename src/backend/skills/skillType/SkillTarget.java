package backend.skills.skillType;


import backend.game.MatchModel;
import backend.game.Tile;

public abstract class SkillTarget extends Skill {

	private int range;
	
	/**
	 * 
	 * @param range
	 * @param skillCharges
	 * @param skillDescription
	 */
	public SkillTarget(int range, int skillCharges, String skillDescription){
		super(skillCharges, skillDescription);
		this.range = range;
	}
	
	/**
	 * Retorna True si el el lugar seleccionado es valido
	 */
	public boolean checkValidTarget(Tile startingTile, Tile targetTile, MatchModel match){
		if(startingTile == null){
			throw new NullPointerException();
		}
		if(startingTile.getPiece() == null){
			throw new NullPointerException();
		}
		if(match == null){
			throw new NullPointerException();
		}
		if(targetTile == null){
			throw new NullPointerException();
		}
		return match.getDistance(startingTile, targetTile)<= range;

	}
	
	public int getRange(){
		return this.range;
	}
}
