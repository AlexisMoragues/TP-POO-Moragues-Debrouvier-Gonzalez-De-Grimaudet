package backend.skills.warriorSkill.halberd;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.MyselfSquareEffect;
import backend.skills.skillType.SkillNoTarget;


public class SpinToWin extends SkillNoTarget{

	public SpinToWin(){
		super(SPIN_TO_WIN_CHARGES ,SPIN_TO_WIN_DESCRIPTION);
		areaOfEffect = new MyselfSquareEffect(SPIN_TO_WIN_LENGTH);
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
				if(match.getDistance(startingTile,newTargetPiece.getPosition())==2){
								
					newTargetPiece.receiveDamage((int) (SPIN_TO_WIN_MAX_DAMAGE*myselfPiece.getAttackModifier()*newTargetPiece.getDmgRecievedModifier()));
					newTargetPiece.resetDmgReceivedModifier();
					
				}
				if(newTargetPiece!=null && match.getDistance(startingTile,newTargetPiece.getPosition())==1){
					newTargetPiece.receiveDamage((int) (SPIN_TO_WIN_MIN_DAMAGE*myselfPiece.getAttackModifier()*newTargetPiece.getDmgRecievedModifier()));
					newTargetPiece.resetDmgReceivedModifier();
				}
			}
		}
		myselfPiece.modifyMovementModifier(SPIN_TO_WIN_MOVEMENT_MODIFIER);	
		myselfPiece.resetAttackModifier();
	}

	@Override
	public boolean checkValidTarget(Tile startingTile, Tile targetTile,
			MatchModel match) {
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

