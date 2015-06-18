package backend.skills.rangerSkills.archerSkills;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.SingleTargetEffect;
import backend.skills.skillType.SkillPieceTargetEnemy;

public class ArrowToTheKnee extends SkillPieceTargetEnemy{
	public ArrowToTheKnee() {
		super(ARROW_TO_THE_KNEE_RANGE, ARROW_TO_THE_KNEE_CHARGES, ARROW_TO_THE_KNEE_DESCRIPTION); 
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
			newTargetPiece.receiveDamage((int) (ARROW_TO_THE_KNEE_DAMAGE*myselfPiece.getAttackModifier()*newTargetPiece.getDmgRecievedModifier()));
			newTargetPiece.resetDmgReceivedModifier();
			newTargetPiece.modifyMovementModifier(ARROW_TO_THE_KNEE_MOVEMENT_MODIFIER);
			
		}
	}

}

