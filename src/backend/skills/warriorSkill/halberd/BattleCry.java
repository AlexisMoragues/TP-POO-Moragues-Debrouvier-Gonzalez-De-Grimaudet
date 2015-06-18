package backend.skills.warriorSkill.halberd;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.MyselfSquareEffect;
import backend.skills.skillType.SkillNoTarget;

public class BattleCry extends SkillNoTarget{  //Duda, como lo hago?

	public BattleCry(){
		super(BATTLECRY_CHARGES,BATTLECRY_DESCRIPTION);
		areaOfEffect = new MyselfSquareEffect (BATTLECRY_LENGTH);
	}

	public void useSkill(Tile startingTile, Tile targetTile, MatchModel match){
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
		for(Tile newTargetTile: areaOfEffect.getAreaOfEffect(startingTile, targetTile, match)){
			Piece newTargetPiece = newTargetTile.getPiece();
			if(newTargetPiece!=null){
				if(newTargetPiece.getTeam() == myselfPiece.getTeam()){
					if(newTargetPiece != myselfPiece){
						newTargetPiece.modifyAttackModifier(BATTLECRY_ATTACKMODIFIER);
					}
					else {
						myselfPiece.modifyAttackModifier(MYSELFBATTLECRY_ATTACKMODIFIER);
					}
				}
			}
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
}
