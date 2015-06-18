package backend.skills.skillType;


import backend.game.MatchModel;
import backend.game.Tile;

public abstract class SkillPieceTargetAlly extends SkillPieceTarget{

	public SkillPieceTargetAlly(int range, int skillCharges, String skillDescription){
		super(range, skillCharges, skillDescription);
	}
	
	/**
	 * Retorna True si el el lugar seleccionado es valido
	 */
	@Override
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
		if(super.checkValidTarget(startingTile, targetTile, match)){
			if(startingTile.getPiece().getTeam() == targetTile.getPiece().getTeam()){
				return true;
			}
		}
		return false;
		
	}
}
