package backend.skills.rangerSkills.javelinRanger;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.MyselfTargetEffect;
import backend.skills.skillType.SkillNoTarget;


public class SeekAndDestroy extends SkillNoTarget{
	
	
		public SeekAndDestroy() {
			super(SEEK_AND_DESTROY_CHARGES, SEEK_AND_DESTROY_DESCRIPTION);
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
			newTargetPiece.modifyAttackModifier(SEEK_AND_DESTROY_ATTACKMODIFIER);
			newTargetPiece.modifyMovementModifier(SEEK_AND_DESTROY_MOVEMENTMODIFIER);
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