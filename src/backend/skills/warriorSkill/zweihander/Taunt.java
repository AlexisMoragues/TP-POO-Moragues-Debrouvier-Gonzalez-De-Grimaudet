package backend.skills.warriorSkill.zweihander;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.MyselfSquareEffect;
import backend.skills.skillType.SkillNoTarget;

public class Taunt extends SkillNoTarget {

	public Taunt() {
		super(TAUNT_CHARGES,TAUNT_DESCRIPTION);
		areaOfEffect = new MyselfSquareEffect(TAUNT_LENGTH);
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
	        if(newTargetPiece!=null && newTargetTile!=startingTile){
	        	newTargetPiece.modifyDmgReceivedModifier(TAUNT_ARMOR_MODIFIER);
				newTargetPiece.modifyMovementModifier(TAUNT_MOVEMENT_MODIFIER);
            }
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
