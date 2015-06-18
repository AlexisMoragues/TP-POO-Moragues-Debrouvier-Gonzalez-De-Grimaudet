package backend.skills.warriorSkill.zweihander;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.MyselfTargetEffect;
import backend.skills.skillType.SkillNoTarget;


public class UndyingMight extends SkillNoTarget{

	public UndyingMight() {
		super(UNDYING_MIGHT_CHARGES ,UNDYING_MIGHT_DESCRPTION);
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
			newTargetPiece.modifyDmgReceivedModifier(INVINCIBILITY);
			newTargetPiece.changeMaxHealth(startingTile.getPiece().getMaxHealth()+UNDYINGMIGHT_HEALTH_INCREASE);
			newTargetPiece.heal(UNDYINGMIGHT_HEALTH_INCREASE);
		}
	}

	@Override
	public boolean checkValidTarget(Tile startingTile, Tile targetTile,	MatchModel match) {
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
};