package backend.skills.rangerSkills.crossbowmanSkills;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.SingleTargetEffect;
import backend.skills.skillType.SkillPieceTargetEnemy;

public class HeadShot extends SkillPieceTargetEnemy{

	public HeadShot() {
		super(HEADSHOT_RANGE, HEADSHOT_CHARGES ,HEADSHOT_DESCRIPTION);
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
			newTargetPiece.receiveDamage((int) (HEADSHOT_DAMAGE*myselfPiece.getAttackModifier()));
			myselfPiece.resetAttackModifier();	
		}	
	}

	}
	

