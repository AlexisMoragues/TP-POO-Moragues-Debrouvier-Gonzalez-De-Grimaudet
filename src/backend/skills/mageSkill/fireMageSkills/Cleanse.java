package backend.skills.mageSkill.fireMageSkills;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.SingleTargetEffect;
import backend.skills.skillType.SkillPieceTargetAlly;


public class Cleanse extends SkillPieceTargetAlly{

	

	public Cleanse() {
		super(CLEANSE_RANGE,CLEANSE_CHARGES,CLEANSE_DESCRIPTION);
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
		Piece myselfPiece = startingTile.getPiece();
		for(Tile newTargetTile: areaOfEffect.getAreaOfEffect(startingTile, targetTile, match)){
			Piece newTargetPiece = newTargetTile.getPiece();
			newTargetPiece.receiveDamage((int) (CLEANSE_DAMAGE*myselfPiece.getAttackModifier()*newTargetPiece.getDmgRecievedModifier()));
			newTargetPiece.resetDmgReceivedModifier();
			newTargetPiece.resetAttackModifier();
			newTargetPiece.resetMovementModifier();
			myselfPiece.resetAttackModifier();
		}
	}
}
