package backend.skills.rangerSkills.archerSkills;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.SingleTargetEffect;
import backend.skills.skillType.SkillPieceTargetEnemy;

public  class SandAttack extends SkillPieceTargetEnemy{

	public SandAttack() {
		super(SAND_ATTACK_RANGE, SAND_ATTACK_CHARGES, SAND_ATTACK_DESCRIPTION);
		areaOfEffect = new SingleTargetEffect();
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
			newTargetPiece.modifyAttackModifier(SAND_ATTACK_ATTACK_MODIFIER);	
		}
	}
}