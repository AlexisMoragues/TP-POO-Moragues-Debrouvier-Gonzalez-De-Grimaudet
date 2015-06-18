package backend.skills.rangerSkills.crossbowmanSkills;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.MyselfTargetEffect;
import backend.skills.skillType.SkillNoTarget;

public class Reload extends SkillNoTarget {
	
	public Reload() {
		super(RELOAD_CHARGES,RELOAD_DESCRIPTION);
		areaOfEffect = new MyselfTargetEffect();
	}

	@Override
	public void useSkill(Tile startingTile, Tile targetTile, MatchModel match) {
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
		Piece myselfPiece = startingTile.getPiece();
		myselfPiece.getSkill().get(0).setSkillCharges(1);
		for(Tile newTargetTile: areaOfEffect.getAreaOfEffect(startingTile, targetTile, match)){
			Piece newTargetPiece = newTargetTile.getPiece();
			newTargetPiece.getSkill().get(0).setSkillCharges(1);
		}	
	}


	@Override
	public boolean checkValidTarget(Tile startingTile, Tile targetTile, MatchModel match) {
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
		Piece myselfPiece = startingTile.getPiece();
		if(myselfPiece.getSkill().get(0).getSkillCharges()==0){ //HeadShot tiene que ser el que esta en el lugar 0.
			return true;		
		}
		return false;
	}

	
	
}
