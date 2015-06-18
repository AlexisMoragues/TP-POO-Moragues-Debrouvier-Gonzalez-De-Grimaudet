package backend.skills.rangerSkills.archerSkills;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.SingleTargetEffect;
import backend.skills.skillType.SkillPieceTargetAlly;

public class HealingElfRoot extends SkillPieceTargetAlly{

	public HealingElfRoot() {
		super(HEALING_ELF_ROOT_RANGE, HEALING_ELF_ROOT_CHARGES, HEALING_ELF_ROOT_DESCRIPTION );
		areaOfEffect = new SingleTargetEffect();
	}

	@Override
	public void useSkill(Tile startingTile, Tile targetTile,MatchModel match) {
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
			newTargetPiece.changeMaxHealth(newTargetPiece.getMaxHealth()+HEALING_ELF_ROOT_MAXHEALTH_INCREASE);
			newTargetPiece.heal(HEALING_ELF_ROOT_HEAL);
		}
	}
}
	