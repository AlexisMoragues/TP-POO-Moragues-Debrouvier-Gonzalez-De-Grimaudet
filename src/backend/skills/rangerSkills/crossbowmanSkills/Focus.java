package backend.skills.rangerSkills.crossbowmanSkills;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.MyselfTargetEffect;
import backend.skills.skillType.SkillNoTarget;

public class Focus extends SkillNoTarget {

	public Focus() {
		super(FOCUS_CHARGES, FOCUS_DESCRIPTION);
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
		for(Tile newTargetTile: areaOfEffect.getAreaOfEffect(startingTile, targetTile, match)){
			Piece newTargetPiece = newTargetTile.getPiece();
			newTargetPiece.modifyAttackModifier(FOCUS_ATTACK_MODIFIER);
			newTargetPiece.modifyDmgReceivedModifier(FOCUS_DEFENCE_REDUCTION);
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
		return true;
	}

}
